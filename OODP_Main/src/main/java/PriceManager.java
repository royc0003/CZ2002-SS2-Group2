import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Calculates the total price of all the tickets booked, taking booking day and discounts in consideration
 *
 */
public class PriceManager implements Serializable {
	/**
	 * rate of watching a movie on a weekday 
	 */
	private double WEEKDAY_RATE = 1.0;
	
	/**
	 * rate of watching a movie on a weekend
	 */
	private double WEEKEND_RATE = 1.5;
	
	/**
	 * normalised price rate
	 */
	private double priceRate = 1.0;
	/**
	 * price per seat
	 */
	private double pricePerSeat;
	
	/**
	 * discounts applied
	 */
	private Boolean discountApplied = false;
	/**
	 * discount rate
	 */
	private double discountRate=1.0;
	/**
	 * standard price
	 */
	private int standardPrice = 10;

	/**
	 * sets the Price rate for the user, including discounts and day of ticket booking 
	 */
	public void setPriceRate(int day){
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



		if (discountApplied == true) {
			priceRate = discountRate;
		}

		if(day == 1){
			priceRate *= WEEKDAY_RATE;
		}
		else {
			priceRate *= WEEKEND_RATE;
		}

		this.pricePerSeat = standardPrice*priceRate;
	}
	/**
	 * gets price per seat rate
	 * @return price per seat rate
	 */
	public double getPricePerSeat() {
		return this.pricePerSeat;
	}
	/**
	 * gets discount rate
	 * @return discount rate
	 */
	public double getDiscountRate() {
		return this.discountRate;
	}
	/**
	 * Changes the weekend and weekday rate 
	 */
	public void changeRates() {
		System.out.println("(1) Weekend Rate: Current price rate is "+ WEEKEND_RATE);
		System.out.println("(2) Weekday Rate: Current price rate is "+ WEEKDAY_RATE);

		System.out.println("What rate will you want to change?");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();

		if(choice == 1) {
			System.out.println("What is the new Weekend Rate?");
			double pr1 = sc.nextDouble();
			this.WEEKEND_RATE = pr1;
		}
		else {
			System.out.println("What is the new Weekday Rate?");
			double pr2 = sc.nextDouble();
			this.WEEKDAY_RATE = pr2;
		}
	}


}