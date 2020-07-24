package com.sf.util;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sf.beans.Book;
import com.sf.beans.Electronic;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.beans.Stationery;
import com.sf.enums.Category;

public class SearchProducts 
{
	
	public Set <Product> search (String s, List <Product> products)
	{
		s=s.toLowerCase();
		Set <Product> spro = new HashSet <Product> () ;
		for(Product product : products)
		{
			if(product.getName().toLowerCase().contains(s))
			{
				spro.add(product);
				continue;
			}
			else if(product.getCategory().toString().toLowerCase().contains(s))
			{
				spro.add(product);
				continue;
			}
			else if(product.getDescription()!=null && product.getDescription().isEmpty()!=true && product.getDescription().toLowerCase().contains(s))
			{
				spro.add(product);
				continue;
			}
			else if (product.getCategory()==Category.BOOK)
			{
				Book book = (Book) product;
				if(book.getBookCategory().toString().toLowerCase().contains(s))
				{
					spro.add(book);
					continue;
				}
			}
			else if (product.getCategory()==Category.FOOD)
			{
				Food food = (Food) product;
				if(food.getFoodCategory().toString().toLowerCase().contains(s))
				{
					spro.add(food);
					continue;
				}
				for (Map.Entry<String,String> entry : food.getSpecification().entrySet())  
				{
					if(entry.getKey().contains(s) || entry.getValue().contains(s))
					{
						spro.add(food);
						continue;
					}
				}
			}
			else if (product.getCategory()==Category.ELECTRONIC)
			{
				Electronic electronic = (Electronic) product;
				if(electronic.getSubCategory().toString().toLowerCase().contains(s))
				{
					spro.add(electronic);
					continue;
				}
				for (Map.Entry<String,String> entry : electronic.getSpecification().entrySet())  
				{
					if(entry.getKey().contains(s) || entry.getValue().contains(s))
					{
						spro.add(electronic);
						continue;
					}
				}
				
			}
			else if (product.getCategory()==Category.STATIONERY)
			{
				Stationery stationery = (Stationery) product;
				if(stationery.getStationeryCategory().toString().toLowerCase().contains(s))
				{
					spro.add(stationery);
					continue;
				}
			}
			
		}
		return spro;		
	}

}
