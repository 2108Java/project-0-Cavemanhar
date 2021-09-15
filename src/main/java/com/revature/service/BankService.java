package com.revature.service;

import java.util.List;

import com.revature.models.User;

public interface BankService {


	public Boolean validateUser(User banker);

	public void addUser(User newBanker);

	public List<User> getAllUnapprovedAccounts();

	public boolean setUserToApproved(String user);

	public List<User> getAllAccounts();

	public boolean isEmployee(User banker);

	public boolean validateUserEmployee(User employeeBank);

	public boolean deleteUser(String users);

	public List<User> getSelectedAccount(User banker);

	public List<User> getSelectedAccountForEmployee(String userBalance);

	public void addDeposit(User banker);



	

}
