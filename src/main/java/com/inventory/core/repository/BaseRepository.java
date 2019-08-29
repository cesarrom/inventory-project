package com.inventory.core.repository;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.models.CommonModel;

public interface BaseRepository {
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends CommonModel> T create(T entity);
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends CommonModel> T createWithFlush(T t);
	@Transactional(propagation = Propagation.REQUIRED)
	public <T extends CommonModel> T update(T entity);
	
}
