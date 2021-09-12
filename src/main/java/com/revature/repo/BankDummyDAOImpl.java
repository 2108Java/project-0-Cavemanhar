package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bank;

public class BankDummyDAOImpl implements BankDAO {
	private List<Bank> dummyUsersList = new ArrayList();
	public void dummyUsers() {
//		List<Bank> dummyUsersList = new ArrayList();
		
		
		 dummyUsersList.add(new Bank("Tyler", "starfish", 100, false, false ));
		 dummyUsersList.add(new Bank("Ashley", "starfish", 100, false, false ));
		 dummyUsersList.add(new Bank("Jeff", "starfish", 0, true, true ));
		 dummyUsersList.add(new Bank("John", "starfish", 1000, true, false ));
		 dummyUsersList.add(new Bank("Kelce", "starfish", 100.50, false, false ));
		
		
	}
	
	@Override
	public void createUser(Bank newBanker) {
		// TODO Auto-generated method stub
		
		dummyUsersList.add(newBanker);
		System.out.println("User Added");
		
	}

	@Override
	public boolean logIn(Bank banker) {
		// TODO Auto-generated method stub
		for(int i = 0; i < dummyUsersList.size(); i++ ) {
			if(dummyUsersList.get(i).getUsername() == banker.getUsername() && dummyUsersList.get(i).getPassword() == banker.getPassword()  ) {
				return true;
			}else {
				return false;
			}
		}
		return false;
		
	}

	@Override
	public List<Bank> selectAllAccounts() {
		// TODO Auto-generated method stub
		return dummyUsersList;
	}

}
