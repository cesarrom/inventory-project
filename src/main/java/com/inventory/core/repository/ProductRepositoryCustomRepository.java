package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.ProductRepository;
import com.inventory.models.query.ProductRepositoryQuery;

public interface ProductRepositoryCustomRepository {
	public List<ProductRepository> list(ProductRepositoryQuery queryParams);
}
