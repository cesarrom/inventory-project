package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.MovementType;
import com.inventory.models.query.MovementTypeQuery;

public interface MovementTypeCustomRepository {
	public List<MovementType> list(MovementTypeQuery queryParams);
}
