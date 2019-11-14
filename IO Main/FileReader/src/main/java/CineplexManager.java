import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.IOException;
import java.util.*;

public class CineplexManager 
{
	protected ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
	protected ArrayList<Cinema> cinemaList = new ArrayList<Cinema>();
	
	protected MovieManager movieManager;
	
	public CineplexManager() {
		movieManager = new MovieManager();
	}
	

//-------------------------Get methods--------------------------------------------------------------------------------------------	
	public Cineplex selectCineplex(int cineplexID)
	{
		for(int i = 0; i< MAIN.cineplexList.size(); i++)
		{
			if(MAIN.cineplexList.get(i).getCineplexID() == cineplexID)
			{

				return MAIN.cineplexList.get(i);
			}
		}
		return null;
	}

//------------------------Display methods----------------------------------------------------------------------------------------------------------	
	
	public void displayMovieListOfCineplex(Cineplex c)
	{
		
		c.displayAvailableMovies();
	}
		
	public void displayAllMovies(MovieManager m)
	{
		m.printGlobalListOfMovieIDs();
	}
	
	
	public void printCineplexlist() {

		
		Cineplex[] SortCopy2= new Cineplex[MAIN.cineplexList.size()];
		SortCopy2 = sortCineplexID();
		
		System.out.println("");
		System.out.println("==============Cineplex List====================");
		System.out.println("Cineplex ID                       Cineplex Name");
		
		for(int i=0;i<SortCopy2.length; i++) {
			System.out.println("("+ SortCopy2[i].getCineplexID() +")                               " + SortCopy2[i].nameOfCineplex);
		}
		}

//------------------------Main methods-----------------------------------------------------------------------------------------------
	
	public void createMovie(MovieManager m)
	{
		m.createMovieCreator();
	}
	
	public void createCineplex()
	{
		//initializeCineplex();
		
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
		MAIN.cineplexList.add(cineplex);
		
		saveCineplexCSV(MAIN.cineplexList);

		
		
		
		System.out.println("Created cineplex " + name + " at location " + location + " with " + number + " cinemas..");	
	}
	
	public void assignMoviesToCineplex(Cineplex c, int movieid)
	{	
		//MovieAndShowtimes m = movieManager.getMovieAndShowtimes(movieid);
		
		c.addMovieToCineplex(movieManager.getMovieAndShowtimes(movieid));
		System.out.println("You have assigned the movie to " + c.nameOfCineplex);
		System.out.println("");
	}
	
		
	public Cineplex[] sortCineplexID(){
		
		Cineplex[] SortCopy= new Cineplex[MAIN.cineplexList.size()];
		
		 for(int i=0; i<MAIN.cineplexList.size(); i++) { SortCopy[i]=
		 MAIN.cineplexList.get(i); }
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
	
	public ArrayList<Cineplex> listOfCineplexWithMovieID(int movieID)
	{
		ArrayList<Cineplex> cineplexListWithMovieID = new ArrayList<Cineplex>();

		for(Cineplex m: MAIN.cineplexList)
		{
			if(m.checkIfMovieExistInCineplex(movieID) == 1)
			{   
				cineplexListWithMovieID.add(m);
			}
		}
		
		return cineplexListWithMovieID;
	}
	
	public void printCinemaIdForCineplex(int cineplexID )
	{
		for(Cineplex c: MAIN.cineplexList)
		{
			if(cineplexID == c.getCineplexID())
			{
				c.printCinemaIdOfCineplex();
			}
		}
	}
	
	//-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------


		public void initializeCineplex(){
			MainCSVHelper csvHelper = new MainCSVHelper();
			try {
				System.out.println("**************************Initializing Objects....");
				MAIN.cineplexList = csvHelper.readFromCineplexDetailsCSV();

			}
			catch(IOException e){
				e.getStackTrace();
				System.out.println("Could not find the file");
			}
		}
		public void saveCineplexCSV(ArrayList<Cineplex> cineplexList){
			MainCSVHelper csvHelper = new MainCSVHelper();
			try{
				System.out.println("***********************************Saving to CSV....");
				csvHelper.writeToCineplexCSV(MAIN.cineplexList);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public void initializeCinema(){
			MainCSVHelper csvHelper = new MainCSVHelper();
			try {
				System.out.println("**********Initializing Objects....");
				MAIN.cinemaList = csvHelper.readFromCinemaCSV();
				
				for (int i = 0; i < MAIN.cineplexList.size(); i++) {
					Cineplex cine = MAIN.cineplexList.get(i);
					for (Cinema c: MAIN.cinemaList) {
						if (cine.cineplexID == c.getCineplexID()) {
							cine.getCinemaList().add(c);
						}
					}
				}
			}
			catch(IOException e){
				e.getStackTrace();
				System.out.println("Could not find the file");
			}
		}
		
		
			
	
		
		
	
}