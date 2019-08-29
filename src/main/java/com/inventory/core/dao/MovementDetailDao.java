package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.MovementDetailCustomRepository;
import com.inventory.models.MovementDetail;

public interface MovementDetailDao extends JpaRepository<MovementDetail, Long>, BaseRepository, MovementDetailCustomRepository {
}
