
import java.util.ArrayList;
import java.util.Scanner;
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

			Scanner sc3 = new Scanner(System.in);
			String type = sc3.nextLine();
			System.out.println("Enter the type for the cinema");
			cinemaList.add(new Cinema(i+1, type));
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
		MovieAndShowtimes[] SortMovieCopy2= new MovieAndShowtimes[localListOfMovieAndShowTimes.size()];
		SortMovieCopy2 = sortMovieID(); 
		for(int i=0; i< SortMovieCopy2.length; i++)
		{
			System.out.println("(" + i + ")" + SortMovieCopy2[i].getMovieTitle());
		}
	}
	

	public void displayAllShowtimes(int movieID) //display movie and its show times for a particular cineplex
	{
		MovieAndShowtimes m = new MovieAndShowtimes();

		for(int i=0; i < localListOfMovieAndShowTimes.size(); i++) {
			if(movieID == localListOfMovieAndShowTimes.get(i).getMovieID()) {
				m= localListOfMovieAndShowTimes.get(i);
			}
		}
		
		System.out.println("Showtimes available for " + m.getMovieTitle() + " are:");
		m.printListOfShowTimes();
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
	    
	    System.out.println("When would the showtime to start? ");
		Scanner sc3 = new Scanner(System.in);
	    String showBegin = sc3.next();
		
	    localListOfMovieAndShowTimes.createShowTime( showBegin , movie );
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
	
	public void selectShowtime(MovieAndShowtimes m) 
	{	
		showTime 
		for(int i=0;i<localListOfMovieAndShowTimes.size() ; i++) {
			localListOfMovieAndShowTimes.get(i).
		}
		
	
	}
	
	
	public MovieAndShowtimes[] sortMovieID(){
			
		MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[localListOfMovieAndShowTimes.size()];
			
			for(int i=0; i<localListOfMovieAndShowTimes.size(); i++) {
				SortMovieCopy[i]= localListOfMovieAndShowTimes.get(i);
			}
			
			for(int i=0; i< SortMovieCopy.length; i++) {
				if(SortMovieCopy[i].getMovieID() > SortMovieCopy[i+1].getMovieID()  ) {
					MovieAndShowtimes temp = SortMovieCopy[i+1];
					SortMovieCopy[i] = SortMovieCopy[i+1];
					SortMovieCopy[i+1] = temp;
				}
			}
			return SortMovieCopy;
		}
		
	
}
