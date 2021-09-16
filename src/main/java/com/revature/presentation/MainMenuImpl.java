package com.revature.presentation;

import java.util.List;
import java.util.Scanner;

import com.revature.models.User;

import com.revature.service.BankService;



public class MainMenuImpl implements MainMenu{

	BankService service;
	
	public MainMenuImpl(BankService service) {
		this.service = service;
	}
	
	private void prettyDisplayOfArray(List<User> array) {
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
		System.out.println("4) Exit");
	}
	private void optionsMenuEmployee() {
		System.out.println("1) Approve new User");
		System.out.println("2) Reject a new User");
		System.out.println("3) View a Users Balance");
		System.out.println("4) View all Transactions");
		System.out.println("5) Log Out");
	}
	private void optionsMenuCustomer() {
		System.out.println("1) Current Balance");
		System.out.println("2) Make Deposit");
		System.out.println("3) Make Withdraw");
//		System.out.println("4) Make A Money Transfer");
//		System.out.println("5) Approve Money Transfer");

		System.out.println("6) Log Out");
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
					User banker = new User(username, password);
//					System.out.println(banker.getUsername());
//					boolean userValidate =service.validateUser(banker) ;
				if (service.validateUser(banker)== true) {
//					System.out.println("in first if");
					
						
//						System.out.println("Sorry not yet implemented");
						boolean running3 = true;
						
						while(running3) {
							optionsMenuCustomer();
						String result3 = sc.nextLine();
						
						switch (result3) {
						case "1":
							
							prettyDisplayOfArray(service.getSelectedAccount(banker));
							break;
						case "2":
							System.out.println("Please enter your a value you wish to Deposit:");
							Double deposit = Double.parseDouble(sc.nextLine());
							banker.setDeposit(deposit);
							service.addDeposit(banker);
							break;
						case "3":
							
							System.out.println("Please enter your a value you wish to Withdraw:");
							Double withdraw = Double.parseDouble(sc.nextLine());
							if (withdraw > 0) {
							banker.setWithdraw(withdraw);
							service.addWithdraw(banker);
							}else {
								System.out.println("Sorry that value is negative please try again");
							}
							
							break;
						case "6":
							System.out.println(banker.getUsername() + " Logging out.");
							running3 = false;
							break;
						}
						
						}
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
					User newBanker = new User(newUsername,newPassword,firstDeposit,false, newAccountType);
					
					service.addUser(newBanker);
					
					prettyDisplayOfArray(service.getAllAccounts());
					break;
				case "3":
					System.out.println("Please enter your Username:");
					String usernameEmployee = sc.nextLine();
					System.out.println("Please enter your Password:");
					String passwordEmployee = sc.nextLine();
					User employeeBank = new User(usernameEmployee, passwordEmployee);
//					System.out.println(employeeBank.getUsername());
					if (service.validateUserEmployee(employeeBank)== true) {
						boolean running2 = true;
						
						while(running2) {
						optionsMenuEmployee();
						String result2 = sc.nextLine();
						
						switch (result2) {
							case "1":
							
								List<User> unApprovedUsers =	service.getAllUnapprovedAccounts();
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
								List<User> unApprovedUser =	service.getAllUnapprovedAccounts();
								prettyDisplayOfArray(unApprovedUser);
								System.out.println("Which user do you wish to reject?(use username)");
								String users = sc.nextLine();
								if (service.deleteUser(users)) {
									System.out.println("User has been Rejected!");
								}else {
									System.out.println("User not found!");
								}
								break;
								
							case "3":
								System.out.println("Which user do you wish to view the balance of?(use username)");
								String userBalance = sc.nextLine();
								
								prettyDisplayOfArray(service.getSelectedAccountForEmployee(userBalance));
								break;
								
							case "5":
								System.out.println(employeeBank.getUsername() + " Logging out.");
								running2 = false;
								break;
							}
						}
					}else {
						System.out.println("Log in failed are you sure you are an employee");
					}
					break;
				case "4":
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



