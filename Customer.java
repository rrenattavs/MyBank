/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/** 
 * @author {Renata Vieira}
 *
 *Jan 30, 2017
 */
public class Customer {
	
	private String firstName;
    private String lastName;
    private String address;
    private Date dateOfBirth;
    
    public static final String STRING_VALUE = "unknown";
    public static final int START_ZERO_VALUE = 0;
	public static final int FIRST_VALUE = 1;
    
	/**
	 * Non-Default constructor for class of Customer
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param dateOfBirth
	 */
    public Customer(String firstName, String lastName, String address, Date dateOfBirth){
    	setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setDateOfBirth(dateOfBirth);
    }
    
   
    /**
	 * Default constructor for class of Customer
	 */
	public Customer() {
		this.firstName = STRING_VALUE;
		this.lastName = STRING_VALUE;
		this.address = STRING_VALUE;
		dateOfBirth = new Date();
	}

	//getters
	/**
	 * Method getFirstName
	 * @return the firstName as a String
	 */
	public String getFirstName() {
		return upperCaseFirstLetter(firstName);
	}

	/**
	 * Method getLastName
	 * @return the lastName as a String
	 */
	public String getLastName() {
		return upperCaseFirstLetter(lastName);
	}

	/**
	 * Method getAddress
	 * @return the address as a String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Method getDateOfBirth
	 * @return the dateOfBirth as a Date
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	
	//setters
	/**
	 * Method setFirstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if(firstName != null && !firstName.isEmpty()){
			this.firstName = firstName;
            
        }else{
            this.firstName = STRING_VALUE;
        }
		
	}

	/**
	 * Method setLast
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if(lastName != null && !lastName.isEmpty()){
			this.lastName = lastName;
            
        }else{
            this.lastName = STRING_VALUE;
        }
	}

	/**
	 * Method setAddress
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if(address != null && !address.isEmpty()){
			this.address = address;
            
        }else{
            this.address = STRING_VALUE;
        }
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		if(dateOfBirth != null){
			this.dateOfBirth = dateOfBirth;
        }else{
            this.dateOfBirth = new Date();
        }
	}
    
	/**
	 * Method upperCaseFirstLetter
	 * @param noun as a String
	 * @return a String after formating a noun with the first letter in upperCase
	 */
	public String upperCaseFirstLetter(String noun){
        return noun.substring(START_ZERO_VALUE,FIRST_VALUE).toUpperCase() + noun.substring(FIRST_VALUE).toLowerCase();
    }
    
    /**
     * Method fullName()
     * @return a string with firstName and lastName value concatenated.  
     */
    public String fullName(){
        return getFirstName() + " "+ getLastName();
    }
    /**
     * Method DisplayDetails
     * This method display all Customer's information
     */
    public void displayDetails(){
    	System.out.println("Customer Name: " + fullName());
        System.out.println("Address: " + address);
        System.out.print("Date Of Birth: ");
        getDateOfBirth().printDetails();
    }
}
