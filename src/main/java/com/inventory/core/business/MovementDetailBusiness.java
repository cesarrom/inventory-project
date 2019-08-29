package com.inventory.core.business;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.inventory.models.MovementDetail;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.query.MovementDetailQuery;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public interface MovementDetailBusiness extends BaseBusiness<MovementDetailDto, MovementDetailQuery, MovementDetail>{
	
	/**
	 * Initialize a product repository by moving certain quantity of it from  RepositoryDto.OUTSIDE to the specified repository,
	 * This movement is of type MovementTypeDto.INITIALIZE
	 * */
	//@Transactional(propagation = Propagation.REQUIRED)
	//public MovementDetail initializeProductRepository(MovementDetailDto movementDetailInfo);
	
	/**
	 * Increments a product repository by moving certain quantity of it from  RepositoryDto.OUTSIDE to the specified repository,
	 * This movement is of type MovementTypeDto.INCOME
	 * */
	//@Transactional(propagation = Propagation.REQUIRED)
	//public MovementDetail addToProductRepository(MovementDetailDto movementDetailInfo);
	
	/**
	 * Decrements a product repository by moving certain quantity of it from the specified repository to RepositoryDto.OUTSIDE,
	 * This movement is of type MovementTypeDto.OUTGOING
	 * */
	//@Transactional(propagation = Propagation.REQUIRED)
	//public MovementDetail removeFromProductRepository(MovementDetailDto movementDetailInfo);
	
	/**
	 * Moves a product from one repository to another, so you have to specify the movementType, and the quantity
	 * */
	//@Transactional(propagation = Propagation.REQUIRED)
	//public MovementDetail moveProduct(MovementDetailDto movementDetailInfo);
	
	//public MovementDetail find(Long movementDetailId);
	
	//public List<MovementDetail> list(MovementDetailQuery query);
}
