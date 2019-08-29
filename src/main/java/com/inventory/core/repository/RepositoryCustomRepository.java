package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Repository;
import com.inventory.models.query.RepositoryQuery;

public interface RepositoryCustomRepository {
	public List<Repository> list(RepositoryQuery queryParams);
}
