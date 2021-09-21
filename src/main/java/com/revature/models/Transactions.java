package com.revature.models;

public class Transactions {

	
	private String Username;

	


	private double savingsBalance;
	private double checkingBalance;
	private double savingsWithdraw;
	private double savingsDeposit;
	private double savingsTransfer;
	private double checkingWithdraw;
	private double checkingDeposit;
	private double checkingTransfer;

	public Transactions(String username) {
		super();
		Username = username;
	}

	public Transactions() {
		super();
	}

	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}


	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	public double getCheckingBalance() {
		return checkingBalance;
	}


	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}


	public double getSavingsWithdraw() {
		return savingsWithdraw;
	}


	public void setSavingsWithdraw(double savingsWithdraw) {
		this.savingsWithdraw = savingsWithdraw;
	}


	public double getSavingsDeposit() {
		return savingsDeposit;
	}


	public void setSavingsDeposit(double savingsDeposit) {
		this.savingsDeposit = savingsDeposit;
	}


	public double getSavingsTransfer() {
		return savingsTransfer;
	}


	public void setSavingsTransfer(double savingsTransfer) {
		this.savingsTransfer = savingsTransfer;
	}


	public double getCheckingWithdraw() {
		return checkingWithdraw;
	}


	public void setCheckingWithdraw(double checkingWithdraw) {
		this.checkingWithdraw = checkingWithdraw;
	}


	public double getCheckingDeposit() {
		return checkingDeposit;
	}


	public void setCheckingDeposit(double checkingDeposit) {
		this.checkingDeposit = checkingDeposit;
	}


	public double getCheckingTransfer() {
		return checkingTransfer;
	}


	public void setCheckingTransfer(double checkingTransfer) {
		this.checkingTransfer = checkingTransfer;
	}


	@Override
	public String toString() {
		return "Transactions [Savings Balance=" + savingsBalance + ", Checking Balance=" + checkingBalance
				+ ", Savings Withdraw=" + savingsWithdraw + ", Savings Deposit=" + savingsDeposit + ", Savings Transfer="
				+ savingsTransfer + ", Checking Withdraw=" + checkingWithdraw + ", Checking Deposit=" + checkingDeposit
				+ ", Checking Transfer=" + checkingTransfer + "]";
	}

	
}
