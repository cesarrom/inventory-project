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

import com.inventory.core.business.SupplierBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.SupplierDto;
import com.inventory.models.query.SupplierQuery;

@Controller
//@RequestMapping("/suppliers")
public class SupplierSocket extends IAMSocket<SupplierDto, SupplierQuery, SupplierBusiness> {
	@Autowired
	public SupplierSocket(SupplierBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/suppliers/find-supplier/{id}")
	@SendToUser("/queue/suppliers/supplier-found")
	public ResponseCanonical<SupplierDto> findSupplier(@DestinationVariable Long id) {
		return new ResponseCanonical<SupplierDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/suppliers/list-suppliers")
	@SendToUser("/queue/suppliers/suppliers-listed")
	public ResponseCanonical<List<SupplierDto>> listSuppliers(@Payload SupplierQuery query) {
		return new ResponseCanonical<List<SupplierDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/suppliers/create-supplier")
	@SendTo("/topic/suppliers/supplier-created")
	public ResponseCanonical<SupplierDto> createSupplier(@Payload SupplierDto entityParam) {
		return new ResponseCanonical<SupplierDto>(
				this.business.create(entityParam).fillDtoModel(new String[] { "movements", "products" }));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/suppliers/update-supplier/{id}")
	@SendTo("/topic/suppliers/supplier-updated")
	public ResponseCanonical<SupplierDto> updateSupplier(@DestinationVariable Long id,
			@Payload SupplierDto entityParam) {
		return new ResponseCanonical<SupplierDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
