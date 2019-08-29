package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.inventory.core.repository.RepositoryCustomRepository;
import com.inventory.models.Repository;
import com.inventory.models.query.RepositoryQuery;
import com.inventory.utils.ObjectUtils;

@org.springframework.stereotype.Repository
public class RepositoryCustomRepositoryImpl implements RepositoryCustomRepository {
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public List<Repository> list(RepositoryQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM "+ Repository.class.getSimpleName() +" bc WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getCategoryIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getCategoryIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" ct.id = :categoryId" + index[0] + " ");
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
		if (ObjectUtils.isThruthy(queryParams.getProductIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getSupplierIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" bc.id = :productId" + index[0] + " ");
				nameValue.put("productId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		TypedQuery<Repository> query = em.createQuery(queryStr.toString(), Repository.class);
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
