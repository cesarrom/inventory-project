package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Movement;
import com.inventory.models.query.MovementQuery;

public interface MovementCustomRepository {
	public List<Movement> list(MovementQuery queryParams);
}
