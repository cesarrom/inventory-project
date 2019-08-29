package com.inventory.core.business;

import com.inventory.models.Customer;
import com.inventory.models.dto.CustomerDto;
import com.inventory.models.query.CustomerQuery;

public interface CustomerBusiness extends BaseBusiness<CustomerDto, CustomerQuery, Customer> {
}
