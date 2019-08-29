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

import com.inventory.core.business.MovementTypeBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementTypeDto;
import com.inventory.models.query.MovementTypeQuery;

@RestController
@RequestMapping("/movement-types")
public class MovementTypeController extends IABMController<MovementTypeDto, MovementTypeQuery, MovementTypeBusiness> {
	@Autowired
	public MovementTypeController(MovementTypeBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")

	public ResponseCanonical<MovementTypeDto> findMovementType(@PathVariable Long id) {
		return new ResponseCanonical<MovementTypeDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")

	public ResponseCanonical<List<MovementTypeDto>> listMovementTypes(MovementTypeQuery query) {
		return new ResponseCanonical<List<MovementTypeDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")

	public ResponseCanonical<MovementTypeDto> createMovementType(@RequestBody MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")

	public ResponseCanonical<MovementTypeDto> updateMovementType(@PathVariable Long id, @RequestBody MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
