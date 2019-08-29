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

import com.inventory.models.dto.MovementTypeDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the movement_types database table.
 * 
 */
@Entity
@Table(name="movement_types")
@NamedQuery(name="MovementType.findAll", query="SELECT m FROM MovementType m")
public class MovementType extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MOVEMENT_TYPES_ID_GENERATOR", sequenceName="MOVEMENT_TYPES_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MOVEMENT_TYPES_ID_GENERATOR")
	private Long id;

	@Column(name="created_at")
	private Date createdAt;

	private String description;

	private String name;

	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="parent_movement_required")
	private Boolean parentMovementRequired;
	
	//bi-directional many-to-one association to MovementDto
	@OneToMany(mappedBy="movementType")
	private List<Movement> movements;

	//bi-directional many-to-one association to RepositoryDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "target_repository_fk")
	private Repository targetRepository;

	//bi-directional many-to-one association to RepositoryDto
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="source_repository_fk")
	private Repository sourceRepository;

	public MovementType() {
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

	public List<Movement> getMovements() {
		return this.movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Movement addMovement(Movement movementDetail) {
		getMovements().add(movementDetail);
		movementDetail.setMovementType(this);

		return movementDetail;
	}

	public Movement removeMovement(Movement movementDetail) {
		getMovements().remove(movementDetail);
		movementDetail.setMovementType(null);

		return movementDetail;
	}

	public Repository getTargetRepository() {
		return this.targetRepository;
	}

	public void setTargetRepository(Repository repository1) {
		this.targetRepository = repository1;
	}

	public Boolean isParentMovementRequired() {
		return parentMovementRequired;
	}

	public void setParentMovementRequired(Boolean parentMovementRequired) {
		this.parentMovementRequired = parentMovementRequired;
	}

	public Repository getSourceRepository() {
		return this.sourceRepository;
	}

	public void setSourceRepository(Repository repository2) {
		this.sourceRepository = repository2;
	}

	@Override
	public MovementTypeDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new MovementTypeDto(), include);
	}

	@Override
	public MovementTypeDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}