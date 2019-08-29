package com.inventory.models.query;

import java.util.List;

public class MovementDetailQuery extends CommonQuery {
	private Long movementId;
	private List<Long> productIds;
	private Boolean omitPositive;
	private Boolean omitNegative;
	private Long sourceRepositoryId;
	private Long targetRepositoryId;
	public Long getMovementId() {
		return movementId;
	}
	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}
	public List<Long> getProductIds() {
		return productIds;
	}
	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}
	public Boolean getOmitPositive() {
		return omitPositive;
	}
	public void setOmitPositive(Boolean omitPositive) {
		this.omitPositive = omitPositive;
	}
	public Boolean getOmitNegative() {
		return omitNegative;
	}
	public void setOmitNegative(Boolean omitNegative) {
		this.omitNegative = omitNegative;
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
}
