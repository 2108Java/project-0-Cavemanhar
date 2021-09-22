package com.revature.repo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.revature.models.User;

public class BankDAOImplTest {
	User u;
	
	BankDAOImpl DAO; 
	@Before
	public void setupUser() {
		u = new User();
	}
	@Before
	public void setupDAO() {
		
		DAO = new BankDAOImpl();
	}
	
	@Test
	public void testLogIn() {
		
		u.setUsername("Kelce");
		u.setPassword("starfish");
		assertTrue(DAO.logIn(u));
		u.setPassword("jargig");
		assertFalse(DAO.logIn(u));
		
		
	}
	
	
	@Test
	public void testSelectEmployee() {
		
		u.setUsername("Kelce");
		u.setPassword("starfish");
		assertFalse(DAO.selectEmployee(u));
		
	}

	
	@Test
	public void testUpdateUserToApproved() {
		
		
		assertTrue(DAO.updateUserToApproved("Kelce"));
		
		
		
	}
	
	@Test
	public void testDeleteUser() {
		
		
		assertTrue(DAO.deleteUser("Ashley"));
	}
	
	@Test
	public void testInsertDeposit() {
		
		u.setUsername("Kelce");
		u.setSavingsDeposit(700);
		
		assertTrue(DAO.insertDeposit(u));
	}
	
	@Test
	public void testInsertWithdraw() {
		u.setUsername("Kelce");
		u.setSavingsWithdraw(700);
		
		assertTrue(DAO.insertWithdraw(u));
		
	}
	@Test
	public void testInsertCheckingDeposit() {
		
		u.setUsername("Kelce");
		u.setCheckingDeposit(700);
		
		assertTrue(DAO.insertCheckingDeposit(u));
	}
	
	@Test
	public void testInsertCheckingWithdraw() {
		u.setUsername("Kelce");
		u.setCheckingWithdraw(700);
		
		assertTrue(DAO.insertCheckingWithdraw(u));
		
	}
	
	@Test
	public void testSelectAccountType() {
		
		u.setUsername("Kelce");
		
		assertTrue(DAO.selectAccountType(u).equals("Both"));
	}
	
	
	@Test
	public void testSelectMoneyTransfer() {
		u.setUsername("Ashley");
		assertFalse(DAO.selectMoneyTransfer(u));
	}
	
}
