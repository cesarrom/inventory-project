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

import com.inventory.core.business.CategoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.CategoryDto;
import com.inventory.models.query.CategoryQuery;

@Controller
//@RequestMapping("/categories")
public class CategorySocket extends IAMSocket<CategoryDto, CategoryQuery, CategoryBusiness> {
	private static final String[] COMMON_INCLUDES = { "parentCategory", "products", "subCategories" };
	@Autowired
	public CategorySocket(CategoryBusiness business) {
		super(business);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/categories/find-categoy/{id}")
	@SendToUser("/queue/categories/category-found")
	public ResponseCanonical<CategoryDto> findCategory(@DestinationVariable Long id) {
		return new ResponseCanonical<CategoryDto>(this.business.find(id).fillDtoModel(COMMON_INCLUDES));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/categories/list-categories")
	@SendToUser("/queue/categories/categories-listed")
	public ResponseCanonical<List<CategoryDto>> listCategories(@Payload CategoryQuery query) {
		return new ResponseCanonical<List<CategoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel(COMMON_INCLUDES)).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/categories/create-category")
	@SendTo("/topic/categories/category-created")
	public ResponseCanonical<CategoryDto> createCategory(@Payload CategoryDto entityParam) {
		return new ResponseCanonical<CategoryDto>(this.business.create(entityParam).fillDtoModel(COMMON_INCLUDES));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@MessageMapping("/categories/update-category/{id}")
	@SendTo("/topic/categories/category-updated")
	public ResponseCanonical<CategoryDto> updateCategory(@DestinationVariable Long id,
			@Payload CategoryDto entityParam) {
		return new ResponseCanonical<CategoryDto>(this.business.update(id, entityParam).fillDtoModel(COMMON_INCLUDES));
	}

}
