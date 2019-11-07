package SS2Assignment;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceManager{
	private final double weekdayRate = 1.0;
	private final double weekendRate = 1.5;
	private double priceRate;
	private Boolean discountApplied;
	private int noOfTickets; 
	
	
	private void setPriceRate(){
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		if(day != Calendar.SATURDAY || day != Calendar.SUNDAY){
			priceRate = weekdayRate;
			if (discountApplied == true) {
				priceRate = 0.9*weekdayRate;
			}
		}
		else 
			priceRate *= weekendRate;
		
		priceRate = priceRate*noOfTickets; 
	}
	
	public double getPriceRate() {
		return priceRate;
	}
    
}
