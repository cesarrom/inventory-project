package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.ProductRepositoryBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.ProductRepository;
import com.inventory.models.Repository;
import com.inventory.models.dto.ProductDto;
import com.inventory.models.dto.ProductRepositoryDto;
import com.inventory.models.dto.RepositoryDto;
import com.inventory.models.query.ProductRepositoryQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class ProductRepositoryBusinessImpl implements ProductRepositoryBusiness {

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public ProductRepositoryBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public ProductRepository create(ProductRepositoryDto productRepository) {
		if (ObjectUtils.isFalsey(productRepository))
			throw new BadRequestException("THE PRODUCT REPOSITORY OBJECT CANNOT BE NULL");
		ProductRepository crudProductRepository = this.daos.getProductRepositoryDao()
				.create(productRepository.fillCrudModel());
		if (ObjectUtils.isFalsey(productRepository.getProduct()))
			throw new BadRequestException("YOU MUST PROVIDE A PRODUCT TO CREATE A PRODUCT REPOSITORY!");
		if (ObjectUtils.isFalsey(productRepository.getRepository()))
			throw new BadRequestException("YOU MUST PROVIDE A REPOSITORY TO CREATE A PRODUCT REPOSITORY!");
		crudProductRepository
				.setProduct(this.businesses.getProductBusiness().find(productRepository.getProduct().getId()));
		Repository desiredRepo = this.businesses.getRepositoryBusuiness().find(productRepository.getRepository().getId());
		crudProductRepository.setRepository(desiredRepo);
		crudProductRepository.setExternal(desiredRepo.getExternal());
		return crudProductRepository;
	}

	@Override
	public List<ProductRepository> list(ProductRepositoryQuery query) {
		return this.daos.getProductRepositoryDao().list(query);
	}

	@Override
	public ProductRepository update(Long productRepositoryId, ProductRepositoryDto productRepositoryParams) {
		if (ObjectUtils.isFalsey(productRepositoryParams))
			throw new BadRequestException("THE PRODUCT REPOSITORY OBJECT CANNOT BE NULL");
		ProductRepository productRepository = this.find(productRepositoryId);
		ObjectUtils.copyPropertiesIgnoringNulls(productRepositoryParams, productRepository);
		this.daos.getProductRepositoryDao().update(productRepository);
		if (ObjectUtils.isThruthy(productRepository.getProduct()))
			productRepository.setProduct(
					this.businesses.getProductBusiness().find(productRepositoryParams.getProduct().getId()));
		if (ObjectUtils.isThruthy(productRepository.getRepository()))
			productRepository.setRepository(
					this.businesses.getRepositoryBusuiness().find(productRepositoryParams.getRepository().getId()));
		return productRepository;
	}

	@Override
	public ProductRepository find(Long productRepositoryId) {
		return this.daos.getProductRepositoryDao().findById(productRepositoryId).orElseThrow(
				() -> new NotFoundException("PRODUCT REPOSITORY NOT FOUND [id:" + productRepositoryId + "]"));
	}

	@Override
	public ProductRepository findByProductIdAndRepositoryId(Long productId, Long repositoryId) {
		return this.daos.getProductRepositoryDao().findByProduct_IdAndRepository_Id(productId, repositoryId)
				.orElseThrow(() -> new NotFoundException("PRODUCT REPOSITORY NOT FOUND WITH [productId:" + productId
						+ ", repositoryId:" + repositoryId + "]"));
	}

	@Override
	public ProductRepository findOrCreateByProductIdAndRepositoryId(Long productId, Long repositoryId,
			Double desiredPrice) {
		return this.daos.getProductRepositoryDao().findByProduct_IdAndRepository_Id(productId, repositoryId)
				.orElseGet(() -> {
					RepositoryDto dtoDesiredRepo = new RepositoryDto();
					dtoDesiredRepo.setId(repositoryId);
					ProductDto dtoDesiredProd = new ProductDto();
					dtoDesiredProd.setId(productId);
					ProductRepositoryDto desiredProductRepository = new ProductRepositoryDto();
					desiredProductRepository.setCurrentQuantity(0L);
					desiredProductRepository.setPrice(desiredPrice);
					desiredProductRepository.setRepository(dtoDesiredRepo);
					desiredProductRepository.setProduct(dtoDesiredProd);
					return this.create(desiredProductRepository);
				});
	}

}
