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

	public User SelectAccount(User banker);

	public List<User> SelectAccountEmployee(String userBalance);

	public boolean insertDeposit(User banker);

	public boolean insertWithdraw(User banker);

	public List<User> selectAllTransactions();

	public boolean insertCheckingWithdraw(User banker);

	public boolean insertCheckingDeposit(User banker);

	public String selectAccountType(User banker);

	public void updateUserAccount(User banker, int value);

	public boolean insertMoneyTransfer(User transfer);

	public void updateTransfer(User banker);

	public boolean selectMoneyTransfer(User banker);



}
