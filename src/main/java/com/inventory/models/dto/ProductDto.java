package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.Product;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the products database table.
 * 
 */

public class ProductDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private Date createdAt;

	private String description;

	private String name;

	private String photo;

	private String unitType;

	private Date updatedAt;
	
	private Double basePrice;

	// bi-directional many-to-one association to MovementDetailDto

	private List<MovementDetailDto> movementDetails;

	// bi-directional many-to-one association to ProductRepositoryDto

	private List<ProductRepositoryDto> productRepositories;

	// bi-directional many-to-one association to CategoryDto

	private CategoryDto category;

	// bi-directional many-to-one association to SupplierDto

	private SupplierDto supplier;

	public ProductDto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUnitType() {
		return this.unitType;
	}

	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Double basePrice) {
		this.basePrice = basePrice;
	}

	public List<MovementDetailDto> getMovementDetails() {
		return this.movementDetails;
	}

	public void setMovementDetails(List<MovementDetailDto> movementDetails) {
		this.movementDetails = movementDetails;
	}

	public MovementDetailDto addMovementDetail(MovementDetailDto movementDetail) {
		getMovementDetails().add(movementDetail);
		movementDetail.setProduct(this);

		return movementDetail;
	}

	public MovementDetailDto removeMovementDetail(MovementDetailDto movementDetail) {
		getMovementDetails().remove(movementDetail);
		movementDetail.setProduct(null);

		return movementDetail;
	}

	public List<ProductRepositoryDto> getProductRepositories() {
		return this.productRepositories;
	}

	public void setProductRepositories(List<ProductRepositoryDto> productRepositories) {
		this.productRepositories = productRepositories;
	}

	public ProductRepositoryDto addProductRepository(ProductRepositoryDto productRepository) {
		getProductRepositories().add(productRepository);
		productRepository.setProduct(this);

		return productRepository;
	}

	public ProductRepositoryDto removeProductRepository(ProductRepositoryDto productRepository) {
		getProductRepositories().remove(productRepository);
		productRepository.setProduct(null);

		return productRepository;
	}

	public CategoryDto getCategory() {
		return this.category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public SupplierDto getSupplier() {
		return this.supplier;
	}

	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}

	public Product fillCrudModel(String[] includes) {
		return BaseFill.actualFillToBaseModel(this, new Product(), includes);
	}

	public Product fillCrudModel() {
		return this.fillCrudModel(new String[] {});
	}

}