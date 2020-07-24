package com.sf.util;

import java.util.Comparator;
import java.util.Date;

import com.sf.beans.Product;

public class SortExpired implements Comparator <Product>{

	@Override
	public int compare(Product o1, Product o2)
	{
		long t1 = (new Date()).getTime() - o1.getExpiryDate().getTime();
		long t2 = (new Date()).getTime() - o2.getExpiryDate().getTime();
		if(t1<t2)
			return -1;
		else if(t1>t2)
			return 1;
		else
		{
			if(o1.getName().compareTo(o2.getName())<0)
				return -1;
			else if(o1.getName().compareTo(o2.getName())>0)
				return 1;
			else
				return 0;
		}
	}

}
