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

import com.inventory.core.business.ProductBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.ProductDto;
import com.inventory.models.query.ProductQuery;

@Controller
//@RequestMapping("/products")
public class ProductSocket extends IAMSocket<ProductDto, ProductQuery, ProductBusiness> {
	private String[] includesDirectRelations = { "supplier", "category", "movementDetails", "productRepositories" };

	@Autowired
	public ProductSocket(ProductBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/products/find-product")
	@SendToUser("/queue/products/product-found")
	public ResponseCanonical<ProductDto> findProduct(@DestinationVariable Long id) {
		return new ResponseCanonical<ProductDto>(this.business.find(id).fillDtoModel(includesDirectRelations));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/products/list-products")
	@SendToUser("/queue/products/products-listed")
	public ResponseCanonical<List<ProductDto>> listProducts(@Payload ProductQuery query) {
		return new ResponseCanonical<List<ProductDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel(includesDirectRelations)).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/products/create-product")
	@SendTo("/topic/products/product-created")
	public ResponseCanonical<ProductDto> createProduct(@Payload ProductDto entityParam) {
		return new ResponseCanonical<ProductDto>(
				this.business.create(entityParam).fillDtoModel(includesDirectRelations));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/products/update-product/{id}")
	@SendTo("/topic/products/product-updated")
	public ResponseCanonical<ProductDto> updateProduct(@DestinationVariable Long id, @Payload ProductDto entityParam) {
		return new ResponseCanonical<ProductDto>(
				this.business.update(id, entityParam).fillDtoModel(includesDirectRelations));
	}

}
