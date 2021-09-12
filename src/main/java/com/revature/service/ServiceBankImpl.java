package com.revature.service;

import java.util.List;

import com.revature.models.Bank;
import com.revature.repo.BankDAO;


public class ServiceBankImpl implements BankService {

	BankDAO database;
	
	public ServiceBankImpl(BankDAO database) {
		this.database = database;
		
	}


@Override
	public Boolean validateUser(Bank banker) {
	// TODO Auto-generated method stub
		if (database.logIn(banker)) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public void addUser(Bank newBanker) {
		
		database.createUser(newBanker);
		
		
	}


	@Override
	public List<Bank> getAllUnapprovedAccounts() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setUserToApproved(String user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Bank> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return database.selectAllAccounts();


	}
}
