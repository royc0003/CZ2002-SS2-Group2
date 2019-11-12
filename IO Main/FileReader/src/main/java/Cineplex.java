
import java.util.ArrayList;
import java.util.Scanner;
public class Cineplex 
{

	public int cineplexID;
	public String nameOfCineplex;
	private String location;
	private int no_of_cinema;
	private ArrayList<Cinema> cinemaList; //array list of cinemas
	private ArrayList<MovieAndShowtimes> localListOfMovieAndShowTimes; // would store the movie objects for the cinema

	
//---------------------Constructor---------------------------------------------------------------------------------------	
	
	public Cineplex(int cineplexID, String name, String location, int no_of_cinema) 
	{
		this.cineplexID = cineplexID;
		this.nameOfCineplex = name;
		this.location = location;
		this.no_of_cinema = no_of_cinema;
		
		this.cinemaList = new ArrayList<Cinema>();
		this.localListOfMovieAndShowTimes = new ArrayList<MovieAndShowtimes>();
		
		for(int i=0; i<no_of_cinema ;i++) //creates number of cinemas
		{

			Scanner sc3 = new Scanner(System.in);
			System.out.println("Now please choose the type of cinema you want to create:");
			System.out.println("Enter the type for the Cinema (" + (i+1) +"):");
			String type = sc3.next();

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
		System.out.println("");
		System.out.println("======Movie List in Cineplex " + nameOfCineplex + "========" );
		System.out.println("Movie ID                  Movie Title ");
		for(int i=0; i< SortMovieCopy2.length; i++)
		{
			System.out.println("(" + SortMovieCopy2[i].getMovieID() + ")                       " + SortMovieCopy2[i].getMovieTitle());
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
	

	public void createShowtimesAndAssignToCinema() 
	//check if movie exists in local movie list first before proceeding
	{
		displayAvailableMovies();
		System.out.println("");
		System.out.println("Enter the movie id that you want to add showtimes to");
		Scanner sc = new Scanner(System.in);
		int userInput = sc.nextInt(); 
		
		for(int i = 0; i< localListOfMovieAndShowTimes.size(); i++)
		{
			if( userInput == localListOfMovieAndShowTimes.get(i).getMovieID())
			{
				System.out.println("Enter the number of showtimes you want to insert");
				
				Scanner sc4 = new Scanner(System.in);
				int number = sc4.nextInt();
				
				for(int y = 0; y < number; y++)
				{
					System.out.println("Enter the starting time of the movie");
					Scanner sc1 = new Scanner(System.in);
					String showBegins = sc1.nextLine();
				
					//print cinema 
					printCinemaIdOfCineplex();
					System.out.println("");
					System.out.println("Enter the cinema ID");
					Scanner sc2 = new Scanner(System.in);
					int cinemaID = sc2.nextInt();
					
					localListOfMovieAndShowTimes.get(i).createShowTime(showBegins, localListOfMovieAndShowTimes.get(i).getMovie(), cinemaID);
					
					for(Cinema n : cinemaList) 
					{
						if(n.getCinemaID() == cinemaID) 
						{
							n.addShowTimeToList(localListOfMovieAndShowTimes.get(i).getShowTime(showBegins, cinemaID));
							System.out.println("Showtime added to array list in cinemaID: " + cinemaID);
						}
					}
				}
			}
		}
	}
	
	public void updateShowtimeToMovie() //delete show time and adds a new showtime
	{
		
		deleteShowTimeToMovie();
		createShowtimesAndAssignToCinema();	
	}
	
	public void deleteShowTimeToMovie()
	{
		displayAvailableMovies();
		System.out.println("");
		
		System.out.println("Enter MovieID of movie you want to delete showtime for");
		Scanner sc = new Scanner(System.in);
		int movieID = sc.nextInt();
		
		for(int i = 0; i< localListOfMovieAndShowTimes.size(); i++)
		{
			if(movieID == localListOfMovieAndShowTimes.get(i).getMovieID())
			{
				printCinemaIdOfCineplex();			//print cinema of cineplex
				System.out.println("");

				System.out.println("Choose a cinema to remove a showtime?");
				Scanner sc3 = new Scanner(System.in);
				int cinemaID= sc3.nextInt();
				
				displayShowTimesForCinema(cinemaID);
				System.out.println("");
				System.out.println("Which showtime do you want to remove?");
				Scanner sc2 = new Scanner(System.in);
				String showBegins= sc2.nextLine();
				
				//removes showtime object from cinema showtime list
				for(Cinema n: cinemaList)
				{
					if(n.getCinemaID() == cinemaID)
					{  
						n.removeShowTimeToList(localListOfMovieAndShowTimes.get(i).getShowTime(showBegins, cinemaID));
						System.out.println("Showtime removed in arraylist");
					}
				}
				//removes the showtime of the movie in the cineplex local list 
				localListOfMovieAndShowTimes.get(i).removeShowTime(showBegins, cinemaID);
				System.out.println("Showtime removed.");
				
				
			}
		}
	}
	
	public ArrayList<ShowTime> getListOfShowTimesForCinema(int cinemaID) 
	{
		for(Cinema n: cinemaList) {
			if(n.getCinemaID() == cinemaID) {
				return n.getListOfShowTime();
			}
		}
		return null;
	}
	

	public void displayShowTimesForCinema(int cinemaID)
	{
		for(Cinema n: cinemaList) 
		{
			if(n.getCinemaID() == cinemaID) 
			{	
				n.displayShowTimesForCinema();
			}
		}
	}
	
	public int selectShowtime(String showtime, int movieID)  //RETURNS CINEMA ID of the showtime
	{	
		MovieAndShowtimes m = new MovieAndShowtimes();
		int cinemaID = -1; 
		for(int i=0; i < localListOfMovieAndShowTimes.size(); i++) {
			if(movieID == localListOfMovieAndShowTimes.get(i).getMovieID()) {
				m= localListOfMovieAndShowTimes.get(i);}}
			
		
		ArrayList<ShowTime> stList = new ArrayList<ShowTime>();
		stList = m.getArrayOfShowTimes();
	
		for(ShowTime n: stList) {
			if(n.getShowBegins().equals(showtime)) {
				return n.getShowTimeCinemaID();
			}
		}
		
		return -1;
	}	
	
	public MovieAndShowtimes[] sortMovieID(){
			
		MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[localListOfMovieAndShowTimes.size()];
			
			for(int i=0; i<localListOfMovieAndShowTimes.size(); i++) {
				SortMovieCopy[i]= localListOfMovieAndShowTimes.get(i);
			}
			
			if(SortMovieCopy.length > 1) {
				for(int i=0; i< SortMovieCopy.length-1; i++) {
					if(SortMovieCopy[i].getMovieID() > SortMovieCopy[i+1].getMovieID()  ) {
						MovieAndShowtimes temp = SortMovieCopy[i+1];
						SortMovieCopy[i] = SortMovieCopy[i+1];
						SortMovieCopy[i+1] = temp;
					}
				}}
			return SortMovieCopy;
		}
	
	public int checkIfMovieExistInCineplex(int movieID)
	{
		for(MovieAndShowtimes m: localListOfMovieAndShowTimes)
		{
			if(m.getMovieID() == movieID)
			{
				return 1;
			}
		}
		return 0;
	}
	
	public void printCinemaIdOfCineplex()
	{ System.out.println("");
		System.out.println("==== List of available IDS in Cineplex " + nameOfCineplex + "====");
		System.out.println("Cinema ID                 Type");
		for(Cinema n: cinemaList)
		{
			System.out.println(n.getCinemaID() + "                         " + n.getType());
		}
	}
	
}
