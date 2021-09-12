package com.revature.service;

import java.util.List;

import com.revature.models.Bank;

public interface BankService {


	public Boolean validateUser(Bank banker);

	public void addUser(Bank newBanker);

	public List<Bank> getAllUnapprovedAccounts();

	public void setUserToApproved(String user);

	public List<Bank> getAllAccounts();



	

}
