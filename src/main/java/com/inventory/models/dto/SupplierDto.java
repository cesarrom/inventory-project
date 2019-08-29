package com.inventory.models.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.inventory.models.Supplier;
import com.inventory.utils.BaseFill;

/**
 * The persistent class for the suppliers database table.
 * 
 */

public class SupplierDto extends CommonModelDto {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String address;

	private String code;

	private Date createdAt;

	private String email;

	private String name;

	private String phone;

	private Date updatedAt;

	private List<MovementDto> movements;

	private List<ProductDto> products;

	public SupplierDto() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<MovementDto> getMovements() {
		return this.movements;
	}

	public void setMovements(List<MovementDto> movementDtos) {
		this.movements = movementDtos;
	}

	public MovementDto addMovement(MovementDto movementDto) {
		getMovements().add(movementDto);
		movementDto.setSupplier(this);

		return movementDto;
	}

	public MovementDto removeMovement(MovementDto movementDto) {
		getMovements().remove(movementDto);
		movementDto.setSupplier(null);

		return movementDto;
	}

	public List<ProductDto> getProducts() {
		return this.products;
	}

	public void setProducts(List<ProductDto> productDtos) {
		this.products = productDtos;
	}

	public ProductDto addProduct(ProductDto productDto) {
		getProducts().add(productDto);
		productDto.setSupplier(this);

		return productDto;
	}

	public ProductDto removeProduct(ProductDto productDto) {
		getProducts().remove(productDto);
		productDto.setSupplier(null);

		return productDto;
	}

	@Override
	@JsonIgnore()
	public Supplier fillCrudModel(String[] includes) {
		return BaseFill.actualFillToBaseModel(this, new Supplier(), includes);
	}

	@Override
	@JsonIgnore()
	public Supplier fillCrudModel() {
		return this.fillCrudModel(new String[]{});
	}

}