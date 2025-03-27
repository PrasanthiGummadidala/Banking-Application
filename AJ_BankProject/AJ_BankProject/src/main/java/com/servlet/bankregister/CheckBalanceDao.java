package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckBalanceDao 
{
	public CheckBalanceBean ViewDetails(CheckBalanceBean cb)  
	{
		CheckBalanceBean rb=null;
		List<CheckBalanceBean> c=new ArrayList<CheckBalanceBean>();
		try {
			Connection con = Connection_Class.getConnection();
			PreparedStatement st = con.prepareStatement("select * from icicibank where USERNAME=? and  PASSWORD=? and ACNO=?");
			st.setString(1, cb.getUserName());
			st.setString(2, cb.getPassword());
			st.setInt(3, cb.getAccountNo());
			
		
			ResultSet rs = st.executeQuery();
			
			if(rs.next())
			{
				rb=new CheckBalanceBean();
				rb.setUserName(rs.getString(1));
				rb.setPassword(rs.getString(2));
				rb.setAccountNo(rs.getInt(3));
				rb.setAmount(rs.getInt(4));
				rb.setAddress(rs.getString(5));
				rb.setPhone(rs.getLong(6));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return rb;
		
	}

}
