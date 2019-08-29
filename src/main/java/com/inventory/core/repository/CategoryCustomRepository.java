package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Category;
import com.inventory.models.query.CategoryQuery;

public interface CategoryCustomRepository  {
	public List<Category> list(CategoryQuery queryParams);
}
