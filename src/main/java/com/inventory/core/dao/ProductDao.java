package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.ProductCustomRepository;
import com.inventory.models.Product;

public interface ProductDao extends JpaRepository<Product, Long>, BaseRepository, ProductCustomRepository {
}
