package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.Category;
import com.inventory.utils.BaseFill;

public class CategoryDto extends CommonModelDto {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Long id;

	
	private Date createdAt;

	private String description;

	private String name;

	
	private Date updatedAt;
	
	private CategoryDto parentCategory;
	
	private List<CategoryDto> subCategories;
	//bi-directional many-to-one association to SupplierDto
	
	private SupplierDto supplier;

	//bi-directional many-to-one association to ProductDto
	
	private List<ProductDto> products;

	public CategoryDto() {
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

	public SupplierDto getSupplier() {
		return this.supplier;
	}

	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}

	public List<ProductDto> getProducts() {
		return this.products;
	}

	public CategoryDto getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(CategoryDto parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<CategoryDto> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<CategoryDto> subCategories) {
		this.subCategories = subCategories;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

	public ProductDto addProduct(ProductDto product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public ProductDto removeProduct(ProductDto product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	
	
	public Category fillCrudModel(String[] includes) {
		return BaseFill.actualFillToBaseModel(this, new Category(), includes);
	}

	
	
	public Category fillCrudModel() {
		// TODO Auto-generated method stub
		return this.fillCrudModel(new String[]{});
	}

}