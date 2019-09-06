package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.ProductRepository;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the product_repositories database table.
 * 
 */

public class ProductRepositoryDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdAt;

	private double currentQuantity;

	private double price;

	private Date updatedAt;

	// bi-directional many-to-one association to ProductDto

	private ProductDto product;

	// bi-directional many-to-one association to RepositoryDto
	private boolean external;
	
	private RepositoryDto repository;

	private List<MovementDetailDto> positiveMovements;

	private List<MovementDetailDto> negativeMovements;

	public ProductRepositoryDto() {
	}
	
	public Boolean getExternal() {
		return external;
	}

	public void setExternal(Boolean external) {
		if(external)
			this.setCurrentQuantity(Double.POSITIVE_INFINITY);
		this.external = external;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public double getCurrentQuantity() {
		return this.currentQuantity;
	}

	public void setCurrentQuantity(double currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public ProductDto getProduct() {
		return this.product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public RepositoryDto getRepository() {
		return this.repository;
	}

	public void setRepository(RepositoryDto repository) {
		this.repository = repository;
	}

	public List<MovementDetailDto> getPositiveMovements() {
		return positiveMovements;
	}

	public void setPositiveMovements(List<MovementDetailDto> positiveMovements) {
		this.positiveMovements = positiveMovements;
	}

	public List<MovementDetailDto> getNegativeMovements() {
		return negativeMovements;
	}

	public void setNegativeMovements(List<MovementDetailDto> negativeMovements) {
		this.negativeMovements = negativeMovements;
	}

	public ProductRepository fillCrudModel(String[] includes) {
		return BaseFill.actualFillToBaseModel(this, new ProductRepository(), includes);
	}

	public ProductRepository fillCrudModel() {
		return this.fillCrudModel(new String[] {});
	}

}