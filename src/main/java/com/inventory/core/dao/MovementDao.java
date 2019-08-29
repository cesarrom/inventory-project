package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.MovementCustomRepository;
import com.inventory.models.Movement;

public interface MovementDao extends JpaRepository<Movement, Long>, BaseRepository, MovementCustomRepository {
}
