import java.util.ArrayList;
/**
Represents a Cinema that has a seat manager to manage the seats.
The cinema has a list of showtimes tag to it.
There can be many cinemas in a cineplex.
*/

public class Cinema implements Serialization {

	/**
	 * type of cinmea
	 */
	private String type;

	/**
	 * The number of seats in the cinema
	 */
	private int seatingCapacity;

	/**
	 * The unique ID of the Cinema 
	 */
	public int cinema_no;

	/**
	 * The seat manager that manages the seats
	 */
	private SeatManager seatManager;

	/**
	 * A list of showtimes for the cinema to show that at that show time, the cinema is in use. 
	 */
	private ArrayList<ShowTime> listOfShowTimes = new ArrayList<ShowTime>(); //array list of cinemas	
	private int cineplexID;

	 /**
	 * Creates a new Cinema with the given cinema number and type of the cinema.
	
	 * @param cinema_no the cinema number 
	 * @param type The type of the cinema ex. Gold, Beanieplex
	 */

	public Cinema(int cinema_no, String type, int cineplexID) 
	{
		seatManager = new SeatManager();
		this.cinema_no = cinema_no;
		this.seatingCapacity = 100;
		this.type = type;
		this.listOfShowTimes = new ArrayList<ShowTime>();
		this.cineplexID = cineplexID;
		
	}

	
	public Cinema(String[] items){
		this.type = items[0];
		this.seatingCapacity = Integer.parseInt(items[1]);
		this.cinema_no = Integer.parseInt(items[2]);
		this.cineplexID =  Integer.parseInt(items[3]);

	}
	

	
	 /**
		 * Display showtimes and movie that will be shown in the cinema
	
		 */
	public void displayShowTimesForCinema()
	{	
		
		System.out.println("========= Cinema " + cinema_no + " Showtimes ============");
		System.out.println("Showtimes                 Movie ");
		for(int i = 0; i < listOfShowTimes.size(); i++)
		{
			System.out.println(listOfShowTimes.get(i).getShowBegins() + "                      " + listOfShowTimes.get(i).getMovieTitle()());
		}
	}
	
	 /**
		 * Get list of showtimes of the cinema
		 * @return a list of showtime objects
	
		 */
	
	public ArrayList<ShowTime> getListOfShowTime()
	{
		return listOfShowTimes;
	}
	
	 /**
		 * Get the type of cinema
		 * @return the type of cinema
	
		 */

	public String getType()
	{
		return type;
	}

	
	 /**
	 * Get the cinema ID
	 * @return the cinema id
	 */
	
	public int getCinemaID()
	{
		return cinema_no;
	}
	
	/**
	 * Get the cinema ID
	 * @return the cinema id
	 */
	
	public int getCineplexID()
	{
		return cineplexID;
	}
	
	 /**
		 * Add another showtime to the list of showtimes of this cinema
		 */
		
	
	public void addShowTimeToList(ShowTime s)
	{
		listOfShowTimes.add(s);
	}
	
	 /**
		 * Remove existing showtime to the list of showtimes of this cinema
		 */
	
	public void removeShowTimeToList(ShowTime s) 
	{
		for(int i = 0; i<listOfShowTimes.size(); i++) 
		{ 
			if(s.getShowBegins().equals(listOfShowTimes.get(i).getShowBegins()) )
			{ 
				listOfShowTimes.remove(i); 
			} 
		} 
	 }
	
	 /**
		 * Display the seat map and the number of empty seats in this cinema
		 */
	
	public void showseats()
	{
		seatManager.seatmap();
		System.out.println("Number of Empty Seats:" + seatManager.getNumEmptySeats());
	}

	 /**
		 * Changes the type of the cinema
		 * @param type is the type of cinema
		 */
	public void setType(String type) 
	{
		this.type = type;
	}

	 /**
		 * To book a seat with the given seat id and customer id 
		 * @param seat_id seat id the customer wants to book
		 * @param cust_id the customer that is booking the seat
		 */
	public void bookseat(String seat_id, int cust_id) 
	{
		seatManager.assignSeat(seat_id, cust_id);
	}
	
	/**
	 * To change the seating capacity of the cinema
	 * @param seatingCapacity the number of seats in teh cinema
	
	 */

	public void setSeatingCapacity(int seatingCapacity)
	{
		this.seatingCapacity = seatingCapacity;
	}

	@Override

	public String[] toCsv() {
		String[] csv = { this.type, Integer.toString(this.seatingCapacity), Integer.toString(this.cinema_no),Integer.toString(this.cineplexID)};
		return csv;
	}

		

		

		

	

	

}