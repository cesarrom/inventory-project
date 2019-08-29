package com.inventory.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
public abstract class IABMController<DTO, QUERY, BUSINESS> {
	BUSINESS business;
	@Autowired
	public IABMController(BUSINESS business) {
		this.business = business;
	}
} 
