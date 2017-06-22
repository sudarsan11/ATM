import java.util.Scanner;
public class UI {
	
	public static void main(String[] args) {
			
			Scanner input = new Scanner(System.in);
			int choice;
			String e,q;
			
			Customer c = new Customer();
			
			
			do{
				System.out.println("Enter your choices"+"1)Load Cash to ATM"+"2)Show customer details"+"3)Show ATM operations");
				choice = input.nextInt();
				
				switch(choice){
				
				
					case 1:
						Atm a = new Atm();
						break;
						
					case 2:	
						c.addCustomers();
						c.showCustomers();
						break;
						
					case 3:
						Process p = new Process();
						
						
						do{
							
							System.out.println("Enter your choices"+"1)Check balance"+"2)Withdraw"+"3)Transfer"+"4)Mini Statment");
							int ch = input.nextInt();
							
							switch(ch){
							
							
								case 1:
									p.checkBalance(c.customers,101);
									break;
								case 2:
									p.withdrawMoney(c.customers,5432, 102);
									break;
									
								case 3:
									p.transferMoney(c.customers);
									break;
									
								case 4:
									p.miniStatement(c.customers,102);
									break;
									
								default:
									
							}
						

							System.out.println("Do you want to continue ?");
							q=input.next(); 
						}while(q!="n");
						
						
					default:
						
				}
				
			
				System.out.println("Do you want to continue ?");
				e=input.next(); 
				
		}while(e!="n");

	}

			
}
