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
public class TestCaseTransactionRecord {

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
		d1 = null;
		d2 = null;
		c1 = null;
		ac1 = null;
	}
	
	@Test
	public void testSetAmountPositive(){
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertEquals(100, tr.getAmount(), .01);
	}
	
	@Test
	public void testSetAmountNegative(){
		tr = new TransactionRecord(-100, d1, ac1, 1);
		assertEquals("Enter a positive value!", 0.0, tr.getAmount(),.01);
	}
	
	@Test
	public void testSetDatePositive(){
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertEquals(tr.getDate(), d1);
	}
	
	@Test
	public void testSetDateNegative(){
		d1 = null;
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertNull(null);
	}
	
	@Test
	public void testAccountNumberPositive(){
		ac1 = new Account(c1, d2, 1000);
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertNotNull(ac1);
	}
	
	@Test
	public void testAccountNumberNegative(){
		ac1 = null;
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertNull(ac1);
	}
	
	@Test
	public void testTransactionTypePositive(){
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertEquals("Deposit", tr.getTransactionType());
	}
	
	@Test
	public void testTransactionTypeNegative(){
		tr = new TransactionRecord(100, d1, ac1, 3);
		assertEquals(null, tr.getTransactionType());
	}
	
}
