package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepositDAo 
{
	public int deposit(CheckBalanceBean b)
	{
		int c=0;
		try {
			Connection con = Connection_Class.getConnection();
			PreparedStatement st = con.prepareStatement("update icicibank set AMOUNT=AMOUNT+? where ACNO=? and  USERNAME=? and PASSWORD=? ");
			
			st.setInt(1, b.getAmount());
			st.setInt(2, b.getAccountNo());
			st.setString(3, b.getUserName());
			st.setString(4, b.getPassword());
			
			c=st.executeUpdate();
		} 
		 catch (Exception e) {
			
			e.printStackTrace();
		}
		return c;
		
	}

}
