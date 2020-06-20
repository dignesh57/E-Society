package com.es.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProviderImpl implements DbConnectionProvider{

	@Override
	public Connection getConnetion() {
		Connection con=null;
		
		try {
			Class.forName(DbConstants.driver);
			con=DriverManager.getConnection(DbConstants.url,DbConstants.name,DbConstants.pass);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
