package com.revature.presentation;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Bank;

import com.revature.service.BankService;



public class MainMenuImpl implements MainMenu{

	BankService service;
	
	public MainMenuImpl(BankService service) {
		this.service = service;
	}
	
	private void prettyDisplayOfArray(List<Bank> array) {
for(int i = 0; i< array.size(); i++) {
			
			if(array.get(i) != null) {
				System.out.println(array.get(i).getUsername());
				System.out.println(array.get(i).getBalance());
				System.out.println(array.get(i).isApproved());
				System.out.println("");
				
			}
			
		}
	}

	
	
	private void optionsMenu() {
		System.out.println("1) Log in to Account");
		System.out.println("2) Apply for Bank Account");
//		System.out.println("3) Complete a todo");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Exit");
	}
	private void optionsMenuEmployee() {
		System.out.println("1) Approve new User");
//		System.out.println("2) Apply for Bank Account");
//		System.out.println("3) Complete a todo");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Exit");
	}
	private void optionsMenuCustomer() {
		System.out.println("1) Current Balance");
//		System.out.println("2) ");
//		System.out.println("3) Complete a todo");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Exit");
	}
	public void Display() {
		
			Scanner sc = new Scanner(System.in);
		
			boolean running = true;
			
		
			while (running) {
				optionsMenu();
				
				String result = sc.nextLine();
				
				switch (result) {
				
				case "1":
					System.out.println("Please enter your Username:");
					String username = sc.nextLine();
					System.out.println("Please enter your Password:");
					String password = sc.nextLine();
					Bank banker = new Bank(username, password);
					service.validateUser(banker);
					
					if(banker.isEmployee() == true) {
						boolean running2 = true;
						
						while(running2) {
						optionsMenuEmployee();
						String result2 = sc.nextLine();
						
						switch (result2) {
						case "1":
							
							List<Bank> unApprovedUsers =	service.getAllUnapprovedAccounts();
							prettyDisplayOfArray(unApprovedUsers);
							System.out.println("Which user do you wish to approve?(use username)");
							String user = sc.nextLine();
							service.setUserToApproved(user);
							break;
							
						case "8":
							running2 = false;
							break;
							
						}
						}
						
						
					}else if (banker.isApproved() == true) {
					
						optionsMenuCustomer();
						
					}else {
						System.out.println("sorry you have yet to be approved.");
						
					}
					
					break;
				case "2":
					System.out.println("Please enter your Username for your new account:");
					String newUsername = sc.nextLine();
					System.out.println("Please enter your Password for your new account::");
					String newPassword = sc.nextLine();
					System.out.println("Please enter your Password for your new account::");
					Double firstDeposit = Double.parseDouble(sc.nextLine());
					System.out.println("Please enter your Password for your new account::");
					Boolean employee = Boolean.parseBoolean(sc.nextLine());
					Bank newBanker = new Bank(newUsername,newPassword,firstDeposit,false, employee);
					
					service.addUser(newBanker);
					break;
				case "8":
					System.out.println("Thank you for banking with us.");
					running = false;
					break;
				default:
					System.out.println("That's not a valid input!");
					System.out.println("Please Try again!");
					
				
				}
				
			
				
				
				
			}
			
			
		}
	}


