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

import com.inventory.models.dto.SupplierDto;
import com.inventory.utils.BaseFill;


/**
 * The persistent class for the suppliers database table.
 * 
 */
@Entity
@Table(name="suppliers")
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier extends CommonModel {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUPPLIERS_ID_GENERATOR", sequenceName="SUPPLIERS_ID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUPPLIERS_ID_GENERATOR")
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

	//bi-directional many-to-one association to CategoryDto
	@OneToMany(mappedBy="supplier")
	private List<Category> categories;

	//bi-directional many-to-one association to MovementDto
	@OneToMany(mappedBy="supplier")
	private List<Movement> movements;

	//bi-directional many-to-one association to ProductDto
	@OneToMany(mappedBy="supplier")
	private List<Product> products;

	public Supplier() {
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

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setSupplier(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setSupplier(null);

		return category;
	}

	public List<Movement> getMovements() {
		return this.movements;
	}

	public void setMovements(List<Movement> movements) {
		this.movements = movements;
	}

	public Movement addMovement(Movement movement) {
		getMovements().add(movement);
		movement.setSupplier(this);

		return movement;
	}

	public Movement removeMovement(Movement movement) {
		getMovements().remove(movement);
		movement.setSupplier(null);

		return movement;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setSupplier(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setSupplier(null);

		return product;
	}

	@Override
	public SupplierDto fillDtoModel(String[] include) {
		return BaseFill.actualFillToDtoModel(this, new SupplierDto(), include);
	}

	@Override
	public SupplierDto fillDtoModel() {
		return this.fillDtoModel(new String[]{});
	}

}