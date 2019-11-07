import java.util.ArrayList;

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
		PriceManager p = new PriceManager;
		totalPrice = ;
		
	}

	
	public void bookingThroughCineplex(CineplexManager m) {
		
		//selectCineplex from CineplexManager
		//print movielist of that cineplex
		//selectmovie("Joker")
		//getshowlist("Joker") for that movie
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
