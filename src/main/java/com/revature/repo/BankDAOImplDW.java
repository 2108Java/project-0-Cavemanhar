package com.revature.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.User;

public class BankDAOImplDW {
	String server = "localhost";
	String url = "jdbc:postgresql://" + server + "/postgres";
	String username = "postgres";
	String password = "p4ssw0rd";
	
	public  User selectCustomer(User banker) {
		
		User customer = new User();
		try (Connection connection = DriverManager.getConnection(url,username,password))
		{
			String sql = "SELECT * FROM Users where username = ?";
			
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, banker.getUsername());
			
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				User	todo = new User(rs.getString("username"),
										rs.getString("user_password"),
										rs.getDouble("balance"),
//										rs.getBoolean("isApproved"),
										rs.getBoolean("isEmployee"),
										
										rs.getString("accountType"));
					
					customer = todo;
			}
		
	}	catch(SQLException e) {
		
		e.printStackTrace();
	}
		return customer;	
	}
	
	public void updateUser(User banker) {
		String sql = "UPDATE Users SET balance = ? WHERE username = ?";
		
		try (Connection connection = DriverManager.getConnection(url,username,password)){
		PreparedStatement ps = connection.prepareStatement(sql);		
		ps.setDouble(1, banker.getBalance());
		ps.setString(2, banker.getUsername());
		ps.execute();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
