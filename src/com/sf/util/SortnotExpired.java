package com.sf.util;

import java.util.Comparator;
import java.util.Date;

import com.sf.beans.Product;

public class SortnotExpired implements Comparator <Product>{

	@Override
	public int compare(Product o1, Product o2)
	{
		long t1 =  o1.getExpiryDate().getTime() - (new Date()).getTime() ;
		long t2 =  o2.getExpiryDate().getTime() - (new Date()).getTime() ;
		if(t1<t2)
			return -1;
		else if(t1>t2)
			return 1;
		else
		{
			if(o1.getPrice() > o2.getPrice() )
				return -1;
			else if(o1.getPrice() < o2.getPrice() )
				return 1;
			else if(o1.getDiscount() < o2.getDiscount())
				return -1;
			else if(o1.getDiscount() > o2.getDiscount())
				return 1;
			else
				return 0;
		}
	}

}