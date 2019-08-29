package com.inventory.models.query;

import java.util.List;

public class ProductQuery extends CommonQuery {
	private List<Long> sourceSupplierIds;
	private List<Long> customerIds;
	private List<Long> supplierIds;
	private String name;
	private String description;
	private List<Long> categoryIds;
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
	public List<Long> getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(List<Long> categoryIds) {
		this.categoryIds = categoryIds;
	}
}
