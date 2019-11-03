public class Movie implements Serialization{
    private int movieID;
    private String movieTitle;
    private int movieRating;
    private int movieAgeRating;
    private String showingStatus;

    public Movie(int movieID, String movieTitle, int movieRating,int movieAgeRating, String showingStatus){
        this.movieID =movieID;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
        this.movieAgeRating =movieAgeRating;
        this.showingStatus = showingStatus;
    }
public void setMovieID(int movieID){
    this.movieID = movieID;
}
public int getMovieID(){
        return movieID;
}

public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
}
public String getMovieTitle(){
       return movieTitle;
}
public void setMovieRating(int movieRating){
        this.movieRating = movieRating;
}
public int getMovieRating(){
    return movieAgeRating;
}


public void setMovieAgeRating(int movieAgeRating){
        this.movieAgeRating = movieAgeRating;
}
public int getMovieAgeRating(){
    return movieAgeRating;
}


public void setShowingStatus(String showingStatus){
        this.showingStatus = showingStatus;
}
public String getShowingStatus(){
    return showingStatus;
}
public String[] toCsv(){
    String[] csv = {Integer.toString(this.movieID), this.movieTitle, Integer.toString(this.movieRating),
            Integer.toString(movieAgeRating), this.showingStatus
    };
    return csv;
    }
}





