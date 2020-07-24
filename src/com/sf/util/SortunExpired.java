package com.sf.util;

import java.util.Comparator;


import com.sf.beans.Product;

public class SortunExpired implements Comparator <Product>{

	@Override
	public int compare(Product o1, Product o2)
	{
		if(o1.getName().compareTo(o2.getName())<0)
			return -1;
		else if(o1.getName().compareTo(o2.getName())>0)
			return 1;
		else
			return 0;
		
		
	}

}