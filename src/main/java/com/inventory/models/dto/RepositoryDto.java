package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.Repository;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the repositories database table.
 * 
 */

public class RepositoryDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdAt;

	private String description;

	private String name;

	private Date updatedAt;

	// bi-directional many-to-one association to MovementTypeDto

	private List<MovementTypeDto> sourceMovementTypes;

	// bi-directional many-to-one association to MovementTypeDto

	private List<MovementTypeDto> targetMovementTypes;

	// bi-directional many-to-one association to ProductRepositoryDto

	private List<ProductRepositoryDto> productRepositories;

	private Boolean external;

	public RepositoryDto() {
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

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<MovementTypeDto> getSourceMovementTypes() {
		return this.sourceMovementTypes;
	}

	public void setSourceMovementTypes(List<MovementTypeDto> movementTypes1) {
		this.sourceMovementTypes = movementTypes1;
	}

	public MovementTypeDto addSourceMovementType(MovementTypeDto movementTypes1) {
		getSourceMovementTypes().add(movementTypes1);
		movementTypes1.setTargetRepository(this);

		return movementTypes1;
	}

	public MovementTypeDto removeSourceMovementType(MovementTypeDto movementTypes1) {
		getSourceMovementTypes().remove(movementTypes1);
		movementTypes1.setTargetRepository(null);

		return movementTypes1;
	}

	public List<MovementTypeDto> getTargetMovementTypes() {
		return this.targetMovementTypes;
	}

	public void setTargetMovementTypes(List<MovementTypeDto> movementTypes2) {
		this.targetMovementTypes = movementTypes2;
	}

	public MovementTypeDto addTargetMovementType(MovementTypeDto movementTypes2) {
		getTargetMovementTypes().add(movementTypes2);
		movementTypes2.setSourceRepository(this);

		return movementTypes2;
	}

	public MovementTypeDto removeTargetMovementType(MovementTypeDto movementTypes2) {
		getTargetMovementTypes().remove(movementTypes2);
		movementTypes2.setSourceRepository(null);

		return movementTypes2;
	}

	public List<ProductRepositoryDto> getProductRepositories() {
		return this.productRepositories;
	}

	public void setProductRepositories(List<ProductRepositoryDto> productRepositories) {
		this.productRepositories = productRepositories;
	}

	public Boolean isExternal() {
		return external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public ProductRepositoryDto addProductRepository(ProductRepositoryDto productRepository) {
		getProductRepositories().add(productRepository);
		productRepository.setRepository(this);

		return productRepository;
	}

	public ProductRepositoryDto removeProductRepository(ProductRepositoryDto productRepository) {
		getProductRepositories().remove(productRepository);
		productRepository.setRepository(null);

		return productRepository;
	}

	public Repository fillCrudModel(String[] includes) {
		return BaseFill.actualFillToBaseModel(this, new Repository(), includes);
	}

	public Repository fillCrudModel() {
		return this.fillCrudModel(new String[] {});
	}

}