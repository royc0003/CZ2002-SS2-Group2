import java.util.ArrayList;

public class Movie implements Serialization, Comparable<Movie>{
    private int movieID;
    private String movieTitle;
    private ArrayList<Integer> listOfRatings = new ArrayList<>();
    private String showingStatus;
    private int movieAgeRating;
    private int averageRating; // main one
    private int duration;
    private ArrayList<String> listOfReviews = new ArrayList<String>(); // array list of reviews

    public Movie(int iD, String title, int ageRating, String showingStatus, int duration)
    {
        this.movieID = iD;
        this.movieTitle = title;
        this.movieAgeRating = ageRating;
        this.showingStatus = showingStatus;
        this.duration = duration;
    }
    public Movie(String[] item) {
    	this.movieID = Integer.parseInt(item[0]);
    	this.movieTitle = item[1];
    	this.showingStatus = item[2];
    	this.movieAgeRating = Integer.parseInt(item[3]);
    	this.averageRating = Integer.parseInt(item[4]);
    	this.duration = Integer.parseInt(item[5]);
    }
    

    public void addToAverageRating(int e)  //Reviews/Ratings Manager Class will use this function to add ratings to a particular movie
    {
        listOfRatings.add(e);

        int totalRatingSum = 0;

        for(int i = 0; i< listOfRatings.size(); i++)
        {
            totalRatingSum = totalRatingSum + listOfRatings.get(i);
        }

        int averageRating = totalRatingSum / listOfRatings.size();

        this.averageRating = averageRating;
    }

    public int getAverageRating(){
        return this.movieAgeRating;
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



public void setMovieDuration(int duration){
        this.duration = duration;
}
public int getMovieDuration(){
        return this.duration;
}


public void setMovieAgeRating(int movieAgeRating){
        this.movieAgeRating = movieAgeRating;
    }
public int getMovieAgeRating(){
    return movieAgeRating;
}


public void setMovieShowingStatus(String showingStatus){
        this.showingStatus = showingStatus;
}
public String getMovieShowingStatus(){
    return showingStatus;
}

public void displayMovieAndReviews()
    {
        System.out.println(movieTitle);
        for(int i = 0; i< listOfReviews.size(); i++)
        {
            System.out.println(listOfReviews.get(i));
        }

    }

    public void addReview(String review)
    {
        listOfReviews.add(review);
    }


    @Override
    public int compareTo(Movie m)
    {
        return m.getAverageRating() - averageRating;
    }


    public String[] toCsv(){
        String[] csv = {Integer.toString(this.movieID), this.movieTitle, this.showingStatus, Integer.toString(this.movieAgeRating),
                Integer.toString(movieAgeRating)
        };
        return csv;
    }
}



