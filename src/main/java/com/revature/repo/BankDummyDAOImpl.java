package com.revature.repo;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class BankDummyDAOImpl implements BankDAO {
	private List<User> dummyUsersList = new ArrayList();
	public void dummyUsers() {
//		List<Bank> dummyUsersList = new ArrayList();
		
		
		 dummyUsersList.add(new User("Tyler", "starfish", 100, false, "Savings" ));
		 dummyUsersList.add(new User("Ashley", "starfish", 100, false, "Checking" ));
		 dummyUsersList.add(new User("Jeff", "starfish", true ));
		 dummyUsersList.add(new User("John", "starfish", 1000, true,  "Checking" ));
		 dummyUsersList.add(new User("Kelce", "starfish", 100.50, false,  "Checking" ));
		
		
	}
	
	@Override
	public void createUser(User newBanker) {

		
		dummyUsersList.add(newBanker);
		System.out.println("User Added");
		
	}

	@Override
	public boolean logIn(User banker) {
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
	public List<User> selectAllAccounts() {
		// TODO Auto-generated method stub
		return dummyUsersList;
	}



	@Override
	public boolean selectEmployee(User banker) {
		
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
	public List<User> selectAllUnapprovedAccounts() {
		List<User> unapprovedUsersList = new ArrayList();
		
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

	@Override
	public List<User> SelectAccount(User banker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> SelectAccountEmployee(String userBalance) {
		// TODO Auto-generated method stub
		return null;
	}

}
