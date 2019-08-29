package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.RepositoryCustomRepository;
import com.inventory.models.Repository;

public interface RepositoryDao extends JpaRepository<Repository, Long>, BaseRepository, RepositoryCustomRepository {
}
