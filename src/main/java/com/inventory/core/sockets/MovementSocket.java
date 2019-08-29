package com.inventory.core.sockets;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.inventory.core.business.MovementBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementDto;
import com.inventory.models.query.MovementQuery;
import com.inventory.utils.ObjectUtils;

@Controller
@RequestMapping("/movements")
public class MovementSocket {

	MovementBusiness business;

	@Autowired
	public MovementSocket(MovementBusiness business) {
		this.business = business;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@MessageMapping("/rollback-movement/{parentMovementId}")
	@SendToUser("/queue/movement-rolledback")
	public ResponseCanonical<MovementDto> rollbackMovement(@DestinationVariable Long parentMovementId,
			@Payload MovementDto headerInfo) {
		if (ObjectUtils.isThruthy(headerInfo) && ObjectUtils.isThruthy(headerInfo.getMovementDetails())) {
			return new ResponseCanonical<MovementDto>(this.business
					.partiallyRollbackMovement(parentMovementId, headerInfo.getMovementDetails(), headerInfo)
					.fillDtoModel());
		}
		return new ResponseCanonical<MovementDto>(
				this.business.rollbackMovement(parentMovementId, headerInfo).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@MessageMapping("/generate-movement")
	@SendToUser("/queue/movement-generated")
	public ResponseCanonical<MovementDto> generateMovement(@Payload MovementDto movementInfo) {
		return new ResponseCanonical<MovementDto>(this.business.generateMovement(movementInfo).fillDtoModel());
	}

	@MessageMapping("/list-movements")
	@SendTo("/topic/movements-listed")
	public ResponseCanonical<List<MovementDto>> listMovements(@Payload MovementQuery query) {
		return new ResponseCanonical<List<MovementDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));

	}

	@MessageMapping("/find-movement/{movementId}")
	@SendTo("/topic/movement-found")
	public ResponseCanonical<MovementDto> findMovement(@DestinationVariable Long movementId) {
		return new ResponseCanonical<MovementDto>(this.business.find(movementId).fillDtoModel());
	}
}
