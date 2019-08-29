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

import com.inventory.core.business.RepositoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.RepositoryDto;
import com.inventory.models.query.RepositoryQuery;

@Controller
@RequestMapping("/repositories")
public class RepositorySocket extends IAMSocket<RepositoryDto, RepositoryQuery, RepositoryBusiness> {
	@Autowired
	public RepositorySocket(RepositoryBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/find-repositoriy")
	@SendToUser("/queue/repository-found")
	public ResponseCanonical<RepositoryDto> findRepository(@DestinationVariable Long id) {
		return new ResponseCanonical<RepositoryDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/list-repositories")
	@SendToUser("/queue/repositories-listed")
	public ResponseCanonical<List<RepositoryDto>> listRepositories(@Payload RepositoryQuery query) {
		return new ResponseCanonical<List<RepositoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/create-repository")
	@SendTo("/topic/repository-created")
	public ResponseCanonical<RepositoryDto> createRepository(@Payload RepositoryDto entityParam) {
		return new ResponseCanonical<RepositoryDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/update-repository/{id}")
	@SendTo("/topic/repository-updated")
	public ResponseCanonical<RepositoryDto> updateRepository(@DestinationVariable Long id,
			@Payload RepositoryDto entityParam) {
		return new ResponseCanonical<RepositoryDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
