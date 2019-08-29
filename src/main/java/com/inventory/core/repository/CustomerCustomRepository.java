package com.inventory.core.repository;

import java.util.List;

import com.inventory.models.Customer;
import com.inventory.models.query.CustomerQuery;

public interface CustomerCustomRepository {
	public List<Customer> list(CustomerQuery queryParams);
}
