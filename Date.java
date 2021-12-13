/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.HashMap;
import java.util.Calendar;


/** 
 * @author {Renata Vieira}
 *
 *Jan 30, 2017
 */
public class Date {
	private int day;
	private int month;
	private int year;
	
	private HashMap<Integer,String> monthNames;
	
	public static final int MIN_DAY = 1;
    public static final int MAX_DAY = 31;
    
    public static final int MIN_MONTH = 1;
    public static final int MAX_MONTH = 12;
    
    public static final int START_YEAR = 1900;
    public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
    
    public static final int MIN_VALUE_DAY = 0;
    public static final int MIN_VALUE_MONTH_FOR = 0;
    public static final int MAX_VALUE_DAY = 10;
    
    public static final int PART_STR_ZERO = 0;
    public static final int PART_STR_ONE = 1;
    public static final int PART_STR_TWO = 2;
    
    public static final int LENGHT_OF_STRING = 8;
    
    /**
     * Non-Default Constructor for class of Date
     * @param day
     * @param month
     * @param year
     */
    public Date(int day, int month, int year){
    	setDay(day);
    	setMonth(month);
    	setYear(year);
    	
    	monthNames = new HashMap<Integer,String>();
    	formatMonth();
    }
    
    /**
	 * Default Constructor for class Date
	 */ 
	public Date() {
		
		this.day = MIN_DAY;
		this.month = MIN_MONTH;
		this.year = START_YEAR;
		
		monthNames = new HashMap<Integer,String>();
    	formatMonth();
	}
    
    //getters
    
    
	/**
     * Method getDay
     * @ return day as an integer
    */
  
    public int getDay(){
        return day;
    }
    
    /**
     * Method getMonth
     * @ return month as an integer
    */
  
    public int getMonth(){
        return month;
    }

    /**
     * Method getYear
     * @ return year as an integer
    */
    public int getYear(){
        return year;
    }
    
    
    //setters
    
    /**
     * Method setDay
     * @param day.  The parameter day should be between 1 to 31.
    */
    public void setDay(int day){
    	if (day >= MIN_DAY && day <= MAX_DAY){
            this.day = day;
        }else{
        	this.day = MIN_DAY;
            System.out.println("The day is Invalid.\nDAY should be between " + MIN_DAY + " to " + MAX_DAY + ".");
        }
    }
    
    /**
     * Method setMonth
     * @param month. The parameter month should be between 1 to 12.
    */
   public void setMonth(int month){
         if(month >= MIN_MONTH && month <= MAX_MONTH){
            this.month = month;
        }else{
        	this.month = MIN_MONTH;
            System.out.println("The month is Invalid.\nMONTH should be between " + MIN_MONTH +" to " + MAX_MONTH +".");
        }
    }
    
    /**
     * Method setYear
     * @param year. The parameter year should starts  in 1900.
    */
   public void setYear(int year){
         if(year >= START_YEAR && year <= CURRENT_YEAR){
            this.year = year;
        }else{
        	this.year = START_YEAR;
            System.out.println("The year is Invalid.\nYear should be between " + START_YEAR +" - " + CURRENT_YEAR +".");
        }
    }
   
   /**
    * Method formatStringInDate
    * @param date as a String
    */
   public void formatStringInDate(String date){
	   if(date != null && date.trim().length() >= LENGHT_OF_STRING){
		   String []parts = date.split("/");
		   setDay(Integer.parseInt(parts[PART_STR_ZERO]));
		   setMonth(Integer.parseInt(parts[PART_STR_ONE]));
		   setYear(Integer.parseInt(parts[PART_STR_TWO]));
		   formatDate(day, month, year);
	   }else{
		   System.out.println("Enter a valid date!");
	   }
   }
   /**
    * private method formatMonth
    * This month is a HashMap, that associates the name of month to a integer(ID)
    */
   private void formatMonth(){
	   String [] nounOfMonths = {"January", "February", "March", "April","May","June","July","August","September","October", "November","December"};
	   for(int i = MIN_VALUE_MONTH_FOR; i< MAX_MONTH; i++){
		   monthNames.put((i+1), nounOfMonths[i]);
	   }
   }
   
   /**
    * Method formatDate
    * @param day
    * @param month
    * @param year
    * @return date as a String
    */
   public String formatDate(int day, int month, int year){
	   String date = null;
	   String monthName = monthNames.get(month);
	   if(day > MIN_VALUE_DAY && day < MAX_VALUE_DAY){
		   date = "0"+ day + "/"+ monthName + "/" +year;
	   }else{
		   date = day + "/"+ monthName + "/" +year;
	   }
	   return date;
   }
   
   /**
    * Method printDetails
    * Display the date
    */
   public void printDetails(){
	   System.out.println(formatDate(getDay(), getMonth(), getYear()));
   }
   
   @Override
	public String toString() {
		return formatDate(getDay(), getMonth(), getYear()) ;
	}
}
