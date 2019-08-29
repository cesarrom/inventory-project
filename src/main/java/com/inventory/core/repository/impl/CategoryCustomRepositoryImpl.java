package com.inventory.core.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.CategoryCustomRepository;
import com.inventory.models.Category;
import com.inventory.models.query.CategoryQuery;
import com.inventory.utils.ObjectUtils;

@Repository
public class CategoryCustomRepositoryImpl implements CategoryCustomRepository  {
	@PersistenceContext
	protected EntityManager em;
	
	@Override
	public List<Category> list(CategoryQuery queryParams) {
		StringBuilder queryStr = new StringBuilder();
		Map<String, Object> nameValue = new HashMap<>();
		queryStr.append("SELECT bc FROM "+ Category.class.getSimpleName() +" bc LEFT JOIN bc.parentCategory AS pc WHERE 1 = 1");
		if (ObjectUtils.isThruthy(queryParams.getFrom())) {
			queryStr.append(" AND bc.createdAt >= :fromParam ");
			nameValue.put("fromParam", queryParams.getFrom());
		}
		if (ObjectUtils.isThruthy(queryParams.getTo())) {
			queryStr.append(" AND bc.createdAt <= :toParam ");
			nameValue.put("toParam", queryParams.getTo());
		}
		
		if (ObjectUtils.isThruthy(queryParams.getDescription())) {
			queryStr.append(" AND bc.description LIKE :description ");
			nameValue.put("description", "%" + queryParams.getDescription() + "%");
		}
		if (ObjectUtils.isThruthy(queryParams.getName())) {
			queryStr.append(" AND bc.name LIKE :name ");
			nameValue.put("name", "%" + queryParams.getName() + "%");
		}
		if (ObjectUtils.isThruthy(queryParams.getParentCategoryId())) {
			queryStr.append(" AND pc.id = :parnetCategoryId ");
			nameValue.put("parnetCategoryId", "%" + queryParams.getParentCategoryId() + "%");
		}
		TypedQuery<Category> query = em.createQuery(queryStr.toString(), Category.class);
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
