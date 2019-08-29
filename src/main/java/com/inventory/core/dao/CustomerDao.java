package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.CustomerCustomRepository;
import com.inventory.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Long>, BaseRepository, CustomerCustomRepository {
}
