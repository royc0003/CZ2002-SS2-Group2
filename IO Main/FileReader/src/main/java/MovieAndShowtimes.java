import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class MovieAndShowtimes {
    private ArrayList<ShowTime> showList;
    private Movie movie;


    public MovieAndShowtimes() { //  constructor
    	ArrayList<ShowTime> showList = new ArrayList<ShowTime>();
    	this.showList = showList;
    	
    	createMovie();
    }
    
    public void createMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("You are now creating a new movie:");
        System.out.println("Insert int ID, String title, int ageRating, String showingStatus, int duration:");
        int a = sc.nextInt();
        String b = sc.nextLine();
        int c = sc.nextInt();
        String d = sc.nextLine();
        int e = sc.nextInt();
        this.movie =  new Movie(a,b,c,d,e); // assigns a new movie object to the movie attribute
    }

    //--------------SHOWTIME RELATED FUNCTIONS-------------------------------------------------------------------------------------------------------

    public void createShowTime(String showBegins, Movie m, int cinemaID){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the number of showTimes to be created");
        int i = sc.nextInt();
        for(int x = 0; x < i; x++){
            showList.add(new ShowTime(showBegins, m, cinemaID));
        }
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
}