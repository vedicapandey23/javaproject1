package labassignment3;
import java.util.*;

public class Account {

	static final double si=0.05;
	static final double ci=0.06;
	
	static final double s_min=1000;
	static final double c_min=2000;
	
	
	
	
	void display(Account account)
	{
		
	  if(account instanceof SavingAccount)
	  {
		  SavingAccount saving=(SavingAccount)account;
		  
		  System.out.println("Customer Name: "+saving.getCustomerName()+", Customer_AccNumber:"+saving.getAccountNumber()+", Account type:" +saving.getAccountType() +",  Balance :"+saving.getAmount());
		  
		  
	  }
	  else  if(account instanceof CurrentAccount)
	  {
		  CurrentAccount current=(CurrentAccount)account;
		  
		  System.out.println("Customer Name: "+current.getCustomerName()+", Customer_AccNumber:"+current.getAccountNumber()+", Account type: " +current.getAccountType() +"   ,Balance :"+current.getAmount());
		  
		  
	  }
		
		
	}
	void withdraw(Account account,double amount)
	{
		if(account instanceof SavingAccount )
		{
			SavingAccount saving=(SavingAccount)account;
			double temp=saving.getAmount()-amount;
			saving.setAmount(temp);
			
			
		}
		else if(account instanceof CurrentAccount )
		{
			CurrentAccount current=(CurrentAccount)account;
			double temp1=current.getAmount()-amount;
			current.setAmount(temp1);
			
			
		}
	}
	void deposit(Account account,double amount)
	{
		if(account instanceof SavingAccount )
		{
			SavingAccount saving=(SavingAccount)account;
			double temp=saving.getAmount()+amount;
			saving.setAmount(temp);
			
			
		}
		else if(account instanceof CurrentAccount )
		{
			CurrentAccount current=(CurrentAccount)account;
			double temp1=current.getAmount()+amount;
			current.setAmount(temp1);
			
			
		}
	}
	void checkminimumbalance(Account account)
	{
		if(account instanceof SavingAccount )
		{
			SavingAccount saving=(SavingAccount)account;
			 if(saving.getAmount()<s_min)
			 {
				 System.out.println("your balance below minimum balance,penality deducted:");
				 double temp=saving.getAmount()*0.01;
				 saving.setAmount(saving.getAmount()-temp);
			 }
			 
			 else{
				 System.out.println("Your Balance is Sufficient");
			 }
			 
		}
		else if(account instanceof CurrentAccount )
		{
			CurrentAccount current=(CurrentAccount)account;
			if(current.getAmount()<s_min)
			{
				System.out.println("your balance below minimum balance,penality deducted:");
				double temp1=current.getAmount()*.02;
				current.setAmount(current.getAmount()-temp1);
			}
			
			 else{
				 System.out.println("Your Balance is Sufficient");
			 }
				
			
		}
	}
	void interest(Account account,int year)
	{
		if(account instanceof SavingAccount )
		{
			SavingAccount saving=(SavingAccount)account;
			double temp=saving.getAmount()*.06*year;
			System.out.println("Your Interest is:"+temp);		
		}
		
	}
}

class SavingAccount extends Account
{
	
	private String customerName;
	private int accountNumber;
	private String accountType;
	private double amount; 
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	

	
	
}

class CurrentAccount extends Account
{
	
	private String customerName;
	private int accountNumber;
	private String accountType;
	private double amount; 
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		
		this.accountType = accountType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
}


class Test
{
	
public static void main(String[] args) {
	String type=null;
	Scanner sc=new Scanner(System.in);
	Account acc=new Account();
	SavingAccount saving=null;
	CurrentAccount current=null;
	
	System.out.println("Enter your choice S for Saving and C for Current");
	char ch=sc.next().charAt(0);
	
	
    switch(ch)
	{
	case 'S':
	
		System.out.println("Enter Customer Name");
		String name=sc.next();
		System.out.println("Enter Customer account number");
		int account=sc.nextInt();
		//System.out.println("Enter Customer account type");
		type="Saving";
		System.out.println("Enter opening amount");
		double amount=sc.nextInt();
		
	    saving=new SavingAccount();
		saving.setCustomerName(name);
		saving.setAccountNumber(account);
		saving.setAccountType(type);
		saving.setAmount(amount);
		
		break;
		
	
	case 'C' :
	
		System.out.println("Enter Customer Name");
		String name1=sc.next();
		System.out.println("Enter Customer account number");
		int account1=sc.nextInt();
		//System.out.println("Enter Customer account type");
		type="Current";
		System.out.println("Enter opening amount");
		double amount1=sc.nextInt();
		
		current=new CurrentAccount();
		current.setCustomerName(name1);
		current.setAccountNumber(account1);
		current.setAccountType(type);
		current.setAmount(amount1);
		
		break;
	
	default :
   	 System.out.println("wrong choice");

	
	}
    System.out.println("Enter 1 to get menu and 0 to exit");
	int ch6=sc.nextInt();
	while(ch6!=0)
	{
    
    System.out.println("Enter your choice 1 for Display, 2 for withdraw, 3 for deposit, 4 for check minimum balance 5 for interest calculation");
    
    int choice=sc.nextInt();
    
    
    switch(choice)
    {
    
    
    case 1:
    	
    	//System.out.println("Enter S for Saving and C for Current");
    	char ch1=type.charAt(0);
    
    	if(ch1=='S')
    	{
    		acc.display(saving);
    	}
    	
    	else if(ch1=='C')
    	{
    		acc.display(current);
    	}
    	
    	break;
    	
    case 2:
    	char ch2=type.charAt(0);
    	System.out.println("Enter the withdrawing amount:");
    	double am=sc.nextDouble();
    	if(ch2=='S')
    	{
    		acc.withdraw(saving,am);
    	}
    	
    	else if(ch2=='C')
    	{
    		acc.withdraw(current,am);
    	}
    	
    	break;
    	
    case 3:
    	char ch3=type.charAt(0);
    	System.out.println("Enter the deposit amount:");
    	double am1=sc.nextDouble();
    	if(ch3=='S')
    	{
    		acc.withdraw(saving,am1);
    	}
    	
    	else if(ch3=='C')
    	{
    		acc.withdraw(current,am1);
    	}
    	
    	break;
    	
    case 4:
    	char ch4=type.charAt(0);
        if(ch4=='S')
        {
        	acc.checkminimumbalance(saving);
        }
        else if(ch4=='C')
        {
        	acc.checkminimumbalance(saving);
        }
        break;
    case 5:
    	char ch5=type.charAt(0);
    	        if(ch5=='S')
    	        {
    	        	System.out.println("enter number of years to calculate interest :");
    	        	int year=sc.nextInt();
    	        	acc.interest(saving,year);
    	        }
    	        else if(ch5=='C')
    	        {
    	        	System.out.println("No Interest on current account type.");
    	        }
    	        break;
     default :
    	 System.out.println("wrong choice");

	}
    
	}
}
}