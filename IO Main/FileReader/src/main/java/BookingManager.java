import java.util.Scanner;
import java.util.ArrayList;

public class BookingManager extends CineplexManager {

private static int totalBookingOrders = 1; 
ArrayList<BookingOrder> orderList = new ArrayList<BookingOrder>(); 

public BookingManager() { //constructor
	
	
}

public void makenewOrder(int customerID) {
	
	BookingOrder bookingOrder = new BookingOrder(customerID, totalBookingOrders); 
	System.out.println("Which method do you prefer? ");
	System.out.println("(1) Choose Cineplex first ");
	System.out.println("(2) Choose Movie first");
	
	Scanner sc = new Scanner(System.in);
	int choice = sc.nextInt();
	
	switch(choice) {
	case 1:
		Cineplex c = getCineplexChoice();
		
		int movieID = getMovieIDChoice(c);
		bookingOrder.setMovieID(movieID);
		
		String showTime = getShowtimeChoice(movieID, c);
		bookingOrder.setShowTime(showTime);
		
		int cinemaID = getCinemaID(showTime, movieID, c);
		getSeatMap(cinemaID, c);  //print seatmap of that cinema
		
		
		System.out.println("How many seats will you book?");
		int count = sc.nextInt();
		bookingOrder.setNoOfTickets(count);
		
		for(int i=0 ;i< count ; i++) {
		  String seatID = bookSeats(cinemaID, customerID, c);
		  bookingOrder.setSeatID(seatID);
		  }
		
		PriceManager pm = new PriceManager();
		double totalPrice = calculateTotalPrice(pm)*bookingOrder.getNoOfTickets();
		bookingOrder.setTotalPrice(totalPrice);
		
		
		break;
	
	case 2:
		bookingThroughMovieList();
		break;
	}
	
	totalBookingOrders++;
	
	
}

public void viewHistory(int customerID) {
	
	
}

public Cineplex getCineplexChoice() {
	System.out.println("Which cineplex would you prefer to watch at?");
	printCineplexlist();
	Scanner sc = new Scanner(System.in);
	int cin = sc.nextInt();
		
	int cinID = cineplexList.get(cin-1).cineplexID;   		//selectCineplex from CineplexManager
	Cineplex c = selectCineplex(cinID);
	return c;
}


public int getMovieIDChoice(Cineplex c) {
	Scanner sc = new Scanner(System.in);

	displayMovieListOfCineplex(c); 							//print movielist of that cineplex

	System.out.println("Which movie do you want to watch?");
	int movieID = sc.nextInt();
	return movieID;
}


public String getShowtimeChoice(int movieID, Cineplex c) {
	Scanner sc = new Scanner(System.in);

	c.displayAllShowtimes(movieID);
	System.out.println("Which showtimes do you want to choose?");
	String showtime = sc.next();  //ERROR HANDLING 
	
	return showtime;
}

public void getSeatMap(int cinemaID, Cineplex c) {
	 c.getSeatMapOfCinema(cinemaID);

}

public int getCinemaID(String showTime, int movieID, Cineplex c) {
	int cinemaID= c.selectShowtime(showTime, movieID);
	return cinemaID;
}

public String bookSeats(int cinemaID, int customerID, Cineplex c) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please choose an empty seat (row and column): ");
		int row = sc.nextInt(); 
		int col = sc.nextInt();
		String SeatID = Integer.toString(row) + "." + Integer.toString(col);
		
		c.bookSeatAtCinema(cinemaID, SeatID, customerID); //book seat
		
		return SeatID;

		}
	
	
	


public void bookingThroughMovieList() {
	
	System.out.println("Which movies do you want to watch at?");
	movieManager.printGlobalListOfMovieIDs();
	Scanner sc = new Scanner(System.in);
	int cin = sc.nextInt();
	
	
	
	
	
	
}



public double calculateTotalPrice(PriceManager m) {
	

	return m.getPriceRate();
	
}

