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

import com.inventory.models.dto.ProductDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCTS_ID_GENERATOR", sequenceName="PRODUCTS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTS_ID_GENERATOR")
	private Long id;

	private String code;

	@Column(name="created_at")
	private Date createdAt;

	private String description;

	private String name;

	private String photo;

	@Column(name="unit_type")
	private Integer unitType;

	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to MovementDetailDto
	@OneToMany(mappedBy="product")
	private List<MovementDetail> movementDetails;

	//bi-directional many-to-one association to ProductRepositoryDto
	@OneToMany(mappedBy="product")
	private List<ProductRepository> productRepositories;

	//bi-directional many-to-one association to CategoryDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "category_fk")
	private Category category;

	//bi-directional many-to-one association to SupplierDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supplier_fk")
	private Supplier supplier;

	public Product() {
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

	public Integer getUnitType() {
		return this.unitType;
	}

	public void setUnitType(Integer unitType) {
		this.unitType = unitType;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<MovementDetail> getMovementDetails() {
		return this.movementDetails;
	}

	public void setMovementDetails(List<MovementDetail> movementDetails) {
		this.movementDetails = movementDetails;
	}

	public MovementDetail addMovementDetail(MovementDetail movementDetail) {
		getMovementDetails().add(movementDetail);
		movementDetail.setProduct(this);

		return movementDetail;
	}

	public MovementDetail removeMovementDetail(MovementDetail movementDetail) {
		getMovementDetails().remove(movementDetail);
		movementDetail.setProduct(null);

		return movementDetail;
	}

	public List<ProductRepository> getProductRepositories() {
		return this.productRepositories;
	}

	public void setProductRepositories(List<ProductRepository> productRepositories) {
		this.productRepositories = productRepositories;
	}

	public ProductRepository addProductRepository(ProductRepository productRepository) {
		getProductRepositories().add(productRepository);
		productRepository.setProduct(this);

		return productRepository;
	}

	public ProductRepository removeProductRepository(ProductRepository productRepository) {
		getProductRepositories().remove(productRepository);
		productRepository.setProduct(null);

		return productRepository;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Override
	public ProductDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new ProductDto(), include);
	}

	@Override
	public ProductDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}