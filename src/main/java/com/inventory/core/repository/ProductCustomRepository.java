package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Product;
import com.inventory.models.query.ProductQuery;

public interface ProductCustomRepository {
	public List<Product> list(ProductQuery queryParams);
}
