/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/** 
 * @author {Renata Vieira}
 *
 *Feb 19, 2017
 */
public class TestCaseBank {
	Date d1, d2, d3;
	Customer c1;
	Bank b1;
	Account ac1;
	TransactionRecord tr;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d1 = new Date(2,1,2000);
		d2 = new Date(3,10,2016);
		c1 = new Customer("oliver", "smith", "vancouver", d1);
		b1 = new Bank("TrollsBank");
		ac1 = new Account(c1, d2, 1000);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSetBankNamePositive(){
		b1.setBankName("BCIT-BANK");
		assertEquals("BCIT-BANK", b1.getBankName());
	}
	
	@Test
	public void testSetBankNameNegative(){
		b1.setBankName(null);
		assertEquals("unknown", b1.getBankName());
	}
	
	@Test
	public void testAddAccountPositive() {
		b1.addAccount(ac1);
		Account account = b1.getAccount(ac1.getAccountNumber());
		assertEquals(ac1, account);
	}
	
	@Test
	public void testAddAccountNegative() {
		b1.addAccount(ac1);
		Account account = b1.getAccount("0" + ac1.getAccountNumber());
		assertNotEquals(ac1, account);
	}
	
	@Test
	public void testMakeTransactionPositive(){
		b1.addAccount(ac1);
		Account account = b1.getAccount(ac1.getAccountNumber());
		assertNotNull(account);
		double amount = 100; 
		assertTrue(account.withdraw(amount));
		tr = new TransactionRecord(amount, d1, ac1, 2);
		account.addTransaction(tr);
		assertTrue(ac1.getTransactions().contains(tr));
	}

	@Test
	public void testMakeTransactionNegative(){
		b1.addAccount(ac1);
		Account account = b1.getAccount(ac1.getAccountNumber());
		assertNotNull(account);
		double amount = -100; 
		assertFalse(account.withdraw(amount));
	}
}
