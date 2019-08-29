package com.inventory.models.dto;


import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventory.models.CommonModel;

public abstract class CommonModelDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date updatedAt;
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date createdAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	@JsonIgnore()
	public abstract CommonModel fillCrudModel(String[] includes);
	@JsonIgnore()
	public abstract CommonModel fillCrudModel();
}
