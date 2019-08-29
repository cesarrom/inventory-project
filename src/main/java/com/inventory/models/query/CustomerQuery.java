package com.inventory.models.query;

public class CustomerQuery extends CommonQuery {
	private String name;
	private Long movementId;
	private Long productId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMovementId() {
		return movementId;
	}
	public void setMovementId(Long movementId) {
		this.movementId = movementId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
