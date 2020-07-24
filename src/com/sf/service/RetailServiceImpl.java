package com.sf.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sf.beans.Product;
import com.sf.exception.NoDataException;
import com.sf.util.GetProduct;
import com.sf.util.GetSpecification;
import com.sf.exception.InvalidInputParameterException;
import com.sf.util.SearchProducts;
import com.sf.util.SortByCategory;
import com.sf.util.SpecialSort;
import com.sf.util.Validation;

public class RetailServiceImpl implements RetailService {

	private Connection connection;

	@Override
	public Map<String, Map<String, String>> fetchAllSpecification()
	{
		// TODO Auto-generated method stub
		
		Map <String, Map <String, String>> m = null;
		try {
			m=(new GetSpecification()).get();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return m;	
	}

	@Override
	public List<Product> fetchAllProduct() throws NoDataException {
		// TODO Auto-generated method stub
		
		Map <String, Map <String, String>> m = this.fetchAllSpecification();
		List <Product> products = null;
		try {
			products = (new GetProduct()).get(m);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(products == null || products.isEmpty())
			 throw new NoDataException();
		return products;
	}

	@Override
	public Set<Product> search(String queryString, List<Product> products) throws NoDataException, InvalidInputParameterException
	{
		// TODO Auto-generated method stub
		if(products == null || products.isEmpty())
			throw new NoDataException();
		for(Product product : products)
			if((new Validation()).validate(product)==1)
			throw new InvalidInputParameterException ();
		if(queryString == null || queryString.isEmpty() || queryString.matches(".*[a-zA-Z]+.*")!=true)
			throw new InvalidInputParameterException();
		Set <Product> result = null;
		result = (new SearchProducts()).search(queryString, products);
		if(result == null || result.isEmpty())
			throw new NoDataException();
		return result;
	}

	@Override
	public void sortByCategory(List<Product> products) 
	{
		// TODO Auto-generated method stub
		if(products==null || products.isEmpty())
			return;
		Collections.sort(products, new SortByCategory());
	}

	@Override
	public List<Product> specialSort(List<Product> products) {
		// TODO Auto-generated method stub
		
		if(products==null || products.isEmpty())
			return products;
		
		products = (new SpecialSort()).specialsort(products);
		return products;
	}

	@Override
	public void filterInvalidProducts(List<Product> products)
	{
		// TODO Auto-generated method stub
		Map <String, Map <String, String>> m = this.fetchAllSpecification();
		if(products==null || products.isEmpty())
			return;
		Iterator itr = products.iterator(); 
        while (itr.hasNext()) 
        { 
            Product p = (Product)itr.next(); 
            if ((new Validation()).validate(p)==1)
            {
            	m.remove(p.getId());
                itr.remove();
            }
        } 
	

	}

}
