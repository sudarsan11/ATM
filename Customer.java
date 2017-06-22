import java.util.ArrayList;

public class Customer extends Transactions{
	
	int accountNo,accountBalance;
	protected int pin;
	String Name;
	
	ArrayList<Customer> customers = new ArrayList<Customer>();
	ArrayList<Transactions> transcations = new ArrayList<Transactions>();
	
	Customer(){
		
	
	}
	
	Customer(int accountNo,String Name,int Pin,int accountBalance){
		
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.pin = Pin;
		this.Name = Name;
	}
	
	
	 public void addCustomers(){
		 
		 customers.add(new Customer(101,"Suresh",2343,25234));
		 customers.add(new Customer(102,"Ganesh",5432,34123));
		 customers.add(new Customer(103,"Magesh",7854,26100));
		 customers.add(new Customer(104,"Naresh",2345,80000));
		 customers.add(new Customer(105,"Harish",1907,103400));
		 
	 }
	 
	 
	 public void showCustomers(){
		 
		 for(Customer customer:customers){
			 
			 System.out.println(customer.accountNo+"\t"+customer.Name+"\t"+customer.pin+"\t"+customer.accountBalance);
		 }
		 
	 }
	 
	 
	
	
}
