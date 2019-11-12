import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTime implements Serialization{ // remember to implement showTime
    private String showBegins;//  with the assumption that its in 24hrs format
    private String showEnds;
    private int cinemaID;
    private Movie movie;
    
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
    public void setShowBegins(String showBegins){
        this.showBegins = showBegins;
    }
    
    public String getMovieTitle(){
        return movie.getMovieTitle();
    }
    public String getShowBegins() {
        return this.showBegins;
    }
    public void setShowEnds(String showEnds) {
        this.showEnds = showEnds;
    }
    public String getShowEnds() {
        return showEnds;
    }
    public void setShowTimeCinemaID(int cinemaID){
        this.cinemaID = cinemaID;
    }
    public int getShowTimeCinemaID(){
        return this.cinemaID;
    }

    public String[] toCsv() {
        String[] csv = {this.showBegins, this.showEnds, Integer.toString(this.cinemaID)};
        return csv;
    }

}