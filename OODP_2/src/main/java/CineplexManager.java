import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;
/**
 * This class allows us to create movies, create a cineplex,
 * assign movies to cineplex from global list of movies,
 * display list of movies. There will only be one cineplex 
 * manager object 
 * 
 */
public class CineplexManager implements Serializable
{
	/**
	 * Array list of cineplexes
	 */
	protected ArrayList<Cineplex> cineplexList;
	/**
	 * MovieManager object
	 */
	protected MovieManager movieManager;
	/**
	 * Creates a new cineplex manager object (there will only be one)
	 */
	public CineplexManager() {
		this.movieManager = new MovieManager(); // initializes


		ArrayList<Cineplex> trialList = null;
		try {
			System.out.println("Reading from Cineplex.dat -----------");
			trialList = (ArrayList) MainCSVHelper.readSerializedObject("Cineplex.dat"); // reads from movie and showtime
			this.cineplexList = trialList; // tries to assign the arraylist of objects to current listofmovie and hsowtimes
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}
		if(this.cineplexList == null){
			this.cineplexList = new ArrayList<Cineplex>();} // temporarily creates a file first will now create Cineplex files		}
	}


//-------------------------Get methods--------------------------------------------------------------------------------------------	
	public ArrayList<Cineplex> getCineplexList(){
		return this.cineplexList;
	}

	/**
	 * Returns a cineplex object
	 * @param Cineplex ID of Cineplex
	 * @return a cineplex object based on specified cineplex id
	 */
	public Cineplex selectCineplex(int cineplexID)
	{
		for(int i = 0; i< cineplexList.size(); i++)
		{
			if(cineplexList.get(i).getCineplexID() == cineplexID)
			{

				return cineplexList.get(i);
			}
		}
		return null;
	}

//------------------------Display methods----------------------------------------------------------------------------------------------------------	
	/**
	 * Display available movies assigned to a cineplex
	 * @param Cinplex object
	 */
	public void displayMovieListOfCineplex(Cineplex c)
	{
		
		c.displayAvailableMovies();
	}
	/**
	 * Display all movies in global list
	 * @param MovieManager object
	 */	
	public void displayAllMovies(MovieManager m)
	{
		m.printGlobalListOfMovieIDs();
	}
	
	/**
	 * Sorts cineplexes based on cineplex ID and prints 
	 * the list of all cineplexes
	 */
	public void printCineplexlist() {
		
		Cineplex[] SortCopy2= new Cineplex[cineplexList.size()];
		SortCopy2 = sortCineplexID();
		
		System.out.println("");
		System.out.println("==============Cineplex List====================");
		System.out.println("Cineplex ID                       Cineplex Name");
		
		for(int i=0;i<SortCopy2.length; i++) {
			System.out.println("("+ SortCopy2[i].getCineplexID() +")                               " + SortCopy2[i].nameOfCineplex);
		}
		}

//------------------------Main methods-----------------------------------------------------------------------------------------------

	public void changeShowingStatusAndRemoveMovieInCineplex()
	{
		printCineplexlist();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the CINEPLEX you want to change showing status for");
		int cineplexID = scan.nextInt();

		Cineplex c = selectCineplex(cineplexID);

		c.updateStatusAndRemoveMovieFromCineplex();

	}

	/**
	 * Uses MovieManager to create a movie
	 * @param MovieManager object
	 */
	public void createMovie(MovieManager m)
	{
		m.createMovieCreator();
	}
	/**
	 * Creates a cineplex object and adds it to the array list
	 * of cineplexes
	 */
	public void createCineplex()
	{
		System.out.println("Enter ID of Cineplex");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		System.out.println("Enter name of Cineplex");
		String name = sc.next();
		
		System.out.println("Enter location of Cineplex");
		String location = sc.next();
		
		System.out.println("Enter no of cinemas in Cineplex");
		int number = sc.nextInt();
		
		Cineplex cineplex = new Cineplex(id, name, location, number);
		cineplexList.add(cineplex);


		MainCSVHelper.writeSerializedObject("Cineplex.dat", this.cineplexList);
		//saveCineplexCSV(this.cineplexList);

		
		System.out.println("Created cineplex " + name + " at location " + location + " with " + number + " cinemas..");	
	}
	/**
	 * Assigns movies to a cineplex
	 * @param Cineplex object
	 * @param Movie ID of movie to be assigned
	 */
	public void assignMoviesToCineplex(Cineplex c, int movieid)
	{	
		//MovieAndShowtimes m = movieManager.getMovieAndShowtimes(movieid);
		
		c.addMovieToCineplex(movieManager.getMovieAndShowtimes(movieid));
		System.out.println("You have assigned the movie to " + c.nameOfCineplex);
		System.out.println("");
	}


	/**
	 * Sorts array list of cineplex list in ascending order based on cineplex ID
	 * @return sorted array list of cineplexes 
	 */
	public Cineplex[] sortCineplexID(){

		Cineplex[] SortCopy= new Cineplex[this.cineplexList.size()];

		for(int i=0; i<this.cineplexList.size(); i++) { SortCopy[i]=
				this.cineplexList.get(i); }
		/*
		 * if(SortCopy.length > 1) { for(int i=0; i< SortCopy.length-1; i++) {
		 * if(SortCopy[i].cineplexID > SortCopy[i+1].cineplexID ) { Cineplex temp =
		 * SortCopy[i+1]; SortCopy[i] = SortCopy[i+1]; SortCopy[i+1] = temp; } }}
		 */
		Arrays.sort(SortCopy, new Comparator<Cineplex>() {
			@Override
			public int compare(Cineplex c1, Cineplex c2) {
				return c1.cineplexID - c2.cineplexID;
			}
		});
		return SortCopy;
	}
	/**
	 * Returns array list of cineplexes showing a particular movie
	 * @return array list of cineplexes
	 */
	public ArrayList<Cineplex> listOfCineplexWithMovieID(int movieID)
	{
		ArrayList<Cineplex> cineplexListWithMovieID = new ArrayList<Cineplex>();

		for(Cineplex m: cineplexList)
		{
			if(m.checkIfMovieExistInCineplex(movieID) == 1)
			{   
				cineplexListWithMovieID.add(m);
			}
		}
		
		return cineplexListWithMovieID;
	}
	/**
	 * Prints all cinemas ID in a specified cineplex
	 * @param cineplex ID of cineplex
	 */
	public void printCinemaIdForCineplex(int cineplexID )
	{
		for(Cineplex c: cineplexList)
		{
			if(cineplexID == c.getCineplexID())
			{
				c.printCinemaIdOfCineplex();
			}
		}
	}
	
	//-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------

		/**
		 * Helps retrieve previously stored data if program crashes or exits
		 */
		public void initializeCineplex(){
			MainCSVHelper csvHelper = new MainCSVHelper();
			try {
				System.out.println("**************************Initializing Objects....");
				this.cineplexList = csvHelper.readFromCineplexDetailsCSV();

			}
			catch(IOException e){
				e.getStackTrace();
				System.out.println("Could not find the file");
			}
		}
		/**
		 * Saves data to a csv file
		 * @param Array list of cineplex objects
		 */
		public void saveCineplexCSV(ArrayList<Cineplex> cineplexList){
			MainCSVHelper csvHelper = new MainCSVHelper();
			try{
				System.out.println("***********************************Saving to CSV....");
				csvHelper.writeToCineplexCSV(cineplexList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		public MovieManager getMovieManager(){
		return this.movieManager;
		}
		
		
			
	
		
		
	
}