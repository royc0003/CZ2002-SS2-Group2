import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MovieAndShowtimes {
    private ArrayList<ShowTime> showList;
    private Movie movie;


    public MovieAndShowtimes() { // empty constructor
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

    public void createShowTime(String showBegins, Movie m){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the number of showTimes to be created");
            showList.add(new ShowTime(showBegins, m));

    }

    public void printListOfShowTimes(){
        for(ShowTime num: showList){
            System.out.println(num.getShowBegins());
        }
    }
    public ArrayList<ShowTime> getArrayOfShowTimes(){
        return this.showList;
    }
// print which show time to remove


    public void removeShowTime(String showBegin){
        for(ShowTime n : showList){
            if(n.getShowBegins().equals(showBegin)){
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


}
