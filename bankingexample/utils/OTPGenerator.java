package day7.bankingexample.utils;

public class OTPGenerator {

	public static int generateOTP()
	{
		int n=(int)(Math.random()*5000 + 100000);
		return(n);
	}
}
