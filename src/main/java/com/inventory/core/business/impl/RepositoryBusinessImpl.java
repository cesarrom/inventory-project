package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.RepositoryBusiness;
import com.inventory.core.dao.RepositoryDao;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.Repository;
import com.inventory.models.dto.RepositoryDto;
import com.inventory.models.query.RepositoryQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class RepositoryBusinessImpl implements RepositoryBusiness {
	
	private RepositoryDao dao;

	@Autowired
	public RepositoryBusinessImpl(RepositoryDao dao) {
		this.dao = dao;
	}

	@Override
	public Repository create(RepositoryDto repository) {
		return this.dao.create(repository.fillCrudModel());
	}

	@Override
	public List<Repository> list(RepositoryQuery query) {
		return this.dao.list(query);
	}

	@Override
	public Repository update(Long repositoryId, RepositoryDto repositoryParams) {
		Repository repository = this.dao.findById(repositoryId).orElseThrow(() -> new NotFoundException("REPOSITORY NOT FOUND [id:"+repositoryId+"]"));
		ObjectUtils.copyPropertiesIgnoringNulls(repositoryParams, repository);
		this.dao.update(repository);
		return repository;
	}

	@Override
	public Repository find(Long repositoryId) {
		return this.dao.findById(repositoryId).orElseThrow(() -> new NotFoundException("REPOSITORY NOT FOUND [id:"+repositoryId+"]"));
	}

	
}
