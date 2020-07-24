package com.sf.beans;

import java.util.Date;

import com.sf.enums.Category;

public class Product {
	private String id;
	private String name;
	private String description;
	private Date manufacturingDate;
	private Date expiryDate;
	private float price;
	private Category category;
	private float discount;

	public Product() {
	}

	public Product(String id, String name, String description, Date manufacturingDate, Date expiryDate, float price,
			Category category, float discount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.manufacturingDate = manufacturingDate;
		this.expiryDate = expiryDate;
		this.price = price;
		this.category = category;
		this.discount = discount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

}
