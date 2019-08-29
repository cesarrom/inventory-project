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

import com.inventory.core.business.ProductRepositoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.ProductRepositoryDto;
import com.inventory.models.query.ProductRepositoryQuery;

@RestController
@RequestMapping("/product-repositories")
public class ProductRepositoryController
		extends IABMController<ProductRepositoryDto, ProductRepositoryQuery, ProductRepositoryBusiness> {
	@Autowired
	public ProductRepositoryController(ProductRepositoryBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")

	public ResponseCanonical<ProductRepositoryDto> findProductRepository(@PathVariable Long id) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")

	public ResponseCanonical<List<ProductRepositoryDto>> listProductRepositories(ProductRepositoryQuery query) {
		return new ResponseCanonical<List<ProductRepositoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")

	public ResponseCanonical<ProductRepositoryDto> createProductRepository(@RequestBody ProductRepositoryDto entityParam) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")

	public ResponseCanonical<ProductRepositoryDto> updateProductRepository(@PathVariable Long id,
			@RequestBody ProductRepositoryDto entityParam) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
