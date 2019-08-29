package com.inventory.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inventory.models.dto.MovementDetailDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the movement_details database table.
 * 
 */
@Entity
@Table(name="movement_details")
@NamedQuery(name="MovementDetail.findAll", query="SELECT m FROM MovementDetail m")
public class MovementDetail extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVEMENT_DETAILS_ID_GENERATOR", sequenceName="MOVEMENT_DETAILS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVEMENT_DETAILS_ID_GENERATOR")
	private Long id;

	@Column(name="created_at")
	private Date createdAt;

	private double quantity;

	@Column(name="updated_at")
	private Date updatedAt;

	private double value;

	//bi-directional many-to-one association to MovementTypeDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "source_product_repository_fk")
	private ProductRepository sourceProductRepository;
	
	//bi-directional many-to-one association to MovementDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "target_product_repository_fk")
	private ProductRepository targetProductRepository;

	//bi-directional many-to-one association to MovementDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "movement_fk")
	private Movement movement;

	//bi-directional many-to-one association to ProductDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_fk")
	private Product product;

	public MovementDetail() {
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

	

	public Movement getMovement() {
		return this.movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductRepository getSourceProductRepository() {
		return sourceProductRepository;
	}

	public void setSourceProductRepository(ProductRepository sourceProductRepository) {
		this.sourceProductRepository = sourceProductRepository;
	}

	public ProductRepository getTargetProductRepository() {
		return targetProductRepository;
	}

	public void setTargetProductRepository(ProductRepository targetProductRepository) {
		this.targetProductRepository = targetProductRepository;
	}

	@Override
	public MovementDetailDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new MovementDetailDto(), include);
	}

	@Override
	public MovementDetailDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}
	
}