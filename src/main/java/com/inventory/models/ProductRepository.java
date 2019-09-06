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

import com.inventory.models.dto.ProductRepositoryDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the product_repositories database table.
 * 
 */
@Entity
@Table(name="product_repositories")
@NamedQuery(name="ProductRepository.findAll", query="SELECT p FROM ProductRepository p")
public class ProductRepository extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCT_REPOSITORIES_ID_GENERATOR", sequenceName="PRODUCT_REPOSITORIES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCT_REPOSITORIES_ID_GENERATOR")
	private Long id;

	@Column(name="created_at")
	private Date createdAt;

	@Column(name="current_quantity")
	private double currentQuantity;

	private double price;

	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to ProductDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_fk")
	private Product product;

	//bi-directional many-to-one association to RepositoryDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "repository_fk")
	private Repository repository;
	
	@OneToMany(mappedBy="targetProductRepository")
	private List<MovementDetail> positiveMovements;
	
	@OneToMany(mappedBy="sourceProductRepository")
	private List<MovementDetail> negativeMovements;
	
	private boolean external;
	
	public ProductRepository() {
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
		if(this.getExternal())
			return Double.POSITIVE_INFINITY;
		return this.currentQuantity;
	}

	public void setCurrentQuantity(double currentQuantity) {
		if(this.getExternal())
			this.currentQuantity = Double.POSITIVE_INFINITY;
		else
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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Repository getRepository() {
		return this.repository;
	}

	public void setRepository(Repository repository) {
		this.repository = repository;
	}

	public List<MovementDetail> getPositiveMovements() {
		return positiveMovements;
	}

	public Boolean getExternal() {
		return external;
	}

	public void setExternal(Boolean external) {
		if(external)
			this.setCurrentQuantity(Double.POSITIVE_INFINITY);
		this.external = external;
	}

	public void setPositiveMovements(List<MovementDetail> positiveMovements) {
		this.positiveMovements = positiveMovements;
	}

	public List<MovementDetail> getNegativeMovements() {
		return negativeMovements;
	}

	public void setNegativeMovements(List<MovementDetail> negativeMovements) {
		this.negativeMovements = negativeMovements;
	}

	@Override
	public ProductRepositoryDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new ProductRepositoryDto(), include);
	}

	@Override
	public ProductRepositoryDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}