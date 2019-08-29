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

import com.inventory.core.business.MovementTypeBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementTypeDto;
import com.inventory.models.query.MovementTypeQuery;

@Controller
@RequestMapping("/movement-types")
public class MovementTypeSocket extends IAMSocket<MovementTypeDto, MovementTypeQuery, MovementTypeBusiness> {
	@Autowired
	public MovementTypeSocket(MovementTypeBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/find-categories")
	@SendToUser("/queue/movement-type-found")
	public ResponseCanonical<MovementTypeDto> findMovementType(@DestinationVariable Long id) {
		return new ResponseCanonical<MovementTypeDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/list-movement-types")
	@SendToUser("/queue/movement-types-listed")
	public ResponseCanonical<List<MovementTypeDto>> listMovementTypes(@Payload MovementTypeQuery query) {
		return new ResponseCanonical<List<MovementTypeDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/create-movement-type")
	@SendTo("/topic/movement-type-created")
	public ResponseCanonical<MovementTypeDto> createMovementType(@Payload MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/update-movement-type/{id}")
	@SendTo("/topic/movement-type-updated")
	public ResponseCanonical<MovementTypeDto> updateMovementType(@DestinationVariable Long id,
			@Payload MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
