package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.CategoryBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.Category;
import com.inventory.models.dto.CategoryDto;
import com.inventory.models.query.CategoryQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class CategoryBusinessImpl implements CategoryBusiness {
	
	private DaoIndex daos;

	@Autowired
	public CategoryBusinessImpl(DaoIndex daos) {
		this.daos = daos;
	}

	@Override
	public Category create(CategoryDto category) {
		if(ObjectUtils.isFalsey(category))
			throw new BadRequestException("THE CATEGORY OBJECT CANNOT BE NULL!");
		Category crudCategory = category.fillCrudModel(); 
		this.daos.getCategoryDao().create(crudCategory);
		if(ObjectUtils.isThruthy(category.getParentCategory()))
			crudCategory.setParentCategory(this.find(category.getParentCategory().getId()));
		return crudCategory;
	}

	@Override
	public List<Category> list(CategoryQuery query) {
		return this.daos.getCategoryDao().list(query);
	}

	@Override
	public Category update(Long categoryId, CategoryDto categoryParams) {
		Category category = this.daos.getCategoryDao().findById(categoryId).orElseThrow(() -> new NotFoundException("CATEGORY NOT FOUND [id:"+categoryId+"]"));
		ObjectUtils.copyPropertiesIgnoringNulls(categoryParams, category);
		this.daos.getCategoryDao().update(category);
		return category;
	}

	@Override
	public Category find(Long categoryId) {
		return this.daos.getCategoryDao().findById(categoryId).orElseThrow(() -> new NotFoundException("CATEGORY NOT FOUND [id:"+categoryId+"]"));
	}

	
}
