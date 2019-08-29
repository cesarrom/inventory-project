package com.inventory.core.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.core.business.CustomerBusiness;
import com.inventory.core.dao.DaoIndex;
import com.inventory.helpers.exceptions.BadRequestException;
import com.inventory.helpers.exceptions.NotFoundException;
import com.inventory.models.Customer;
import com.inventory.models.dto.CustomerDto;
import com.inventory.models.query.CustomerQuery;
import com.inventory.utils.ObjectUtils;

@Service
public class CustomerBusinessImpl implements CustomerBusiness {
	
	private DaoIndex daos;

	@Autowired
	public CustomerBusinessImpl(DaoIndex daos) {
		this.daos = daos;
	}

	@Override
	public Customer create(CustomerDto customer) {
		if(ObjectUtils.isFalsey(customer))
			throw new BadRequestException("THE CUSTOMER OBJECT CANNOT BE NULL!");
		Customer crudCustomer = customer.fillCrudModel();
		return this.daos.getCustomerDao().create(crudCustomer);
	}

	@Override
	public List<Customer> list(CustomerQuery query) {
		return this.daos.getCustomerDao().list(query);
	}

	@Override
	public Customer update(Long customerId, CustomerDto customerParams) {
		Customer customer = this.daos.getCustomerDao().findById(customerId).orElseThrow(() -> new NotFoundException("CUSTOMER NOT FOUND [id:"+customerId+"]"));
		ObjectUtils.copyPropertiesIgnoringNulls(customerParams, customer);
		this.daos.getCustomerDao().update(customer);
		return customer;
	}

	@Override
	public Customer find(Long customerId) {
		return this.daos.getCustomerDao().findById(customerId).orElseThrow(() -> new NotFoundException("CUSTOMER NOT FOUND [id:"+customerId+"]"));
	}

	
}
