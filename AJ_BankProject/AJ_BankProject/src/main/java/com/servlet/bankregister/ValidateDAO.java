package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ValidateDAO {

	public static int validate(CheckBalanceBean rb)
	{
		int k=0;
		try
		{

			
			Connection con =Connection_Class.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from icicibank where USERNAME=? and  PASSWORD=? and ACNO=?");
			ps.setString(1, rb.getUserName());
			ps.setString(2, rb.getPassword());
			ps.setInt(3, rb.getAccountNo());
			
			 ResultSet rs = ps.executeQuery();
			 if(rs.next())k++;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
