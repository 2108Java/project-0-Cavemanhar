package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bank;

public class BankDummyDAOImpl implements BankDAO {
	private List<Bank> dummyUsersList = new ArrayList();
	public void dummyUsers() {
//		List<Bank> dummyUsersList = new ArrayList();
		
		
		 dummyUsersList.add(new Bank("Tyler", "starfish", 100, false, "Savings" ));
		 dummyUsersList.add(new Bank("Ashley", "starfish", 100, false, "Checking" ));
		 dummyUsersList.add(new Bank("Jeff", "starfish", true ));
		 dummyUsersList.add(new Bank("John", "starfish", 1000, true,  "Checking" ));
		 dummyUsersList.add(new Bank("Kelce", "starfish", 100.50, false,  "Checking" ));
		
		
	}
	
	@Override
	public void createUser(Bank newBanker) {

		
		dummyUsersList.add(newBanker);
		System.out.println("User Added");
		
	}

	@Override
	public boolean logIn(Bank banker) {
		// TODO Auto-generated method stub
		boolean validate = false;
		for(int i = 0; i < dummyUsersList.size(); i++ ) {
			
			if(dummyUsersList.get(i).getUsername().equals(banker.getUsername())
					&& dummyUsersList.get(i).getPassword().equals(banker.getPassword())
					&& dummyUsersList.get(i).isApproved()){
				
				
				validate=true;
				break;
			}
			
		}
		return validate;
		
	}

	@Override
	public List<Bank> selectAllAccounts() {
		// TODO Auto-generated method stub
		return dummyUsersList;
	}



	@Override
	public boolean selectEmployee(Bank banker) {
		
		boolean validate = false;
		for(int i = 0; i < dummyUsersList.size(); i++ ) {
			
			if(dummyUsersList.get(i).getUsername().equals(banker.getUsername())
					&& dummyUsersList.get(i).getPassword().equals(banker.getPassword())
							&& dummyUsersList.get(i).isEmployee()) {
				
				
				validate=true;
				break;
			}
			
		}
		return validate;
	}

	@Override
	public List<Bank> selectAllUnapprovedAccounts() {
		List<Bank> unapprovedUsersList = new ArrayList();
		
			for(int i = 0; i < dummyUsersList.size(); i++ ) {
			
				if(dummyUsersList.get(i).isApproved() == false) {
				
				
				unapprovedUsersList.add(dummyUsersList.get(i));
				
					
				}
			
			}
		return unapprovedUsersList;
	}

	@Override
	public boolean updateUserToApproved(String user) {
		boolean validate = false;
		for(int i = 0; i < dummyUsersList.size(); i++ ) {
			
			if(dummyUsersList.get(i).getUsername().equals(user) ) {
				
				dummyUsersList.get(i).setApproved(true);
				
				validate=true;
				break;
			}
			
		}
		return validate;
	}

	@Override
	public boolean deleteUser(String user) {
		// TODO Auto-generated method stub
		
		
		boolean validate = false;
		for(int i = 0; i < dummyUsersList.size(); i++ ) {
			
			if(dummyUsersList.get(i).getUsername().equals(user) ) {
				
				dummyUsersList.remove(i);
				
				validate=true;
				break;
			}
			
		}
		return validate;
	}

}
