package com.servlet.bankregister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

public class TransferDao {
	public int getCurrentBalance(int acno) {
		int amt = 0;
		try {
			Connection con = Connection_Class.getConnection();
			PreparedStatement pstmt = con.prepareStatement("select * from  icicibank  where ACNO=?");
			pstmt.setInt(1, acno);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				amt = rs.getInt("AMOUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return amt;
	}

	public int transfer(CheckBalanceBean bb) throws SQLException {
		int k = 0;
		Connection con = Connection_Class.getConnection();

		con.setAutoCommit(false);
		Savepoint s = con.setSavepoint();
		try {
			PreparedStatement ps = con
					.prepareStatement("select * from icicibank where USERNAME=? and PASSWORD=? and ACNO=?");
			String uname=bb.getUserName();
			String password = bb.getPassword();
			int accountNo = bb.getAccountNo();
			System.out.println(uname);
			System.out.println(password);
			System.out.println(accountNo);
			ps.setString(1, uname);
			ps.setString(2, password);
			ps.setInt(3, accountNo);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				if (getCurrentBalance(bb.getAccountNo()) >= bb.getAmount()) {

					PreparedStatement ps1 = con.prepareStatement("select * from sastabank where  acno=?");
					ps1.setInt(1, bb.getTargetAcno());

					ResultSet rs1 = ps1.executeQuery();

					if (rs1.next()) {

						PreparedStatement pstmt1 = con
								.prepareStatement("update sastabank set amount=amount-? where Acno=?");
						PreparedStatement pstmt2 = con
								.prepareStatement("update sastabank set amount=amount+? where Acno=?");

						pstmt1.setInt(1, bb.getAmount());
						pstmt1.setInt(2, bb.getAccountNo());
						k = pstmt1.executeUpdate();
						if (k > 0) {
							pstmt2.setInt(1, bb.getAmount());
							pstmt2.setInt(2, bb.getTargetAcno());
							k = pstmt2.executeUpdate();
							if (k == 0)
								throw new RuntimeException();
							else
							{
								con.commit();
							}
						}

					} else {
						System.out.println("Reciver Account Not Found");
						return -3;
					}

				} else {
					System.out.println("Insufficient Balance");
					return -1;
				}
			} else {
				System.out.println("Sender Account not verfied");
				return -2;
			}
		} catch (Exception e) {
			con.rollback(s);
			e.printStackTrace();
		}
		con.setAutoCommit(true);

		return k;

	}

}
