package com.servlet.bankregister;

import java.io.Serializable;

public class CheckBalanceBean implements Serializable
{
	
	private String userName;
	private String password;
	private int accountNo;
	private String rePassword;
	private Integer amount;
	private String address;
	private long phone ;
	
	private int targetAcno;
	
	
	public int getTargetAcno() {
		return targetAcno;
	}
	public void setTargetAcno(int targetAcno) {
		this.targetAcno = targetAcno;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
		
}
