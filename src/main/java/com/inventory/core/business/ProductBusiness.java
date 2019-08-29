package com.inventory.core.business;

import com.inventory.models.Product;
import com.inventory.models.dto.ProductDto;
import com.inventory.models.query.ProductQuery;

public interface ProductBusiness extends BaseBusiness<ProductDto, ProductQuery, Product> {

}
