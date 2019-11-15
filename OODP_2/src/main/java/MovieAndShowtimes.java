import java.io.Serializable;
import java.util.ArrayList;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MovieAndShowtimes implements Serializable {
    private ArrayList<ShowTime> showList;
    private Movie movie;


    public MovieAndShowtimes(){ //  constructor
    	ArrayList<ShowTime> showList = new ArrayList<ShowTime>();
    	this.showList = showList;
    

        }

    public void printDetails(int movieID, String movieTitle, int movieAgeRating, double movieAverageRating, int movieDuration, String showingStatus)
    {
        System.out.println("***************");
        System.out.println("Movie ID: " + movieID);
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Director of Movie: " + movie.getdirector());

        for(String x : movie.getListOfCast()){
            System.out.println("Cast: " + x);}

        if(movieAgeRating == 0){
            System.out.println("Movie Rating: NA ");
        }
        else{
            System.out.println("Movie Rating: " + movieAverageRating);
        }
        System.out.println("Minimum age to enter: " + movieAgeRating);
        System.out.println("Movie Duration: " + movieDuration);
        System.out.println("Showing Status: " + showingStatus);
        System.out.println("Synopsis: " + movie.getSynopsis());

        System.out.println("***************");
    }
    
    public void createMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You are now creating a new movie:");
        System.out.println("Insert Movie ID");
        int a = sc.nextInt();   
        System.out.println("Insert Title");
        String b = sc.next();
        sc.nextLine();
        System.out.println("Insert Age Rating (integer)");
        int c = sc.nextInt();
        System.out.println("Insert Showing Status (string)");
        String d = sc.next();
        sc.nextLine();
        System.out.println("Insert duration (minutes)");
        int e =sc.nextInt();
        System.out.println("Insert director of movie:");
        String f = sc.next();
        sc.nextLine();
        System.out.println("Insert synopsis of movie:");
        String g =sc.nextLine();
        sc.nextLine();
        System.out.println("Insert the number of cast");
        int count = sc.nextInt();
        ArrayList<String> listOfCast = new ArrayList<String>();

        for(int i=0 ; i<count ; i++){
            System.out.println("Insert name of cast " + (i+1));
            String cast = sc.next();
            sc.nextLine();
            listOfCast.add(cast);
        }



        this.movie =  new Movie(a,b,c,d,e, f,g, listOfCast); // assigns a new movie object to the movie attribute
      //  saveMovieToCSV(this.movie);
    }
    
    public void setMovie(Movie m){
        this.movie = m;
    }

    //--------------SHOWTIME RELATED FUNCTIONS-------------------------------------------------------------------------------------------------------

    public void createShowTime(String showBegins, Movie m, int cinemaID){
        Scanner sc = new Scanner(System.in);
       /* System.out.println("Insert the number of showTimes to be created");
        int i = sc.nextInt();
        for(int x = 0; x < i; x++){*/
            showList.add(new ShowTime(showBegins, m, cinemaID));
           // saveShowTimeCSV(this.showList);
        
    }

    public void printListOfShowTimes(){  //PRINT SORTED SHOWTIMES
    	
    	String[] s =  new String[showList.size()];
    	s = sortShowTimes();
    	int i=0;
    	for(String a: s) {
    		System.out.println(a);
    		i++;
    	}
    
    	
    }
    public ArrayList<ShowTime> getArrayOfShowTimes(){
    	

        return this.showList;
    }

    public void removeShowTime(String showBegin, int cinemaID){ // removes showtime related to a cinemaID

        for(ShowTime n : showList){

            if(n.getShowBegins().equals(showBegin)&& n.getShowTimeCinemaID() == cinemaID){

                showList.remove(n);

                break;

            }

        }
    }

    //-------------------MOVIE RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------

    public Movie getMovie(){
        return this.movie;
    }
    public int getMovieID(){
        return movie.getMovieID();
    }
    public String getMovieTitle(){
        return movie.getMovieTitle();
    }
    public int getMovieAgeRating(){
        return movie.getMovieAgeRating();
    }
    public String getMovieShowingStatus(){
        return movie.getMovieShowingStatus();
    }
    public int getMovieDuration(){return movie.getMovieDuration();}
    public double getMovieAverageRating(){return movie.getAverageRating();};


    //-------------------SHOWTIME RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------
    
    
public String[] sortShowTimes(){
		
	String[] SortCopy= new String[showList.size()];
		
		for(int i=0; i<showList.size(); i++) {
			SortCopy[i]= showList.get(i).getShowBegins();
		}
		
		Arrays.sort(SortCopy);
		
		return SortCopy;
	}
		



public ShowTime getShowTime(String showBegins, int cinemaID){

    ShowTime x = null;
    for(ShowTime n: showList){

        if(n.getShowBegins().equals(showBegins)&& n.getShowTimeCinemaID() == cinemaID){

            return x = n;

        }

    }

    return x;

}

public int getNoOfTicketSold()
{
    return movie.getNoOfTicketSold();
}



//-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------
/*public void initializeMovie() throws IOException {
    MainCSVHelper csvHelper = new MainCSVHelper();
    try {
;            System.out.println("**************************Initializing Objects....");
ArrayList<Movie> temp = new ArrayList<Movie>();
        temp = csvHelper.readFromMoviesCSV();
        this.movie = temp.get(0); // retrieves the very first item for initilaization
        // test
        System.out.println("Test...");
        System.out.println(this.movie.getMovieTitle());
    }
    catch(IOException e){
        e.getStackTrace();
        System.out.println("Could not find the file");
    }
}*/

/*public void saveMovieToCSV(Movie m){
    MainCSVHelper csvHelper = new MainCSVHelper();
ArrayList<Movie> temp = new ArrayList<Movie>();
temp.add(m);
    try{
        System.out.println("***********************************Saving to CSV....");
        csvHelper.writeToMovieCSV(temp);
    } catch (IOException e) {
        e.printStackTrace();
    }
}*/
public void initializeShowTime(){
    MainCSVHelper csvHelper = new MainCSVHelper();
    try {
        System.out.println("**************************Initializing Objects....");
        this.showList = csvHelper.readFromShowTimeCSV();

    }
    catch(IOException e){
        e.getStackTrace();
        System.out.println("Could not find the file");
    }
}
public void saveShowTimeCSV(ArrayList<ShowTime> showList){
    MainCSVHelper csvHelper = new MainCSVHelper();
    try{
        System.out.println("***********************************Saving to CSV....");
        csvHelper.writeToShowTimeCSV(showList);
    } catch (IOException e) {
        e.printStackTrace();
    }
}



	/*
	 * public String[] toCsv(){ String[] csv =
	 * {Integer.toString(movie.getMovieID()), movie.getMovieTitle(),
	 * movie.getMovieShowingStatus(), Integer.toString(movie.getMovieAgeRating()),
	 * Integer.toString(movie.getMovieAgeRating()),
	 * this.showList.get(0).getShowBegins(), this.showList.get(1).getShowBegins()..)
	 * }; return csv; }
	 */
}