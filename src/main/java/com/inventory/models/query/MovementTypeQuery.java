package com.inventory.models.query;

public class MovementTypeQuery extends CommonQuery {
	private String name;
	private String description;
	private Long sourceRepositoryId;
	private Long targetRepositoryId;
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
