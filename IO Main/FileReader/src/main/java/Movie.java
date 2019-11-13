import java.util.ArrayList;

public class Movie implements Serialization, Comparable<Movie>{
    private int movieID;
    private String movieTitle;
    private int totalRatings;
    private int totalRaters;
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
        this.averageRating = 0;
    }
    public Movie(String[] item) {
    	this.movieID = Integer.parseInt(item[0]);
    	this.movieTitle = item[1];
    	this.totalRatings = Integer.parseInt(item[2]);
    	this.totalRaters = Integer.parseInt(item[3]);
    	this.showingStatus = item[4];
    	this.movieAgeRating = Integer.parseInt(item[5]);
    	this.averageRating = Integer.parseInt(item[6]);
    	this.duration = Integer.parseInt(item[7]);
    }
    

    public void addToAverageRating(int e)  //Reviews/Ratings Manager Class will use this function to add ratings to a particular movie
    {
        //listOfRatings.add(e);

        //int totalRatingSum = 0;

       /* for(int i = 0; i< totalRatings; i++)
        {
            totalRatingSum = totalRatingSum + listOfRatings.get(i);
        }*/
    	int averageRating;
    	if(totalRaters>0) {
    		averageRating = ((totalRatings/totalRaters ) + e) / (totalRaters+1);}
    	else {
    		averageRating =e;
    	}
        totalRaters++;
        
        this.averageRating = averageRating;
    }

    public int getAverageRating(){
        return this.averageRating;
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
        String[] csv = {Integer.toString(this.movieID), this.movieTitle,Integer.toString(this.totalRatings),Integer.toString(this.totalRaters), this.showingStatus, Integer.toString(this.movieAgeRating), Integer.toString(this.averageRating), Integer.toString(this.duration)};
        return csv;
    }
    
    // convert arraylist of reviews to string array
    // string[] csv = string[]
    
}



