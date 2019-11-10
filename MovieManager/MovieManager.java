import java.util.ArrayList;
import java.util.Scanner;

public class MovieManager {
    private MovieDisplay displayMovie;
    private static ArrayList<MovieAndShowtimes> listOfMovieAndShowtimes;

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
            listOfMovieAndShowtimes.add(new MovieAndShowtimes());
        }
        createMovie();;// adds movie to every single MovieShhowTimes objects created
    }


    private void createMovie(){ //creates new movies

        for(MovieAndShowtimes n : listOfMovieAndShowtimes){
            n.createMovie();
        }

    }
    //--------------MANAGES WITH REMOVAL OF MOVIES-------------------------------------------------------------------------------------------------------
    public void removeMovie(int MovieID) { // removes an object from a list of created Movies
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            if(n.getMovieID() == MovieID){
                listOfMovieAndShowtimes.remove(n);
                break;
            }
        }
    }
    //--------------MANAGES WITH LISTING OF DETAILS------------------------------------------------------------------------------------------------------
// return list of movieIDs done
    // prints list of movieIDs done
    // returns list of movieObjects
    // gets a single movie from the list of movieObjects --
public void printGlobalListOfMovieIDs(){
        System.out.println("******************************************************************");
        for(MovieAndShowtimes n: listOfMovieAndShowtimes){
            System.out.println("Movie ID: "+ n.getMovieID() +", Movie Title: "+n.getMovieTitle());
        }
    System.out.println("******************************************************************");
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
                //return n.getShowList();
            }
        }
    }




}
