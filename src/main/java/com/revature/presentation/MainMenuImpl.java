package com.revature.presentation;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.models.User;

import com.revature.service.BankService;



public class MainMenuImpl implements MainMenu{
	public final static Logger loggy=Logger.getLogger(MainMenuImpl.class);
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
	
	private void prettyDisplayOfArray(User selectedAccount) {

			
			if(selectedAccount != null) {
				System.out.println("Username: " + selectedAccount.getUsername());
				System.out.println("Savings Balance: $" + selectedAccount.getSavingsBalance());
				System.out.println("Checking Balance: $" + selectedAccount.getCheckingBalance());
				System.out.println("AccountType: " + selectedAccount.getAccountType());
				System.out.println("");
				
			}
			
		
		
	}

	private void prettyDisplayOfTransactions(List<User> array) {
		for(int i = 0; i< array.size(); i++) {
			
			if(array.get(i) != null) {
				System.out.println("Username: " +array.get(i).getUsername());
				System.out.println("Savings Balance: $" +array.get(i).getSavingsBalance());
				System.out.println("Savings Deposit: $" +array.get(i).getSavingsDeposit());
				System.out.println("SavingsWithdrawl: $" +array.get(i).getSavingsWithdraw());
				System.out.println("Checking Balance: $" +array.get(i).getCheckingBalance());
				System.out.println("Checking Deposit: $" +array.get(i).getCheckingDeposit());
				System.out.println("Checking Withdrawl: $" +array.get(i).getCheckingWithdraw());
				System.out.println("Savings Transfer: $" +array.get(i).getSavingsMoneyTransfer());
				System.out.println("Checking Transfer: $" +array.get(i).getCheckingMoneyTransfer());
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
		System.out.println("7) Make A Money Transfer");
		System.out.println("8) Approve Money Transfer");

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
					loggy.info("Logging in user");
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
						loggy.info("User logged in ");
						while(userLoggedIn) {
							
							banker = service.getSelectedAccount(banker);
							optionsMenuCustomer();
						String result3 = sc.nextLine();
						
						switch (result3) {
						case "1":
							loggy.info("Displaying user data");
							prettyDisplayOfArray(service.getSelectedAccount(banker));
							break;
						case "2":
							if(banker.getAccountType().equals("Both")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double deposit = Double.parseDouble(sc.nextLine());
								if (deposit > 0) {
									loggy.info("Depositing money");
									banker.setSavingsDeposit(deposit);
									service.addDeposit(banker);
								}else{
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
							}else if (banker.getAccountType().equals("Savings")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double deposit = Double.parseDouble(sc.nextLine());
								if (deposit > 0) {
									banker.setSavingsDeposit(deposit);
									service.addDeposit(banker);
								
								}else{
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
							} 
							}else{
								loggy.warn("Incorrect account checked");
								System.out.println("Your account only has a Checking Account.");
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
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else if (banker.getAccountType().equals("Savings")) {
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double withdraw = Double.parseDouble(sc.nextLine());
								if (withdraw > 0) {
								banker.setSavingsWithdraw(withdraw);
								service.addWithdraw(banker);
								}else {
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
							}else {
								loggy.warn("Incorrect account checked");
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
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
							}else if (banker.getAccountType().equals("Checking")) {
								System.out.println("Please enter your a value you wish to Deposit:");
								Double checkingDeposit = Double.parseDouble(sc.nextLine());
								if (checkingDeposit > 0) {
								banker.setCheckingDeposit(checkingDeposit);
								service.addCheckingDeposit(banker);
								}else{
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else {
								loggy.warn("Incorrect account checked");
								System.out.println("Your account only has a Savings Account");
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
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else if (banker.getAccountType().equals("Checking")) {
								
								System.out.println("Please enter your a value you wish to Withdraw:");
								Double checkingWithdraw = Double.parseDouble(sc.nextLine());
								if (checkingWithdraw > 0) {
								banker.setCheckingWithdraw(checkingWithdraw);
								service.addCheckingWithdraw(banker);
								}else {
									loggy.warn("Incorrect value insereted");
									System.out.println("Sorry that value is negative please try again");
								}
								
							}else {
								loggy.warn("Incorrect account checked");
								System.out.println("Your account only has a Savings Account");
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
								loggy.warn("User already has both a checking and a savings account");
								System.out.println("You already have both a Savings and a Checking account");
							}
							break;
						case "7":
							
							System.out.println("Which account do you wish to transfer money from:");
							String account = sc.nextLine();
							
							
							if(account.equals("Savings") && (banker.getAccountType().equals("Savings")|| (banker.getAccountType().equals("Both")))) {
								
								System.out.println("How much do you wish to transfer");
								Double savingsTransfer = Double.parseDouble(sc.nextLine());
							
								if (savingsTransfer > 0) {
									banker.setSavingsMoneyTransfer(savingsTransfer);
								
								service.addMoneyTransfer( banker);
								}else {
									loggy.warn("Incorrect value entered");
									System.out.println("Amount entered is not valid");
								}
								
								
								
							}else if (account.equals("Checking") &&( (banker.getAccountType().equals("Checking")) || (banker.getAccountType().equals("Both")))) {
								System.out.println("How much do you wish to transfer");
								Double checkingTransfer = Double.parseDouble(sc.nextLine());
								if (checkingTransfer > 0) {
								banker.setCheckingMoneyTransfer(checkingTransfer);
								service.addMoneyTransfer( banker);
								}else {
									loggy.warn("Incorrect value entered");
									System.out.println("Amount entered is not valid");
								}
								
							}else {
								loggy.warn("Incorrect value entered");
								System.out.println("You entered neither Savings nor Checking or do not have such an account");
							}
							
							break;
							
						case "8":
//							service.validateUser(banker);
							
							
							if(service.moneyTransferApprove(banker)) {
								System.out.println("do you wish to appove of the transfer Y/N");
								String approve = sc.nextLine();
								if(approve.equals("Y")) {
										service.transferMoney(banker);
//									System.out.println(banker.getCheckingBalance());
								}else {
									loggy.info("Transfer denied by user");
									service.removeTransfer(banker);
									System.out.println("Transfer removed");
								}
							}
								else {
									loggy.info("Transfer approve selected without a transfer to approve");
								System.out.println("No money transfers to approve currently");
							}
							
							break;
						case "0":
							loggy.info("User logged logged out");
							System.out.println(banker.getUsername() + " Logging out.");
							userLoggedIn = false;
							break;
						}
						
						}
						break;
										
					}
				else {
					loggy.warn("User failed to logged in ");
					System.out.println("Log in failed may not yet be approved");
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
						loggy.info("User created with both account types ");
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
						loggy.info("User created with savings account");
						System.out.println("Please enter your a value you wish to initially deposit:");
						Double firstDeposit = Double.parseDouble(sc.nextLine());

						newBanker.setUsername(newUsername);
						newBanker.setPassword(newPassword);
						newBanker.setAccountType(newAccountType);
						newBanker.setSavingsBalance(firstDeposit);
							service.addUser(newBanker);
						
					}else if(newAccountType.equals("Checking")) {
						loggy.info("User created with checking account ");
						System.out.println("Please enter your a value you wish to initially deposit:");
						Double firstDeposit = Double.parseDouble(sc.nextLine());

						newBanker.setUsername(newUsername);
						newBanker.setPassword(newPassword);
						newBanker.setAccountType(newAccountType);
						newBanker.setCheckingBalance(firstDeposit);
							service.addUser(newBanker);
						
					}else {
						loggy.warn("user entered an incorrect account type");
						System.out.println("you entered an invalid Account Type");
					}
					
					
					
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
						loggy.info("employee login ");
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
									loggy.info("Customer approved ");
									System.out.println("User has been approved!");
								}else {
									loggy.warn("Customer account not found");
									System.out.println("User not found!");
								}
								break;
							case "2":
								List<User> unApprovedUser =	service.getAllUnapprovedAccounts();
								prettyDisplayOfArray(unApprovedUser);
								System.out.println("Which user do you wish to reject?(use username)");
								String users = sc.nextLine();
								if (service.deleteUser(users)) {
									loggy.info("Customer rejected");
									System.out.println("User has been Rejected!");
								}else {
									loggy.warn("Customer account not found");
									System.out.println("User not found!");
								}
								break;
								
							case "3":
								loggy.info("view the balance of a user");
								System.out.println("Which user do you wish to view the balance of?(use username)");
								String userBalance = sc.nextLine();
								
								prettyDisplayOfArray(service.getSelectedAccountForEmployee(userBalance));
								break;
							case "4":
								loggy.info("View all transactions");
								prettyDisplayOfTransactions(service.getAllTransactions());
								break;
							case "0":
								loggy.info("Employee logging out");
								System.out.println(employeeBank.getUsername() + " Logging out.");
								employeeLoggedIn = false;
								break;
							}
						}
					}else {
						loggy.warn("Employee log in failed");
						System.out.println("Log in failed are you sure you are an employee");
					}
					break;
				case "0":
					loggy.info("Closing App");
					System.out.println("Thank you for banking with us.");
					running = false;
					break;
				default:
					loggy.warn("Invalid app input");
					System.out.println("That's not a valid input!");
					System.out.println("Please Try again!");
					
				
				}
				
			
				
				
				
			}
			
			
	}




}



