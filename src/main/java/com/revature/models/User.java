package com.revature.models;



public class User {
	
	private int id;


	private String name;
	private String username;
	private String password;
	private double savingsBalance;
	private boolean isApproved;
	private boolean isEmployee;
	private String accountType;
	private double savingsWithdraw;
	private double checkingBalance;
	private double savingsDeposit;
	private double checkingWithdraw;
	
	private double checkingDeposit;
	
	




	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	
	public User(String username, String password, double savingsBalance, boolean isEmployee, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.savingsBalance = savingsBalance;
		this.isEmployee = isEmployee;
		this.accountType = accountType;
	}

	public User(String name, String username, String password, double savingsBalance, boolean isApproved,
			String accountType, double checkingBalance) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.savingsBalance = savingsBalance;
		this.isApproved = isApproved;
		this.accountType = accountType;
		this.checkingBalance = checkingBalance;
	}



	public User(String username, double savingsBalance, double savingsWithdraw, double savingsDeposit) {
		super();
		this.username = username;
		this.savingsBalance = savingsBalance;
		this.savingsWithdraw = savingsWithdraw;
		this.savingsDeposit = savingsDeposit;
	}

	public User(String username, String password, double savingsBalance, double checkingBalance, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.savingsBalance = savingsBalance;
		this.accountType = accountType;
		this.checkingBalance = checkingBalance;
	}


	public User(String username, double savingsBalance, double savingsWithdraw, 
			double savingsDeposit, double checkingBalance, double checkingWithdraw, double checkingDeposit) {
		super();
		this.username = username;
		this.savingsBalance = savingsBalance;
		this.savingsWithdraw = savingsWithdraw;
		this.checkingBalance = checkingBalance;
		this.savingsDeposit = savingsDeposit;
		this.checkingWithdraw = checkingWithdraw;
		this.checkingDeposit = checkingDeposit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double getSavingsWithdraw() {
		return savingsWithdraw;
	}

	public void setSavingsWithdraw(double savingsWithdraw) {
		this.savingsWithdraw = savingsWithdraw;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsDeposit() {
		return savingsDeposit;
	}

	public void setSavingsDeposit(double savingsDeposit) {
		this.savingsDeposit = savingsDeposit;
	}

	public double getCheckingWithdraw() {
		return checkingWithdraw;
	}

	public void setCheckingWithdraw(double checingWithdraw) {
		this.checkingWithdraw = checingWithdraw;
	}

	public double getCheckingDeposit() {
		return checkingDeposit;
	}

	public void setCheckingDeposit(double checkingDeposit) {
		this.checkingDeposit = checkingDeposit;
	}


	

	
}
