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
public class TestCaseCustomer {

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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		c1 = null;
	}
	@Test    //---firstName
	public void testSetfirstNamePositive() {
		c1.setFirstName("max");
		assertEquals("Max", c1.getFirstName());
	}
	@Test    
	public void testSetfirstNameNegative() {
		c1.setFirstName("");
		//assertNotNull("unknown", c1.getFirstName());
	}
	@Test    //---lastName
	public void testSetLastNamePositive() {
		c1.setLastName("anderson");
		assertEquals("Anderson", c1.getLastName());
	}
	@Test    
	public void testSetLastNameNegative() {
		c1.setLastName(null);
		assertNotNull("unknown",c1.getLastName());
	}
	
	@Test    //---address
	public void testSetAddressPositive() {
		c1.setAddress("burnaby");
		assertEquals("burnaby", c1.getAddress());
	}
	@Test    
	public void testSetAddressNegative() {
		c1.setAddress(null);
		assertEquals("unknown", c1.getAddress());
	}
	@Test //---DateOfBirth   
	public void testSetDateOfBirthPositive() {
		c1.setDateOfBirth(d1);
		assertEquals(d1, c1.getDateOfBirth());
	}
	
	@Test
	public void testSetDateOfBirthNegative() {
		c1.setDateOfBirth(null);
		assertNull(null);
	}
	
	@Test  //function fullName
	public void testFullNamePositive(){
		c1.setFirstName("victor");
		c1.setLastName("sanderson");
        assertEquals("Victor Sanderson", c1.fullName());
    }
	
	@Test
	public void testUpperCaseFirstLetterPositive(){
		c1.setFirstName("max");
		assertEquals("Max", c1.getFirstName());
		c1.setLastName("anderson");
		assertEquals("Anderson", c1.getLastName());
		
	}

}
