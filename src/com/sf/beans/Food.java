package com.sf.beans;

import java.util.Date;
import java.util.Map;

import com.sf.enums.Category;
import com.sf.enums.FoodCategory;

public class Food extends Product {
	private FoodCategory foodCategory;
	private Map<String, String> specification;

	public Food() {
	}

	public Food(String id, String name, String description, Date manufacturingDate, Date expiryDate, float price,
			Category category, float discount, FoodCategory foodCategory, Map<String, String> specification) {
		super(id, name, description, manufacturingDate, expiryDate, price, category, discount);
		this.foodCategory = foodCategory;
		this.specification = specification;
	}

	public FoodCategory getFoodCategory() {
		return foodCategory;
	}

	public void setMilkCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public Map<String, String> getSpecification() {
		return specification;
	}

	public void setSpecification(Map<String, String> specification) {
		this.specification = specification;
	}
}
