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

import com.inventory.core.business.CustomerBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.CustomerDto;
import com.inventory.models.query.CustomerQuery;

@Controller
@RequestMapping("/customers")
public class CustomerSocket extends IAMSocket<CustomerDto, CustomerQuery, CustomerBusiness> {

	@Autowired
	public CustomerSocket(CustomerBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/find-customer/{id}")
	@SendToUser("/queue/customer-found")
	public ResponseCanonical<CustomerDto> findCustomer(@DestinationVariable Long id) {
		return new ResponseCanonical<CustomerDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/list-customers")
	@SendToUser("/queue/customers-listed")
	public ResponseCanonical<List<CustomerDto>> listCustomers(@Payload CustomerQuery query) {
		return new ResponseCanonical<List<CustomerDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/create-customer")
	@SendTo("/topic/customer-created")
	public ResponseCanonical<CustomerDto> createCustomer(@Payload CustomerDto entityParam) {
		return new ResponseCanonical<CustomerDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/update-customer/{id}")
	@SendTo("/topic/customer-updated")
	public ResponseCanonical<CustomerDto> updateCustomer(@DestinationVariable Long id,
			@Payload CustomerDto entityParam) {
		return new ResponseCanonical<CustomerDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
