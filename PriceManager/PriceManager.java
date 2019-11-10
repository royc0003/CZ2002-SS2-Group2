package SS2Assignment;

import java.util.Calendar;
import java.util.Scanner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceManager{
	private final double WEEKDAY_RATE = 1.0;
	private final double WEEKEND_RATE = 1.5;
	private double priceRate = 1.0;
	private Boolean discountApplied = false;
	private int noOfTickets; 
	private double discountRate=1.0;
	
	private void setPriceRate(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you qualify for any discount? \n");
		System.out.println("1. Yes! \n");
		System.out.println("2. Nope \n");
		int discount = sc.nextInt();
		 
		if (discount == 1 ) {
			discountApplied = true;
			System.out.println("Which discount would you like to use? \n");
			System.out.println("1. Student Discount \n");
			System.out.println("2. Elderly Discount \n");
			System.out.println("3. CZ2002 Bank card User \n");
			int discountIdentity = sc.nextInt();
			switch (discountIdentity) {
			case 1:{ System.out.println("Congratulations! You have applied for Student Discount \n Remember to get a valid identification card for our staff to check at the entrace of the cinema ");;
			discountRate = 0.6;
			break;}
			case 2:{ System.out.println("Congratulations! You have applied for Elderly Discount \n Remember to get a valid identification card for our staff to check at the entrace of the cinema ");;
			discountRate = 0.8;
			break;}
			case 3:{ System.out.println("Congratulations! You have applied to pay using CZ2002 Bank Card \n");;
			discountRate = 0.9;
			break;}
			}
		}
		
		Calendar c = Calendar.getInstance();
		int day = c.get(Calendar.DAY_OF_WEEK);
		
		if (discountApplied == true) {
			priceRate = discountRate;
		}
		
		if(day != Calendar.SATURDAY || day != Calendar.SUNDAY){
			priceRate *= WEEKDAY_RATE;
		}
		else {
			priceRate *= WEEKEND_RATE; 
		}
		
		priceRate = priceRate*noOfTickets; 
	}
	
	public double getPriceRate() {
		return priceRate;
	}
    
}
