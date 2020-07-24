package com.sf.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Date;

import com.sf.beans.Product;
import com.sf.enums.Category;
public class SpecialSort 
{
	@SuppressWarnings("deprecation")
	public List <Product> specialsort(List <Product> products)
	{
		List <Product> finallist = new ArrayList <Product> ();
		List <Product> expired = new ArrayList <Product> ();
		List <Product> notexpired = new ArrayList <Product> ();
		List <Product> unexpired = new ArrayList <Product> ();
		
		for (Product product : products)
		{
			if(product.getCategory()==Category.FOOD)
			{
			Date exp = product.getExpiryDate();
			if(exp==null)
			{
				unexpired.add(product);
				continue;
			}
		
			Date now = new Date();
			if(exp.getYear() > now.getYear())
				notexpired.add(product);
			else if(exp.getYear() < now.getYear())
				expired.add(product);
			else if(exp.getMonth() > now.getMonth())
				notexpired.add(product);
			else if(exp.getMonth() < now.getMonth())
				expired.add(product);
			else if(exp.getDate() > now.getDate())
				notexpired.add(product);
			else if(exp.getDate() < now.getDate())
				expired.add(product);
			else
				notexpired.add(product);
			}
			else
				unexpired.add(product);
		
		}
		
		Collections.sort(expired,new SortExpired());
		Collections.sort(notexpired,new SortnotExpired());
		Collections.sort(unexpired,new SortunExpired());
		
		for(Product product : notexpired)
			finallist.add(product);
		for(Product product : unexpired)
			finallist.add(product);
		for(Product product : expired)
			finallist.add(product);

		return finallist;
	}

}
