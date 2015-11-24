package test.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.Account;

public class TestAccount {

	private Account account;
	
	@Before
	public void init() {
		this.account = new Account(5000);
	}
	
	@Test
	public void testWhenAccountCreated() {
		assertEquals(5000.0, this.account.getBalance(), 0);
	}
	
	@Test
	public void testWithDraw() {
		this.account.withdraw(100);
		assertEquals(4900.0, this.account.getBalance(), 0);
		this.account.withdraw(5000);
		assertEquals(-100.0, this.account.getBalance(), 0);
	}
	
	@Test
	public void testCredit() {
		this.account.credit(100);
		assertEquals(5100.0, this.account.getBalance(), 0);
		this.account.credit(200);
		assertEquals(5300.0, this.account.getBalance(), 0);
	}

}
