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

import com.inventory.core.business.ProductRepositoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.ProductRepositoryDto;
import com.inventory.models.query.ProductRepositoryQuery;

@Controller
//@RequestMapping("/product-repositories")
public class ProductRepositorySocket
		extends IAMSocket<ProductRepositoryDto, ProductRepositoryQuery, ProductRepositoryBusiness> {
	@Autowired
	public ProductRepositorySocket(ProductRepositoryBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/product-repositories/find-product-repository")
	@SendToUser("/queue/product-repositories/product-repository-found")
	public ResponseCanonical<ProductRepositoryDto> findProductRepository(@DestinationVariable Long id) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/product-repositories/list-product-repositories")
	@SendToUser("/queue/product-repositories/product-repositories-listed")
	public ResponseCanonical<List<ProductRepositoryDto>> listProductRepositories(
			@Payload ProductRepositoryQuery query) {
		return new ResponseCanonical<List<ProductRepositoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/product-repositories/create-product-repository")
	@SendTo("/topic/product-repositories/product-repository-created")
	public ResponseCanonical<ProductRepositoryDto> createProductRepository(@Payload ProductRepositoryDto entityParam) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/product-repositories/update-product-repository/{id}")
	@SendTo("/topic/product-repositories/product-repository-updated")
	public ResponseCanonical<ProductRepositoryDto> updateProductRepository(@DestinationVariable Long id,
			@Payload ProductRepositoryDto entityParam) {
		return new ResponseCanonical<ProductRepositoryDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
