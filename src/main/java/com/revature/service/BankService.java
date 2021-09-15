package com.revature.service;

import java.util.List;

import com.revature.models.Bank;

public interface BankService {


	public Boolean validateUser(Bank banker);

	public void addUser(Bank newBanker);

	public List<Bank> getAllUnapprovedAccounts();

	public boolean setUserToApproved(String user);

	public List<Bank> getAllAccounts();

	public boolean isEmployee(Bank banker);

	public boolean validateUserEmployee(Bank employeeBank);

	public boolean deleteUser(String users);

	public List<Bank> getSelectedAccount(Bank banker);

	public List<Bank> getSelectedAccountForEmployee(String userBalance);



	

}
