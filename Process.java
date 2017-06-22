import java.util.*;

public class Process extends Customer {

	
	public void checkBalance(ArrayList<Customer> customers,int acctNo){
		
		int s=0;
		for(Customer c:customers){
			
			while(c.accountNo==acctNo){
				s++;

				break;
			}	
			
		}
		System.out.println(s);
		
		Customer customer = customers.get(s);
		
		System.out.println(customer.accountBalance);
	}
	
	public void withdrawMoney(ArrayList<Customer> customers,int pin,int acctNo){
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter amount");
		int withdraw = input.nextInt();
		
		int s=0;
		for(Customer c:customers){
			
			while(c.accountNo==acctNo){
				s++;
				break;
			}	
		}
		
		Customer customer = customers.get(s);
	
		
		if(pin!=customer.pin)
			System.out.println("Invalid pin");
		
		else{
			
		
			if(withdraw>10000||withdraw<100)
				System.out.println("Enter a valid amount");
			
			
			if(withdraw>customer.accountBalance||withdraw>customer.atmBalance)	
				System.out.println("Insufficient balance");
				
			
			if(withdraw<1000){
				
				
				customer.denominations[1] = customer.denominations[1]-((withdraw - 1000)/500);
				customer.denominations[2] = customer.denominations[2]-10;
				
				customer.currency = customer.currency-withdraw;
				customer.accountBalance = customer.accountBalance-withdraw;
				
				
				customer.transactionAmount++;
				customer.transcationType = "Debit";
				customer.remarks = "Debited"+withdraw+"rupees from ATM";
				customer.transactionAmount = withdraw;
				
				System.out.println(customer.accountBalance);
				System.out.println(customer.currency);
			}
			
			if(withdraw<=5000){
				
				
		        customer.denominations[0] = customer.denominations[0]-1;
		        customer.denominations[1] = customer.denominations[1]-((withdraw -(1000+(withdraw/100)))/500);
		        customer.denominations[2] = customer.denominations[2]-(withdraw/100);	        
		        
		        customer.currency = customer.currency-withdraw;
		        customer.accountBalance = customer.accountBalance-withdraw;
		        

				customer.transactionAmount++;
				customer.transcationType = "Debit";
				customer.remarks = "Debited"+withdraw+"rupees from ATM";
				customer.transactionAmount = withdraw;
		        
		        
		        System.out.println(customer.denominations[0]+"\t"+customer.denominations[1]+"\t"+customer.denominations[2]);
				System.out.println(customer.accountBalance);
				System.out.println(customer.currency);
		        
		        
			}
			
			if(withdraw>5000){
				
				customer.denominations[0] = customer.denominations[0]-3;
				customer.denominations[1] = customer.denominations[1]-((withdraw - 4000)/500);
				customer.denominations[2] = customer.denominations[2]-10;
				
				customer.currency = customer.currency-withdraw;
				customer.accountBalance = customer.accountBalance-withdraw;
				

				customer.transactionAmount++;
				customer.transcationType = "Debit";
				customer.remarks = "Debited"+withdraw+"rupees from ATM";
				customer.transactionAmount = withdraw;
				
				System.out.println(customer.denominations[0]+"\t"+customer.denominations[1]+"\t"+customer.denominations[2]);
				System.out.println(customer.accountBalance);
				System.out.println(customer.currency);
				
			}
			
		}
	}
	
	
	public void transferMoney(ArrayList<Customer> customers){
		
		
		int sacctNo = 101,racctNo = 102, transferAmount = 2000;
		int s = 0,r=0;
		
		for(Customer c:customers){
			
			while(c.accountNo==sacctNo){
				s++;
				break;
			}	
			
			while(c.accountNo==racctNo){
				r++;
				break;
			}	
		}
		
	/*	for(Customer c:customers){
			
			while(c.accountNo==racctNo){
				r++;
				break;
			}	
		}
		*/

		Customer sender = customers.get(0);
		Customer receiver = customers.get(1);
		
		if(transferAmount>10000||transferAmount<1000)
			System.out.println("Enter a valid amount to transfer");
		
		
		sender.accountBalance = sender.accountBalance-transferAmount;
		receiver.accountBalance = receiver.accountBalance+transferAmount;
		
		System.out.println(sender.accountBalance+"\t"+receiver.accountBalance);
		
		sender.transactionID++;
		sender.transcationType = "Credit";
		sender.remarks = "Funds Transfer to Acc"+racctNo;
		sender.transactionAmount = transferAmount;
		
		receiver.transactionID++;
		receiver.transcationType = "Credit";
		receiver.remarks = "Funds Transfer from Acc"+sacctNo;
		receiver.transactionAmount = transferAmount;
		
		
		
		
		
	}
	
	
	public void miniStatement(ArrayList<Customer> customers,int acctNo){
		
		int s=0;
		for(Customer c:customers){
			
			while(c.accountNo==acctNo){
				s++;
				break;
				
			}	
			
			
		}
		
		
		Customer customer = customers.get(1);
		
		for(Transactions trans:customer.transcations){
			
			System.out.println(trans.transactionID+trans.remarks+trans.transcationType+trans.transactionAmount);
		}
		
	}
	
	
/*	public static void main(String arg[]){
		
		Customer c = new Customer();
		c.addCustomers();
		c.showCustomers();
		Process p = new Process();
		p.checkBalance(c.customers, 102);
	} */
}
