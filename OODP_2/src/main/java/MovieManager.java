import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java. util. Iterator;

public class MovieManager implements Serializable {
	/**
	 * MovieDisplay object
	 */
    private MovieDisplay displayMovie;
    /**
     * Array list of movie and showtimes objects
     */
    protected static ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes;
    /**
     * Creates a new movie manager object
     */
    public MovieManager() {
		this.displayMovie = new MovieDisplay();
		this.listOfMovieAndShowtimes = new ArrayList<MovieAndShowtimes>(); // calls the write function in constructor

		ArrayList<MovieAndShowtimes> trialList = null;
		try{
			System.out.println("Reading from MovieAndShowtimes.dat -----------");
			trialList = (ArrayList)MainCSVHelper.readSerializedObject("MovieAndShowtimes.dat"); // reads from movie and showtime
			this.listOfMovieAndShowtimes = trialList; // tries to assign the arraylist of objects to current listofmovie and hsowtimes
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage());
		}


//		if (this.listOfMovieAndShowtimes == null) {
//			this.listOfMovieAndShowtimes = new ArrayList<MovieAndShowtimes>();
//		}
	}
    /**
     * Creates a new movie manager object
     * @param displayMovie This MovieManager's MovieDisplay object
     * @param listOfMoviesAndShowtimes This MovieManager's array list of MovieAndShowtimes objects
     */
    public MovieManager(MovieDisplay displayMovie, ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes){
        this.displayMovie = displayMovie;
        MovieManager.listOfMovieAndShowtimes = listOfMovieAndShowtimes;
    }

    /**
     * Prints details of all movies
     * @param listOfMovieAndShowtimes Array list of MovieAndShowtimes objects
     */
	public void printDetails(ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes){

		for(MovieAndShowtimes x : listOfMovieAndShowtimes){
			x.printDetails(x.getMovieID(), x.getMovieTitle(), x.getMovieAgeRating(),x.getMovieAverageRating(), x.getMovieDuration(), x.getMovieShowingStatus()
			);
		};
	}

    //--------------MANAGES WITH CREATION OF MOVIES-------------------------------------------------------------------------------------------------------
	/**
     * Creates a new movieAndShowtime object
     */
    public void createMovieCreator(){ //createMovieShowTimes objects to be added in a list
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number of MovieAndShowtimes to create:");
        int i = sc.nextInt();
        for(int x= 0; x< i; x++){
        	MovieAndShowtimes n = new MovieAndShowtimes();
            n.createMovie();        // adds movie to every single MovieShhowTimes objects created

            listOfMovieAndShowtimes.add(n);
            MainCSVHelper.writeSerializedObject("MovieAndShowtimes.dat", listOfMovieAndShowtimes); // does the saving to serialize
            saveMovieAndShowtimesCSV(listOfMovieAndShowtimes);
            System.out.println("");
            System.out.println("You have created a movie!");

        }
    }


    /*private void createMovie(){ //creates new movies
    	
        for(MovieAndShowtimes n : listOfMovieAndShowtimes){
            n.createMovie();
        }
    }*/
    //--------------MANAGES WITH REMOVAL OF MOVIES-------------------------------------------------------------------------------------------------------
   /**
     * Removes a movie from listOfMovieAndShowtimes array list
     * @param the Movie ID of the movie to be removed
     */
    public void removeMovie(int MovieID) { // removes an object from a list of created Movies
    	/*ArrayList<MovieAndShowtimes> toRemove = new ArrayList<MovieAndShowtimes>();
    	for (MovieAndShowtimes m :listOfMovieAndShowtimes ) {
    	    if (m.getMovieID() == MovieID) {
    	        toRemove.add(m);
    	    }
    	}
    	listOfMovieAndShowtimes.removeAll(toRemove);*/
    	for(int i = 0; i < listOfMovieAndShowtimes.size(); i++) {
    		MovieAndShowtimes temp = listOfMovieAndShowtimes.get(i);
    		if(listOfMovieAndShowtimes.get(i).getMovieID() == MovieID) {
    			listOfMovieAndShowtimes.remove(temp);
    			break;
    		}
    	}
        

        
        
    	
        
       /* Iterator<MovieAndShowtimes> iter = listOfMovieAndShowtimes.iterator();
        while (iter.hasNext()) {
            MovieAndShowtimes movShowtime = iter.next();
            if (movShowtime.getMovieID() == MovieID)
                iter.remove();
        }*/
        
        
        
    }
    //--------------MANAGES WITH LISTING OF DETAILS------------------------------------------------------------------------------------------------------
// return list of movieIDs done
    // prints list of movieIDs done
    // returns list of movieObjects
    // gets a single movie from the list of movieObjects --
    /**
     *  prints all movie IDs in the array list 
     */
    public void printGlobalListOfMovieIDs(){
		
		MovieAndShowtimes[] SortMovieCopy2= new MovieAndShowtimes[listOfMovieAndShowtimes.size()];
		SortMovieCopy2 = sortGlobalListMovieID(); 
		System.out.println("");
		System.out.println("==========Global List of Movies==============");
	
		System.out.println("MovieID            MovieTitle         ShowingStatus  ");
		for(int i=0; i< SortMovieCopy2.length; i++)
		{
			System.out.println("(" + SortMovieCopy2[i].getMovieID() + ")                  " + SortMovieCopy2[i].getMovieTitle() + "               " + SortMovieCopy2[i].getMovieShowingStatus());
		}
		System.out.println("________________________________________________");
		
	}
	/**
	 * Returns an array list of integers of movie IDS
	 * @return an array list of Movie IDS (int)
	 */
	public ArrayList<Integer> getGlobalListOfMovieIDs(){
	        ArrayList<Integer> listOfMovieIDs = new ArrayList<Integer>();
	        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
	            listOfMovieIDs.add(n.getMovieID());
	        }
	        return listOfMovieIDs;
	}
	/**
	 *  Returns an array list of movie objects
	 *  @return an array list of movie objects
	 */
	public ArrayList<Movie> getGlobalListOfMovieObjects(){
	        ArrayList<Movie> arrayListOfMovieOBjects = new ArrayList<Movie>();
	        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
	            arrayListOfMovieOBjects.add(n.getMovie());
	        }
	        return arrayListOfMovieOBjects;
	}
	
	
	/**
	 * Returns a single movie object
	 * @param Movie ID of Movie object to be retrieved
	 * @return returns a single movie object with the specified ID
	 */
	public Movie getMovie(int MovieID){
		
	    Movie x = null;
	        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
	            if(n.getMovieID() == MovieID){
	                return n.getMovie();
	        	}
	        }
	    return x;
	}
	/**
	 * Returns a single MovieAndShowtimes object
	 * @param movie ID of MovieAndShowtimes object to be retreived
	 * @return returns a single MovieAndShowtimes object with specified movie ID
	 */
	public MovieAndShowtimes getMovieAndShowtimes(int MovieID){
	        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
	            if(n.getMovieID() == MovieID){
	                return n; // returns the MovieAndShowtimes object
	            }
	        }
	    return null; // if cannot find return null
	}
	/**
	 * Returns an array list of MovieAndShowtimes Object
	 * @return returns an array list MovieAndShowtimes objects
	 */
	public ArrayList<MovieAndShowtimes> getListOfMovieAndShowtimes(){ //take note of the static change mad ehere
		return this.listOfMovieAndShowtimes;
	}
	

    //--------------MANAGES WITH SHOWTIMES------------------------------------------------------------------------------------------------------

/**
	 * Creates a MovieAndShowtimes object
	 */
    public void createMovieShowtimes(){ // This is to be made dynamic
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){ // we need to check for every title
            System.out.println("You are referring to this movie: "+ n.getMovieTitle());
            createShowTimes();
        }
    }

//createSingleShowTime
    //createMultipleShowTime
    private void createShowTimes(){ // creates  Showtimes
        Scanner sc = new Scanner(System.in);
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            //Date showBegins =; // remember to update this
            //Date showEnds =  ; // remember to update this
            //n.createShowTime(Date showBegins, Date showEnds);
        }
    }

/**
	 * Prints showtimes of specified Movies
	 * @param Movie ID of movie
	 */
    public void getShowList(int MovieID){ // remenber to input size
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            if(n.getMovieID() == MovieID){
                n.printListOfShowTimes();
            }
        }
    }
    
     /**
	 * Sorts the Movie IDs based on ascending order and returns the array list 
	 */
    public MovieAndShowtimes[] sortGlobalListMovieID(){
		
		MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[listOfMovieAndShowtimes.size()];
			
			for(int i=0; i<listOfMovieAndShowtimes.size(); i++) {
				SortMovieCopy[i]= listOfMovieAndShowtimes.get(i);
			}
			
			
//			if(SortMovieCopy.length > 1) {
//				for(int i=0; i< SortMovieCopy.length - 1; i++) {
//					if(SortMovieCopy[i].getMovieID() > SortMovieCopy[i+1].getMovieID()  ) {
//						MovieAndShowtimes temp = SortMovieCopy[i];
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
	 * Allows the staff to update details of a movie
	 */
    public void updateDetailsToMovie()
    {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the movie ID you want to update/change details for: ");
    	int ID = scan.nextInt();

    	for(MovieAndShowtimes x: listOfMovieAndShowtimes) {
			if (ID == x.getMovieID()) {
				System.out.println("What do you want to update/change?");
				System.out.println("1. Change ID of movie");
				System.out.println("2. Change Title of movie");
				System.out.println("3. Change movie age rating");
				System.out.println("4. Change duration of movie");

				int userChoice = scan.nextInt();

				switch (userChoice) {
					case 1:
						System.out.println("Enter the new movie ID:");
						int movieID = scan.nextInt();
						x.getMovie().setMovieID(movieID);
						System.out.println("Movie ID updated!");
						return;
					case 2:
						System.out.println("Enter the new title of movie:");
						String movieTitle = scan.next();
						x.getMovie().setMovieTitle(movieTitle);
						System.out.println("Movie Title updated!");
						return;
					case 3:
						System.out.println("Enter the new minimum age to watch the movie:");
						int minAge = scan.nextInt();
						x.getMovie().setMovieAgeRating(minAge);
						System.out.println("Movie age rating updated!");
						return;
					case 4:
						System.out.println("Enter the new duration of movie:");
						int duration = scan.nextInt();
						x.getMovie().setMovieDuration(duration);
						System.out.println("Movie duration updated!");
						return;

				}

			}
		}


			System.out.println("no such movie found!");

        		
    }
    public void saveMovieAndShowtimes(){ // function to be called to save data
		MainCSVHelper.writeSerializedObject("MovieAndShowtimes.dat", listOfMovieAndShowtimes);	}
   /**
	 * Allows staff to update showing status of a movie
	 * If showing status is changed to "End Of Showing",
	 * movie is automatically removed from array list of MovieAndShowtimes
	 */
    public void changeShowingStatusAndRemoveMovie()
    {	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the movie ID you want to change showing status from");
    	int ID = scan.nextInt();
    	int i;
    	for( i = 0; i < listOfMovieAndShowtimes.size(); i ++)
    	{
    		if(ID == listOfMovieAndShowtimes.get(i).getMovieID())
    		{
    			System.out.println("Enter the new showing status (Coming Soon, Now Showing, End of Showing");
    			String showingStatus = scan.next();
    			listOfMovieAndShowtimes.get(i).getMovie().setMovieShowingStatus(showingStatus);
        		
            	if(showingStatus.equals("EndOfShowing"))
            	{
            		removeMovie(ID);
            		System.out.println("Movie removed due to showing status being changed to End Of Showing");
            		break;
            	}
            	
    		
    		}
    	
    	}
    	
    	if(i== listOfMovieAndShowtimes.size()-1) {
			System.out.println("No such movie found!");
    			}
		MainCSVHelper.writeSerializedObject("MovieAndShowtimes.dat", listOfMovieAndShowtimes); // saves after altering the showtime
    	
    	}
 /**
	 * Saves data to a csv file
	 * @param Array list of MovieAndShowtimes objects
	 */
    public void saveMovieAndShowtimesCSV(ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes){
		MainCSVHelper csvHelper = new MainCSVHelper();
		try{
			System.out.println("*************Saving to CSV....");
			csvHelper.writeToMovieAndShowtimeCSV(listOfMovieAndShowtimes);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    /**
	 * Helps retrieve previously stored data if program crashes or exits
	 */
    public void initializeMovie(){
		MainCSVHelper csvHelper = new MainCSVHelper();
		try {
			System.out.println("**********Initializing Objects....");
			listOfMovieAndShowtimes = csvHelper.readFromMoviesCSV();
		}
		catch(IOException e){
			e.getStackTrace();
			System.out.println("Could not find the file");
		}
	}
}
		
    
    
