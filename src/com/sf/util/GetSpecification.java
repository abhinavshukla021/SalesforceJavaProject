package com.sf.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.sf.connection.DBConnectionManagerImpl;

public class GetSpecification
{
	
	public Map<String, Map<String, String>> get() throws ClassNotFoundException, SQLException {

	Connection conn = (new DBConnectionManagerImpl()).getConnection();
	Statement stmt = conn.createStatement();
	
	String q = "Select * FROM specification_tbl";
	
	ResultSet rs    = stmt.executeQuery(q);
	
	Map <String, Map <String, String>> m = new HashMap <String, Map <String, String>> ();
	
	while (rs.next()) 
	{
		String rk = rs.getString("referenceKey");
		String att = rs.getString("attribute");
		String val = rs.getString("value");
		
		if(m.isEmpty()==true)
		{
			Map <String, String> temp = new HashMap <String, String>();
			temp.put(att, val);
			m.put(rk, temp);
		}
		else if (m.containsKey(rk)==true)
		{
			m.get(rk).put(att, val);
		}
		else
		{
			Map <String, String> temp = new HashMap <String, String>();
			temp.put(att, val);
			m.put(rk, temp);
		}
	}
	
    rs.close();
    stmt.close();
    
    if(conn!=null)
    	conn.close();
    
    
	return m;
	}
}
