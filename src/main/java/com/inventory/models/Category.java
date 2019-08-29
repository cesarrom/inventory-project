package com.inventory.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inventory.models.dto.CategoryDto;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the categories database table.
 * 
 */
@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CATEGORIES_ID_GENERATOR", sequenceName = "CATEGORIES_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORIES_ID_GENERATOR")
	private Long id;

	@Column(name = "created_at")
	private Date createdAt;

	private String description;

	private String name;

	@Column(name = "updated_at")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_category_fk")
	private Category parentCategory;
	
	@OneToMany(mappedBy = "parentCategory")
	private List<Category> subCategories;

	// bi-directional many-to-one association to SupplierDto
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "supplier_fk")
	private Supplier supplier;

	// bi-directional many-to-one association to ProductDto
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	public Category() {
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

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public Category getParentCategory() {
		return parentCategory;
	}

	public void setParentCategory(Category parentCategory) {
		this.parentCategory = parentCategory;
	}

	public List<Category> getSubCategories() {
		return subCategories;
	}

	public void setSubCategories(List<Category> subCategories) {
		this.subCategories = subCategories;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

		return product;
	}

	@Override
	public CategoryDto fillDtoModel(String[] includes) {
		return BaseFill.actualFillToDtoModel(this, new CategoryDto(), includes);
	}

	@Override
	public CategoryDto fillDtoModel() {
		return this.fillDtoModel(new String[] {});
	}

}