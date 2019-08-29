package com.inventory.models.query;

import java.util.List;

public class RepositoryQuery extends CommonQuery {
	private List<Long> customerIds;
	private List<Long> supplierIds;
	private List<Long> categoryIds;
	private String name;
	private String description;
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
	public List<Long> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
}
