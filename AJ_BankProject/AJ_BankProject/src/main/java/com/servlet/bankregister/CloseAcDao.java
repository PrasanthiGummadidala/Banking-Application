package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CloseAcDao 
{
	public int close(CheckBalanceBean cb)
	{
		int n=0;
		
		Connection con = Connection_Class.getConnection();
		
		try {
			PreparedStatement st = con.prepareStatement("delete from icicibank where ACNO=?");
			
			st.setInt(1, cb.getAccountNo());
			n=st.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return n;
	}

}
