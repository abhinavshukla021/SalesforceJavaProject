package com.sf.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sf.beans.Book;
import com.sf.beans.Electronic;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.beans.Stationery;
import com.sf.connection.DBConnectionManagerImpl;
import com.sf.enums.Category;
import com.sf.exception.NoDataException;
import com.sf.service.RetailServiceImpl;
import com.sf.util.PrintObjects;
import com.sf.util.SearchProducts;
import com.sf.util.SpecialSort;
import com.sf.util.Validation;

public class Test {

	public static void main(String[] args) throws NoDataException 
	{
	    // Step 1 Testing begin ...
		try {
			Connection connection1 = (new DBConnectionManagerImpl()).getConnection();
			System.out.println(String.format("Connected to database %s "
                    + "successfully.", connection1.getCatalog()));	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		// Step 1 Testing ended ...
		
		// Step 2 Testing begins ...
		Map <String, Map <String, String>> m = null;
		m = (new RetailServiceImpl()).fetchAllSpecification();
		/*
        for (String rk : m.keySet()) {  
            System.out.println("RK: " + rk);
            Map <String, String> temp = m.get(rk);
    		int count=0;
            for(String att : temp.keySet())
            {
            	System.out.println("Att: " + att + " : " + temp.get(att));
            	count++;
            }
            System.out.println(count);
        }
        */
		// Step 2 Testing ends ...
		
        // Step 3 Testing begins ...
        List <Product> products = null;
        try {
			products = (new RetailServiceImpl()).fetchAllProduct();
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         (new PrintObjects()).printit(products);
        // Step 3 Testing ends ...
        
        // Step 4 Testing begins ...
        String s = "Acer"; 
        Set <Product> result = null;
        try {
			result = (new RetailServiceImpl()).search(s,products);
		} catch (NoDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (com.sf.exception.InvalidInputParameterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result==null || result.isEmpty())
			throw new NoDataException();
		//for (Product product : result)
		//	System.out.println(product.getName());
		// Step 4 Testing ends ...
		
		// Step 5 Testing begins ...
		(new RetailServiceImpl()).sortByCategory(products);
		//(new PrintObjects()).printit(products);
		// Step 5 Testing ends ...
		
		// Test 6 testing begins ...
		products = (new RetailServiceImpl()).specialSort(products);
		// (new PrintObjects()).printit(products);
		// Step 6 Testing ends ...
		
		// Step 7 Testing begins ...
		(new RetailServiceImpl()).filterInvalidProducts(products);
		// (new PrintObjects()).printit(products);
		 }
	

}
