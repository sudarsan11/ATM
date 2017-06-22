import java.util.*;
public class Atm {

	int currency,atmBalance;
	int[] denominations = new int[3];
	ArrayList<Atm> ar = new ArrayList<Atm>();
	
	Atm(){
		
		
		denominations[0] = 20;
		denominations[1] = 100;
		denominations[2] = 300;
		
		currency = (denominations[0]*1000)+(denominations[1]*500)+(denominations[2]*100);
		atmBalance = currency;
	}
	
	
}
