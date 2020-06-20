package com.es.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public interface DbConnectionProvider {

	public Connection getConnetion();

}
