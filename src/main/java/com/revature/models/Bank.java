package com.revature.models;

public class Bank {
	
	private String username;
	private String password;
	private double balance;
	private boolean isApproved;
	private boolean isEmployee;

	private double withdraw;
	private double deposit;
	
	public Bank(String username, String password, double balance, boolean isApproved, boolean isEmployee,
			double withdraw, double deposit) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.isApproved = isApproved;
		this.isEmployee = isEmployee;
		this.withdraw = withdraw;
		this.deposit = deposit;
	}

	public Bank(String username, String password, double balance, boolean isApproved, boolean isEmployee) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.isApproved = isApproved;
		this.isEmployee = isEmployee;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public boolean isEmployee() {
		return isEmployee;
	}

	public void setEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}
	

}
