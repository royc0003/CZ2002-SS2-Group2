import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.IOException;
import java.util.ArrayList;

public class BookingManager extends CineplexManager implements Serializable {
	ArrayList<BookingOrder> orderList;

	public BookingManager() {
		this.orderList = new ArrayList<BookingOrder>();
//		ArrayList<BookingOrder> trialList = null;
//		try {
//			System.out.println("Reading from BookingOrder.dat -----------");
//			trialList = (ArrayList) MainCSVHelper.readSerializedObject("BookingOrder.dat"); // reads from movie and showtime
//			this.orderList = trialList; // tries to assign the arraylist of objects to current listofmovie and hsowtimes
//		} catch (Exception e) {
//			System.out.println("Exception >> " + e.getMessage());
//		}

	}



//------------------ Main Methods -----------------------------------------------------------------------------------------------
public ArrayList<BookingOrder> getOrderList(){
		return this.orderList;
}
public void makeNewOrder(int customerID, PriceManager priceManager) {
	
	//initializeBookingOrder();
	int day = getDate();

	BookingOrder bookingOrder = new BookingOrder(customerID, this.orderList.size()+1);
	orderList.add(bookingOrder);

	bookingOrder = orderList.get(this.orderList.size()-1);

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
		for(int ict = 0; ict < MovieManager.listOfMovieAndShowtimes.size(); ict++)
		{
			if(MovieManager.listOfMovieAndShowtimes.get(ict).getMovieID() == movieID)
			{
				for(int xy = 0; xy < count; xy++)
				{
					MovieManager.listOfMovieAndShowtimes.get(ict).getMovie().addToNoOfTicketSold();
				}
			}
		}
		
		for(int i=0 ;i< count ; i++) {
		  System.out.println("Reserve the seat "+ (i+1) + ": ");
		  String seatID = bookSeats(cinemaID, customerID, c);
		  bookingOrder.setSeatID(seatID);
		  }

		double totalPrice = calculateTotalPrice(priceManager,bookingOrder.getOrderNo(), day );
		bookingOrder.setTotalPrice(totalPrice);
		payment(bookingOrder,priceManager, cinemaID);


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

		for(int ict = 0; ict < MovieManager.listOfMovieAndShowtimes.size(); ict++)
		{
			if(MovieManager.listOfMovieAndShowtimes.get(ict).getMovieID() == movieID2)
			{
				for(int xy = 0; xy < count2; xy++)
				{
					MovieManager.listOfMovieAndShowtimes.get(ict).getMovie().addToNoOfTicketSold();
				}
			}
		}
		
		for(int i=0 ;i< count2 ; i++) {
		  String seatID2 = bookSeats(cinemaID2, customerID, c2);
		  bookingOrder.setSeatID(seatID2);
		  }


		double totalPrice1 = calculateTotalPrice(priceManager,bookingOrder.getOrderNo() , day);
		bookingOrder.setTotalPrice(totalPrice1);
		payment(bookingOrder,priceManager, cinemaID2);

		break;}
	}


	System.out.println("Saving newOrder into  BookingOrder.dat************");
	MainCSVHelper.writeSerializedObject("BookingOrder.dat", this.orderList); // for saving

	//saveBookingOrderCSV(this.orderList);
	
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
	
	//initializeCineplex();

	printCineplexlist();
	Scanner sc = new Scanner(System.in);
	int cin = sc.nextInt();
 
	
	Cineplex c = selectCineplex(cin);
	System.out.println(c.getCineplexID() + c.nameOfCineplex);
	return c;
}


public int getMovieIDChoice(Cineplex c) {
	Scanner sc = new Scanner(System.in);

//	// Choose movie ID to watch

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




public void viewBookingHistory(int customerID) {
	System.out.println("Size of ORderList: "+this.orderList.size());
	System.out.println("===========================================Booking History===================================================");
	System.out.println("  Customer ID  |  OrderNo  |  Cineplex       |  Movie Title  |  Showtime  |  No of Tickets  |  Total Price (SGD)  ");
	
	for(BookingOrder n: this.orderList) {
		if(n.getCustomerID() == customerID) {
			//System.out.println(n.getCustomerID() + "              | " + n.getOrderNo() + "          | " + selectCineplex(n.getCineplexID()).nameOfCineplex+ " | " + movieManager.getMovie(n.getMovieID()).getMovieTitle()  + " | " + n.getShowTime() + " | " + n.getNoOfTickets() + " | " + "$"+n.getTotalPrice() );
			System.out.println(n.getCustomerID() + "              | " + n.getOrderNo() + "          | " + n.getCineplexID()+ "               |     " + n.getMovieID() + "          | " + n.getShowTime() + "      | " + n.getNoOfTickets() + "              | " + "$"+n.getTotalPrice() );
		}
		
		
	}}
	public double calculateTotalPrice(PriceManager m, int orderNo, int day) {
		int i=0;
		for(BookingOrder n: orderList) {
			if(n.getOrderNo() == orderNo) {
				break;}

			i++;}

		BookingOrder n = orderList.get(i);
		m.setPriceRate(day);

		double totalPrice = m.getPricePerSeat()*n.getNoOfTickets();

		return totalPrice + (totalPrice*0.06);

	}

	public void payment(BookingOrder n, PriceManager priceManager, int CinemaID) {
		Scanner sc = new Scanner(System.in);
		System.out.println("  ");
		System.out.println("======Last step of the booking process: Payment=======");

		if(priceManager.getDiscountRate() == 0.6) {
			System.out.println("Student discount applied");
		}
		else if(priceManager.getDiscountRate() == 0.8) {
			System.out.println("Elderly Discount applied");
		}
		else if(priceManager.getDiscountRate() == 0.9) {
			System.out.println("CZ2002 Bank Card applied");
		}
		System.out.println("Total Price: SGD " + n.getTotalPrice());
		Date now = new Date();  // dow mon dd hh:mm:ss zzz yyyy

		SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMddhhmm");
		String dates = dateFormatter.format(now);


		System.out.println("(1) Pay");
		int choice = sc.nextInt();
		while(choice != 1) {
			System.out.println("Transaction unsuccessful");
			System.out.println("(1) Pay");
			choice = sc.nextInt();
		}


		System.out.println("Payment successful!");
		System.out.println("Transaction ID: " + CinemaID + dates);
	}

public void printTickets(BookingOrder n) {  //PRINT THE NUMBER OF TICKETS in the order... will have different seatID 
	int count = n.getNoOfTickets();
	int i=0;

	for(i=0; i<count ;i++) {
		System.out.println(" ");
		System.out.println(" ======= Ticket " + (i+1) + "===== ");
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

	public int getDate() {
		int day = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Would you like to book for \n(1) Today \n(2) Later Day");
		int bookchoice = sc.nextInt();
		int date,month,year;
		SimpleDateFormat simpleDateformat;

		switch(bookchoice) {
			case 1:
				Calendar c = Calendar.getInstance();
				day = c.get(Calendar.DAY_OF_WEEK);
				if(day != Calendar.SATURDAY && day != Calendar.SUNDAY){

					day = 1;
				}
				else {
					day = 0;
				}
				break;
			case 2:
				// dow mon dd hh:mm:ss zzz yyyy
				System.out.println("Enter date (dd)");
				date = sc.nextInt();
				System.out.println("Enter month (mm)");
				month = sc.nextInt();
				System.out.println("Enter year (yyyy)");
				year = sc.nextInt();

				Date bookdate = new Date(date,month,year);
				simpleDateformat = new SimpleDateFormat("EEEE"); // the day of the week spelled out completely
				String dayname = simpleDateformat.format(bookdate);
				if(dayname != "Saturday" && dayname != "Sunday") {
					day = 1;
				}
				else {
					day = 0;
				}
		}

		return day;

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


