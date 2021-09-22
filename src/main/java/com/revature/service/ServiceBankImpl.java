package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.repo.BankDAO;


public class ServiceBankImpl implements BankService {

	BankDAO database;
	
	public ServiceBankImpl(BankDAO database) {
		this.database = database;
		
	}


@Override
	public Boolean validateUser(User banker) {
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
	public void addUser(User newBanker) {
		
		database.createUser(newBanker);
		
		
	}


	@Override
	public List<User> getAllUnapprovedAccounts() {
		
		List<User> unapprovedAccounts= new ArrayList();
		
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
	public List<User> getAllAccounts() {
		// TODO Auto-generated method stub
		
		return database.selectAllAccounts();


	}




	@Override
	public boolean isEmployee(User banker) {
		
		
		// TODO Auto-generated method stub
		return database.selectEmployee(banker);
	}


	@Override
	public boolean validateUserEmployee(User employeeBank) {
		// TODO Auto-generated method stub
		return database.selectEmployee(employeeBank);
	}


	@Override
	public boolean deleteUser(String users) {
		// TODO Auto-generated method stub
		return database.deleteUser(users);
	}


	@Override
	public User getSelectedAccount(User banker) {
		// TODO Auto-generated method stub
		return database.SelectAccount(banker);
	}


	@Override
	public List<User> getSelectedAccountForEmployee(String userBalance) {
		// TODO Auto-generated method stub
		return database.SelectAccountEmployee(userBalance);
	}


	@Override
	public void addDeposit(User banker) {
		// TODO Auto-generated method stub
		if (database.insertDeposit(banker)) {
			System.out.println("Successful deposit");
		}
	}


	@Override
	public void addWithdraw(User banker) {
		// TODO Auto-generated method stub
			if (database.insertWithdraw(banker) == false) {
				System.out.println("transaction failed overdraft with current amount");
			}
	}


	@Override
	public List<User> getAllTransactions() {
		// TODO Auto-generated method stub
		return database.selectAllTransactions();
	}


	@Override
	public void addCheckingDeposit(User banker) {
		if (database.insertCheckingDeposit(banker)) {
			System.out.println("Successful deposit");
		}
	}


	@Override
	public void addCheckingWithdraw(User banker) {
		if (database.insertCheckingWithdraw(banker) == false) {
			System.out.println("transaction failed overdraft with current amount");
		}
	}


	@Override
	public String selectAccountType(User banker) {
		// TODO Auto-generated method stub
		return database.selectAccountType(banker);
	}


	@Override
	public void addUserAccount(User banker, int value) {
		database.updateUserAccount(banker, value);
		
	}


	@Override
	public void addMoneyTransfer(User banker) {
		if(database.insertMoneyTransfer( banker)) {
			
		}
		
	}


	@Override
	public void transferMoney(User banker) {
		
		database.updateTransfer(banker);
		
	}


	@Override
	public boolean moneyTransferApprove(User banker) {
		// TODO Auto-generated method stub
		return database.selectMoneyTransfer(banker);
	}
}
