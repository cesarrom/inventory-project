package com.inventory.core.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = { RuntimeException.class })
public class DaoIndex {
	@Autowired
	private CategoryDao categoryDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private MovementDao movementDao;
	@Autowired
	private MovementDetailDao movementDetailDao;
	@Autowired
	private MovementTypeDao movementTypeDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductRepositoryDao productRepositoryDao;
	@Autowired
	private RepositoryDao repositoryDao;
	@Autowired
	private SupplierDao supplierDao; 
	
	public CategoryDao getCategoryDao() {
		return categoryDao;
	}
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public MovementDao getMovementDao() {
		return movementDao;
	}
	public MovementDetailDao getMovementDetailDao() {
		return movementDetailDao;
	}
	public MovementTypeDao getMovementTypeDao() {
		return movementTypeDao;
	}
	public ProductDao getProductDao() {
		return productDao;
	}
	public ProductRepositoryDao getProductRepositoryDao() {
		return productRepositoryDao;
	}
	public RepositoryDao getRepositoryDao() {
		return repositoryDao;
	}
	public SupplierDao getSupplierDao() {
		return supplierDao;
	}
}
