package com.revature.presentation;

import java.util.Scanner;

import com.revature.service.BankService;



public class MainMenuImpl implements MainMenu{

	BankService service;
	
	public MainMenuImpl(BankService service) {
		this.service = service;
	}
	
	private void optionsMenu() {
		System.out.println("1) Log in to Account");
		System.out.println("2) Apply for Bank Account");
		System.out.println("3) Complete a todo");
		System.out.println("4) Delete a todo");
		System.out.println("5) View all incomplete todos");
		System.out.println("6) View all complete todos");
		System.out.println("7) View a single todo");
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
					break;
				
				}
				
			
				
				
				
			}
			
			
		}
	}


