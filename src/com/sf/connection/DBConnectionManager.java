package com.sf.connection;

import java.sql.Connection;
import java.sql.SQLException;

public interface DBConnectionManager {
	public Connection getConnection() throws ClassNotFoundException, SQLException;

	public void closeConnection() throws SQLException;
}
