import java.util.ArrayList;
import java.io.IOException;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MovieAndShowtimes {
    private ArrayList<ShowTime> showList;
    private Movie movie;


    public MovieAndShowtimes(){ //  constructor
    	ArrayList<ShowTime> showList = new ArrayList<ShowTime>();
    	this.showList = showList;
    

        }
    
    public void createMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You are now creating a new movie:");
        System.out.println("Insert Movie ID");
        int a = sc.nextInt();   
        System.out.println("Insert Title");
        String b = sc.next();
        System.out.println("Insert Age Rating (integer)");
        int c = sc.nextInt(); 
        System.out.println("Insert Showing Status (string)");
        String d = sc.next();
        System.out.println("Insert duration (minutes)");
        int e =sc.nextInt(); 
        this.movie =  new Movie(a,b,c,d,e); // assigns a new movie object to the movie attribute
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
            saveShowTimeCSV(this.showList);
        
    }

    public void printListOfShowTimes(){  //PRINT SORTED SHOWTIMES
    	
    	String[] s =  new String[showList.size()];
    	s = sortShowTimes();
    	int i=0;
    	for(String a: s) {
    		System.out.println("(" + i + ")" + a);
    		i++;
    	}
    
    	
    }
    public ArrayList<ShowTime> getArrayOfShowTimes() throws IOException{
    	
    	//initializeMovie();
    	initializeShowTime();
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
    public int getMovieAverageRating(){return movie.getAverageRating();};


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