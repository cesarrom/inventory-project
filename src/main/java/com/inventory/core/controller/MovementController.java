package com.inventory.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.core.business.MovementBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementDto;
import com.inventory.models.query.MovementQuery;
import com.inventory.utils.ObjectUtils;

@RestController
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/movements")
public class MovementController {

	MovementBusiness business;

	@Autowired
	public MovementController(MovementBusiness business) {
		this.business = business;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@PutMapping("/{parentMovementId}")
    @SendTo("/topic/movement-rolledback")
	public ResponseCanonical<MovementDto> rollbackMovement(@PathVariable Long parentMovementId,
			@RequestBody MovementDto headerInfo) {
		if (ObjectUtils.isThruthy(headerInfo) && ObjectUtils.isThruthy(headerInfo.getMovementDetails())) {
			return new ResponseCanonical<MovementDto>(this.business
					.partiallyRollbackMovement(parentMovementId, headerInfo.getMovementDetails(), headerInfo)
					.fillDtoModel());
		}
		return new ResponseCanonical<MovementDto>(
				this.business.rollbackMovement(parentMovementId, headerInfo).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@PostMapping("/")
    @SendTo("/topic/movement-generated")
	public ResponseCanonical<MovementDto> generateMovement(@RequestBody MovementDto movementInfo) {
		return new ResponseCanonical<MovementDto>(this.business.generateMovement(movementInfo).fillDtoModel());
	}

	@GetMapping("/")
	public ResponseCanonical<List<MovementDto>> listMovements(MovementQuery query) {
		return new ResponseCanonical<List<MovementDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));

	}

	@GetMapping("/{movementId}")
	public ResponseCanonical<MovementDto> findMovement(@PathVariable Long movementId) {
		return new ResponseCanonical<MovementDto>(this.business.find(movementId).fillDtoModel());
	}
}
