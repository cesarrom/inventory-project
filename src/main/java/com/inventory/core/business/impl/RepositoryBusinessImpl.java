package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.RepositoryBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.ProductRepository;
import com.inventory.models.Repository;
import com.inventory.models.dto.RepositoryDto;
import com.inventory.models.query.RepositoryQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class RepositoryBusinessImpl implements RepositoryBusiness {
	

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public RepositoryBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public Repository create(RepositoryDto repository) {
		Repository repo = this.daos.getRepositoryDao().create(repository.fillCrudModel());
		this.daos.getProductDao().findAll().stream().parallel().forEach(prod -> {
			try {
				ProductRepository pr = new ProductRepository();
				this.daos.getProductRepositoryDao().create(pr);
				pr.setProduct(prod);
				pr.setRepository(repo);
				pr.setExternal(repo.getExternal());
				pr.setPrice((prod.getBasePrice() * repo.getEffectivePricePercentage())/100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return repo;
	}

	@Override
	public List<Repository> list(RepositoryQuery query) {
		return this.daos.getRepositoryDao().list(query);
	}

	@Override
	public Repository update(Long repositoryId, RepositoryDto repositoryParams) {
		Repository repository = this.daos.getRepositoryDao().findById(repositoryId).orElseThrow(() -> new NotFoundException("REPOSITORY NOT FOUND [id:"+repositoryId+"]"));
		ObjectUtils.copyPropertiesIgnoringNulls(repositoryParams, repository);
		this.daos.getRepositoryDao().update(repository);
		return repository;
	}

	@Override
	public Repository find(Long repositoryId) {
		return this.daos.getRepositoryDao().findById(repositoryId).orElseThrow(() -> new NotFoundException("REPOSITORY NOT FOUND [id:"+repositoryId+"]"));
	}

	
}
