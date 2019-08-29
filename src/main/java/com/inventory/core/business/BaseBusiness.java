package com.inventory.core.business;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface BaseBusiness<P,Q,R> {
	@Transactional(propagation = Propagation.REQUIRED)
	public R create(P entity);
	@Transactional(propagation = Propagation.REQUIRED)
	public R update(Long id, P params);
	public List<R> list(Q query);
	public R find(Long id);
}
