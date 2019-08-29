package com.inventory.models.query;

import java.util.List;

public class MovementQuery extends CommonQuery {
	private List<Long> movementDetailIds;
	private List<Long> productIds;
	private List<Long> movementTypeIds;
	private Long sourceRepositoryId;
	private Long targetRepositoryId;
	private Long customerId;
	private Long supplierId;
	public List<Long> getMovementDetailIds() {
		return movementDetailIds;
	}
	public void setMovementDetailIds(List<Long> movementDetailIds) {
		this.movementDetailIds = movementDetailIds;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	public List<Long> getMovementTypeIds() {
		return movementTypeIds;
	}
	public void setMovementTypeIds(List<Long> movementTypeIds) {
		this.movementTypeIds = movementTypeIds;
	}
	public Long getSourceRepositoryId() {
		return sourceRepositoryId;
	}
	public void setSourceRepositoryId(Long sourceRepositoryId) {
		this.sourceRepositoryId = sourceRepositoryId;
	}
	public Long getTargetRepositoryId() {
		return targetRepositoryId;
	}
	public void setTargetRepositoryId(Long targetRepositoryId) {
		this.targetRepositoryId = targetRepositoryId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}
}
