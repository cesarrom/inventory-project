package com.inventory.core.business;

import com.inventory.models.ProductRepository;
import com.inventory.models.dto.ProductRepositoryDto;
import com.inventory.models.query.ProductRepositoryQuery;

public interface ProductRepositoryBusiness extends BaseBusiness<ProductRepositoryDto, ProductRepositoryQuery, ProductRepository> {
	ProductRepository findByProductIdAndRepositoryId(Long productId, Long repositoryId);
	ProductRepository findOrCreateByProductIdAndRepositoryId(Long productId, Long repositoryId, Double desiredPrice);
}
