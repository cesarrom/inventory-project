package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.MovementDetail;
import com.inventory.models.query.MovementDetailQuery;

public interface MovementDetailCustomRepository {
	public List<MovementDetail> list(MovementDetailQuery queryParams);
}
