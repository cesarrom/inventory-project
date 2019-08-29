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

import com.inventory.models.dto.MovementDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the movements database table.
 * 
 */
@Entity
@Table(name="movements")
@NamedQuery(name="Movement.findAll", query="SELECT m FROM Movement m")
public class Movement extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVEMENTS_ID_GENERATOR", sequenceName="MOVEMENTS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVEMENTS_ID_GENERATOR")
	private Long id;

	private String code;

	private String comments;

	@Column(name="created_at")
	private Date createdAt;

	@Column(name="movement_date")
	private Date movementDate;

	@Column(name="total_value")
	private double totalValue;

	private Integer type;

	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to MovementDetailDto
	@OneToMany(mappedBy="movement")
	private List<MovementDetail> movementDetails;

	//bi-directional many-to-one association to CustomerDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "customer_fk")
	private Customer customer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="movement_type_fk")
	private MovementType movementType;
	
	//bi-directional many-to-one association to MovementDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="parent_movement_fk")
	private Movement movement;

	//bi-directional many-to-one association to MovementDto
	@OneToMany(mappedBy="movement")
	private List<Movement> childrenMovement;

	//bi-directional many-to-one association to SupplierDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "supplier_fk")
	private Supplier supplier;

	public Movement() {
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

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getMovementDate() {
		return this.movementDate;
	}

	public void setMovementDate(Date movementDate) {
		this.movementDate = movementDate;
	}

	public double getTotalValue() {
		return this.totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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
		movementDetail.setMovement(this);

		return movementDetail;
	}

	public MovementDetail removeMovementDetail(MovementDetail movementDetail) {
		getMovementDetails().remove(movementDetail);
		movementDetail.setMovement(null);

		return movementDetail;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Movement getMovement() {
		return this.movement;
	}

	public void setMovement(Movement movement) {
		this.movement = movement;
	}

	public List<Movement> getChildrenMovement() {
		return this.childrenMovement;
	}

	public void setChildrenMovement(List<Movement> movements) {
		this.childrenMovement = movements;
	}

	public Movement addMovement(Movement movement) {
		getChildrenMovement().add(movement);
		movement.setMovement(this);

		return movement;
	}

	public Movement removeMovement(Movement movement) {
		getChildrenMovement().remove(movement);
		movement.setMovement(null);

		return movement;
	}

	public Supplier getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public MovementType getMovementType() {
		return this.movementType;
	}

	public void setMovementType(MovementType movementType) {
		this.movementType = movementType;
	}

	@Override
	public MovementDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new MovementDto(), include);
	}

	@Override
	public MovementDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}