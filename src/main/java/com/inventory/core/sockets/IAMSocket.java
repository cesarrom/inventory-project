package com.inventory.core.sockets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public abstract class IAMSocket<DTO, QUERY, BUSINESS> {
	BUSINESS business;

	@Autowired
	public IAMSocket(BUSINESS business) {
		this.business = business;
	}
}
