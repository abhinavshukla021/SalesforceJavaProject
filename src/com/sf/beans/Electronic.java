package com.sf.beans;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.sf.enums.Category;
import com.sf.enums.ElectronicCategory;

public class Electronic extends Product {
	private Map<String, String> specification = new HashMap<String, String>();
	private ElectronicCategory subCategory;

	public Electronic() {
	}

	public Electronic(String id, String name, String description, Date manufacturingDate, Date expiryDate, float price,
			Category category, float discount, Map<String, String> specification, ElectronicCategory subCategory) {
		super(id, name, description, manufacturingDate, expiryDate, price, category, discount);
		this.specification = specification;
		this.subCategory = subCategory;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}

	public ElectronicCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(ElectronicCategory subCategory) {
		this.subCategory = subCategory;
	}
}
