package com.pharmacy.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	private  static final String url="jdbc:mysql://localhost:3306/pharmacy";
	private final static String user="root";
	private final static String password="root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url,user,password);	
	}
}
