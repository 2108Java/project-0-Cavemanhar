package com.revature.service;

import java.util.List;

import com.revature.models.Bank;

public interface BankService {


	public void validateUser(Bank banker);

	public void addUser(Bank newBanker);

	public List<Bank> getAllUnapprovedAccounts();

	public void setUserToApproved(String user);



	

}
