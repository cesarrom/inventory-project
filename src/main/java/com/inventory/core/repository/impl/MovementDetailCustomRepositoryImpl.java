package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.MovementDetailCustomRepository;
import com.inventory.models.MovementDetail;
import com.inventory.models.query.MovementDetailQuery;
import com.inventory.utils.ObjectUtils;

@Repository
public class MovementDetailCustomRepositoryImpl implements MovementDetailCustomRepository {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<MovementDetail> list(MovementDetailQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM " + MovementDetail.class.getSimpleName() + " bc"
				+ " LEFT JOIN bc.movement AS mov LEFT JOIN bc.product AS p LEFT JOIN bc.sourceProductRepository AS spr "
				+ "LEFT JOIN bc.targetProductRepository AS tpr "
				+ "LEFT JOIN spr.product AS sprp LEFT JOIN tpr.product AS tprp WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		if (ObjectUtils.isThruthy(queryParams.getMovementId())) {
			queryStr.append(" AND mov.id = :movementId ");
			nameValue.put("movementId", queryParams.getMovementId());
		}
		if (ObjectUtils.isThruthy(queryParams.getSourceRepositoryId())) {
			queryStr.append(" AND spr.id = :sourceRepositoryId ");
			nameValue.put("sourceRepositoryId", queryParams.getSourceRepositoryId());
		}
		if (ObjectUtils.isThruthy(queryParams.getTargetRepositoryId())) {
			queryStr.append(" AND tpr.id = :targetRepositoryId ");
			nameValue.put("targetRepositoryId", queryParams.getTargetRepositoryId());
		}
		if (ObjectUtils.isThruthy(queryParams.getProductIds())) {
			final int[] index = { 0 };
			final StringBuilder movementDSB = new StringBuilder();
			queryParams.getProductIds().stream().forEach(id -> {
				if (index[0] > 0)
					movementDSB.append(" OR ");
				movementDSB.append(" ( p.id = :productId" + index[0] + " ");
				if (ObjectUtils.isThruthy(queryParams.getOmitNegative())) {
					movementDSB.append(" AND sprp.id != :productId" + index[0] + " ");
				} else if (ObjectUtils.isThruthy(queryParams.getOmitPositive())) {
					movementDSB.append(" AND tprp.id != :productId" + index[0] + " ");
				}
				movementDSB.append(") ");
				nameValue.put("productId" + index[0], id);
				index[0]++;
			});
			queryStr.append(" AND ( " + movementDSB.toString() + " ) ");
		}
		TypedQuery<MovementDetail> query = em.createQuery(queryStr.toString(), MovementDetail.class);
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
