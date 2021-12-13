/**
 * 
 */
package ca.bcit.comp1451.assignment1;
import java.util.HashMap;
import java.util.Scanner;
/** 
 * @author {Renata Vieira}
 *
 *Jan 30, 2017
 */
public class Bank {
	
	private String bankName;
	private HashMap<String,Account> banks;
	
	Scanner scan;
	
	public static final String DEFAULT_STRING = "unknown";
	public static final int MIN_INT_VALUE = 0;
	public static final int MAX_INT_VALUE = 3;
	
	public static final int INDEX_DEPOSIT = 1;
	public static final int INDEX_WITHDRAW = 2;
	public static final int INDEX_TRANSACTIONS = 3;
	
	public static final char OP_UPPER = 'Y';
	public static final char OP_LOWER = 'y';
	
	/**
	 * Non default constructor
	 * @param bankName
	 */
	public Bank(String bankName){
		setBankName(bankName);
		banks = new HashMap<String,Account>();	
	}
	
	/**
	 * Method getBankName
	 * @return bankName
	 */
	public String getBankName(){
		return bankName;
	}
	
	/**
	 * Method setBankName
	 * @param bankName as a String
	 */
	public void setBankName(String bankName){
		if(bankName != null && !bankName.isEmpty()){
			this.bankName = bankName;
		}else{
			this.bankName = DEFAULT_STRING;
		}
	}
	
	/**
	 * Method addAccount
	 * This method add the new account on the list.
	 * @param toAdd
	 */
	public void addAccount(Account toAdd){
		if(toAdd!= null && !banks.containsKey(toAdd.getAccountNumber())){
			banks.put(toAdd.getAccountNumber(),toAdd);
		}else if(toAdd == null){
			System.out.println("Error: Enter a valid account value");
		}else{
			System.out.println("Account has already been registered");
		}
	}
	
	/**
	 * Method getAccount finds and returns the account object associated
	 * @param accountNumber
	 * @return the account number found on the list
	 */
	public Account getAccount(String accountNumber){
		if(accountNumber != null && !accountNumber.isEmpty() && banks.containsKey(accountNumber)){
			return banks.get(accountNumber);
		}else{
			System.out.println("Account Number is not in the register.");
			return null;
		}
	}
	
	/**
	 * Method that takes a parameter iterates through the HashMap and 
	 * display all transactions of that account if the account was found.
	 * 
	 * @param accountNumber as a String
	 */
	public void showAccountTransactions(String accountNumber){
		if(getAccount(accountNumber) != null){
			Account account = getAccount(accountNumber);
			account.displayDetails();
			for (TransactionRecord transaction : account.getTransactions()) { 
				System.out.println(transaction);
				System.out.println();
			}
		}
	}
	
	/**
	 * Method makeTransaction
	 * This method creates a loop to ask the user for the accountNumber and searches the HashMap
	 * This accountNumber is the keys at the HashMap
	 * Menu options: 1-Deposit, 2-Withdraw , 3-Transfer and 4-Exit- show the transactions
	 */
	public void makeTransaction(){
		scan = new Scanner(System.in);
		TransactionRecord tr;
		int option;
		
		System.out.println("Enter the account number: ");
		String accountNumber = scan.next();
		Account account = getAccount(accountNumber);
			
		if (account != null){
			do{
				System.out.println("\nWhat would you like to do?\n");
				System.out.println("1.DEPOSIT: ");
				System.out.println("2.WITHDRAW: ");
				System.out.println("3.SHOW TRANSACTIONS:");
				option = scan.nextInt();
				switch(option){ 
					case INDEX_DEPOSIT:	
							System.out.println("Enter the amount:");
							double amountDep = scan.nextDouble();
							System.out.println("Enter a date (dd/mm/yyyy): ");
							String date1 = scan.next();
							Date dateDep= new Date();
							dateDep.formatStringInDate(date1);
							tr = new TransactionRecord(amountDep, dateDep, account, INDEX_DEPOSIT);
							if(account.deposit(amountDep)){
	    						account.addTransaction(tr);
	    					}
							break;
							
					case INDEX_WITHDRAW:	
							System.out.println("Enter the amount:");
							double amountWd = scan.nextDouble();
							System.out.println("Enter a date (dd/mm/yyyy): ");
							String date2 = scan.next();
							Date dateWd = new Date();
							dateWd.formatStringInDate(date2);
							tr = new TransactionRecord(amountWd, dateWd, account,INDEX_WITHDRAW);
							if(account.withdraw(amountWd)){
	    						account.addTransaction(tr);
	    					}
	    					break;
	    					
					
					case INDEX_TRANSACTIONS:	
							System.out.println("All transactions: ");
							System.out.println("---------------------------------");
	    					showAccountTransactions(accountNumber);
	    					System.out.println("---------------------------------");
	    					System.out.println("Balance: " + account.getBalance());
	    					System.out.println("---------------------------------");
	    					break;
	    			default:System.out.println("Choose an option between " + INDEX_DEPOSIT +" to " + INDEX_TRANSACTIONS +".");
							break;
				
				}//close switch
    			
			}while(option != MAX_INT_VALUE);
		}
		System.out.println("\nDo you want make another transaction: 'y': Yes 'n': No\n");
		int op = scan.next().charAt(MIN_INT_VALUE);
		
		//keep or not the user into the method makeTransaction
		if(op == OP_LOWER || op == OP_UPPER){
			makeTransaction();
		}else{
			System.out.println("---------------------------------");
			System.out.println("           Thank you!");
			System.out.println("---------------------------------");
			scan.close();
		}
	}
	
	/**
	 * Method void main
	 * @param args
	 */
	public static void main(String [] args){
		
		Bank b = new Bank ("TROLLsBank");                       
		
		Date dc1 = new Date(15,11,2013); //dateCreated
		Date dc2 = new Date(2,8,2009); //dateCreated
		Date dc3 = new Date(01,10,2015); //dateCreated
		Date dc4 = new Date(8,05,2016); //dateCreated
		Date dc5 = new Date(07,1,2017); //dateCreated
		
		Account [] acc = {new Account(new Customer("marK","smiTH", "burnaby", new Date(01,12,1989)),dc1,10000),
						  new Account(new Customer("oliver","Anderson", "vancouver", new Date(4,02,1990)),dc2,20000),
						  new Account(new Customer("matheo","laSaLLe", "kamloop", new Date(01,12,1989)),dc3,5000), 
						  new Account(new Customer("max","fishman", "kelowna", new Date(4,02,1992)),dc4,100000),
						  new Account(new Customer("WILLIAM","Dunn", "new westminster", new Date(01,12,1979)),dc5,2000)};
		
		
		System.out.println("---------------------------------");
		System.out.println("         " + b.getBankName());
		for(Account account: acc){
			b.addAccount(account);
		}System.out.println("---------------------------------");
		b.makeTransaction();
		
	}

}
