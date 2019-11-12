//{"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"}

import java.util.ArrayList;
import java.util.Scanner;
public class Movies implements Serialization {
    private int movieID;
    private String movieTitle;
    private int movieRating;
    private int movieAgeRating;
    private String showingStatus;

    public int getMovieID(){
        return this.movieID;
    }
    public String getMovieTitle(){
        return this.movieTitle;
    }
    public int getMovieRating(){
        return this.movieRating;
    }
    public int getMovieAgeRating(){
        return this.movieAgeRating;
    }
    public String getShowingStatus(){
        return this.showingStatus;
    }


    // this creates a list of showTimes
    public Movies(String[] item){
        this.movieID = Integer.parseInt(item[0]);
        this.movieTitle = item[1];
        this.movieRating  = Integer.parseInt(item[2]);
        this.movieAgeRating = Integer.parseInt(item[3]);
        this.showingStatus = item[4];
    }
    public Movies(int movieID, String movieTitle, int movieRating, int movieAgeRating, String showingStatus){
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
        this.movieAgeRating = movieAgeRating;
        this.showingStatus = showingStatus;

    }


    public String convertToString(int i) {
        return Integer.toString(i);
    }
    public String[] toCsv(){
        String[] csv = {convertToString(this.movieID), this.movieTitle, convertToString(this.movieRating),
        convertToString(this.movieAgeRating), this.showingStatus};
        return csv;
    }
}

