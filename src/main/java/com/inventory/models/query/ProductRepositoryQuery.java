package com.inventory.models.query;

import java.util.List;

public class ProductRepositoryQuery extends CommonQuery {
	private List<Long> customerIds;
	private List<Long> supplierIds;
	private List<Long> sourceSupplierIds;
	private List<Long> categoryIds;
	private List<Long> repositoryIds;
	private List<Long> productIds;
	public List<Long> getCustomerIds() {
		return customerIds;
	}
	public void setCustomerIds(List<Long> customerIds) {
		this.customerIds = customerIds;
	}
	public List<Long> getSupplierIds() {
		return supplierIds;
	}
	public void setSupplierIds(List<Long> supplierIds) {
		this.supplierIds = supplierIds;
	}
	public List<Long> getSourceSupplierIds() {
		return sourceSupplierIds;
	}
	public void setSourceSupplierIds(List<Long> sourceSupplierIds) {
		this.sourceSupplierIds = sourceSupplierIds;
	}
	public List<Long> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public List<Long> getRepositoryIds() {
		return repositoryIds;
	}
	public void setRepositoryIds(List<Long> repositoryIds) {
		this.repositoryIds = repositoryIds;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
}
