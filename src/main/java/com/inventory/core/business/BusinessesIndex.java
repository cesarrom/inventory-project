package com.inventory.core.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessesIndex {
	@Autowired
	private CategoryBusiness categoryBusiness;
	@Autowired
	private CustomerBusiness customerBusiness;
	@Autowired
	private MovementBusiness movementBusiness;
	@Autowired
	private MovementDetailBusiness movementDetailBusiness;
	@Autowired
	private MovementTypeBusiness movementTypeBusiness;
	@Autowired
	private ProductBusiness productBusiness;
	@Autowired
	private ProductRepositoryBusiness productRepositoryBusiness;
	@Autowired
	private RepositoryBusiness repositoryBusuiness;
	@Autowired
	private SupplierBusiness supplierBusiness;
	
	
	public CategoryBusiness getCategoryBusiness() {
		return categoryBusiness;
	}
	public CustomerBusiness getCustomerBusiness() {
		return customerBusiness;
	}
	public MovementBusiness getMovementBusiness() {
		return movementBusiness;
	}
	public MovementDetailBusiness getMovementDetailBusiness() {
		return movementDetailBusiness;
	}
	public MovementTypeBusiness getMovementTypeBusiness() {
		return movementTypeBusiness;
	}
	public ProductBusiness getProductBusiness() {
		return productBusiness;
	}
	public ProductRepositoryBusiness getProductRepositoryBusiness() {
		return productRepositoryBusiness;
	}
	public RepositoryBusiness getRepositoryBusuiness() {
		return repositoryBusuiness;
	}
	public SupplierBusiness getSupplierBusiness() {
		return supplierBusiness;
	}
}
