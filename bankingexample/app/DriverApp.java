package day7.bankingexample.app;

import java.util.Scanner;

import day7.bankingexample.MyBank;
import day7.bankingexample.entity.Customer;
import day7.bankingexample.utils.OTPGenerator;

public class DriverApp {
	static int loginCounter=1; 
	
	public static void main(String[] args) {
		Customer c1=new Customer();
		int choice;
		c1.setCustomerName("Alice");
		c1.setLoginID("alice@gmail.com");
		c1.setPassword("alice123");
		
		Customer c2=new Customer();
		c2.setCustomerName("Ben");
		c2.setLoginID("ben@gmail.com");
		c2.setPassword("ben123");
		
		Customer c3=new Customer();
		c3.setCustomerName("Chris");
		c3.setLoginID("chris@gmail.com");
		c3.setPassword("chris123");
		
		Customer customers[]=new Customer[3];
		customers[0]=c1;
		customers[1]=c2;
		customers[2]=c3;
		
		
		MyBank mb=new MyBank(5000);
		Scanner sc=new Scanner(System.in);
		do
		{
		System.out.println("Please enter Login ID"); //alice@gmail.com
		String lid=sc.next();
		
		System.out.println("Please enter Passowd"); //alice123
		String pwd=sc.next();
		
		boolean result=false;
		for(Customer c:customers)
		{
			result=c.authenticate(lid, pwd);
			if(result==true)
			break;
		}
		
		if(result)
		{
		do
		{
		System.out.println("***banking options");	
		System.out.println("1. View Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Online Funds Transfer");
		System.out.println("5. Exit");
		
		System.out.println("Please enter Choice : "); //alice123
		choice=sc.nextInt();
		switch(choice)
		{
		case 1 :   System.out.println("Current Balance" +mb.getBalance());
		break;
		
		case 2 :   
				   System.out.println("Enter Amount to Deposit"); 
				   double dAmt=sc.nextDouble();
				   if(dAmt>0)
				   {
					   if(mb.deposit(dAmt))
						   System.out.println("Amount Deposited Successfully, Updated Balance "+mb.getBalance());
					   else
						   System.out.println("Deposit cancelled");
				   }
				   else
				   {
				   System.out.println("Please enter Valid Deposit Amount");
				   }
				
		break;
		
		case 3 :   System.out.println("Enter Amount to Withdraw"); 
				   double wAmt=sc.nextDouble();
				   if(wAmt>0)
				   {
					   String trans=mb.withdraw(wAmt)?"Amount Withdrawn Successfully Updated Balance ,"+mb.getBalance():"InSufficient Funds";
					   System.out.println(trans);
				   }
				   else
				   {
				   System.out.println("Please enter Valid Withdrawal Amount");
				   }
		break;
		
		case 4 :   
					int otpReceivedOnSMS=OTPGenerator.generateOTP();
					System.out.println("SMS OTP :" + otpReceivedOnSMS);
			
					System.out.println("Please type the OTP");
					int userEntreredOTP=sc.nextInt();
					
					if(otpReceivedOnSMS==userEntreredOTP)
					{
							System.out.println("Enter Amount to Transfer"); 
						   double tAmt=sc.nextDouble();
						   if(tAmt>0)
						   {
							   String trans=mb.transferFunds(tAmt)?"Amount Transfer SuccessfullyUpdated Balance ,"+mb.getBalance():"InSufficient Funds";
							   System.out.println(trans);
						   }
					}
					else
					{
						System.out.println("Invalid OTP");
					}
		break;
		
		case 5 :   System.exit(0);
			
		default : System.out.println("Invalid Input");
		}
		}while(choice!=5);
		loginCounter=4;
		}
		else
		{
			System.out.println("Invalid Credentials");
			loginCounter++;
		}
		
		}while(loginCounter<=3);

	}

}
