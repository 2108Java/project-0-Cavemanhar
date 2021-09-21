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
				System.out.println("Username: " + array.get(i).getUsername());
				System.out.println("Savings Balance: $" +array.get(i).getSavingsBalance());
				System.out.println("Checking Balance: $" +array.get(i).getCheckingBalance());
				System.out.println("AccountType: " +array.get(i).getAccountType());
				System.out.println("");
				
			}
			
		}
	}

	private void prettyDisplayOfTransactions(List<User> array) {
		for(int i = 0; i< array.size(); i++) {
			
			if(array.get(i) != null) {
				System.out.println("Username: " +array.get(i).getUsername());
				System.out.println("Balance: $" +array.get(i).getSavingsBalance());
				System.out.println("Deposit: $" +array.get(i).getSavingsDeposit());
				System.out.println("Withdrawl: $" +array.get(i).getSavingsWithdraw());
				System.out.println("Balance: $" +array.get(i).getCheckingBalance());
				System.out.println("Deposit: $" +array.get(i).getCheckingDeposit());
				System.out.println("Withdrawl: $" +array.get(i).getCheckingWithdraw());
				System.out.println("");
				
			}
			
		}
	}
	
	private void optionsMenu() {
		System.out.println("1) Log in to Bank Account");
		System.out.println("2) Apply for Bank Account");
		System.out.println("3) Log in to Employee Account");
		System.out.println("0) Exit");
	}
	private void optionsMenuEmployee() {
		System.out.println("1) Approve new User");
		System.out.println("2) Reject a new User");
		System.out.println("3) View a Users Balance");
		System.out.println("4) View all Transactions");
		System.out.println("0) Log Out");
	}
	private void optionsMenuCustomer() {
		System.out.println("1) Current Balance");
		System.out.println("2) Make Savings Deposit");
		System.out.println("3) Make Savings Withdraw");
		System.out.println("4) Make Checking Deposit");
		System.out.println("5) Make Checking Withdraw");
		System.out.println("6) Make A new Account");
//		System.out.println("5) Make A Money Transfer");
//		System.out.println("6) Approve Money Transfer");

		System.out.println("0) Log Out");
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
					
						banker.setAccountType(service.selectAccountType(banker));
//						System.out.println("Sorry not yet implemented");
						boolean userLoggedIn = true;
						
						while(userLoggedIn) {
							optionsMenuCustomer();
						String result3 = sc.nextLine();
						
						switch (result3) {
						case "1":
							
							prettyDisplayOfArray(service.getSelectedAccount(banker));
							break;
						case "2":
							if(banker.getAccountType().equals("Both")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double deposit = Double.parseDouble(sc.nextLine());
								if (deposit > 0) {
									banker.setSavingsDeposit(deposit);
									service.addDeposit(banker);
								}else{
									System.out.println("Sorry that value is negative please try again");
								}
							}else if (banker.getAccountType().equals("Savings")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double deposit = Double.parseDouble(sc.nextLine());
								if (deposit > 0) {
									banker.setSavingsDeposit(deposit);
									service.addDeposit(banker);
								
							}else {
								System.out.println("Your account only has a Checking Account.");
								}
							}
							break;
						case "3":
							if(banker.getAccountType().equals("Both")) {
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double withdraw = Double.parseDouble(sc.nextLine());
								if (withdraw > 0) {
								banker.setSavingsWithdraw(withdraw);
								service.addWithdraw(banker);
								}else {
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else if (banker.getAccountType().equals("Savings")) {
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double withdraw = Double.parseDouble(sc.nextLine());
								if (withdraw > 0) {
								banker.setSavingsWithdraw(withdraw);
								service.addWithdraw(banker);
								}else {
									System.out.println("Sorry that value is negative please try again");
								}
							}else {
								System.out.println("Your account only has a Checking Account.");
							}
							
							break;
						case "4":
							if(banker.getAccountType().equals("Both")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double checkingDeposit = Double.parseDouble(sc.nextLine());
								if (checkingDeposit > 0) {
								banker.setCheckingDeposit(checkingDeposit);
								service.addCheckingDeposit(banker);
								}else{
									System.out.println("Sorry that value is negative please try again");
								}
							}else if (banker.getAccountType().equals("Checking")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double checkingDeposit = Double.parseDouble(sc.nextLine());
								if (checkingDeposit > 0) {
								banker.setCheckingDeposit(checkingDeposit);
								service.addCheckingDeposit(banker);
								}
								
							}else {
								System.out.println("Sorry that value is negative please try again");
							}
							
							break;
						case "5":
							if(banker.getAccountType().equals("Both")) {
								
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double checkingWithdraw = Double.parseDouble(sc.nextLine());
								if (checkingWithdraw > 0) {
								banker.setCheckingWithdraw(checkingWithdraw);
								service.addCheckingWithdraw(banker);
								}else {
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else if (banker.getAccountType().equals("Checking")) {
								
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double checkingWithdraw = Double.parseDouble(sc.nextLine());
								if (checkingWithdraw > 0) {
								banker.setCheckingWithdraw(checkingWithdraw);
								service.addCheckingWithdraw(banker);
								}else {
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else {
								System.out.println("Sorry that value is negative please try again");
							}
							
							
							break;
						case "6":
							if(banker.getAccountType().equals("Savings")){
								int value = 2;
								System.out.println("Please enter your a value you wish to initially deposit:");
								Double firstDeposit = Double.parseDouble(sc.nextLine());

								
								banker.setAccountType("Both");
								banker.setCheckingBalance(firstDeposit);
									service.addUserAccount(banker, value);
								
							}else if(banker.getAccountType().equals("Checking")) {
								
								int value = 1;
								System.out.println("Please enter your a value you wish to initially deposit:");
								Double firstDeposit = Double.parseDouble(sc.nextLine());

								
								banker.setAccountType("Both");
								banker.setSavingsBalance(firstDeposit);
									service.addUserAccount(banker, value);
								
							}else {
								System.out.println("You already have both a savings and a checking account");
							}
							break;
						case "0":
							System.out.println(banker.getUsername() + " Logging out.");
							userLoggedIn = false;
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
//					System.out.println("Please enter your Name for your new account:");
//					String newName = sc.nextLine();
					System.out.println("Please enter your Username for your new account:");
					String newUsername = sc.nextLine();
					System.out.println("Please enter your Password for your new account:");
					String newPassword = sc.nextLine();
					System.out.println("Please enter your account type for your new account as either Savings, Checking, or Both:");
					String newAccountType = sc.nextLine();
					User newBanker = new User();
					
					
					if(newAccountType.equals("Both")) {
						System.out.println("Please enter your a value you wish to initially in Savings Deposit:");
						Double firstSavingsDeposit = Double.parseDouble(sc.nextLine());
						System.out.println("Please enter your a value you wish to initially in Checking Deposit:");
						Double firstCheckingDeposit = Double.parseDouble(sc.nextLine());

						newBanker.setUsername(newUsername);
						newBanker.setPassword(newPassword);
						newBanker.setAccountType(newAccountType);
						newBanker.setSavingsBalance(firstSavingsDeposit);
						newBanker.setCheckingBalance(firstCheckingDeposit);
							service.addUser(newBanker);
						
						
						
					}else if(newAccountType.equals("Savings")){
						
						System.out.println("Please enter your a value you wish to initially deposit:");
						Double firstDeposit = Double.parseDouble(sc.nextLine());

						newBanker.setUsername(newUsername);
						newBanker.setPassword(newPassword);
						newBanker.setAccountType(newAccountType);
						newBanker.setSavingsBalance(firstDeposit);
							service.addUser(newBanker);
						
					}else if(newAccountType.equals("Checking")) {
						
						System.out.println("Please enter your a value you wish to initially deposit:");
						Double firstDeposit = Double.parseDouble(sc.nextLine());

						newBanker.setUsername(newUsername);
						newBanker.setPassword(newPassword);
						newBanker.setAccountType(newAccountType);
						newBanker.setCheckingBalance(firstDeposit);
							service.addUser(newBanker);
						
					}else {
						System.out.println("you entered an invalid Account Type");
					}
					
					System.out.println("Please enter your a value you wish to initially deposit:");
					Double firstDeposit = Double.parseDouble(sc.nextLine());
//					System.out.println("Please enter if you are a employee:");
//					Boolean employee = Boolean.parseBoolean(sc.nextLine());
					newBanker.setUsername(newUsername);
					newBanker.setPassword(newPassword);
					newBanker.setAccountType(newAccountType);
					newBanker.setSavingsBalance(firstDeposit);
//						newBanker =new User(newName, newUsername, newPassword, firstDeposit, newAccountType);
						service.addUser(newBanker);
					
//					prettyDisplayOfArray(service.getAllAccounts());
					break;
				case "3":
					System.out.println("Please enter your Username:");
					String usernameEmployee = sc.nextLine();
					System.out.println("Please enter your Password:");
					String passwordEmployee = sc.nextLine();
					User employeeBank = new User(usernameEmployee, passwordEmployee);
//					System.out.println(employeeBank.getUsername());
					if (service.validateUserEmployee(employeeBank)== true) {
						boolean employeeLoggedIn = true;
						
						while(employeeLoggedIn) {
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
							case "4":
								prettyDisplayOfTransactions(service.getAllTransactions());
								break;
							case "0":
								System.out.println(employeeBank.getUsername() + " Logging out.");
								employeeLoggedIn = false;
								break;
							}
						}
					}else {
						System.out.println("Log in failed are you sure you are an employee");
					}
					break;
				case "0":
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



