package com.inventory.models.dto;

import java.util.Date;

import com.inventory.models.MovementDetail;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the movement_details database table.
 * 
 */

public class MovementDetailDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdAt;

	private double quantity;

	private Date updatedAt;

	private double value;
	
	private double discountPercentage;

	// bi-directional many-to-one association to MovementTypeDto

	private ProductRepositoryDto sourceProductRepository;

	// bi-directional many-to-one association to MovementDto

	private ProductRepositoryDto targetProductRepository;

	// bi-directional many-to-one association to MovementDto

	private MovementDto movement;

	// bi-directional many-to-one association to ProductDto

	private ProductDto product;

	public MovementDetailDto() {
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

	public double getQuantity() {
		return this.quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public double getValue() {
		return this.value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public MovementDto getMovement() {
		return this.movement;
	}

	public void setMovement(MovementDto movement) {
		this.movement = movement;
	}

	public ProductDto getProduct() {
		return this.product;
	}

	public void setProduct(ProductDto product) {
		this.product = product;
	}

	public ProductRepositoryDto getSourceProductRepository() {
		return sourceProductRepository;
	}

	public void setSourceProductRepository(ProductRepositoryDto sourceProductRepository) {
		this.sourceProductRepository = sourceProductRepository;
	}

	public ProductRepositoryDto getTargetProductRepository() {
		return targetProductRepository;
	}

	public void setTargetProductRepository(ProductRepositoryDto targetProductRepository) {
		this.targetProductRepository = targetProductRepository;
	}

	public MovementDetail fillCrudModel(String[] includes) {
		// TODO Auto-generated method stub
		return BaseFill.actualFillToBaseModel(this, new MovementDetail(), includes);
	}

	public MovementDetail fillCrudModel() {
		return this.fillCrudModel(new String[] {});
	}

}