package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.SupplierCustomRepository;
import com.inventory.models.Supplier;

public interface SupplierDao extends JpaRepository<Supplier, Long>, BaseRepository, SupplierCustomRepository {
}
