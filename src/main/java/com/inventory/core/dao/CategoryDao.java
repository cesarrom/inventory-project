package com.inventory.core.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.core.repository.BaseRepository;
import com.inventory.core.repository.CategoryCustomRepository;
import com.inventory.models.Category;

public interface CategoryDao extends JpaRepository<Category, Long>, BaseRepository, CategoryCustomRepository  {
}
