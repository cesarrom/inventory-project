package com.inventory.helpers;

import org.springframework.http.HttpStatus;

public class ResponseCanonical<T> {
	private Integer status;
	private T response;
	public ResponseCanonical(T response) {
		this.status = HttpStatus.OK.value();
		this.response = response;
	}
	public ResponseCanonical(T response, Integer status) {
		this.status = status;
		this.response = response;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
