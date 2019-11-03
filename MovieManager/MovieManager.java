import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MovieManager {
    private MovieDisplay displayMovie;
    private ArrayList<MovieCreator> listOfMovieCreator;

    public MovieManager(MovieDisplay displayMovie, ArrayList<MovieCreator> listOfMovieCreator){
        this.displayMovie = displayMovie;
        this.listOfMovieCreator = listOfMovieCreator;
    }
    public void printDetails(ArrayList<MovieCreator> listOfMovieCreator){
        for(MovieCreator x : listOfMovieCreator){
            displayMovie.printDetails(x.getMovie().getMovieID(),x.getMovie().getMovieTitle(), x.getMovie().getMovieRating(), x.getMovie().getMovieAgeRating(), x.getMovie().getShowingStatus());
        };
    }
    public void createMovieCreator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert number of creators");
        int i = sc.nextInt();
        for(int x= 0; x< i; x++){
            listOfMovieCreator.add(new MovieCreator());
        }
    }

    public void createMovieShowtimes(){ // new function
        createMovie();
        for(MovieCreator n: listOfMovieCreator){ // we need to check for every title
            System.out.println("You are referring to this movie: "+ n.getMovieTitle());
            createShowTimes();
        }
    }
    public void removeMovie(int index) {
        for(MovieCreator n: listOfMovieCreator){
            if(n.getMovieID() == index){
                listOfMovieCreator.remove(index);
                break;
            }
        }
    }


    private void createMovie(){
        for(MovieCreator n : listOfMovieCreator){
            n.createMovie();
        }
    }

    private void createShowTimes(){
        Scanner sc = new Scanner(System.in);
        for(MovieCreator n: listOfMovieCreator){
            //Date showBegins =; // remember to update this
            //Date showEnds =  ; // remember to update this
            //n.createShowTime(Date showBegins, Date showEnds);
        }
    }

    public void getMovie(int index) { // to poinder upon remeber to input size
        for (MovieCreator n : listOfMovieCreator) {
            if (n.getMovieID() == index) {
                return ;
            }
        }
    }

    public void getShowLIst(int index){ // remenber to input size
        for(MovieCreator n: listOfMovieCreator){
            if(n.getMovieID() == index){
                //return n.getShowList();
            }
        }
    }





}
