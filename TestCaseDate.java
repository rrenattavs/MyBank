/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
/** 
 * @author {Renata Vieira}
 *
 *Feb 19, 2017
 */
public class TestCaseDate {
	Date d1, d2, d3;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		d1 = new Date(2,1,2000);
		d2 = new Date(3,10,2016);
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		d1 = null;
		d2 = null;
		d3 = null;
	}
	
	@Test    //---Day
	public void testSetDayPositive() {
		d1.setDay(15);
		assertEquals(15, d1.getDay());
	}
	
	@Test
	public void testSetDayNegative() {
		d1.setDay(32);
		assertEquals(1, d1.getDay());
	}
	@Test   //--Month
	public void testSetMonthPositive() {
		d1.setMonth(10);
		assertEquals(10, d1.getMonth());
	}
	
	@Test 
	public void testSetMonthNegative() {
		d1.setMonth(15);
		assertEquals(1, d1.getMonth());
	}
	@Test   //--YEAR
	public void testSetYearPositive() {
		d1.setYear(2010);
		assertEquals(2010, d1.getYear());
	}
	
	@Test 
	public void testSetYearNegative() {
		d1.setDay(1800);
		assertEquals(2000, d1.getYear());
	}
	
	@Test
	public void testFormatDatePositive(){
		d1.formatDate(10, 2, 2010);
		assertEquals("10/February/2010", d1.formatDate(10, 2, 2010));
	}
	
	@Test
	public void testFormatDateNegative(){
		d1 = new Date(10,13,2010);
		assertEquals("10/January/2010", d1.formatDate(d1.getDay(), d1.getMonth(),d1.getYear()));
	}
	
	@Test
	public void testFormatDateNegative2(){
		d1 =  new Date (0,0,2100);
		assertEquals("01/January/1900", d1.formatDate(d1.getDay(), d1.getMonth(),d1.getYear()));
	}
	
	@Test
	public void testFormatDateNegative3(){
		d1 = new Date();
		assertEquals("01/January/1900", d1.formatDate(d1.getDay(), d1.getMonth(),d1.getYear()));
	}
	@Test
	public void testFormatStringInDatePositive(){
		d3 = new Date();
		String date = "15/02/2017";
		d3.formatStringInDate(date);
		assertEquals("15/February/2017", d3.formatDate(d3.getDay(), d3.getMonth(), d3.getYear()));
	}
	
	@Test
	public void testFormatStringInDateNegative(){
		d3 = new Date();
		String date = "15/02/200";
		d3.formatStringInDate(date);
		assertEquals("15/February/1900", d3.formatDate(d3.getDay(), d3.getMonth(), d3.getYear()));
	}
	
	
	public void testBoundaries(){
		d1.setDay(1);
		assertEquals(1,d1.getDay());
		d1.setDay(31);
		assertEquals(31,d1.getDay());
		
		d1.setMonth(1);
		assertEquals(1,d1.getMonth());
		d1.setMonth(12);
		assertEquals(12,d1.getMonth());
		
		d1.setYear(1900);
		assertEquals(1900,d1.getYear());
		d1.setYear(Calendar.getInstance().get(Calendar.YEAR));
		assertEquals(Calendar.getInstance().get(Calendar.YEAR), d1.getYear());
	}

}
