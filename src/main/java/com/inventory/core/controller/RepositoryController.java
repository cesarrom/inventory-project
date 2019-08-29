package com.inventory.core.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.core.business.RepositoryBusiness;
import com.inventory.helpers.ResponseCanonical;
import com.inventory.models.dto.RepositoryDto;
import com.inventory.models.query.RepositoryQuery;

@RestController
@RequestMapping("/repositories")
public class RepositoryController extends IABMController<RepositoryDto, RepositoryQuery, RepositoryBusiness> {
	@Autowired
	public RepositoryController(RepositoryBusiness business) {
		super(business);
		// TODO Auto-generated constructor stub
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/{id}")

	public ResponseCanonical<RepositoryDto> findRepository(@PathVariable Long id) {
		return new ResponseCanonical<RepositoryDto>(this.business.find(id).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@GetMapping("/")

	public ResponseCanonical<List<RepositoryDto>> listRepositories(RepositoryQuery query) {
		return new ResponseCanonical<List<RepositoryDto>>(this.business.list(query).parallelStream()
				.map(item -> item.fillDtoModel()).collect(Collectors.toList()));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PostMapping("/")

	public ResponseCanonical<RepositoryDto> createRepository(@RequestBody RepositoryDto entityParam) {
		return new ResponseCanonical<RepositoryDto>(this.business.create(entityParam).fillDtoModel());
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = { RuntimeException.class })
	@PutMapping("/{id}")

	public ResponseCanonical<RepositoryDto> updateRepository(@PathVariable Long id, @RequestBody RepositoryDto entityParam) {
		return new ResponseCanonical<RepositoryDto>(this.business.update(id, entityParam).fillDtoModel());
	}

}
