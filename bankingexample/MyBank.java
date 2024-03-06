package day7.bankingexample;

import day7.bankingexample.utils.OTPGenerator;

public class MyBank implements BankingService{
	
	private double balance;   
	
	public MyBank() {}
	public MyBank(double balance) {
		this.balance = balance;
	}

	@Override
	public double getBalance() {
		return this.balance;
	}

	@Override
	public boolean deposit(double dAmt) 
	{
		this.balance=this.balance+dAmt;
		return true;
	}

	@Override
	public boolean withdraw(double wAmt) {
		if(wAmt>this.getBalance())
		{
			return false;
		}
		else
		{
		this.balance=this.balance-wAmt; 
			return true;
		}
	}

	@Override
	public boolean transferFunds(double tAmt) {
		return withdraw(tAmt);
		
	}

}
