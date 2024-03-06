package day7.bankingexample;

public interface BankingService {
	
	double getBalance();
	boolean deposit(double dAmt);
	boolean withdraw(double wAmt);
	boolean transferFunds(double tAmt);
}
