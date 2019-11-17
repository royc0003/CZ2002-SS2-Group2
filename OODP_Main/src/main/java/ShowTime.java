/**
 * Represents a showtime object, 
 */
import java.io.Serializable;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTime implements Serialization, Serializable { // remember to implement showTime
	/**
	* The start time of the movie
	*/// remember to implement showTime
    private String showBegins;//  with the assumption that its in 24hrs format
    /**
	* The end time of the movie
	*/
    private String showEnds;
    /**
	* ID of the cinema movie is playing in 
	*/
    private int cinemaID;
    /**
	* Movie of showtime
	*/
    private Movie movie;
    
    /**
	* Creates a new showtime object
	* @param showBegins This start time of movie
	* @param movie This Movie of showtime
	* @param cinemaID This cinema's ID
	*/
    public ShowTime(String showBegins, Movie movie, int cinemaID) { // note that duration will be given in minutes
        this.showBegins = showBegins; // ill receive duration in integer
        String part1 = showBegins.substring(0,2); //11
        String part2 = showBegins.substring(2); // 30
        int x = Integer.parseInt(part1)*60; // converison to minutes 660
        int total = x + Integer.parseInt(part2) + movie.getMovieDuration();
        if(total >= 1440){
            total -= 1440;
        }
        int hour = total/60; // gives the hour
        int min = total %60; // remainder gives min
        this.showEnds = (Integer.toString(hour) + Integer.toString(min));
        this.cinemaID = cinemaID;
        this.movie = movie;
    }
    public ShowTime(String[] item) {
    	this.showBegins = item[0];
    	this.showEnds = item[1];
    	this.cinemaID = Integer.parseInt(item[2]);
    }
    
    //*********************************************************************************************************************
    /**
   	* Changes start time of movie
   	* @param showBegins New movie start time
   	*/
       public void setShowBegins(String showBegins){
           this.showBegins = showBegins;
       }
       /**
   	* Gets movie title of showtime
   	* @return movie title of showtime
   	*/
       public String getMovieTitle(){
           return movie.getMovieTitle();
       }
       /**
   	* Gets start time of movie
   	* @return start time of movie
   	*/
       public String getShowBegins() {
           return this.showBegins;
       }
       /**
   	* Changes ending time of movie
   	* @param showEnds New movie end time
   	*/
       public void setShowEnds(String showEnds) {
           this.showEnds = showEnds;
       }
       /**
   	* Gets end time of movie
   	* @return end time of movie
   	*/
       public String getShowEnds() {
           return showEnds;
       }
       /**
   	* Changes cinema ID of showtimes
   	* @param cinemaID New cinema ID of showtime
   	*/
       public void setShowTimeCinemaID(int cinemaID){
           this.cinemaID = cinemaID;
       }
       /**
   	* Gets cinema ID of showtime
   	* @return cinema ID of showtime
   	*/
       public int getShowTimeCinemaID(){
           return this.cinemaID;
       }

       /**
   	* Stores data into csv
   	* @return String array
   	*/
       public String[] toCsv() {
           String[] csv = {this.showBegins, this.showEnds, Integer.toString(this.cinemaID)};
           return csv;
       }


}