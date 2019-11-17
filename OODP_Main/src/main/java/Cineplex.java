import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.io.IOException;
/**
 * Represents a Cineplex that has many cinemas in it
 * The cineplex has a local list of movies that it is currently showing
 */

public class Cineplex implements Serializable
{


	/**
	 *the unique ID that identifies the cineplex
	 */
	public int cineplexID;
	/**
	 *name of cineplex
	 */
	public String nameOfCineplex;
	/**
	 *location of cineplex
	 */
	private String location;
	/**
	 *the total number of cinemas in the cineplex
	 */
	private int no_of_cinema;
	/**
	 *the list of cinema objects in the cineplex
	 */
	private ArrayList<Cinema> cinemaList; //array list of cinemas
	
	/**
	 *the local list of Movie and Showtimes objects in the cineplex 
	 */
	private ArrayList<MovieAndShowtimes> localListOfMovieAndShowTimes; // would store the movie objects for the cinema

	
//---------------------Constructor---------------------------------------------------------------------------------------	
	
	/**
	 *Create Cineplex with the given cineplex id, name of the cineplex, location and number of cinemas the cineplex will have
	 *It will also create the list of movie and showtime objects tag to the cineplex
	 *With the number of cinemas, it create cinemas according to the number in the cineplex
	 *@param cineplexID unique identity of the cineplex
	 *@param name name of cineplex
	 *@param location location of cineplex
	 *@param no_of_cinema total number of cinemas in the cineplex
	 */
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
			//saveCinemaCSV(this.cinemaList);
		}	
	}
	/** 
	 * initialise Cineplex
	 * @param item
	 */
	public Cineplex(String[] item){
		this.cineplexID = Integer.parseInt(item[0]);
		this.nameOfCineplex = item[1];
		this.location = item[2];
		this.no_of_cinema = Integer.parseInt(item[3]);

	}
	
	

//-------------------------Get methods-----------------------------------------------------

	
	/**
	 * Get cineplex ID of this cineplex
	 *  @return this cineplex id
	 */
	public int getCineplexID() 
	{   
		return cineplexID;
	}

	public void getLocalMovieList(){
		for(MovieAndShowtimes n: localListOfMovieAndShowTimes){
			System.out.println("MovieID " + n.getMovieID());
		}

	}

	
	public void createCinema(int no_of_cinema) {  //CREATE CINEMA OBJECTS for each "old" cineplex bc we didnt create this cineplex
		
		this.cinemaList = new ArrayList<Cinema>();
		
		for(int i=0; i<no_of_cinema ;i++) //creates number of cinemas
		{

			Scanner sc3 = new Scanner(System.in);
			System.out.println("Now please choose the type of cinema you want to create:");
			System.out.println("Enter the type for the Cinema (" + (i+1) +"):");
			String type = sc3.next();

			cinemaList.add(new Cinema(i+1, type));
			//saveCinemaCSV(this.cinemaList);
		}	
	}
	
	/**
	 * Get cineplex name of this cineplex
	 *  @return this cineplex name
	 */
	public String getCineplexName()
	{
		return nameOfCineplex;
	}
	
	/**
	 * Get number of cinemas in cineplex
	 *  @return number of cinemas 
	 */
	public int getNumberOfCinemas() 
	{
		return no_of_cinema;
	}
	
	/**
	 * Get location of the cineplex
	 *  @return location of cineplex
	 */
	
	public String getLocationCineplex() 
	{
		return location;
	}
	
	/**
	 * Get seatmap of a specific cinema in this cineplex
	 */
	
	
	public void getSeatMapOfCinema(int cinema_no) 
	{
		for(Cinema n: cinemaList ) {
			if(cinema_no == n.getCinemaID()) {
				n.showseats();
			}
		}
		
		
		//cinemaList.get(cinema_no).showseats();
	}
	
	public void InitializeList() {
		this.localListOfMovieAndShowTimes = new ArrayList<MovieAndShowtimes>();
	}
	
//-------------------------Display methods--------------------------------------------------------------------------------------------------
	
	/**
	 * Display all the movies in the cineplex along with its movie id and title
	 * the movies are sorted according to their movie id
	 */
	
	public void displayAvailableMovies() 
	{	
		//INITIALIZE MOVIE AND SHOWTIMES

		if(localListOfMovieAndShowTimes.size() > 0) {
			MovieAndShowtimes[] SortMovieCopy2= new MovieAndShowtimes[localListOfMovieAndShowTimes.size()];
			SortMovieCopy2 = sortMovieID(); 
					
			System.out.println("");
			System.out.println("======Movie List in Cineplex " + nameOfCineplex + "========" );
			System.out.println("Movie ID                  Movie Title ");
			for(int i=0; i< SortMovieCopy2.length; i++)
			{
				System.out.println("(" + SortMovieCopy2[i].getMovieID() + ")                       " + SortMovieCopy2[i].getMovieTitle());
			}}
		else
			{
				System.out.println("NOTHING IN MOVIE AND SHOWTIME LIST");
			}
			
	}
	
	/**
	 * Display all the showtimes of the specific movie
	 * @param movieID
	 */

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
	/**
	 * Adds movie and showtime to cineplex
	 * @param object object of MovieAndShowtime class
	 */
	public void addMovieToCineplex(MovieAndShowtimes object) //ADD MOVIE AND SHOWTIMES 
	{   
		

		localListOfMovieAndShowTimes.add(object);
	}
	

	/**
	 * books the seats according to the seat ID in the specific Cinema screen
	 * @param cinema_no Cinema Screen ID
	 * @param seat_id Seat ID
	 * @param cust_id Unique customer ID
	 */
	public void bookSeatAtCinema(int cinema_no, String seat_id, int cust_id) 
	{
		for(Cinema n: cinemaList) {
			if(cinema_no == n.getCinemaID()) {
				n.bookseat(seat_id, cust_id);
				break;
			}
		}
		
	}

	public void updateStatusAndRemoveMovieFromCineplex()
	{

		displayAvailableMovies();

		System.out.println("Enter the movie ID of the movie you want to update status for");
		Scanner sc = new Scanner(System.in);
		int ID = sc.nextInt();

		for(int i = 0; i< localListOfMovieAndShowTimes.size(); i++)
		{
			if(localListOfMovieAndShowTimes.get(i).getMovieID() == ID)
			{
				System.out.println("Enter the new showing status of the movie");
				String newShowingStatus = sc.next();
				localListOfMovieAndShowTimes.get(i).getMovie().setMovieShowingStatus(newShowingStatus);

				if(newShowingStatus.equals("EndOfShowing"))
				{
					removeMovieFromCineplex(ID);
					System.out.println("Movie removed from cineplex: " + ID + " due to showing status being changed to End Of Showing");
					return;
				}
				else
				{
					System.out.println("Movie showing status updated to: " + newShowingStatus);
					return;
				}
			}
		}
		System.out.println("MOVIE ID NOT FOUND IN CINEPLEX");
	}

	public void removeMovieFromCineplex(int movieID)
	{
		for(int i = 0; i< localListOfMovieAndShowTimes.size(); i++)
		{
			if(localListOfMovieAndShowTimes.get(i).getMovieID() == movieID)
			{
				int index = localListOfMovieAndShowTimes.indexOf(localListOfMovieAndShowTimes.get(i));
				localListOfMovieAndShowTimes.remove(index);
			}
		}
	}
	/**
	 * Assigns showtime to cinema screens
	 */
	public void createShowtimesAndAssignToCinema() 
	//check if movie exists in local movie list first before proceeding
	{
		System.out.println(" ");
		System.out.println("======== Create Showtime for A Movie ==========");
		System.out.println(" ");
		displayAvailableMovies();
		System.out.println("");
		System.out.println("Enter the movie id that you want to add showtimes to: ");
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
	/**
	 * Updates show time by first deletion and then addition
	 */
	public void updateShowtimeToMovie() //delete show time and adds a new showtime
	{
		
		deleteShowTimeToMovie();
		createShowtimesAndAssignToCinema();	
	}
	/**
	 * deletes show time
	 */
	public void deleteShowTimeToMovie()
	{
		System.out.println(" ");
		System.out.println("======== Delete Showtime for A Movie ==========");
		System.out.println(" ");
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
	/**
	 * gets all the showtimes for the cinema screen
	 * @param cinemaID unique Cinema screen ID
	 */
	public ArrayList<ShowTime> getListOfShowTimesForCinema(int cinemaID) 
	{
		for(Cinema n: cinemaList) {
			if(n.getCinemaID() == cinemaID) {
				return n.getListOfShowTime();
			}
		}
		return null;
	}
	
	/**
	 * Displays all the show times for the Cinema Screen
	 * @param cinemaID unique Cinema screen ID
	 */
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
	
	/**
	 * for selection of the show time of a cinema
	 * @param showtime show times available in the cinema
	 * @param movieID unique ID of a movie
	 * @throws IOException 
	 */
	public int selectShowtime(String showtime, int movieID) throws IOException  //RETURNS CINEMA ID of the showtime
	{	
		MovieAndShowtimes m = null;
		int cinemaID = -1;
		for(int i=0; i < localListOfMovieAndShowTimes.size(); i++) {
			if(movieID == localListOfMovieAndShowTimes.get(i).getMovieID()) {
				m= localListOfMovieAndShowTimes.get(i);}}


		ArrayList<ShowTime> stList = m.getArrayOfShowTimes(); // array of showtimes of that movie id
	
		for(ShowTime n: stList) {
			if(n.getShowBegins().equals(showtime)) {
				return n.getShowTimeCinemaID();
			}
		}
		
		return -1;
	}	
	/**
	 * sorts all the movies according their ID
	 * @return sorted movie ID list
	 */
	public MovieAndShowtimes[] sortMovieID(){
			
		MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[localListOfMovieAndShowTimes.size()];
			
			for(int i=0; i<localListOfMovieAndShowTimes.size(); i++) {
				SortMovieCopy[i]= localListOfMovieAndShowTimes.get(i);
			}
			
//			if(SortMovieCopy.length > 1) {
//				for(int i=0; i< SortMovieCopy.length-1; i++) {
//					if(SortMovieCopy[i].getMovieID() > SortMovieCopy[i+1].getMovieID()  ) {
//						MovieAndShowtimes temp = SortMovieCopy[i+1];
//						SortMovieCopy[i] = SortMovieCopy[i+1];
//						SortMovieCopy[i+1] = temp;
//					}
//				}}
		Arrays.sort(SortMovieCopy, new Comparator<MovieAndShowtimes>() {
			@Override
			public int compare(MovieAndShowtimes m1, MovieAndShowtimes m2) {
				return m1.getMovieID() - m2.getMovieID();
			}
		});



		return SortMovieCopy;
		}
	/**
	 * Checks if a specific movie exists in a cineplex
	 * @param movieID unique ID of the movie
	 * @return 1 if movie exists, and 0 is it doesnt
	 */
	public int checkIfMovieExistInCineplex(int movieID)
	{
		//InitializeList();   //initializelocallist bc now we didnt create cineplex so have to initialize locallist here
		
		for(MovieAndShowtimes m: localListOfMovieAndShowTimes)
		{
			if(m.getMovieID() == movieID)
			{
				return 1;
			}
		}
		return 0;
	}
	
	/** 
	 * Prints out the available Cinema IDs in the Cineplex
	 */
	public void printCinemaIdOfCineplex()
	{ System.out.println("");
		System.out.println("==== List of available IDS in Cineplex " + nameOfCineplex + "====");
		System.out.println("Cinema ID                 Type");
		for(Cinema n: cinemaList)
		{
			System.out.println(n.getCinemaID() + "                         " + n.getType());
		}
	}
	/**
	 * Converts String to csv
	 * @return csv
	 */
	public String[] toCsv(){
		String[] csv = {Integer.toString(this.cineplexID), this.nameOfCineplex, this.location, Integer.toString(this.no_of_cinema)};
		return csv;

	}
	/**
	 * initializes cinema screen and catches any exception errors
	 */
	public void initializeCinema(){
		MainCSVHelper csvHelper = new MainCSVHelper();
		try {
			System.out.println("**********Initializing Objects....");
			this.cinemaList = csvHelper.readFromCinemaCSV();

		}
		catch(IOException e){
			e.getStackTrace();
			System.out.println("Could not find the file");
		}
	}
	/**
	 * save cinema CSV using the arraylist of cinema objects
	 * @param cinemaList the list of cinema objects in the cineplex
	 */
	public void saveCinemaCSV(ArrayList<Cinema> cinemaList){
		MainCSVHelper csvHelper = new MainCSVHelper();
		try{
			System.out.println("*************Saving to CSV....");
			csvHelper.writeToCinemaCSV(cinemaList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}