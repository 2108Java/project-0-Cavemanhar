package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;



public class BankDAOImpl implements BankDAO {
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "p4ssw0rd";
	@Override
	public void createUser(User newBanker) {

		if(newBanker.getAccountType().equals("Savings")) {
			try (Connection connection = DriverManager.getConnection(url,username,password))
			{
				String sql= "Insert INTO Users(username,user_password,isApproved,isEmployee,savings_balance,accountType) Values (?,?,?,?,?,?)";// send sql to the database	
				PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
				ps.setString(1, newBanker.getUsername());
				ps.setString(2, newBanker.getPassword());
				ps.setBoolean(3, newBanker.isApproved());	
				ps.setBoolean(4, newBanker.isEmployee());
				ps.setDouble(5, newBanker.getSavingsBalance());
				ps.setString(6, "Savings");
				ps.execute();// execute the prepared statement from user to add to database
				
					connection.close();
				}		
			catch(SQLException e) {
				
				e.printStackTrace();
			}
			try (Connection connection = DriverManager.getConnection(url,username,password))
			{
				String sql= "Insert INTO transactions(username_foreign_id ,savings_deposit ,savings_withdrawl ,savings_balance) Values (?,?,?,?)";// send sql to the database	
				PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
				ps.setString(1, newBanker.getUsername());
				ps.setDouble(2, newBanker.getSavingsDeposit());
				ps.setDouble(3, newBanker.getSavingsWithdraw());	
				ps.setDouble(4, newBanker.getSavingsBalance());
				ps.execute();// execute the prepared statement from user to add to database
				
				connection.close();
				}		
			catch(SQLException e) {
				
				e.printStackTrace();
			}
			
		}else if(newBanker.getAccountType().equals("Checking")) {
			
			try (Connection connection = DriverManager.getConnection(url,username,password))
			{
				String sql= "Insert INTO Users(username,user_password,isApproved,isEmployee,checking_balance,accountType) Values (?,?,?,?,?,?)";// send sql to the database	
				PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
				ps.setString(1, newBanker.getUsername());
				ps.setString(2, newBanker.getPassword());
				ps.setBoolean(3, newBanker.isApproved());	
				ps.setBoolean(4, newBanker.isEmployee());
				ps.setDouble(5, newBanker.getCheckingBalance());
				ps.setString(6, "Checking");
				ps.execute();// execute the prepared statement from user to add to database
				
					connection.close();
				}		
			catch(SQLException e) {
				
				e.printStackTrace();
			}
			try (Connection connection = DriverManager.getConnection(url,username,password))
			{
				String sql= "Insert INTO transactions(username_foreign_id ,checking_deposit ,checking_withdrawl ,checking_balance) Values (?,?,?,?)";// send sql to the database	
				PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
				ps.setString(1, newBanker.getUsername());
				ps.setDouble(2, newBanker.getCheckingDeposit());
				ps.setDouble(3, newBanker.getCheckingWithdraw());	
				ps.setDouble(4, newBanker.getCheckingBalance());
				ps.execute();// execute the prepared statement from user to add to database
				
				connection.close();
				}		
			catch(SQLException e) {
				
				e.printStackTrace();
			}
		}else {
			
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO Users(username, user_password, isApproved, isEmployee, savings_balance, checking_balance, accountType) Values (?,?,?,?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, newBanker.getUsername());
			ps.setString(2, newBanker.getPassword());
			ps.setBoolean(3, newBanker.isApproved());	
			ps.setBoolean(4, newBanker.isEmployee());
			ps.setDouble(5, newBanker.getSavingsBalance());
			ps.setDouble(6, newBanker.getCheckingBalance());
			ps.setString(7, "Both");
			ps.execute();// execute the prepared statement from user to add to database
			
	
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO transactions(username_foreign_id ,savings_deposit ,savings_withdrawl ,savings_balance, checking_deposit ,checking_withdrawl ,checking_balance) Values (?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, newBanker.getUsername());
			ps.setDouble(2, newBanker.getSavingsDeposit());
			ps.setDouble(3, newBanker.getSavingsWithdraw());	
			ps.setDouble(4, newBanker.getSavingsBalance());
			ps.setDouble(2, newBanker.getCheckingDeposit());
			ps.setDouble(3, newBanker.getCheckingWithdraw());	
			ps.setDouble(4, newBanker.getCheckingBalance());
			ps.execute();// execute the prepared statement from user to add to database
			
	
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		}
	}

	@Override
	public boolean logIn(User banker) {
		String sql = "SELECT * from Users WHERE username = ? and user_password = ? and isapproved = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setString(2, banker.getPassword());
		ps.setBoolean(3, true);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getBoolean("isApproved") == true) {
				success = true;
			}else {
				success = false;
			}
			}connection.close();
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<User> selectAllAccounts() {
		List<User> itemArray = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				User	todo = new User(rs.getString("username"),
										rs.getString("user_password"),
										rs.getDouble("savings_balance"),
										rs.getDouble("checking_balance"),
										rs.getString("accountType"));
				itemArray.add(i,todo);
												
						i++;				
			}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return itemArray;		
	}

	
	@Override
	public boolean selectEmployee(User banker) {
		String sql = "SELECT * from Users WHERE username = ? and user_password = ? and isemployee = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setString(2, banker.getPassword());
		ps.setBoolean(3, true);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
		if (rs.getBoolean("isEmployee") == true) {
			success = true;
		}else {
			success = false;
		}
		}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<User> selectAllUnapprovedAccounts() {
		List<User> itemArray = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users where isApproved = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, false);
			
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				User	todo = new User(rs.getString("username"),
										rs.getString("user_password"),
										rs.getDouble("savings_balance"),
										rs.getDouble("checking_balance"),
										rs.getString("accountType"));
				itemArray.add(i,todo);
												
						i++;				
			}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return itemArray;		
	}

	@Override
	public boolean updateUserToApproved(String user) {
		String sql = "UPDATE Users SET isApproved = ? WHERE username = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setBoolean(1, true);
		ps.setString(2, user);
		ps.execute();
		success = true;
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteUser(String users) {
	
		String sql = "DELETE from Users WHERE username = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, users);
		ps.execute();
		success = true;
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public User SelectAccount(User banker) {
		User todo = new User();
		String sql = "SELECT * from Users WHERE username = ?";
	
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		
	
		while(rs.next()) {
				todo = new User(rs.getString("username"),
									rs.getString("user_password"),
									rs.getDouble("savings_balance"),
									rs.getDouble("checking_balance"),
									rs.getString("accountType"),
									rs.getBoolean("money_transfer"));
			
											
									
		}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return todo;
	}

	@Override
	public List<User> SelectAccountEmployee(String userBalance) {
		List<User> itemArray = new ArrayList<>();
		String sql = "SELECT * from Users WHERE username = ?";
	
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, userBalance);
		ps.execute();
		
		ResultSet rs = ps.executeQuery();
		
		int i = 0;
		while(rs.next()) {
			User	todo = new User(rs.getString("username"),
									rs.getString("user_password"));
//									rs.getDouble("balance"),
//									rs.getBoolean("isApproved"),
//									rs.getBoolean("isEmployee"),
									
//									rs.getString("accountType"));
			itemArray.add(i,todo);
											
					i++;				
		}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return itemArray;
	}

	@Override
	public boolean insertDeposit(User banker) {
		
		BankDAOImplDW Deposit = new BankDAOImplDW();
	
		Boolean success = false;
		User currentCustomer = Deposit.selectCustomer(banker);
		System.out.println(banker.getSavingsDeposit());
		currentCustomer.setSavingsBalance( banker.getSavingsDeposit() + currentCustomer.getSavingsBalance()); 
		
		System.out.println(currentCustomer.getSavingsBalance());
		
		Deposit.updateUser(currentCustomer);
		
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO transactions(username_foreign_id, savings_deposit, savings_withdrawl, savings_balance) Values (?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, banker.getUsername());
			ps.setDouble(2, banker.getSavingsDeposit());
			ps.setDouble(3, banker.getSavingsWithdraw());	
			ps.setDouble(4, currentCustomer.getSavingsBalance());
			ps.execute();// execute the prepared statement from user to add to database
			success = true;
			connection.close();
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean insertWithdraw(User banker) {
		BankDAOImplDW withdraw = new BankDAOImplDW();
		Boolean success = false;
		
		User currentCustomer = withdraw.selectCustomer(banker);
		System.out.println(banker.getSavingsDeposit());
		if (currentCustomer.getSavingsBalance() > banker.getSavingsWithdraw()) {
		currentCustomer.setSavingsBalance(  currentCustomer.getSavingsBalance() - banker.getSavingsWithdraw()); 
		
		System.out.println(currentCustomer.getSavingsBalance());
		
		withdraw.updateUser(currentCustomer);
		success = true;
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO transactions(username_foreign_id,savings_deposit, savings_withdrawl, savings_balance) Values (?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, banker.getUsername());
			ps.setDouble(2, banker.getSavingsDeposit());
			ps.setDouble(3, banker.getSavingsWithdraw());	
			ps.setDouble(4, currentCustomer.getSavingsBalance());
			ps.execute();// execute the prepared statement from user to add to database
			
			connection.close();
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		}else {
			
		}
		return success;
	}

	@Override
	public List<User> selectAllTransactions() {
		List<User> itemArray = new ArrayList<>();
		String sql = "SELECT * from Transactions";
	
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		
		
		ResultSet rs = ps.executeQuery();
		
		int i = 0;
		while(rs.next()) {
			User	todo = new User(rs.getString("username_foreign_id"),
									rs.getDouble("savings_balance"),
									rs.getDouble("savings_withdrawl"),
									rs.getDouble("savings_deposit"),
									rs.getDouble("checking_balance"),
									rs.getDouble("checking_withdrawl"),
									rs.getDouble("checking_deposit"),
									rs.getDouble("checking_transfer"),
									rs.getDouble("savings_transfer")
			);
									
									
			itemArray.add(i,todo);
											
					i++;				
		}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return itemArray;
	}

	@Override
	public boolean insertCheckingWithdraw(User banker) {
		BankDAOImplDW withdraw = new BankDAOImplDW();
		Boolean success = false;
		
		User currentCustomer = withdraw.selectCustomer(banker);
		System.out.println(banker.getSavingsDeposit());
		if (currentCustomer.getSavingsBalance() > banker.getSavingsWithdraw()) {
		currentCustomer.setSavingsBalance(  currentCustomer.getSavingsBalance() - banker.getSavingsWithdraw()); 
		
		System.out.println(currentCustomer.getSavingsBalance());
		
		withdraw.updateUser(currentCustomer);
		success = true;
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO transactions(username_foreign_id, checking_deposit, checking_withdrawl, checking_balance) Values (?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, banker.getUsername());
			ps.setDouble(2, banker.getSavingsDeposit());
			ps.setDouble(3, banker.getSavingsWithdraw());	
			ps.setDouble(4, currentCustomer.getSavingsBalance());
			ps.execute();// execute the prepared statement from user to add to database
			connection.close();
	
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		}else {
			
		}
		return success;
	}

	@Override
	public boolean insertCheckingDeposit(User banker) {
		BankDAOImplDW Deposit = new BankDAOImplDW();
		
		Boolean success = false;
		User currentCustomer = Deposit.selectCustomer(banker);
		System.out.println(banker.getCheckingDeposit());
		currentCustomer.setCheckingBalance( banker.getCheckingDeposit() + currentCustomer.getCheckingBalance()); 
		
		System.out.println(currentCustomer.getCheckingBalance());
		
		Deposit.updateUser(currentCustomer);
		
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO transactions(username_foreign_id , checking_deposit, checking_withdrawl , checking_balance) Values (?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, banker.getUsername());
			ps.setDouble(2, banker.getCheckingDeposit());
			ps.setDouble(3, banker.getCheckingWithdraw());	
			ps.setDouble(4, currentCustomer.getCheckingBalance());
			ps.execute();// execute the prepared statement from user to add to database
			success = true;
			connection.close();
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public String selectAccountType(User banker) {
		
		String account = "";
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users where username = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, banker.getUsername());
			ResultSet rs = ps.executeQuery();
			connection.close();
			
			while(rs.next()) {
				
										
										
				 account = rs.getString("accountType");
				
												
										
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return account;
	}

	@Override
	public void updateUserAccount(User banker, int value) {
		
		if (value == 1) {
			

			String sql = "UPDATE Users SET accounttype = ?, savings_balance = ? WHERE username = ?";
			
			try (Connection connection = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = connection.prepareStatement(sql);		
			ps.setString(1, "Both");
			ps.setDouble(2, banker.getSavingsBalance());
			ps.setString(3, banker.getUsername());
			ps.execute();
			connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}else {

			String sql = "UPDATE Users SET accounttype = ?, checking_balance = ? WHERE username = ?";
			
			try (Connection connection = DriverManager.getConnection(url,username,password)){
			PreparedStatement ps = connection.prepareStatement(sql);		
			ps.setString(1, "Both");
			ps.setDouble(2, banker.getCheckingBalance());
			ps.setString(3, banker.getUsername());
			ps.execute();
			connection.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public boolean insertMoneyTransfer( User banker) {
		
		boolean success = false;
	
		
		
		
		String sql1 = "UPDATE Users SET money_transfer = ? WHERE username = ?";
		
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql1);		
		ps.setBoolean(1, true);
		ps.setString(2, banker.getUsername());
		ps.execute();
		success = true;
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "Insert INTO transactions(username_foreign_id , checking_transfer, savings_transfer, money_transfer_approval) Values (?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql2);		
		
		ps.setString(1, banker.getUsername());
		ps.setDouble(2, banker.getCheckingMoneyTransfer());
		ps.setDouble(3, banker.getSavingsMoneyTransfer());
		ps.setBoolean(4, false);
		ps.execute();
		success = true;
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return success;
	}

	@Override
	public void updateTransfer(User banker) {
		
		String sql = "SELECT * FROM transactions WHERE username_foreign_id = ? AND money_transfer_approval = ?";
		
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setBoolean(2, false);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			banker.setCheckingMoneyTransfer(rs.getDouble("checking_transfer"));
			banker.setSavingsMoneyTransfer(rs.getDouble("savings_transfer"));
			
			
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		banker.setSavingsBalance(banker.getSavingsBalance() - banker.getSavingsMoneyTransfer() + banker.getCheckingMoneyTransfer());
		banker.setCheckingBalance(banker.getCheckingBalance() - banker.getCheckingMoneyTransfer() + banker.getSavingsMoneyTransfer());

		String sql1 = "UPDATE Users SET money_transfer = ?, checking_balance = ?, savings_balance = ?  WHERE username = ?";
		
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql1);		
		ps.setBoolean(1, false);
		ps.setDouble(2, banker.getCheckingBalance());
		ps.setDouble(3, banker.getSavingsBalance());
		ps.setString(4, banker.getUsername());
		ps.execute();
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		String sql2 = "insert into transactions (username_foreign_id , savings_balance, checking_balance, savings_transfer, checking_transfer,  money_transfer_approval) values (?,?,?,?,?,?)";

		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql2);		
		
		ps.setString(1, banker.getUsername());
		ps.setDouble(2, banker.getSavingsBalance());
		ps.setDouble(3, banker.getCheckingBalance());
		ps.setDouble(4, banker.getSavingsMoneyTransfer());
			
		ps.setDouble(5, banker.getCheckingMoneyTransfer());
			
		ps.setBoolean(6, true);
		ps.execute();
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean selectMoneyTransfer(User banker) {
		String sql = "SELECT * FROM Users WHERE username = ? AND money_transfer = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setBoolean(2, true);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			if (rs.getBoolean("money_transfer") == true) {
				success = true;
			}else {
				success = false;
			}
			}connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteTransfer(User banker) {
		String sql = "DELETE from transactions WHERE username_foreign_id = ? and money_transfer_approval = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setBoolean(2, false);
		ps.execute();
		success = true;
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		String sql1 = "UPDATE Users SET money_transfer = ? WHERE username = ?";
		
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql1);		
		ps.setBoolean(1, false);
		ps.setString(2, banker.getUsername());
		ps.execute();
		connection.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return success;
	}



}
