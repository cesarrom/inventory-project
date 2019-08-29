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

import com.inventory.core.business.MovementDetailBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.MovementDetailDto;
import com.inventory.models.query.MovementDetailQuery;

@Controller
@RequestMapping("/movement-details")
public class MovementDetailSocket extends IAMSocket<MovementDetailDto, MovementDetailQuery, MovementDetailBusiness> {
	@Autowired
	public MovementDetailSocket(MovementDetailBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/find-movement-detail")
	@SendToUser("/queue/movement-detail-found")
	public ResponseCanonical<MovementDetailDto> findMovementDetail(@DestinationVariable Long id) {
		return new ResponseCanonical<MovementDetailDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/list-movement-details")
	@SendToUser("/queue/movement-detail-listed")
	public ResponseCanonical<List<MovementDetailDto>> listMovementDetails(@Payload MovementDetailQuery query) {
		return new ResponseCanonical<List<MovementDetailDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/create-movement-detail")
	@SendTo("/topic/movement-detail-created")
	public ResponseCanonical<MovementDetailDto> createMovementDetail(@Payload MovementDetailDto entityParam) {
		return new ResponseCanonical<MovementDetailDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/update-movement-detail")
	@SendTo("/topic/movement-detail-updated")
	public ResponseCanonical<MovementDetailDto> updateMovementDetail(@DestinationVariable Long id,
			@Payload MovementDetailDto entityParam) {
		return new ResponseCanonical<MovementDetailDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
