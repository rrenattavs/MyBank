/**
 * 
 */
package ca.bcit.comp1451.assignment1;

import java.util.ArrayList;
import java.lang.String;

/** 
 * @author {Renata Vieira}
 *
 *Jan 30, 2017
 */
public class Account {
	
	private Customer customer;
	private String accountNumber;
	private Date dateCreated;
	private double balance;
	private ArrayList<TransactionRecord> transactions;
	
	private static int IDaccountNumber = 0;
	
	public static final double DOUBLE_VALUE = 0.0;
	public static final double DIV_BY_DOUBLE = 100.00;
	
	
	/**
	 * Non-Default constructor for class of Account
	 * @param customer
	 * @param dateCreated
	 * @param balance
	 * @param transactions
	 */
	public Account(Customer customer, Date dateCreated, double balance) {
		setCustomer(customer);
		setDateCreated(dateCreated);
		setBalance(balance);
		accountNumber = createAccountNumber();
		transactions = new ArrayList<TransactionRecord>();
			
	}
	
	/**
	 * Default Constructor for class of Account
	 */
	public Account() {
		this.customer = new Customer();
		this.dateCreated = new Date();
		this.balance = DOUBLE_VALUE;
		accountNumber = createAccountNumber();
		transactions = new ArrayList<TransactionRecord>();
		
	}
	
	//getters
	/**
	 * Method getCustomer
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * Method getAccountNumber
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * Method getDateCreated
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	/**
	 * Method getBalance
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Method getTransactions
	 * @return the transactions
	 */
	public ArrayList<TransactionRecord> getTransactions() {
		return transactions;
	}
	
	//setters
	
	/**
	 * Method setCustomer
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		if(customer!= null){
			this.customer = customer;
		}else{
			customer = new Customer();
		}
	}
	
	/**
	 * Method setDateCreated
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		if(dateCreated!=null){
			this.dateCreated = dateCreated;
		}else{
			this.dateCreated = new Date();
		}
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		if(balance > DOUBLE_VALUE){
			this.balance = balance;
		}else{
			this.balance = DOUBLE_VALUE;
		}
			
	}
	/**
	 * private createdAccountNumber
	 * @return A string
	 */
	private String createAccountNumber(){
		IDaccountNumber++;
		return "000" + IDaccountNumber;
		
	}
	
	/**
	 * Method deposit
	 * @param amount
	 * @return a boolean value
	 */
	public boolean deposit(double amount){
		
		if(amount > DOUBLE_VALUE){
			balance += amount;
			return true;
		}else{
			System.out.println("Enter a positive value!");
			return false;
		}
	}
	
	/**
	 * Method withdraw
	 * @param amount
	 * @return a boolean value
	 */
	public boolean withdraw(double amount){
		if(amount > DOUBLE_VALUE && amount<= balance){
			balance -= amount;
			return true;
		}else{
			System.out.println("Error: Balance is not enough! or The value is negative.");
			return false;
		}
	}
	
	/**
	 * Method addTransaction
	 * @param transaction
	 */
	public void addTransaction(TransactionRecord transaction){
		if(transaction != null){
			transactions.add(transaction);
		}else{
			System.out.println("No transation effectued!");
		}
	}
	
	/**
	 * Method displayTransations
	 * This method display all the transactions in the ArrayList
	 */
	public void displayTransations(){
		for(TransactionRecord transaction: transactions){
			
			System.out.println(transaction.toString());
			
		}
	}
	
	/**
	 * This method display details about Account class
	 */
	public void displayDetails(){
		customer.displayDetails();
		System.out.println("Account number: " + accountNumber);
		System.out.print("Account created: ");
		getDateCreated().printDetails();
		System.out.println("Balance: " + Math.round(balance*DIV_BY_DOUBLE)/DIV_BY_DOUBLE);
		
	}
	
	@Override	
	public String toString(){
		
		return "\nACCOUNT NUMBER: " + getAccountNumber() + "CUSTOMER " + getCustomer() +
				"\nDATE CREATED :" + getDateCreated();
	}
}
