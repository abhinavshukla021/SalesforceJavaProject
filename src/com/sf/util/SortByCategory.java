package com.sf.util;

import java.util.Comparator;

import com.sf.beans.Book;
import com.sf.beans.Electronic;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.beans.Stationery;
import com.sf.enums.Category;

public class SortByCategory implements Comparator <Product> 
{

	@Override
	public int compare(Product o1, Product o2) 
	{
		if(o1.getCategory().toString().compareTo(o2.getCategory().toString())<0)
		return -1;
		else if(o1.getCategory().toString().compareTo(o2.getCategory().toString())>0)
		return 1;
		else
		{
			if(o1.getCategory()==Category.BOOK)
			{
				Book O1 = (Book) o1;
				Book O2 = (Book) o2;
				if(O1.getBookCategory().toString().compareTo(O2.getBookCategory().toString())<0)
					return -1;
				else if(O1.getBookCategory().toString().compareTo(O2.getBookCategory().toString())>0)
					return 1;
				else
					return 0;
			}
			else if(o1.getCategory()==Category.FOOD )
			{
				Food O1 = (Food) o1;
				Food O2 = (Food) o2;
				if(O1.getFoodCategory().toString().compareTo(O2.getFoodCategory().toString())<0)
					return -1;
				else if(O1.getFoodCategory().toString().compareTo(O2.getFoodCategory().toString())>0)
					return 1;
				else
					return 0;
			}
			else if(o1.getCategory()==Category.ELECTRONIC )
			{
				
				Electronic O1 = (Electronic) o1;
				Electronic O2 = (Electronic) o2;
				if(O1.getSubCategory().toString().compareTo(O2.getSubCategory().toString())<0)
					return -1;
				else if(O1.getSubCategory().toString().compareTo(O2.getSubCategory().toString())>0)
					return 1;
				else
					return 0;
			
			}
			else 
			{
				Stationery O1 = (Stationery) o1;
				Stationery O2 = (Stationery) o2;
				if(O1.getStationeryCategory().toString().compareTo(O2.getStationeryCategory().toString())<0)
					return -1;
				else if(O1.getStationeryCategory().toString().compareTo(O2.getStationeryCategory().toString())>0)
					return 1;
				else
					return 0;
				
			}
		}
	}

}
