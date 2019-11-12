import java.util.ArrayList;
import java.util.Scanner;
import java. util. Iterator;

public class MovieManager {
    private MovieDisplay displayMovie;
    protected static ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes;

    public MovieManager() {
    	this.listOfMovieAndShowtimes = new ArrayList<MovieAndShowtimes>();  
    	this.displayMovie = new MovieDisplay(); 
    	}
    
    public MovieManager(MovieDisplay displayMovie, ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes){
        this.displayMovie = displayMovie;
        MovieManager.listOfMovieAndShowtimes = listOfMovieAndShowtimes;
    }
    
    public void printDetails(ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes){
    	
        for(MovieAndShowtimes x : listOfMovieAndShowtimes){
            displayMovie.printDetails(x.getMovieID(), x.getMovieTitle(), x.getMovieAgeRating(),x.getMovieAverageRating(), x.getMovieDuration(), x.getMovieShowingStatus()
            );
        };
    }

    //--------------MANAGES WITH CREATION OF MOVIES-------------------------------------------------------------------------------------------------------

    public void createMovieCreator(){ //createMovieShowTimes objects to be added in a list
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number of MovieAndShowtimes to create:");
        int i = sc.nextInt();
        for(int x= 0; x< i; x++){
        	MovieAndShowtimes n = new MovieAndShowtimes();
            n.createMovie();        // adds movie to every single MovieShhowTimes objects created

            listOfMovieAndShowtimes.add(n);
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
    public void removeMovie(int MovieID) { // removes an object from a list of created Movies
    	ArrayList<MovieAndShowtimes> toRemove = new ArrayList<MovieAndShowtimes>();
    	for (MovieAndShowtimes m :listOfMovieAndShowtimes ) {
    	    if (m.getMovieID() == MovieID) {
    	        toRemove.add(m);
    	    }
    	}
    	listOfMovieAndShowtimes.removeAll(toRemove);
        

        
        
    	
        
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
public void printGlobalListOfMovieIDs(){
	
	MovieAndShowtimes[] SortMovieCopy2= new MovieAndShowtimes[listOfMovieAndShowtimes.size()];
	SortMovieCopy2 = sortGlobalListMovieID(); 
	System.out.println("");
	System.out.println("==========Global List of Movies========");

	System.out.println("MovieID                      MovieTitle");
	for(int i=0; i< SortMovieCopy2.length; i++)
	{
		System.out.println("(" + SortMovieCopy2[i].getMovieID() + ")                           " + SortMovieCopy2[i].getMovieTitle());
	}
	System.out.println("________________________________________________");
	
}

public ArrayList<Integer> getGlobalListOfMovieIDs(){
        ArrayList<Integer> listOfMovieIDs = new ArrayList<Integer>();
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            listOfMovieIDs.add(n.getMovieID());
        }
        return listOfMovieIDs;
}
public ArrayList<Movie> getGlobalListOfMovieObjects(){
        ArrayList<Movie> arrayListOfMovieOBjects = new ArrayList<Movie>();
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            arrayListOfMovieOBjects.add(n.getMovie());
        }
        return arrayListOfMovieOBjects;
}
public Movie getMovie(int MovieID){
    Movie x = null;
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            if(n.getMovieID() == MovieID)
                x= n.getMovie();
            break;
        }
    return x;
}

public MovieAndShowtimes getMovieAndShowtimes(int MovieID){
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            if(n.getMovieID() == MovieID){
                return n; // returns the MovieAndShowtimes object
            }
        }
    return null; // if cannot find return null
}

public ArrayList<MovieAndShowtimes> getListOfMovieAndShowtimes(){ //take note of the static change mad ehere
	return this.listOfMovieAndShowtimes;
}


    //--------------MANAGES WITH SHOWTIMES------------------------------------------------------------------------------------------------------


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


    public void getShowList(int MovieID){ // remenber to input size
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            if(n.getMovieID() == MovieID){
                n.printListOfShowTimes();
            }
        }
    }
    
    
    public MovieAndShowtimes[] sortGlobalListMovieID(){
		
		MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[listOfMovieAndShowtimes.size()];
			
			for(int i=0; i<listOfMovieAndShowtimes.size(); i++) {
				SortMovieCopy[i]= listOfMovieAndShowtimes.get(i);
			}
			
			
			if(SortMovieCopy.length > 1) {			
				for(int i=0; i< SortMovieCopy.length - 1; i++) {
					if(SortMovieCopy[i].getMovieID() > SortMovieCopy[i+1].getMovieID()  ) {
						MovieAndShowtimes temp = SortMovieCopy[i];
						SortMovieCopy[i] = SortMovieCopy[i+1];
						SortMovieCopy[i+1] = temp;
					}
				}}

			return SortMovieCopy;
		}
    
    public void updateDetailsToMovie()
    {
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the movie ID you want to update/change details for: ");
    	int ID = scan.nextInt();

    	for(MovieAndShowtimes x: listOfMovieAndShowtimes)
    	{
    		if(ID == x.getMovieID())
    		{
		    	System.out.println("What do you want to update/change?");
		    	System.out.println("1. Change ID of movie");
		    	System.out.println("2. Change Title of movie");
		    	System.out.println("3. Change movie age rating");
		    	System.out.println("4. Change duration of movie");
		    	
		    	int userChoice = scan.nextInt();
		    		
		    	switch (userChoice)
		    	{ 
		        	case 1: 
		        		System.out.println("Enter the new movie ID:");
		        		int movieID = scan.nextInt();
		        		x.getMovie().setMovieID(movieID);
		        		System.out.println("Movie ID updated!");
		        		break;
		        	case 2:
		        		System.out.println("Enter the new title of movie:");
		        		String movieTitle = scan.next();
		        		x.getMovie().setMovieTitle(movieTitle);
		        		System.out.println("Movie Title updated!");
		        		break;
		        	case 3: 
		        		System.out.println("Enter the new minimum age to watch the movie:");
		        		int minAge = scan.nextInt();
		        		x.getMovie().setMovieAgeRating(minAge);
		        		System.out.println("Movie age rating updated!");
		        		break;
		        	case 4:
		        		System.out.println("Enter the new duration of movie:");
		        		int duration = scan.nextInt();
		        		x.getMovie().setMovieDuration(duration);
		        		System.out.println("Movie duration updated!");
		        		break;
		    	}
    		}
    		else
    			System.out.println("no such movie found!");
    	}
        		
    }
    
    public void changeShowingStatusAndRemoveMovie()
    {	
    	Scanner scan = new Scanner(System.in);
    	
    	System.out.println("Enter the movie ID you want to change showing status from");
    	int ID = scan.nextInt();

    	for(MovieAndShowtimes x: listOfMovieAndShowtimes)
    	{
    		if(ID == x.getMovieID())
    		{
    			System.out.println("Enter the new showing status (Coming Soon, Now Showing, End of Showing");
    			String showingStatus = scan.nextLine();
        		x.getMovie().setMovieShowingStatus(showingStatus);
        		
            	if(showingStatus.equalsIgnoreCase("End of Showing"));
            	{
            		removeMovie(ID);
            		System.out.println("Movie removed due to showing status being changed to End Of Showing");
            	}
    		}
    		else
    			System.out.println("No such movie found!");
    	}
    }
		
    
    




}