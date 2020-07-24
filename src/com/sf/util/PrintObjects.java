package com.sf.util;

import java.util.List;
import java.util.Map;

import com.sf.beans.Book;
import com.sf.beans.Electronic;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.beans.Stationery;
import com.sf.enums.Category;

public class PrintObjects
{
	public void printit(List <Product> products)
	{
		if(products==null || products.isEmpty())
			return;
		  for(Product product : products) 
	        {
	        if(product.getCategory()==Category.BOOK)
	        {
	        	Book book = (Book) product;
	        	System.out.println(book.getId()+" "+book.getName()+" "+book.getDescription()
	        	+" "+book.getManufacturingDate()+" "+book.getExpiryDate()+" "+book.getPrice()+" "+book.getCategory()+
	        	" "+book.getDiscount()+" "+book.getNoOfPages()+" "+book.getAuthor()+" "+book.getBookCategory());
	        }
	        System.out.println();
	        if(product.getCategory()==Category.STATIONERY)
	        {
	        	Stationery stationery = (Stationery) product;
	        	System.out.println(stationery.getId()+" "+stationery.getName()+" "+stationery.getDescription()
	        	+" "+stationery.getManufacturingDate()+" "+stationery.getExpiryDate()+" "+stationery.getPrice()+" "+stationery.getCategory()+
	        	" "+stationery.getDiscount()+" "+stationery.getStationeryCategory());
	        }
	        System.out.println();
	        if(product.getCategory()==Category.ELECTRONIC)
	        {
	        	Electronic electronic = (Electronic) product;
	        	System.out.println(electronic.getId()+" "+electronic.getName()+" "+electronic.getDescription()
	        	+" "+electronic.getManufacturingDate()+" "+electronic.getExpiryDate()+" "+electronic.getPrice()+" "+electronic.getCategory()+
	        	" "+electronic.getDiscount()+" "+electronic.getSubCategory());
	            for (Map.Entry<String,String> entry : electronic.getSpecification().entrySet())  
	                System.out.println( entry.getKey() + " " 
	                                  + entry.getValue()); 
	        }
	        if(product.getCategory()==Category.FOOD)
	        {
	        	Food food = (Food) product;
	        	System.out.println(food.getId()+" "+food.getName()+" "+food.getDescription()
	        	+" "+food.getManufacturingDate()+" "+food.getExpiryDate()+" "+food.getPrice()+" "+food.getCategory()+
	        	" "+food.getDiscount()+" "+food.getFoodCategory());
	            for (Map.Entry<String,String> entry : food.getSpecification().entrySet())  
	                System.out.println( entry.getKey() + " " 
	                                  + entry.getValue()); 
	        }
	        
	        }
		
	}

}
