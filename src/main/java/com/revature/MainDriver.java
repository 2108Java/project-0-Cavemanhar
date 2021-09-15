package com.revature;


import com.revature.service.BankService;
import com.revature.service.ServiceBankImpl;
import com.revature.presentation.MainMenu;
import com.revature.presentation.MainMenuImpl;
import com.revature.repo.BankDAO;
import com.revature.repo.BankDAOImpl;
import com.revature.repo.BankDummyDAOImpl;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;

public class MainDriver {


	
	public static void main(String[] args) {
		
		
		
	BankDAO database = new BankDAOImpl();
	
//	database.dummyUsers();
		
		BankService service = new ServiceBankImpl(database);
		
		MainMenu mainMenu = new MainMenuImpl(service);
		
		mainMenu.Display();
	}
	
	
}