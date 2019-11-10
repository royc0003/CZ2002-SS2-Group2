import java.util.Scanner;

public class BookingOrder extends CineplexManager {

	private int noOfTickets = 0;
	private int orderNo;
	private String showTime;
	private String seatID;
	private int movieID = 0;
	private int customerID;
	private double totalPrice =0;
	
	public BookingOrder(int customerID, int orderNo) {
		this.customerID = customerID; 
		this.orderNo = orderNo;
	}
	
	public void calculateTotalPrice() {
		//PriceManager p = new PriceManager;
		//totalPrice = ;
		
	}

	
	public void bookingThroughCineplex() {
		
		System.out.println("Which cineplex would you prefer to watch at?");
		printCineplexlist();
		Scanner sc = new Scanner(System.in);
		int cin = sc.nextInt();
			
		int cinID = cineplexList.get(cin).cineplexID;   		//selectCineplex from CineplexManager
		Cineplex c = selectCineplex(cinID);
		displayMovieListOfCineplex(c); 							//print movielist of that cineplex

		
		System.out.println("Which movie do you want to watch?");
		int movieID = sc.nextInt();
	
		c.displayAllShowtimes(movieID);
		System.out.println("Which showtimes do you want to choose?");

		
		c.selectShowtime(String showtime);
	
		
		
		//select showtime which will return seatmap of the cinema that is assigned to that showtime
		//bookseatmap - assign the seat
		//noOfTickets ++;
		
	}
	
	public void bookingThroughMovieList(CineplexManager m) {
		
	}
	
	public void bookingOrder(int orderNo) {
		
	}
	
	public String getSeatID(int customerID) {
		return seatID;
	}
	
	public double getTotalPrice() {
		return totalPrice;
	}
	
	
	
}