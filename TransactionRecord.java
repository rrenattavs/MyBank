/**
 * 
 */
package ca.bcit.comp1451.assignment1;

/** 
 * @author {Renata Vieira}
 *
 *Jan 30, 2017
 */
public class TransactionRecord {
	
	private double amount;
	private Date date;
	private Account accountNumber;
	private int transactionType;
	
	public static final double DOUBLE_VALUE = 0.0;
	
	public static final int INDEX_DEPOSIT = 1;
	public static final int INDEX_WITHDRAW = 2;
	
	
	/**
	 * Non Default Constructor
	 * @param amount
	 * @param date
	 */
	public TransactionRecord(double amount, Date date, Account accountNumber, int index){
		setAmount(amount);
		setDate(date);
		transactionType = index;
		setAccountNumber(accountNumber);
	}

	//getters
	
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the accountNumber
	 */
	public Account getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType();
	}

	//setters
	/**
	 * Method setAmount
	 * @param amount as a double
	 */
	public void setAmount(double amount) {
		if(amount > DOUBLE_VALUE){
			this.amount = amount;
		}else{
			System.out.println("Enter a positive value!");
		}
	}

	/**
	 * Method setDate
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		if(date != null){
			this.date = date;
		}else{
			date = new Date();
		}
	}

	/**
	 * Method setAccountNumber
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Account accountNumber) {
		if(accountNumber!= null){
			this.accountNumber = accountNumber;
		}else{
			this.accountNumber = new Account();
		}	
	}
	
	/**
	 * Method transactionType
	 * @return a String
	 */
	public String transactionType() {
		String transaction = null;
		if(transactionType == INDEX_DEPOSIT){		//1
			transaction = "Deposit";
		}else if(transactionType == INDEX_WITHDRAW){	//2
			transaction = "Withdraw";
		}else{
			System.out.println("Type of transaction invalid!");
		}
		
		return transaction;
	}
	
	@Override
	public String toString() {
		
		return "\nACCOUNT NUMBER: " + getAccountNumber().getAccountNumber() +"\nAMOUNT: " + getAmount() +
				"\nDATE :" + getDate() + "\nTRANSACTION TYPE: " +getTransactionType();
	}
}
