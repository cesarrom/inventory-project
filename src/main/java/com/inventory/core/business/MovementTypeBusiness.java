package com.inventory.core.business;

import com.inventory.models.MovementType;
import com.inventory.models.dto.MovementTypeDto;
import com.inventory.models.query.MovementTypeQuery;

public interface MovementTypeBusiness extends BaseBusiness<MovementTypeDto, MovementTypeQuery, MovementType> {
	MovementType findBySourceAndTargetRepository(Long sourceRepositoryId, Long targetRepositoryId);
	MovementType findBySourceAndTargetRepository(Long sourceRepositoryId, Long targetRepositoryId, Boolean parentRequired);
}
