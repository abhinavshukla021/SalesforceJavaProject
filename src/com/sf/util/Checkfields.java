package com.sf.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;



public class Checkfields 
{

	public int book(ResultSet rs) throws SQLException 
	{
		if(rs.getString("id")==null || rs.getString("id").isEmpty())
			return 1;
	
		else if(rs.getString("name")==null || rs.getString("name").isEmpty())
	        return 1;
		
		else if(rs.getDate("manufacturing_date")==null )
			return 1;

		else if(rs.getFloat("price")==0 )
			return 1;
		
		else if(rs.getInt("noOfPages")==0 )
			return 1;
		
		else if(rs.getString("author")==null || rs.getString("author").isEmpty())
			return 1;
			
		return 0;
	}
	
	public int stationery(ResultSet rs) throws SQLException 
	{
		if(rs.getString("id")==null || rs.getString("id").isEmpty())
			return 1;
	
		else if(rs.getString("name")==null || rs.getString("name").isEmpty())
	        return 1;
		
		else if(rs.getDate("manufacturing_date")==null )
			return 1;

		else if(rs.getFloat("price")==0 )
			return 1;

			
		return 0;
	}

	
	public int electronic(ResultSet rs, Map <String, String> m) throws SQLException 
	{
		if(m==null || m.isEmpty())
		{
			return 1;
		}
		for (Map.Entry<String,String> entry : m.entrySet())  
		{
			if(entry.getKey()==null )
			return 1;
			
			if(entry.getValue()==null )
			return 1;
			
			if(entry.getKey().isEmpty() )
			return 1;
			
			if(entry.getValue().isEmpty())
			return 1;
			
		}
		if(rs.getString("id")==null || rs.getString("id").isEmpty())
			return 1;
	
		else if(rs.getString("name")==null || rs.getString("name").isEmpty())
	        return 1;
		
		else if(rs.getDate("manufacturing_date")==null )
			return 1;

		else if(rs.getFloat("price")==0 )
			return 1;

			
		return 0;
	}
	
	public int food(ResultSet rs, Map <String, String> m) throws SQLException 
	{
		if(m==null || m.isEmpty())
		{
			return 1;
		}
		for (Map.Entry<String,String> entry : m.entrySet())  
		{
			if(entry.getKey()==null )
			return 1;
			
			if(entry.getValue()==null )
			return 1;
			
			if(entry.getKey().isEmpty() )
			return 1;
			
			if(entry.getValue().isEmpty())
			return 1;
			
		}
		if(rs.getString("id")==null || rs.getString("id").isEmpty())
			return 1;
	
		else if(rs.getString("name")==null || rs.getString("name").isEmpty())
	        return 1;
		
		else if(rs.getDate("manufacturing_date")==null )
			return 1;

		else if(rs.getFloat("price")==0 )
			return 1;

			
		return 0;
	}
	

}
