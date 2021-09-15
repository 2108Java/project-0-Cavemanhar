package com.revature.repo;

import java.util.List;

import com.revature.models.Bank;

public interface BankDAO {

	public void createUser(Bank newBanker);

	public boolean logIn(Bank banker);

	public List<Bank> selectAllAccounts();

//	public void dummyUsers();

	public boolean selectEmployee(Bank banker);

	public List<Bank> selectAllUnapprovedAccounts();

	public boolean updateUserToApproved(String user);

	public boolean deleteUser(String users);

}
