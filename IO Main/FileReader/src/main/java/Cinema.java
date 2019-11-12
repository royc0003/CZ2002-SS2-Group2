import java.util.ArrayList;


public class Cinema implements Serialization {

	private String type;

	private int seatingCapacity;

	public int cinema_no;

	private SeatManager seatManager;

	private ArrayList<ShowTime> listOfShowTimes = new ArrayList<ShowTime>(); //array list of cinemas


	

	public Cinema(int cinema_no, String type) 
	{
		seatManager = new SeatManager();
		this.cinema_no = cinema_no;
		this.seatingCapacity = 100;
		this.type = type;
		this.listOfShowTimes = new ArrayList<ShowTime>();
	}

	public void displayShowTimesForCinema()
	{	System.out.println("========= Cinema " + cinema_no + " Showtimes ============");
		System.out.println("Showtimes                 Movie ");
		for(int i = 0; i < listOfShowTimes.size(); i++)
		{
			System.out.println(listOfShowTimes.get(i).getShowBegins() + "                      " + listOfShowTimes.get(i).getMovieTitle());
		}
	}
	
	public ArrayList<ShowTime> getListOfShowTime()
	{
		return listOfShowTimes;
	}
	

	public String getType()
	{
		return type;
	}

	public int getCinemaID()
	{
		return cinema_no;
	}
	
	public void addShowTimeToList(ShowTime s)
	{
		listOfShowTimes.add(s);
	}
	
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
	
	public void showseats()
	{
		seatManager.seatmap();
		System.out.println("Number of Empty Seats:" + seatManager.getNumEmptySeats());
	}

	public void setType(String type) 
	{
		this.type = type;
	}

	public void bookseat(String seat_id, int cust_id) 
	{
		seatManager.assignSeat(seat_id, cust_id);
	}

	public void setSeatingCapacity(int seatingCapacity)
	{
		this.seatingCapacity = seatingCapacity;
	}

	@Override

	public String[] toCsv() {
		String[] csv = {Integer.toString(this.cinema_no), this.type, Integer.toString(this.seatingCapacity)};
		return csv;
	}

		

		

		

	

	

}