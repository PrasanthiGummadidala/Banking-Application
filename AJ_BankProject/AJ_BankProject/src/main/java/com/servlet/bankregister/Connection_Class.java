package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_Class {
	
	private static Connection con;
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","c##ajdb","sqlpassword");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static Connection getConnection()
	{
		return con;
	}
}
