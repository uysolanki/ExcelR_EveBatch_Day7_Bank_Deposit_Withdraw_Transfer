package day7.bankingexample.entity;

public class Customer {
	private String customerName;
	private String loginID;
	private String password;
	
	public Customer() {}
	public Customer(String customerName, String loginID, String password) {
		this.customerName = customerName;
		this.loginID = loginID;
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getLoginID() {
		return loginID;
	}
	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", loginID=" + loginID + ", password=" + password + "]";
	}
	
	
	public boolean authenticate(String consoleloginID, String consolePassword)
	{
		if(consoleloginID.equals(this.getLoginID())  && consolePassword.equals(this.getPassword()))
			return true;
		else
			return false;
			
	}
	
	
	
	
	
	
}
