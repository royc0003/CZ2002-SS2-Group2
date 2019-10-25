import java.io.IOException;
import java.util.ArrayList;

public class Staff {
    //{"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"}
    public static void main(String[] args) {
        MainCSVHelper csvHelper = new MainCSVHelper();
        ArrayList<Movies> movieList = new ArrayList<Movies>();
        Movies movie1 = new Movies(1, "TheJoke", 5, 18, "NowShowing");
        Movies movie2 = new Movies(2, "Cinderella", 10, 12, "NowShowing");
        Movies movie3 = new Movies(3, "IWannaRest", 100, 21, "NowShowing");
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        try {
            csvHelper.writeToMovieCSV(movieList);
        }
        catch(IOException e){
            e.getStackTrace();
            System.out.println("Could not find the file");
        }
    }

}
