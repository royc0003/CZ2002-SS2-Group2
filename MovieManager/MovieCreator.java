import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MovieCreator {
    private ArrayList<ShowTime> showList;
    private Movie movie;

    /*MovieCreator(Movie movie, ArrayList<ShowTime> showList){
        this.movie = movie;
        this.showList = showList;
    }*/
    public MovieCreator() {

    }
    public Movie createMovie(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert movieId, movieTitle, movieRating, movieAgeRating, showingStatus");
        int a = sc.nextInt();
        String b = sc.nextLine();
        int c = sc.nextInt();
        int d = sc.nextInt();
        String e = sc.nextLine();
        return new Movie(a,b,c,d,e);
    }
    public void createShowTime(Date showBegins, Date showEnds){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert the number of showTimes to be created");
        int i = sc.nextInt();
        for(int x = 0; x < i; x++){
            showList.add(new ShowTime(showBegins, showEnds));
        }
    }

    public void printShowTime(){
        for(ShowTime num: showList){
            System.out.println(num);
        }
    }
    public String getMovieTitle(){
        return movie.getMovieTitle();
    }
    public int getMovieID(){
        return movie.getMovieID();
    }

    public void removeShowTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Which showTime to be removed?");
        int i = sc.nextInt();
        showList.remove(i);
    }
    public Movie getMovie(){
        return this.movie;
    }


    public ArrayList<ShowTime> getShowList(){
        return this.showList;
    }
}
