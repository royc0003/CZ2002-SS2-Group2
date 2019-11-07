import java.util.ArrayList;

public class Cineplex 
{

	public int cineplexID;
	public String nameOfCineplex;
	private String location;
	private int no_of_cinema;
	private ArrayList<Cinema> cinemaList = new ArrayList<Cinema>(); //array list of cinemas
	private ArrayList<MovieAndShowtimes> localListOfMovieAndShowTimes; // would store the movie objects for the cinema

	
//---------------------Constructor---------------------------------------------------------------------------------------	
	
	public Cineplex(int cineplexID, String name, String location, int no_of_cinema) 
	{
		this.cineplexID = cineplexID;
		this.nameOfCineplex = name;
		this.location = location;
		this.no_of_cinema = no_of_cinema;
		 
		for(int i=0; i<no_of_cinema ;i++) //creates number of cinemas
		{
			cinemaList.add(new Cinema(i+1));
		}	
	}
	

//-------------------------Get methods-----------------------------------------------------
	
	public int getCineplexID() 
	{
		return cineplexID;
	}
	
	public String getCineplexName()
	{
		return nameOfCineplex;
	}
	
	public int getNumberOfCinemas() 
	{
		return no_of_cinema;
	}
	
	public String getLocationCineplex() 
	{
		return location;
	}
	
	public void getSeatMapOfCinema(int cinema_no) 
	{
		cinemaList.get(cinema_no).showseats();
	}
	
	
//-------------------------Display methods--------------------------------------------------------------------------------------------------
	
	public void displayAvailableMovies() //display available movies in a cinema
	{
		for(int i=0; i< localListOfMovieAndShowTimes.size(); i++)
		{
			System.out.println(localListOfMovieAndShowTimes.get(i).getMovieTitle());
		}
	}
	
	public void displayShowtimes(MovieAndShowtimes m) //display movie and its show times for a particular cineplex
	{
		System.out.println("Showtimes available for " + m.getMovieTitle + " are:");
		for(int i = 0; i< getShowList.size(); i++)
		{
			System.out.println(getShowList.get(i).getShowBegins);
		}
	}

//----------------------------Main methods--------------------------------------------------------------
	
	public void addMovieToCineplex(MovieAndShowtimes object) //ADD MOVIE AND SHOWTIMES 
	{
		localListOfMovieAndShowTimes.add(object);
	}
	
	public void bookSeatAtCinema(int cinema_no, String seat_id, int cust_id) 
	{
		cinemaList.get(cinema_no).bookseat(seat_id, cust_id);
		
	}
	

	public void createShowtimesAndAssignToCinema(MovieAndShowtimes movieAndShowtimes) 
	//check if movie exists in local movie list first before proceeding
	{
		movieAndShowtimes.createShowTime();
		//assignment to cinema to be completed
		
	}
	
	public void updateShowtimeToCinema() //delete show time and adds a new showtime
	{
		deleteShowtimeToCinema();
		//createShowtimesAndAssignToCinema(MovieAndShowtimes m);
	}
	
	public void deleteShowtimeToCinema()
	{
		
	}
	
	public void selectShowtime() 
	{
		
	}
	
	
}
