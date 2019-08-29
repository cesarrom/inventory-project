package com.inventory.core.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.MovementTypeCustomRepository;
import com.inventory.models.MovementType;

public interface MovementTypeDao extends JpaRepository<MovementType, Long>, BaseRepository, MovementTypeCustomRepository {
	Optional<MovementType> findBySourceRepository_IdAndTargetRepository_IdAndParentMovementRequired(Long sourceRepositoryId, Long targetRepositoryId, Boolean parentMovementRequired);
}
