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
				System.out.println(array.get(i).getAccountType());
				System.out.println(array.get(i).isApproved());
				System.out.println("");
				
			}
			
		}
	}

	
	
	private void optionsMenu() {
		System.out.println("1) Log in to Bank Account");
		System.out.println("2) Apply for Bank Account");
		System.out.println("3) Log in to Employee Account");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Exit");
	}
	private void optionsMenuEmployee() {
		System.out.println("1) Approve new User");
		System.out.println("2) Reject a new User");
		System.out.println("3) View a Users Balance");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Log Out");
	}
	private void optionsMenuCustomer() {
		System.out.println("1) Current Balance");
//		System.out.println("2) Make Deposit");
//		System.out.println("3) Make Withdraw");
//		System.out.println("4) Delete a todo");
//		System.out.println("5) View all incomplete todos");
//		System.out.println("6) View all complete todos");
//		System.out.println("7) View a single todo");
		System.out.println("8) Log Out");
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
//					System.out.println(banker.getUsername());
//					boolean userValidate =service.validateUser(banker) ;
				if (service.validateUser(banker)== true) {
//					System.out.println("in first if");
					
						optionsMenuCustomer();
						System.out.println("Sorry not yet implemented");
						break;
										
					}
				else {
					System.out.println("Log in failed");
				}
					
					break;
				case "2":
					System.out.println("Please enter your Username for your new account:");
					String newUsername = sc.nextLine();
					System.out.println("Please enter your Password for your new account:");
					String newPassword = sc.nextLine();
					System.out.println("Please enter your a value you wish to initially deposit:");
					Double firstDeposit = Double.parseDouble(sc.nextLine());
//					System.out.println("Please enter if you are a employee:");
//					Boolean employee = Boolean.parseBoolean(sc.nextLine());
					System.out.println("Please enter your account type for your new account as either Savings or Checking:");
					String newAccountType = sc.nextLine();
					Bank newBanker = new Bank(newUsername,newPassword,firstDeposit,false, newAccountType);
					
					service.addUser(newBanker);
					
					prettyDisplayOfArray(service.getAllAccounts());
					break;
				case "3":
					System.out.println("Please enter your Username:");
					String usernameEmployee = sc.nextLine();
					System.out.println("Please enter your Password:");
					String passwordEmployee = sc.nextLine();
					Bank employeeBank = new Bank(usernameEmployee, passwordEmployee);
//					System.out.println(employeeBank.getUsername());
					if (service.validateUserEmployee(employeeBank)== true) {
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
								if (service.setUserToApproved(user)) {
									System.out.println("User has been approved!");
								}else {
									System.out.println("User not found!");
								}
								break;
							case "2":
								List<Bank> unApprovedUser =	service.getAllUnapprovedAccounts();
								prettyDisplayOfArray(unApprovedUser);
								System.out.println("Which user do you wish to reject?(use username)");
								String users = sc.nextLine();
								if (service.deleteUser(users)) {
									System.out.println("User has been Rejected!");
								}else {
									System.out.println("User not found!");
								}
								break;
							case "8":
								System.out.println("Employee Logging out.");
								running2 = false;
								break;
							}
						}
					}else {
						System.out.println("Log in failed are you sure you are an employee");
					}
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



