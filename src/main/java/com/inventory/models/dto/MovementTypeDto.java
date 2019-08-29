package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.inventory.models.MovementType;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the movement_types database table.
 * 
 */

public class MovementTypeDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date createdAt;

	private String description;

	private String name;

	private Date updatedAt;

	private Boolean parentMovementRequired;

	// bi-directional many-to-one association to MovementDto

	private List<MovementDto> movements;

	// bi-directional many-to-one association to RepositoryDto

	//
	private RepositoryDto targetRepository;

	// bi-directional many-to-one association to RepositoryDto

	//
	private RepositoryDto sourceRepository;

	public MovementTypeDto() {
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

	public List<MovementDto> getMovements() {
		return this.movements;
	}

	public void setMovements(List<MovementDto> movements) {
		this.movements = movements;
	}

	public MovementDto addMovement(MovementDto movementDetail) {
		getMovements().add(movementDetail);
		movementDetail.setMovementType(this);

		return movementDetail;
	}

	public MovementDto removeMovement(MovementDto movementDetail) {
		getMovements().remove(movementDetail);
		movementDetail.setMovementType(null);

		return movementDetail;
	}

	public RepositoryDto getTargetRepository() {
		return this.targetRepository;
	}

	public void setTargetRepository(RepositoryDto repository1) {
		this.targetRepository = repository1;
	}

	public Boolean isParentMovementRequired() {
		return parentMovementRequired;
	}

	public void setParentMovementRequired(Boolean parentMovementRequired) {
		this.parentMovementRequired = parentMovementRequired;
	}

	public RepositoryDto getSourceRepository() {
		return this.sourceRepository;
	}

	public void setSourceRepository(RepositoryDto repository2) {
		this.sourceRepository = repository2;
	}

	public MovementType fillCrudModel(String[] includes) {
		// TODO Auto-generated method stub
		return BaseFill.actualFillToBaseModel(this, new MovementType(), includes);
	}

	public MovementType fillCrudModel() {
		return this.fillCrudModel(new String[] {});
	}

}