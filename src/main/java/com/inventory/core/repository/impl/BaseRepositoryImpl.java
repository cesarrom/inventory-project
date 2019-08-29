package com.inventory.core.repository.impl;

import java.time.Instant;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.models.CommonModel;

@Repository
public class BaseRepositoryImpl implements BaseRepository {

	@PersistenceContext
	protected EntityManager em;

	public <T extends CommonModel> T create(T entity) {
		entity.setCreatedAt(Date.from(Instant.now()));
		entity.setUpdatedAt(Date.from(Instant.now()));
		this.em.persist(entity);
		return entity;
	}
	public <T extends CommonModel> T createWithFlush(T t) {
		T x = this.create(t);
		em.flush();
		return x;
	}

	public <T extends CommonModel> T update(T entity) {
		entity.setUpdatedAt(Date.from(Instant.now()));
		this.em.merge(entity);
		em.flush();
		return entity;
	}

}
