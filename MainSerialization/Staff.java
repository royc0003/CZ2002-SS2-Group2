import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Staff {
    //{"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"}
    ArrayList<Movies> movieList;
    MainCSVHelper csvHelper = new MainCSVHelper();
    //initializating of objects required
    public void initializeObjects(){
        try {
            System.out.println("**************************Initializing Objects....");
            this.movieList = csvHelper.readFromMoviesCSV();
            for(Movies n: movieList){
                System.out.println(n.getMovieTitle());
            }
        }
        catch(IOException e){
            e.getStackTrace();
            System.out.println("Could not find the file");
        }
    }
    //savetoCSV to be implemented in functions that require it to be saved
    public void saveToCSV(ArrayList<Movies> movieList){
        try{
            System.out.println("***********************************Saving to CSV....");
            csvHelper.writeToMovieCSV(movieList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Movies> getMovieList(){
        return this.movieList;
    }

    public static void main(String[] args) {
        Staff renew = new Staff();
        renew.initializeObjects();
        ArrayList<Movies> trying = renew.getMovieList();
        System.out.println("Size of trying is : "+ trying.size());
        for(Movies n : trying){
            System.out.println(n.getMovieTitle());
        }
       /* Movies movie1 = new Movies(1, "TheJoke", 5, 18, "NowShowing");
        Movies movie2 = new Movies(2, "Cinderella", 10, 12, "NowShowing");
        Movies movie3 = new Movies(3, "IWannaRest", 100, 21, "NowShowing");
        Movies movie4 = new Movies(4, "Clarita&KokLiang", 100, 21, "NowShowing");
       trial.add(movie1);
       trial.add(movie2);
       trial.add(movie3);
       trial.add(movie4);
       lolStaff.saveToCSV(trial);

        Movies movie1 = new Movies(1, "TheJoke", 5, 18, "NowShowing");
        Movies movie2 = new Movies(2, "Cinderella", 10, 12, "NowShowing");
        Movies movie3 = new Movies(3, "IWannaRest", 100, 21, "NowShowing");
        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);
        try {
           // csvHelper.writeToMovieCSV(movieList);
            System.out.println("This is working");
            ArrayList<Movies> movieList = csvHelper.readFromMoviesCSV();
            for(Movies n: movieList){
                System.out.println(n.getMovieTitle());
            }
            System.out.println(movieList.size());

        }
        catch(IOException e){
            e.getStackTrace();
            System.out.println("Could not find the file");
        }*/
        //using power for loop

       // System.out.println(movieList.size());
       // System.out.println("This is working");
    }


}
