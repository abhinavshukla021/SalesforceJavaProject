package com.sf.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sf.beans.Book;
import com.sf.beans.Electronic;
import com.sf.beans.Food;
import com.sf.beans.Product;
import com.sf.beans.Stationery;
import com.sf.connection.DBConnectionManagerImpl;
import com.sf.enums.BookCategory;
import com.sf.enums.Category;
import com.sf.enums.ElectronicCategory;
import com.sf.enums.FoodCategory;
import com.sf.enums.StationeryCategory;

public class GetProduct 
{

	public List <Product> get(Map <String, Map <String, String>> m) throws ClassNotFoundException, SQLException
	{
		
		Connection conn = (new DBConnectionManagerImpl()).getConnection();
		Statement stmt = conn.createStatement();
		
		List <Product> pro = new ArrayList <Product> ();	
		Product p = null;
		
		// Getting books
		String q = "Select * FROM book_tbl";
		
		ResultSet rs    = stmt.executeQuery(q);
		
		
		
	    while(rs.next())
		{
	    	if(rs.getString("category")==null || rs.getString("category").isEmpty() || rs.getString("category").compareTo("BOOK")!=0)
	    		continue;
	    	if(rs.getString("bookcategory")==null || rs.getString("bookcategory").isEmpty() || ( rs.getString("bookcategory").compareTo("SHORTSTORY")!=0 && rs.getString("bookcategory").compareTo("TEXTBOOK")!=0 ))
	    		continue;
			if((new Checkfields()).book(rs)==1)
				continue;
			Book book = new Book(rs.getString("id"), rs.getString("name"), rs.getString("description"), 
					rs.getDate("manufacturing_date"), rs.getDate("expiry_date"), rs.getFloat("price"),
					Category.valueOf(rs.getString("category")), rs.getFloat("discount"), rs.getInt("noOfPages"),
					BookCategory.valueOf(rs.getString("bookcategory")), rs.getString("author"));	
			p = book;
			pro.add(p);
			
		}
		
		// Getting electronic
	    q = "Select * FROM electronic_tbl";
	    
	    rs    = stmt.executeQuery(q);
	    
	    while(rs.next())
		{
	    	if(rs.getString("category")==null || rs.getString("category").isEmpty() || rs.getString("category").compareTo("ELECTRONIC")!=0)
	    		continue;
	    	if(rs.getString("electroniccategory")==null || rs.getString("electroniccategory").isEmpty() || ( rs.getString("electroniccategory").compareTo("LAPTOP")!=0 && rs.getString("electroniccategory").compareTo("MOBILE")!=0 && rs.getString("electroniccategory").compareTo("TV")!=0 ))
	    		continue;
	    	if(m==null || m.isEmpty())
	    		continue;
	    	if((new Checkfields()).electronic(rs,m.get(rs.getString("id")))==1)
				continue;
	    	
			Electronic electronic = new Electronic(rs.getString("id"), rs.getString("name"), rs.getString("description"), 
					rs.getDate("manufacturing_date"), rs.getDate("expiry_date"), rs.getFloat("price"),
					Category.valueOf(rs.getString("category")), rs.getFloat("discount"), m.get(rs.getString("id")),
					ElectronicCategory.valueOf(rs.getString("electroniccategory")));	
			p = electronic;
			pro.add(p);		
		}
	    
		// Getting Food
        q = "Select * FROM food_tbl";
		
		rs    = stmt.executeQuery(q);
		
	    while(rs.next())
		{
	    	if(rs.getString("category")==null || rs.getString("category").isEmpty() || rs.getString("category").compareTo("FOOD")!=0)
	    		continue;
	    	
	    	if(rs.getString("foodcategory")==null || rs.getString("foodcategory").isEmpty() ||( rs.getString("foodcategory").compareTo("MILK")!=0 && rs.getString("foodcategory").compareTo("BEVERAGE")!=0))
	    		continue;
	    	
	    	if(m==null || m.isEmpty())
	    		continue;
	    	if((new Checkfields()).food(rs,m.get(rs.getString("id")))==1)
				continue;
	    	
			Food food = new Food(rs.getString("id"), rs.getString("name"), rs.getString("description"), 
					rs.getDate("manufacturing_date"), rs.getDate("expiry_date"), rs.getFloat("price"),
					Category.valueOf(rs.getString("category")), rs.getFloat("discount"), 
					FoodCategory.valueOf(rs.getString("foodcategory")), m.get(rs.getString("id")));	
			p = food;
			pro.add(p);	
	
		}
	    
		// Getting Stationery
        q = "Select * FROM stationery_tbl";
		
		rs    = stmt.executeQuery(q);
		
	    while(rs.next())
		{
	    	if(rs.getString("category").compareTo("STATIONERY")!=0)
	    		continue;
	    	if(rs.getString("stationerycategory")==null || rs.getString("stationerycategory").isEmpty() || (rs.getString("stationerycategory").compareTo("PEN")!=0 && rs.getString("stationerycategory").compareTo("DIARY")!=0 && rs.getString("stationerycategory").compareTo("CALCULATOR")!=0))   
	    		continue;
	    	if((new Checkfields()).stationery(rs)==1)
				continue;
			Stationery stationery = new Stationery(rs.getString("id"), rs.getString("name"), rs.getString("description"), 
					rs.getDate("manufacturing_date"), rs.getDate("expiry_date"), rs.getFloat("price"),
					Category.valueOf(rs.getString("category")), rs.getFloat("discount"), 
					StationeryCategory.valueOf(rs.getString("stationerycategory")));	
			p = stationery;
			pro.add(p);		
		}
	    
	    rs.close();
	    stmt.close();
	    
	    if(conn!=null)
	    	conn.close();
		
		return pro;
	}


}
