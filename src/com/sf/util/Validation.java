package com.sf.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sf.beans.Book;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.enums.BookCategory;
import com.sf.enums.Category;
import com.sf.enums.FoodCategory;

public class Validation
{
	public int validate (Product product)
	{
			String id = product.getId();
			if( id.isBlank() || id.length()!=18 || !id.matches("[A-Za-z0-9]+"))
			{
				return 1;
			}
			String name = product.getName();
			if( name.isBlank())
			{
				return 1;
			}
			float price = product.getPrice();
			if(price < 0)
			{
				return 1;
			}
			float discount = product.getDiscount();
			if(discount < 0 || discount > 100)
			{
				return 1;
			}
			Date mfg = product.getManufacturingDate();
			Date now = new Date();
			if(mfg.getYear() > now.getYear())
			{
				return 1;
			}
			else if(mfg.getYear() == now.getYear())
			{
				if(mfg.getMonth() > now.getMonth())
				{
					return 1;
				}
				else if(mfg.getMonth() == now.getMonth())
				{
					if(mfg.getDate() > now.getDate())
					{
					return 1;
					}
				}
			}
			if(product.getCategory()==Category.BOOK)
			{
				Book b = (Book) product;
				String author = b.getAuthor();
				if(author.isBlank())
					return 1;
				
			}
			Date exp = product.getExpiryDate();
			if(product.getCategory()==Category.BOOK || product.getCategory()==Category.STATIONERY || product.getCategory()==Category.ELECTRONIC)
			{
				if(exp!=null)
				{
					return 1;
				}
			}
			if(product.getCategory()==Category.FOOD )
			{
				if(exp==null)
				{
				return 1;
				}
				
				Food f = (Food) product;
				if(f.getFoodCategory()==FoodCategory.MILK)
				{
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(mfg);
				calendar.add(Calendar.MONTH,3);
				calendar.add(Calendar.DATE,15);
				Date future = calendar.getTime();
				calendar.setTime(exp);
				Date expiry = calendar.getTime();
				if(expiry.compareTo(future)>0)
				{
					return 1;
				}
				if(now.getYear() > exp.getYear())
				{
					return 1;
				}
				else if(now.getYear() == exp.getYear())
				{
					if(now.getMonth() > exp.getMonth())
					{
						return 1;
					}
					else if(now.getMonth() == exp.getMonth())
					{
						if(now.getDate() > exp.getDate())
						{
						return 1;
						}
					}
				}
				}	
	}
			return 0;
	}
}
