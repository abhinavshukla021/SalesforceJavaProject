package com.sf.beans;

import java.util.Date;

import com.sf.enums.BookCategory;
import com.sf.enums.Category;

public class Book extends Product {
	private int noOfPages;
	private String author;
	private BookCategory bookCategory;

	public Book() {
	}

	public Book(String id, String name, String description, Date manufacturingDate, Date expiryDate, float price,
			Category category, float discount, int noOfPages, BookCategory bookCategory, String author) {
		super(id, name, description, manufacturingDate, expiryDate, price, category, discount);
		this.noOfPages = noOfPages;
		this.bookCategory = bookCategory;
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public BookCategory getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(BookCategory bookCategory) {
		this.bookCategory = bookCategory;
	}
	

}
