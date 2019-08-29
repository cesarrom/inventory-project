package com.inventory.core.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.ProductRepositoryCustomRepository;
import com.inventory.models.ProductRepository;

public interface ProductRepositoryDao extends JpaRepository<ProductRepository, Long>, BaseRepository, ProductRepositoryCustomRepository {
	Optional<ProductRepository> findByProduct_IdAndRepository_Id(Long productId, Long repositoryId);

}
