package com.revature.repo;

import java.util.List;

import com.revature.models.User;

public interface BankDAO {

	public void createUser(User newBanker);

	public boolean logIn(User banker);

	public List<User> selectAllAccounts();

//	public void dummyUsers();

	public boolean selectEmployee(User banker);

	public List<User> selectAllUnapprovedAccounts();

	public boolean updateUserToApproved(String user);

	public boolean deleteUser(String users);

	public List<User> SelectAccount(User banker);

	public List<User> SelectAccountEmployee(String userBalance);

}
