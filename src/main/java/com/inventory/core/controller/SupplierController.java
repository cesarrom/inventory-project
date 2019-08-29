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

import com.inventory.core.business.SupplierBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.SupplierDto;
import com.inventory.models.query.SupplierQuery;

@RestController
@RequestMapping("/suppliers")
public class SupplierController extends IABMController<SupplierDto, SupplierQuery, SupplierBusiness> {
	@Autowired
	public SupplierController(SupplierBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")

	public ResponseCanonical<SupplierDto> findSupplier(@PathVariable Long id) {
		return new ResponseCanonical<SupplierDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")

	public ResponseCanonical<List<SupplierDto>> listSuppliers(SupplierQuery query) {
		return new ResponseCanonical<List<SupplierDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")

	public ResponseCanonical<SupplierDto> createSupplier(@RequestBody SupplierDto entityParam) {
		return new ResponseCanonical<SupplierDto>(
				this.business.create(entityParam).fillDtoModel(new String[] { "movements", "products" }));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")

	public ResponseCanonical<SupplierDto> updateSupplier(@PathVariable Long id, @RequestBody SupplierDto entityParam) {
		return new ResponseCanonical<SupplierDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
