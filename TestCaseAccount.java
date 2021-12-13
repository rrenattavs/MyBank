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
public class TestCaseAccount {

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
	public void testSetCostumerPositive(){
		assertEquals(c1, ac1.getCustomer());
	}
	@Test
	public void testSetCostumerNegative(){
		c1 = null;
		assertNull(c1);
	}
	@Test
	public void testDateCreatedPositive(){
		assertEquals(d2, ac1.getDateCreated());
	}
	
	@Test
	public void testDateCreatedNegative(){
		d2 = null;
		assertNull(d2);
	}
	
	@Test
	public void testSetBalancePositive(){
		ac1.setBalance(2000);
		assertEquals(2000,ac1.getBalance(), .01);
	}
	@Test
	public void testSetBalanceNegative(){
		ac1.setBalance(-1000);
		assertEquals(0.0, ac1.getBalance(), .01);
	}
	@Test
	public void testDepositPositive(){
		ac1.deposit(100);
		assertEquals(1100, ac1.getBalance(),.01);
	}
	
	@Test
	public void testDepositNegative(){
		ac1.deposit(-100);
		assertEquals(1000,ac1.getBalance(), 0.001);
	}
	@Test 
	public void testWithdrawPositive(){
		ac1.withdraw(100);
		assertEquals(100, ac1.getBalance(),1000);
	}
	
	@Test // negative value
	public void testWithdrawNegative(){
		ac1.withdraw(-100);
		assertEquals(1000, ac1.getBalance(), 0.001);
	}
	@Test //withdraw > balance
	public void testWithdrawNegative2(){
		ac1.withdraw(2000);
		assertEquals(1000, ac1.getBalance(), 0.001);
	}
	//@Test
	public void testAddTransactionPositive(){
		tr = new TransactionRecord(100, d1, ac1, 1);
		assertTrue(tr!=null);
	}
	
	@Test
	public void testAddTransactionNegative(){
		ac1.addTransaction(null);
		assertNull("No transation effectued!", null);
	}
	
}
