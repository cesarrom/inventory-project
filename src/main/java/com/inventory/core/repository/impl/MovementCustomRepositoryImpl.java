package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.MovementCustomRepository;
import com.inventory.models.Movement;
import com.inventory.models.query.MovementQuery;
import com.inventory.utils.ObjectUtils;

@Repository
public class MovementCustomRepositoryImpl implements MovementCustomRepository {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<Movement> list(MovementQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM " + Movement.class.getSimpleName() + " bc "
				+ " LEFT JOIN bc.customer AS c LEFT JOIN bc.movementDetails AS mds LEFT JOIN mds.product AS p "
				+ "LEFT JOIN bc.movementType AS mt LEFT JOIN mt.sourceRepository AS sr LEFT JOIN mt.targetRepository AS tr "
				+ "WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.movementDate >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.movementDate <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getCustomerId())) {
			queryStr.append(" AND c.id = :customerId ");
			nameValue.put("customerId", queryParams.getCustomerId());
		}
		if (ObjectUtils.isThruthy(queryParams.getSourceRepositoryId())) {
			queryStr.append(" AND sr.id = :sourceRepositoryId ");
			nameValue.put("sourceRepositoryId", queryParams.getSourceRepositoryId());
		}
		if (ObjectUtils.isThruthy(queryParams.getTargetRepositoryId())) {
			queryStr.append(" AND tr.id = :targetRepositoryId ");
			nameValue.put("targetRepositoryId", queryParams.getTargetRepositoryId());
		}
		if (ObjectUtils.isThruthy(queryParams.getSupplierId())) {
			queryStr.append(" AND s.id = :supplierId ");
			nameValue.put("supplierId", queryParams.getSupplierId());
		}
		if (ObjectUtils.isThruthy(queryParams.getMovementDetailIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getMovementDetailIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" mds.id = :movementDetailId" + index[0] + " ");
				nameValue.put("movementDetailId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		if (ObjectUtils.isThruthy(queryParams.getMovementTypeIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getMovementTypeIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" mt.id = :movementTypeId" + index[0] + " ");
				nameValue.put("movementTypeId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		if (ObjectUtils.isThruthy(queryParams.getProductIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getProductIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" p.id = :productId" + index[0] + " ");
				nameValue.put("productId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		TypedQuery<Movement> query = em.createQuery(queryStr.toString(), Movement.class);
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
