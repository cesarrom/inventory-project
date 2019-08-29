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

import com.inventory.core.business.CustomerBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.CustomerDto;
import com.inventory.models.query.CustomerQuery;

@RestController
@RequestMapping("/customers")
public class CustomerController extends IABMController<CustomerDto, CustomerQuery, CustomerBusiness> {

	@Autowired
	public CustomerController(CustomerBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")
	public ResponseCanonical<CustomerDto> findCustomer(@PathVariable Long id) {
		return new ResponseCanonical<CustomerDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")
	public ResponseCanonical<List<CustomerDto>> listCustomers(CustomerQuery query) {
		return new ResponseCanonical<List<CustomerDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")
    @SendTo("/topic/customer-created")
	public ResponseCanonical<CustomerDto> createCustomer(@RequestBody CustomerDto entityParam) {
		return new ResponseCanonical<CustomerDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")
    @SendTo("/topic/customer-updated")
	public ResponseCanonical<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto entityParam) {
		return new ResponseCanonical<CustomerDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
