package com.inventory.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.core.business.CategoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.CategoryDto;
import com.inventory.models.query.CategoryQuery;

@RestController
@RequestMapping("/categories")
public class CategoryController extends IABMController<CategoryDto, CategoryQuery, CategoryBusiness> {

	@Autowired
	public CategoryController(CategoryBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")
	public ResponseCanonical<CategoryDto> findCategory(@PathVariable Long id) {
		return new ResponseCanonical<CategoryDto>(this.business.find(id).fillDtoModel(new String[] { "products" }));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")
	public ResponseCanonical<List<CategoryDto>> listCategories(CategoryQuery query) {
		return new ResponseCanonical<List<CategoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")
    @SendTo("/topic/category-created")
	public ResponseCanonical<CategoryDto> createCategory(@RequestBody CategoryDto entityParam) {
		return new ResponseCanonical<CategoryDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")
    @SendTo("/topic/category-updated")
	public ResponseCanonical<CategoryDto> updateCategory(@PathVariable Long id, @RequestBody CategoryDto entityParam) {
		return new ResponseCanonical<CategoryDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
