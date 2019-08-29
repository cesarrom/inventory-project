package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.BusinessesIndex;
import com.inventory.core.business.MovementTypeBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.MovementType;
import com.inventory.models.dto.MovementTypeDto;
import com.inventory.models.query.MovementTypeQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class MovementTypeBusinessImpl implements MovementTypeBusiness {

	private DaoIndex daos;
	private BusinessesIndex businesses;

	@Autowired
	public MovementTypeBusinessImpl(DaoIndex daos, BusinessesIndex businesses) {
		this.daos = daos;
		this.businesses = businesses;
	}

	@Override
	public MovementType create(MovementTypeDto movementType) {
		if (ObjectUtils.isFalsey(movementType))
			throw new BadRequestException("THE MOVEMENT TYPE DETAIL OBJECT CANNOT BE NULL");
		MovementType crudMovementType = this.daos.getMovementTypeDao().create(movementType.fillCrudModel());
		if (ObjectUtils.isFalsey(movementType.getSourceRepository()))
			throw new BadRequestException("YOU MUST PROVIDE A SOURCE REPOSITORY TO CREATE A MOVEMENT TYPE!");
		if (ObjectUtils.isFalsey(movementType.getTargetRepository()))
			throw new BadRequestException("YOU MUST PROVIDE A TARGET REPOSITORY TO CREATE A MOVEMENT TYPE!");
		crudMovementType.setSourceRepository(
				this.businesses.getRepositoryBusuiness().find(movementType.getSourceRepository().getId()));
		crudMovementType.setTargetRepository(
				this.businesses.getRepositoryBusuiness().find(movementType.getTargetRepository().getId()));
		return crudMovementType;
	}

	@Override
	public List<MovementType> list(MovementTypeQuery query) {
		return this.daos.getMovementTypeDao().list(query);
	}

	@Override
	public MovementType update(Long movementTypeId, MovementTypeDto movementTypeParams) {
		if (ObjectUtils.isFalsey(movementTypeParams))
			throw new BadRequestException("THE MOVEMENT TYPE OBJECT CANNOT BE NULL");
		MovementType movementType = this.find(movementTypeId);
		ObjectUtils.copyPropertiesIgnoringNulls(movementTypeParams, movementType);
		this.daos.getMovementTypeDao().update(movementType);
		if (ObjectUtils.isThruthy(movementTypeParams.getSourceRepository()))
			movementType.setSourceRepository(
					this.businesses.getRepositoryBusuiness().find(movementType.getSourceRepository().getId()));
		if (ObjectUtils.isThruthy(movementTypeParams.getTargetRepository()))
			movementType.setSourceRepository(
					this.businesses.getRepositoryBusuiness().find(movementType.getSourceRepository().getId()));
		return movementType;
	}

	@Override
	public MovementType find(Long movementTypeId) {
		return this.daos.getMovementTypeDao().findById(movementTypeId)
				.orElseThrow(() -> new NotFoundException("MOVEMENT TYPE NOT FOUND [id:" + movementTypeId + "]"));
	}

	@Override
	public MovementType findBySourceAndTargetRepository(Long sourceRepositoryId, Long targetRepositoryId) {
		return this.findBySourceAndTargetRepository(sourceRepositoryId, targetRepositoryId, false);
	}

	@Override
	public MovementType findBySourceAndTargetRepository(Long sourceRepositoryId, Long targetRepositoryId,
			Boolean parentRequired) {
		// TODO Auto-generated method stub
		return this.daos.getMovementTypeDao()
				.findBySourceRepository_IdAndTargetRepository_IdAndParentMovementRequired(sourceRepositoryId, targetRepositoryId, parentRequired)
				.orElseThrow(() -> new BadRequestException("NO MOVEMENT TYPE FOUND GIVEN SOURCE AND TARGET REPOS ["
						+ sourceRepositoryId + ", " + targetRepositoryId + "]"));
	}

}
