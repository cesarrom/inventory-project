package com.inventory.core.business;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.models.Movement;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.dto.MovementDto;
import com.inventory.models.query.MovementQuery;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface MovementBusiness {
	/**
	 * Takes a specific movement and generates an opposite equivalent based on its movementDetails
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public Movement rollbackMovement(Long parentMovementId, MovementDto headerInfo);
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Takes a specific movement and generates a partial opposite based on some of its movementDetails
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public Movement partiallyRollbackMovement(Long movementId, List<MovementDetailDto> partiallyRollbackInfo, MovementDto headerInfo);

	

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * */
	@Transactional(propagation = Propagation.REQUIRED)
	public Movement generateMovement(MovementDto movementInfo);
	
	
	public List<Movement> list(MovementQuery query);
	
	public Movement find(Long movementId);

	
}
