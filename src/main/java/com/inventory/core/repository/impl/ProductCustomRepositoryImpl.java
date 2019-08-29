package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.ProductCustomRepository;
import com.inventory.models.Product;
import com.inventory.models.query.ProductQuery;
import com.inventory.utils.ObjectUtils;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<Product> list(ProductQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM " + Product.class.getSimpleName() + " bc "
				+ " LEFT JOIN bc.category AS c LEFT JOIN bc.supplier AS sspls"
				+ " LEFT JOIN bc.movementDetails AS mds LEFT JOIN mds.movement AS mvm LEFT JOIN mvm.customer AS cs"
				+ " LEFT JOIN mvm.supplier AS spls"
				+ " WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getName())) {
			queryStr.append(" AND bc.name LIKE :name ");
			nameValue.put("name", "%" + queryParams.getName() + "%");
		}
		if (ObjectUtils.isThruthy(queryParams.getDescription())) {
			queryStr.append(" AND bc.description LIKE :description ");
			nameValue.put("description", "%" + queryParams.getDescription() + "%");
		}
		if (ObjectUtils.isThruthy(queryParams.getCategoryIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getCategoryIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" c.id = :categoryId" + index[0] + " ");
				nameValue.put("categoryId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		if (ObjectUtils.isThruthy(queryParams.getCustomerIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getCustomerIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" cs.id = :customerId" + index[0] + " ");
				nameValue.put("customerId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		if (ObjectUtils.isThruthy(queryParams.getSupplierIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getSupplierIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" spls.id = :supplierId" + index[0] + " ");
				nameValue.put("supplierId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		if (ObjectUtils.isThruthy(queryParams.getSourceSupplierIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getSupplierIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" sspls.id = :sourceSupplierId" + index[0] + " ");
				nameValue.put("sourceSupplierId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		TypedQuery<Product> query = em.createQuery(queryStr.toString(), Product.class);
		if (ObjectUtils.isThruthy(queryParams.getSkip())) {
			query.setFirstResult(queryParams.getSkip());
		}
		if (ObjectUtils.isThruthy(queryParams.getLimit())) {
			query.setMaxResults(queryParams.getLimit());
		}
		nameValue.forEach((key, value) -> query.setParameter(key, value));

		return query.getResultList();
	}
}
