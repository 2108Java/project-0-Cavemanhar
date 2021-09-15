package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bank;


public class BankDAOImpl implements BankDAO {
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "p4ssw0rd";
	@Override
	public void createUser(Bank newBanker) {
boolean success = false;
		
		
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql= "Insert INTO Users(username,user_password,isApproved,isEmployee,balance,accountType) Values (?,?,?,?,?,?)";// send sql to the database	
			PreparedStatement ps = connection.prepareStatement(sql);//get ready to send 
			ps.setString(1, newBanker.getUsername());
			ps.setString(2, newBanker.getPassword());
			ps.setBoolean(3, newBanker.isApproved());	
			ps.setBoolean(4, newBanker.isEmployee());
			ps.setDouble(5, newBanker.getBalance());
			ps.setString(6, newBanker.getAccountType());
			ps.execute();// execute the prepared statement from user to add to database
			
			success = true;	
			}		
		catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean logIn(Bank banker) {
		String sql = "SELECT * from Users WHERE username = ? and user_password = ?";
		boolean success = false;
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setString(1, banker.getUsername());
		ps.setString(2, banker.getPassword());
		ps.execute();
		ResultSet rs = ps.executeQuery();
		
		if (rs != null) {
			success = true;
		}else {
			success = false;
		}
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Bank> selectAllAccounts() {
		List<Bank> itemArray = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				Bank	todo = new Bank(rs.getString("username"),
										rs.getString("user_password"),
										rs.getDouble("balance"),
//										rs.getBoolean("isApproved"),
										rs.getBoolean("isEmployee"),
										
										rs.getString("accountType"));
				itemArray.add(i,todo);
												
						i++;				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return itemArray;		
	}

	
	@Override
	public boolean selectEmployee(Bank banker) {
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
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Bank> selectAllUnapprovedAccounts() {
		List<Bank> itemArray = new ArrayList<>();
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users where isApproved = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, false);
			
			
			ResultSet rs = ps.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				Bank	todo = new Bank(rs.getString("username"),
										rs.getString("user_password"),
										rs.getDouble("balance"),
//										rs.getBoolean("isApproved"),
										rs.getBoolean("isEmployee"),
										
										rs.getString("accountType"));
				itemArray.add(i,todo);
												
						i++;				
			}
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
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return success;
	}

}
