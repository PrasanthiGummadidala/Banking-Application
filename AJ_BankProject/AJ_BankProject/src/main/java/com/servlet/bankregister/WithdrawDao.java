package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class WithdrawDao 
{
	public int withdraw(CheckBalanceBean b) {
		int c=0,amount=0;
		try {
			Connection con = Connection_Class.getConnection();
			PreparedStatement st = con.prepareStatement("update icicibank set AMOUNT=AMOUNT-? where ACNO=? and  USERNAME=? and PASSWORD=? ");
			PreparedStatement st1 = con.prepareStatement("select AMOUNT  from sastabank where ACNO=?");
			st1.setInt(1, b.getAccountNo());
			ResultSet set = st1.executeQuery();
			while(set.next())
			{
				amount=set.getInt(1);
			}
			if(amount>=b.getAmount())
			{
			st.setInt(1, b.getAmount());
			st.setInt(2, b.getAccountNo());
			st.setString(3, b.getUserName());
			st.setString(4, b.getPassword());
			
			c=st.executeUpdate();
			}
			else
			{
				c=-1;
			}
		} 
		 catch (Exception e) {
			
			e.printStackTrace();
		}
		return c;
	}

}
