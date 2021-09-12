package com.revature.repo;

import java.util.List;

import com.revature.models.Bank;

public interface BankDAO {

	public void createUser(Bank newBanker);

	public boolean logIn(Bank banker);

	public List<Bank> selectAllAccounts();

	public void dummyUsers();

}
