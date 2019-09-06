package com.inventory.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inventory.models.dto.RepositoryDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the repositories database table.
 * 
 */
@Entity
@Table(name="repositories")
@NamedQuery(name="Repository.findAll", query="SELECT r FROM Repository r")
public class Repository extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="REPOSITORIES_ID_GENERATOR", sequenceName="REPOSITORIES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REPOSITORIES_ID_GENERATOR")
	private Long id;

	@Column(name="created_at")
	private Date createdAt;

	private String description;

	private String name;

	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to MovementTypeDto
	@OneToMany(mappedBy="sourceRepository")
	private List<MovementType> sourceMovementTypes;

	//bi-directional many-to-one association to MovementTypeDto
	@OneToMany(mappedBy="targetRepository")
	private List<MovementType> targetMovementTypes;

	//bi-directional many-to-one association to ProductRepositoryDto
	@OneToMany(mappedBy="repository")
	private List<ProductRepository> productRepositories;
	@Column(name="effective_price_percentage")
	private Double effectivePricePercentage;
	
	private boolean external;

	public Repository() {
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

	public List<MovementType> getSourceMovementTypes() {
		return this.sourceMovementTypes;
	}

	public void setSourceMovementTypes(List<MovementType> movementTypes1) {
		this.sourceMovementTypes = movementTypes1;
	}

	public MovementType addSourceMovementType(MovementType movementTypes1) {
		getSourceMovementTypes().add(movementTypes1);
		movementTypes1.setTargetRepository(this);

		return movementTypes1;
	}

	public MovementType removeSourceMovementType(MovementType movementTypes1) {
		getSourceMovementTypes().remove(movementTypes1);
		movementTypes1.setTargetRepository(null);

		return movementTypes1;
	}

	public List<MovementType> getTargetMovementTypes() {
		return this.targetMovementTypes;
	}

	public void setTargetMovementTypes(List<MovementType> movementTypes2) {
		this.targetMovementTypes = movementTypes2;
	}

	public MovementType addTargetMovementType(MovementType movementTypes2) {
		getTargetMovementTypes().add(movementTypes2);
		movementTypes2.setSourceRepository(this);

		return movementTypes2;
	}

	public MovementType removeTargetMovementType(MovementType movementTypes2) {
		getTargetMovementTypes().remove(movementTypes2);
		movementTypes2.setSourceRepository(null);

		return movementTypes2;
	}

	public List<ProductRepository> getProductRepositories() {
		return this.productRepositories;
	}

	public void setProductRepositories(List<ProductRepository> productRepositories) {
		this.productRepositories = productRepositories;
	}

	public Boolean getExternal() {
		return external;
	}

	public void setExternal(Boolean external) {
		this.external = external;
	}

	public Double getEffectivePricePercentage() {
		return effectivePricePercentage;
	}

	public void setEffectivePricePercentage(Double effectivePricePercentage) {
		this.effectivePricePercentage = effectivePricePercentage;
	}

	public ProductRepository addProductRepository(ProductRepository productRepository) {
		getProductRepositories().add(productRepository);
		productRepository.setRepository(this);

		return productRepository;
	}

	public ProductRepository removeProductRepository(ProductRepository productRepository) {
		getProductRepositories().remove(productRepository);
		productRepository.setRepository(null);

		return productRepository;
	}

	@Override
	public RepositoryDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new RepositoryDto(), include);
	}

	@Override
	public RepositoryDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}