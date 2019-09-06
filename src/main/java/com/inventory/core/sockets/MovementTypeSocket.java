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

import com.inventory.core.business.MovementTypeBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementTypeDto;
import com.inventory.models.query.MovementTypeQuery;

@Controller
//@RequestMapping("/movement-types")
public class MovementTypeSocket extends IAMSocket<MovementTypeDto, MovementTypeQuery, MovementTypeBusiness> {
	private static final String[] MOVEMENT_TYPE_INCLUDES= {"sourceRepository", "targetRepository"};
	@Autowired
	public MovementTypeSocket(MovementTypeBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/movement-types/find-categories")
	@SendToUser("/queue/movement-types/movement-type-found")
	public ResponseCanonical<MovementTypeDto> findMovementType(@DestinationVariable Long id) {
		return new ResponseCanonical<MovementTypeDto>(this.business.find(id).fillDtoModel(MOVEMENT_TYPE_INCLUDES));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/movement-types/list-movement-types")
	@SendToUser("/queue/movement-types/movement-types-listed")
	public ResponseCanonical<List<MovementTypeDto>> listMovementTypes(@Payload MovementTypeQuery query) {
		return new ResponseCanonical<List<MovementTypeDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel(MOVEMENT_TYPE_INCLUDES)).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/movement-types/create-movement-type")
	@SendTo("/topic/movement-types/movement-type-created")
	public ResponseCanonical<MovementTypeDto> createMovementType(@Payload MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.create(entityParam).fillDtoModel(MOVEMENT_TYPE_INCLUDES));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/movement-types/update-movement-type/{id}")
	@SendTo("/topic/movement-types/movement-type-updated")
	public ResponseCanonical<MovementTypeDto> updateMovementType(@DestinationVariable Long id,
			@Payload MovementTypeDto entityParam) {
		return new ResponseCanonical<MovementTypeDto>(this.business.update(id, entityParam).fillDtoModel(MOVEMENT_TYPE_INCLUDES));
	}

}
