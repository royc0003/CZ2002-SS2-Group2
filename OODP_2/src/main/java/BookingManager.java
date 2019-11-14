import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;

public class BookingManager extends CineplexManager {
	private static int totalBookingOrders = 1; 
	ArrayList<BookingOrder> orderList;

	public BookingManager() {
		this.orderList = new ArrayList<BookingOrder>(); 

	}

public int getTotalBookingOrders() {
	return this.totalBookingOrders;
}

//------------------ Main Methods -----------------------------------------------------------------------------------------------

public void makeNewOrder(int customerID, PriceManager priceManager) {
	
	//initializeBookingOrder();

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
		System.out.println("Get CINEPLEX ID");
		bookingOrder.setCineplexID(cineplexID);
		
		System.out.println("going to movie id");
		int movieID = getMovieIDChoice(c);
		
		System.out.println("after movie id");

		bookingOrder.setMovieID(movieID);
		
		String showTime = getShowtimeChoice(movieID, c);
		bookingOrder.setShowTime(showTime);
		
		int cinemaID = getCinemaID(showTime, movieID, c);
		getSeatMap(cinemaID, c);  //print seatmap of that cinema
		
		
		System.out.println("How many seats will you book?");
		int count = sc.nextInt();
		bookingOrder.setNoOfTickets(count);
		
		for(int i=0 ;i< count ; i++) {
		  System.out.println("Reserve the seat "+ (i+1) + ": ");
		  String seatID = bookSeats(cinemaID, customerID, c);
		  bookingOrder.setSeatID(seatID);
		  }
		
		double totalPrice = calculateTotalPrice(priceManager,bookingOrder.getOrderNo() );
		bookingOrder.setTotalPrice(totalPrice);
		
		
		break;}
	
	case 2:{
		int movieID2 = getMovieIDfromGlobalMovieList();
		bookingOrder.setMovieID(movieID2);
		Cineplex c2 = showListofCineplex(movieID2); //CineplexIDcustomerchoose
		if(c2 == null) {
			break;
		}
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
		
		
		double totalPrice1 = calculateTotalPrice(priceManager,bookingOrder.getOrderNo() );
		bookingOrder.setTotalPrice(totalPrice1);
	
		break;}
	}
	

	totalBookingOrders++;
	
	saveBookingOrderCSV(this.orderList);
	
	System.out.println("Would you want to print your tickets?");
	System.out.println("(1) Yes");
	System.out.println("(2) No");
	
	int ch = sc.nextInt();
	if(ch == 1) {
		printTickets(bookingOrder);
	}

	
}


public Cineplex getCineplexChoice() {
	System.out.println("Which cineplex would you prefer to watch at?");
	
	initializeCineplex();

	printCineplexlist();
	Scanner sc = new Scanner(System.in);
	int cin = sc.nextInt();
 
	
	Cineplex c = selectCineplex(cin);
	System.out.println(c.getCineplexID() + c.nameOfCineplex);
	return c;
}


public int getMovieIDChoice(Cineplex c) {
	Scanner sc = new Scanner(System.in);
   
	// Make movies
	System.out.println("______Creating movies_______");
	movieManager.createMovieCreator();
	movieManager.printDetails(movieManager.getListOfMovieAndShowtimes());
	
	// see the cineplex
	printCineplexlist();
	 System.out.println("Choose the cineplex ID");
	 int ID = sc.nextInt();
	 
	 //create cinema for existing cineplex
	System.out.println("______Creating cinemas for Cineplex" + c.cineplexID +"_______");
	 System.out.println("Choose the number of cinemas to create");
	 int no_of_cinema = sc.nextInt();
	 c.createCinema(no_of_cinema);
	 
	 
	// assign movie to cineplex
	System.out.println("______Assign Movie to Cineplex_______");
	 movieManager.printGlobalListOfMovieIDs();
	 System.out.println("Choose the movie ID");

	 int movieID = sc.nextInt();
	 
	assignMoviesToCineplex(selectCineplex(ID), movieID);
	 
	// make showtimes 
	
	System.out.println("______Add Showtimes to Movie_______");
	printCineplexlist();
	 System.out.println("Choose the cineplex ID you want to add showtimes to");
	 int cineplexID1 = sc.nextInt();
	 Cineplex c1 = selectCineplex(cineplexID1);	
	 c1.createShowtimesAndAssignToCinema();
	
	
	// Choose movie ID to watch 
    System.out.println("______Start Booking!_______");
	displayMovieListOfCineplex(c); 							//print movielist of that cineplex
	System.out.println("Which movie do you want to watch?");
	int movieID2 = sc.nextInt();
	return movieID2;
}


public String getShowtimeChoice(int movieID, Cineplex c) {
	Scanner sc = new Scanner(System.in);

	c.displayAllShowtimes(movieID);
	System.out.println("Choose the showtime - Write it in string");
	String showtime = sc.next();  //ERROR HANDLING 
	
	return showtime;
}

public void getSeatMap(int cinemaID, Cineplex c) {
	 c.getSeatMapOfCinema(cinemaID);

}

public int getCinemaID(String showTime, int movieID, Cineplex c) {
	int cinemaID= c.selectShowtime(showTime, movieID);
	
	System.out.println("CINEMA ID : " + cinemaID);
	return cinemaID;
}

public String bookSeats(int cinemaID, int customerID, Cineplex c) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Please choose the ROW for an empty seat: ");
		int row = sc.nextInt(); 
		System.out.println("Please choose the COlUMN for an empty seat: ");
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

	ArrayList<Cineplex> nlist = listOfCineplexWithMovieID(movieID);
	
	if(nlist.size() > 0) {
		System.out.println("===== Cineplexes Showing the Movie ======");
		System.out.println("");
		System.out.println("CineplexID			Name");
	
		int i=0;
		for(Cineplex n: nlist) {
			System.out.println("(" + n.getCineplexID() + ")" + "       			" + n.getCineplexName());
			i++;
		}
		
		System.out.println("Please choose your preferred Cineplex ID: ");
		int choice = sc.nextInt();
		
		
		Cineplex c = selectCineplex(choice);
		
		return 	c;}
	else {
		return null;
	}
		
}


public double calculateTotalPrice(PriceManager m, int orderNo) {
	int i=0;
	for(BookingOrder n: orderList) {
		if(n.getOrderNo() == orderNo) {
				break;}
		
		i++;}

	BookingOrder n = orderList.get(i);
	m.setPriceRate();
	
	double totalPrice = m.getPriceRate()*n.getNoOfTickets();
	

	return totalPrice;
	
	}


public void viewBookingHistory(int customerID) {
		
	System.out.println("===========================================Booking History===================================================");
	System.out.println("  Customer ID  |  OrderNo  |  Cineplex       |  Movie Title  |  Showtime  |  No of Tickets  |  Total Price (SGD)  ");
	
	for(BookingOrder n: orderList) {
		if(n.getCustomerID() == customerID) {
			//System.out.println(n.getCustomerID() + "              | " + n.getOrderNo() + "          | " + selectCineplex(n.getCineplexID()).nameOfCineplex+ " | " + movieManager.getMovie(n.getMovieID()).getMovieTitle()  + " | " + n.getShowTime() + " | " + n.getNoOfTickets() + " | " + "$"+n.getTotalPrice() );
			System.out.println(n.getCustomerID() + "              | " + n.getOrderNo() + "          | " + n.getCineplexID()+ " | " + n.getMovieID() + " | " + n.getShowTime() + " | " + n.getNoOfTickets() + " | " + "$"+n.getTotalPrice() );
			break;
		}
		
		
	}}


public void printTickets(BookingOrder n) {  //PRINT THE NUMBER OF TICKETS in the order... will have different seatID 
	int count = 1;
	int i=0;

	
	for(i=0; i<count ;i++) {
		System.out.println("");
		System.out.println(" ======= Ticket " + i+1 + "===== ");
		System.out.println("CustomerID: " + n.getCustomerID() );
		System.out.println("Order No: " + n.getOrderNo() );
		System.out.println("Total Price of Order: SGD" + n.getTotalPrice());
		System.out.println("Watching at " + selectCineplex(n.getCineplexID()).nameOfCineplex);
		System.out.println(" ");
		Movie movie = movieManager.getMovie(n.getMovieID());
		System.out.println("Movie: " + movie.getMovieTitle() );
		System.out.println("Starting Time: " + n.getShowTime() ); 
		System.out.println("Seat ID: " + n.getListOfSeatID().get(i) ); 

		System.out.println("__________________________________");
	}

}



//-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------
	
	  public void initializeBookingOrder(){ MainCSVHelper csvHelper = new
	  MainCSVHelper(); try {
	  System.out.println("**************************Initializing Objects....");
	  this.orderList = csvHelper.readFromBookingOrderCSV();
	  
	  } catch(IOException e){ e.getStackTrace();
	  System.out.println("Could not find the file"); } }
	 
	public void saveBookingOrderCSV(ArrayList<BookingOrder> orderList){
		MainCSVHelper csvHelper = new MainCSVHelper();
		try{
			System.out.println("***********************************Saving to CSV....");
			csvHelper.writeToBookingOrderCSV(orderList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


