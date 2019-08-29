package com.inventory.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.inventory.models.dto.CustomerDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the customers database table.
 * 
 */
@Entity
@Table(name="customers")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CUSTOMERS_ID_GENERATOR", sequenceName="CUSTOMERS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CUSTOMERS_ID_GENERATOR")
	private Long id;

	private String address;

	private String code;

	@Column(name="created_at")
	private Date createdAt;

	private String email;

	private String name;

	private String phone;

	@Column(name="updated_at")
	private Date updatedAt;

	//bi-directional many-to-one association to MovementDto
	@OneToMany(mappedBy="customer")
	private List<Movement> movements;

	public Customer() {
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

	public List<Movement> getMovements() {
		return this.movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Movement addMovement(Movement movement) {
		getMovements().add(movement);
		movement.setCustomer(this);

		return movement;
	}

	public Movement removeMovement(Movement movement) {
		getMovements().remove(movement);
		movement.setCustomer(null);

		return movement;
	}

	@Override
	public CustomerDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new CustomerDto(), include);
	}

	@Override
	public CustomerDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}