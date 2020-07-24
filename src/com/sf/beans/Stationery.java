package com.sf.beans;

import java.util.Date;

import com.sf.enums.Category;
import com.sf.enums.StationeryCategory;

public class Stationery extends Product {
	private StationeryCategory stationeryCategory;

	public Stationery() {
	}

	public StationeryCategory getStationeryCategory() {
		return stationeryCategory;
	}

	public void setStationeryCategory(StationeryCategory stationeryCategory) {
		this.stationeryCategory = stationeryCategory;
	}

	public Stationery(String id, String name, String description, Date manufacturingDate, Date expiryDate, float price,
			Category category, float discount, StationeryCategory stationeryCategory) {
		super(id, name, description, manufacturingDate, expiryDate, price, category, discount);
		this.stationeryCategory = stationeryCategory;
	}
}
