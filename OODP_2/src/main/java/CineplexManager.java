import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class CineplexManager implements Serializable
{
	protected ArrayList<Cineplex> cineplexList;
	protected MovieManager movieManager;
	
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
//		if(this.cineplexList == null){
//			this.cineplexList = new ArrayList<Cineplex>(); // temporarily creates a file first will now create Cineplex files		}
//	}

	}


	

//-------------------------Get methods--------------------------------------------------------------------------------------------	
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
	
	public void displayMovieListOfCineplex(Cineplex c)
	{
		
		c.displayAvailableMovies();
	}
		
	public void displayAllMovies(MovieManager m)
	{
		m.printGlobalListOfMovieIDs();
	}
	
	
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
	
	public void createMovie(MovieManager m)
	{
		m.createMovieCreator();
	}
	
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
	
	public void assignMoviesToCineplex(Cineplex c, int movieid)
	{	
		//MovieAndShowtimes m = movieManager.getMovieAndShowtimes(movieid);
		
		c.addMovieToCineplex(movieManager.getMovieAndShowtimes(movieid));
		System.out.println("You have assigned the movie to " + c.nameOfCineplex);
		System.out.println("");
	}
	
		
	public Cineplex[] sortCineplexID(){
		
		Cineplex[] SortCopy= new Cineplex[cineplexList.size()];
		
		for(int i=0; i<cineplexList.size(); i++) {
			SortCopy[i]= cineplexList.get(i);
		}
		
		if(SortCopy.length > 1) {		
			for(int i=0; i< SortCopy.length-1; i++) {
				if(SortCopy[i].cineplexID > SortCopy[i+1].cineplexID  ) {
					Cineplex temp = SortCopy[i+1];
					SortCopy[i] = SortCopy[i+1];
					SortCopy[i+1] = temp;
				}
			}}
			
		return SortCopy;
	}
	
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