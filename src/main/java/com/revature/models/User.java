package com.revature.models;

public class User {
	
	private int id;


	private String name;
	private String username;
	private String password;
	private double balance;
	private boolean isApproved;
	private boolean isEmployee;
	private String accountType;

	private double withdraw;
	
	private double deposit;
	
	public User(String username, String password, double balance, boolean isApproved, boolean isEmployee,
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

	
	public User(String username, String password, double balance,  boolean isEmployee, String accountType) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
		this.isEmployee = isEmployee;
		this.isApproved = false;
		
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	public User(String username, String password, boolean isEmployee) {
		this.username = username;
		this.password = password;
		this.isEmployee = isEmployee;
		this.isApproved = true;
	}


	public User(String username, String password, Double balance, boolean isApproved, String accountType) {
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
		this.isApproved = false;
	}


	public User(int id, String name, String username, String password, double balance, String accountType) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
		this.isApproved = false;
		this.isEmployee = false;
	}

	public User( String name, String username, String password, double balance, String accountType) {
		super();
		
		this.name = name;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accountType = accountType;
		this.isApproved = false;
		this.isEmployee = false;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}


	


	public User(String username, double balance, double withdraw, double deposit) {
		super();
		this.username = username;
		this.balance = balance;
		this.withdraw = withdraw;
		this.deposit = deposit;
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
	
	public double getWithdraw() {
		return withdraw;
	}


	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}


	public double getDeposit() {
		return deposit;
	}


	public void setDeposit(double deposit) {
		this.deposit = deposit;
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



}
