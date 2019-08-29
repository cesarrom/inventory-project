package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.SupplierCustomRepository;
import com.inventory.models.Supplier;
import com.inventory.models.query.SupplierQuery;
import com.inventory.utils.ObjectUtils;

@Repository
public class SupplierCustomRepositoryImpl implements SupplierCustomRepository {
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public List<Supplier> list(SupplierQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM "+ Supplier.class.getSimpleName() +" bc WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getMovementId())) {
			queryStr.append(" AND mvs.id = :movementId ");
			nameValue.put("movementId", queryParams.getMovementId());
		}
		if (ObjectUtils.isThruthy(queryParams.getProductId())) {
			queryStr.append(" AND p.id = :productId ");
			nameValue.put("productId", queryParams.getProductId());
		}
		if (ObjectUtils.isThruthy(queryParams.getName())) {
			queryStr.append(" AND bc.description LIKE :name ");
			nameValue.put("name", "%" + queryParams.getName() + "%");
		}
		TypedQuery<Supplier> query = em.createQuery(queryStr.toString(), Supplier.class);
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
