import java.util.Scanner;
import java.util.ArrayList;

public class BookingManager extends CineplexManager {

public BookingManager() {
	
}
private static int totalBookingOrders = 1; 
ArrayList<BookingOrder> orderList = new ArrayList<BookingOrder>(); 


public int getTotalBookingOrders() {
	return this.totalBookingOrders;
}

//------------------ Main Methods -----------------------------------------------------------------------------------------------

public void makeNewOrder(int customerID) {
	
	orderList.add(new BookingOrder(customerID, totalBookingOrders));
	BookingOrder bookingOrder = orderList.get(totalBookingOrders-1);
	System.out.println("Which method do you prefer? ");
	System.out.println("(1) Choose Cineplex first ");
	System.out.println("(2) Choose Movie first");
	
	Scanner sc = new Scanner(System.in);
	int choice = sc.nextInt();
	
	switch(choice) {
	case 1:{
		Cineplex c = getCineplexChoice();
		
		int cineplexID = c.getCineplexID();
		bookingOrder.setCineplexID(cineplexID);
		
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
		
		
		break;}
	
	case 2:{
		int movieID2 = getMovieIDfromGlobalMovieList();
		bookingOrder.setMovieID(movieID2);
		Cineplex c2 = showListofCineplex(movieID2); //CineplexIDcustomerchoose
				
		int cineplexID2 = c2.getCineplexID();
		bookingOrder.setCineplexID(cineplexID2);
				
		String showTime2 = getShowtimeChoice(movieID2, c2);
		bookingOrder.setShowTime(showTime2);
		

		int cinemaID2 = getCinemaID(showTime2, movieID2, c2);
		getSeatMap(cinemaID2, c2);  //print seatmap of that cinema
		
		
		System.out.println("How many seats will you book?");
		int count2 = sc.nextInt();
		bookingOrder.setNoOfTickets(count2);
		
		for(int i=0 ;i< count2 ; i++) {
		  String seatID2 = bookSeats(cinemaID2, customerID, c2);
		  bookingOrder.setSeatID(seatID2);
		  }
		
		PriceManager pm = new PriceManager();
		double totalPrice = calculateTotalPrice(pm)*bookingOrder.getNoOfTickets();
		bookingOrder.setTotalPrice(totalPrice);
	
		break;}
	}
	

	totalBookingOrders++;
	
	System.out.println("Would you want to print your tickets?");
	System.out.println("(1) Yes");
	System.out.println("(2) No");
	
	int ch = sc.nextInt();
	if(ch == 1) {
		printTickets(bookingOrder.getOrderNo());
	}

	
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
	
	
public int getMovieIDfromGlobalMovieList() {

	System.out.println("Which movies do you want to watch at?");
	movieManager.printGlobalListOfMovieIDs();
	Scanner sc = new Scanner(System.in);
	int movieID = sc.nextInt();
	
	return movieID;
}

public Cineplex showListofCineplex(int movieID) {
	Scanner sc = new Scanner(System.in);

	ArrayList<Cineplex> nlist = new ArrayList<Cineplex>();
	
	nlist = listOfCineplexWithMovieID(movieID);
	
	System.out.println("===== Cineplexes Showing the Movie ======");
	System.out.println("");
	System.out.println("CineplexID			Name");

	int i=0;
	for(Cineplex n: nlist) {
		System.out.println("(" + i + ")" + "       			" + n.getCineplexName());
		i++;
	}
	
	System.out.println("Please choose your preferred Cineplex ID: ");
	int choice = sc.nextInt();
	
	return 	nlist.get(choice-1);
	
}


public double calculateTotalPrice(PriceManager m) {
	
	return m.getPriceRate() ;
	}


public void viewBookingHistory(int customerID) {
	
	System.out.println("===========================================Booking History===================================================");
	System.out.println("  Customer ID  |  OrderNo  |  Cineplex  |  Movie Title  |  Showtime  |  No of Tickets  |  Total Price (SGD)  ");
	
	for(BookingOrder n: orderList) {
		if(n.getCustomerID() == customerID) {
			System.out.print(n.getCustomerID() + " | " + n.getOrderNo() + " | " + selectCineplex(n.getCineplexID()).nameOfCineplex+ " | ");
			System.out.print(movieManager.getMovie(n.getMovieID()).getMovieTitle()  + " | " + n.getShowTime() + " | " + n.getNoOfTickets() + " | " + "$"+n.getTotalPrice() );
		}
		
		
	}}


public void printTickets(int orderNo) {  //PRINT THE NUMBER OF TICKETS in the order... will have different seatID 
	int count = 1;
	
	int i=0;
	for(BookingOrder n: orderList) {
		if(n.getOrderNo() == orderNo) {
			if(n.getNoOfTickets()>1) {
				count = n.getNoOfTickets();
				break;}
		}
		i++;
	}
	BookingOrder n = orderList.get(i);

	
	for(i=0; i<count ;i++) {
		System.out.println("");
		System.out.println(" ======= Ticket " + i+1 + "===== ");
		System.out.println("CustomerID: " + n.getCustomerID() );
		System.out.println("Order No: " + n.getOrderNo() );
		System.out.println("Watching at " + selectCineplex(n.getCineplexID()).nameOfCineplex);
		System.out.println(" ");
		
		System.out.println("Movie: " + movieManager.getMovie(n.getMovieID()).getMovieTitle() );
		System.out.println("Starting Time: " + n.getShowTime() ); 
		System.out.println("Seat ID: " + n.getListOfSeatID().get(i) );   

		System.out.println("__________________________________");
	}

}

}


