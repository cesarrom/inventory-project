package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.ProductBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.Product;
import com.inventory.models.dto.ProductDto;
import com.inventory.models.query.ProductQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class ProductBusinessImpl implements ProductBusiness {

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public ProductBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public Product create(ProductDto product) {
		if (ObjectUtils.isFalsey(product))
			throw new BadRequestException("THE PRODUCT OBJECT CANNOT BE NULL");
		Product prod = this.daos.getProductDao().create(product.fillCrudModel());
		if (ObjectUtils.isFalsey(product.getSupplier())) {
			throw new BadRequestException("YOU MUST PROVIDE A SUPPLIER");
		}
		if (ObjectUtils.isFalsey(product.getCategory())) {
			throw new BadRequestException("YOU MUST PROVIDE A CATEGORY");
		}
		prod.setSupplier(this.businesses.getSupplierBusiness().find(product.getSupplier().getId()));
		prod.setCategory(this.businesses.getCategoryBusiness().find(product.getCategory().getId()));
		return prod;
	}

	@Override
	public List<Product> list(ProductQuery query) {
		return this.daos.getProductDao().list(query);
	}

	@Override
	public Product update(Long productId, ProductDto productParams) {
		Product product = this.find(productId);
		ObjectUtils.copyPropertiesIgnoringNulls(productParams, product);
		this.daos.getProductDao().update(product);
		if (ObjectUtils.isThruthy(productParams.getSupplier())) {
			product.setSupplier(this.businesses.getSupplierBusiness().find(productParams.getSupplier().getId()));
		}
		if (ObjectUtils.isThruthy(productParams.getCategory())) {
			product.setCategory(this.businesses.getCategoryBusiness().find(productParams.getCategory().getId()));
		}
		this.daos.getProductDao().update(product);
		return product;
	}

	@Override
	public Product find(Long productId) {
		return this.daos.getProductDao().findById(productId)
				.orElseThrow(() -> new NotFoundException("PRODUCT NOT FOUND [id:" + productId + "]"));
	}

}
