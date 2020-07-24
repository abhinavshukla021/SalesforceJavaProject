package com.sf.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class DBConnectionManagerImpl implements DBConnectionManager {
	private Connection connection;

	@Override
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		this.connection = null;
		String url = "jdbc:mysql://localhost:3306/SalesforceDb";
		String user = "root";
		String password = "root1234";
		this.connection = DriverManager.getConnection(url, user, password);
		return this.connection;
	}

	@Override
	public void closeConnection() throws SQLException {
		// TODO Auto-generated method stub
		
		if(this.connection!=null)
		{
			this.connection.close();
		}
	}
}
