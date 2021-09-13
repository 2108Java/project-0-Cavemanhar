package com.revature.service;

import java.util.ArrayList;
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
//	System.out.println(banker.getUsername() + banker.getPassword());
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
		
		List<Bank> unapprovedAccounts= new ArrayList();
		
			unapprovedAccounts = database.selectAllUnapprovedAccounts();
		// TODO Auto-generated method stub
		return unapprovedAccounts;
	}


	@Override
	public boolean setUserToApproved(String user) {
		// TODO Auto-generated method stub
		
		
		return database.updateUserToApproved(user);
	}


	@Override
	public List<Bank> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return database.selectAllAccounts();


	}




	@Override
	public boolean isEmployee(Bank banker) {
		
		
		// TODO Auto-generated method stub
		return database.selectEmployee(banker);
	}
}
