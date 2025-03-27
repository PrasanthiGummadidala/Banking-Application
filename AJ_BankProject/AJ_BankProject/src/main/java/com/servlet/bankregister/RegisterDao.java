package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegisterDao 
{
	public int register(RegisterBean rb)
	{
		int n=0;
		try {
			Connection con = Connection_Class.getConnection();
			
			PreparedStatement st = con.prepareStatement("insert into icicibank values (?,?,?,?,?,?)");
			st.setInt(1, rb.getAccountNo());
			st.setString(2, rb.getUserName());
			st.setString(3, rb.getPassword());
			
			st.setInt(4, rb.getAmount());
			st.setString(5, rb.getAddress());
			st.setLong(6, rb.getPhone());
		n=st.executeUpdate();
			
		} 
		catch (SQLIntegrityConstraintViolationException e) {
			return -1;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return n;
		
		
	}
	
	public int getacNo(RegisterBean rb)
	{
		int acno=0;
		try {

			Connection con=Connection_Class.getConnection();
			PreparedStatement st = con.prepareStatement("select * from sastabank where USERNAME=? and PASSWORD=?");
			st.setString(1, rb.getUserName());
			st.setString(2, rb.getPassword());
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				acno=rs.getInt(3);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return acno;
	}
	
}
