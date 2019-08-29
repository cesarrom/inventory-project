package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.Movement;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the movementDtos database table.
 * 
 */

public class MovementDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String code;

	private String comments;

	private Date createdAt;

	private Date movementDate;

	private double totalValue;

	private Integer type;

	private Date updatedAt;

	// bi-directional many-to-one association to MovementDetailDto

	private List<MovementDetailDto> movementDetails;

	// bi-directional many-to-one association to CustomerDto

	private CustomerDto customer;

	private MovementTypeDto movementType;

	// bi-directional many-to-one association to MovementDto

	private MovementDto movement;

	// bi-directional many-to-one association to MovementDto

	private List<MovementDto> childrenMovement;

	// bi-directional many-to-one association to SupplierDto

	private SupplierDto supplier;

	public MovementDto() {
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

	public List<MovementDetailDto> getMovementDetails() {
		return this.movementDetails;
	}

	public void setMovementDetails(List<MovementDetailDto> movementDetails) {
		this.movementDetails = movementDetails;
	}

	public MovementDetailDto addMovementDetail(MovementDetailDto movementDetail) {
		getMovementDetails().add(movementDetail);
		movementDetail.setMovement(this);

		return movementDetail;
	}

	public MovementDetailDto removeMovementDetail(MovementDetailDto movementDetail) {
		getMovementDetails().remove(movementDetail);
		movementDetail.setMovement(null);

		return movementDetail;
	}

	public CustomerDto getCustomer() {
		return this.customer;
	}

	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}

	public MovementDto getMovement() {
		return this.movement;
	}

	public void setMovement(MovementDto movement) {
		this.movement = movement;
	}

	public List<MovementDto> getChildrenMovement() {
		return this.childrenMovement;
	}

	public void setChildrenMovement(List<MovementDto> movements) {
		this.childrenMovement = movements;
	}

	public MovementDto addMovement(MovementDto movement) {
		getChildrenMovement().add(movement);
		movement.setMovement(this);

		return movement;
	}

	public MovementDto removeMovement(MovementDto movement) {
		getChildrenMovement().remove(movement);
		movement.setMovement(null);

		return movement;
	}

	public SupplierDto getSupplier() {
		return this.supplier;
	}

	public void setSupplier(SupplierDto supplier) {
		this.supplier = supplier;
	}

	public MovementTypeDto getMovementType() {
		return this.movementType;
	}

	public void setMovementType(MovementTypeDto movementType) {
		this.movementType = movementType;
	}

	public Movement fillCrudModel(String[] includes) {
		// TODO Auto-generated method stub
		return BaseFill.actualFillToBaseModel(this, new Movement(), includes);
	}

	public Movement fillCrudModel() {
		// TODO Auto-generated method stub
		return this.fillCrudModel(new String[] {});
	}

}