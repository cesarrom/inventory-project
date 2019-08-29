package com.inventory.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.core.business.ProductBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.ProductDto;
import com.inventory.models.query.ProductQuery;

@RestController
@RequestMapping("/products")
public class ProductController extends IABMController<ProductDto, ProductQuery, ProductBusiness> {
	private String[] includesDirectRelations = { "supplier", "category", "movementDetails", "productRepositories" };

	@Autowired
	public ProductController(ProductBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")

	public ResponseCanonical<ProductDto> findProduct(@PathVariable Long id) {
		return new ResponseCanonical<ProductDto>(this.business.find(id).fillDtoModel(includesDirectRelations));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")

	public ResponseCanonical<List<ProductDto>> listProducts(ProductQuery query) {
		return new ResponseCanonical<List<ProductDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel(includesDirectRelations)).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")

	public ResponseCanonical<ProductDto> createProduct(@RequestBody ProductDto entityParam) {
		return new ResponseCanonical<ProductDto>(
				this.business.create(entityParam).fillDtoModel(includesDirectRelations));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")

	public ResponseCanonical<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductDto entityParam) {
		return new ResponseCanonical<ProductDto>(
				this.business.update(id, entityParam).fillDtoModel(includesDirectRelations));
	}

}
