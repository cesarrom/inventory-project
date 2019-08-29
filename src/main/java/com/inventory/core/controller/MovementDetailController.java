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

import com.inventory.core.business.MovementDetailBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.query.MovementDetailQuery;

@RestController
@RequestMapping("/movement-details")
public class MovementDetailController
		extends IABMController<MovementDetailDto, MovementDetailQuery, MovementDetailBusiness> {
	@Autowired
	public MovementDetailController(MovementDetailBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")
	public ResponseCanonical<MovementDetailDto> findMovementDetail(@PathVariable Long id) {
		return new ResponseCanonical<MovementDetailDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")
	public ResponseCanonical<List<MovementDetailDto>> listMovementDetails(MovementDetailQuery query) {
		return new ResponseCanonical<List<MovementDetailDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")
	@SendTo("/topic/movement-detail-created")
	public ResponseCanonical<MovementDetailDto> createMovementDetail(@RequestBody MovementDetailDto entityParam) {
		return new ResponseCanonical<MovementDetailDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")
	@SendTo("/topic/movement-detail-updated")
	public ResponseCanonical<MovementDetailDto> updateMovementDetail(@PathVariable Long id,
			@RequestBody MovementDetailDto entityParam) {
		return new ResponseCanonical<MovementDetailDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
