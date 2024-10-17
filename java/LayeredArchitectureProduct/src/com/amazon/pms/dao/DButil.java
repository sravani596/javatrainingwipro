package com.amazon.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DButil {

	public static Connection getDBConnection() {
		
		Connection conn =null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_db", "root", "ABC596@sravs");

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}
}
