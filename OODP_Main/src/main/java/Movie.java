import java.io.Serializable;
import java.util.ArrayList;
/**
* Represents a movie
* There can be many movies in a cineplex
*/
public class Movie implements Serialization, Comparable<Movie>, Serializable {
	/**
	 * The ID of the movie
	 */
	private int movieID;
	
	/**
	* The title of the movie
	*/
	private String movieTitle;
	/**
	* Array list of ratings for movie
	*/
    private ArrayList<Integer> listOfRatings = new ArrayList<>();
    
    /**
	* Showing Status of Movie
	*/
    private String showingStatus;
    
    /**
	* Minimum age to watch the movie
	*/
    private int movieAgeRating;
    /**
	* Average rating of movie
	*/
    private double averageRating; 
    /**
	* Duration of the movie (in minutes)
	*/
    private int duration;
    /**
     * duration of the movie
     */
    private String director;
    /**
     * array list of cast members
     */
    private ArrayList<String> listOfCast = new ArrayList<String>();
    /**
     * synopsis of the movie
     */
    private String synopsis;
    /**
     * array list of review
     */
    private ArrayList<String> listOfReviews = new ArrayList<String>(); // array list of reviews
    /**
     * number of tickets sold
     */
    private int noOfTicketSold;
    /**
	* Creates a new movie with the given movie id, title,
	* showing status and duration
	*/
    public Movie(int iD, String title, int ageRating, String showingStatus, int duration, String director, String synopsis, ArrayList<String> listOfCast)
    {
        this.movieID = iD;
        this.movieTitle = title;
        this.movieAgeRating = ageRating;
        this.showingStatus = showingStatus;
        this.duration = duration;
        this.averageRating = 0;
        this.director = director;
        this.synopsis = synopsis;
        this.listOfCast = listOfCast;
        this.noOfTicketSold = 0;
    }
    /**
     * 
     * @param item
     */
    public Movie(String[] item) {
    	this.movieID = Integer.parseInt(item[0]);
    	this.movieTitle = item[1];
    	this.showingStatus = item[2];
    	this.movieAgeRating = Integer.parseInt(item[3]);
    	this.averageRating = Integer.parseInt(item[4]);
    	this.duration = Integer.parseInt(item[5]);
    }
    
    /**
	* Adds a rating to the movie and computes average rating
	* based on total number of ratings.
	* @param e Rating added to movie.
	*/
    public void addToAverageRating(int e)  //Reviews/Ratings Manager Class will use this function to add ratings to a particular movie
    {
        listOfRatings.add(e);

        double totalRatingSum = 0;

        for(int i = 0; i< listOfRatings.size(); i++)
        {
            totalRatingSum = totalRatingSum + listOfRatings.get(i);
        }

        double averageRating = totalRatingSum / listOfRatings.size();

        this.averageRating = averageRating;
    }

    /**
	* Get average movie rating of a movie
	* @return this averageRating.
	*/
    public int getAverageRating(){
        return this.movieAgeRating;
    }

    /**
	* Changes the movie ID of the movie.
	* @param movieID the movie's new ID
	*/
    public void setMovieID(int movieID){
    this.movieID = movieID;
    }
    
    /**
	* Get ID of movie
	* @return this movieID.
	*/
    public int getMovieID(){
        return movieID;
    }
    /**
	* Get director of movie
	* @return director
	*/
    public String getdirector(){
        return this.director;
    }
    /**
	* Get synopsis of movie
	* @return synopsis
	*/
    public String getSynopsis(){
        return this.synopsis;
    }
    /**
	* Get cast list
	* @return cast list
	*/
    public ArrayList<String> getListOfCast(){
        return this.listOfCast;
    }
    /**
	* Changes the movie title of a movie
	* @param movieTitle, the new movie's title
	*/
    public void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }
    
    /**
	* Get title of movie
	* @return this movieTitle.
	*/
    public String getMovieTitle(){
       return movieTitle;
	}


    /**
	* Changes movie title
	* @param duration, the new duration of movie
	*/
    public void setMovieDuration(int duration){
        this.duration = duration;
    }
    
    /**
	* Get duration of movie
	* @return this duration of movie.
	*/	
    public int getMovieDuration(){
        return this.duration;
    }

    /**
	* Changes the minimum age to enter movie
	* @param movieAgeRating, the new minimum age
	*/
    public void setMovieAgeRating(int movieAgeRating){
        this.movieAgeRating = movieAgeRating;
    }
    
    /**
	* Get minimum age to enter movie
	* @return this movieAgeRating.
	*/
    public int getMovieAgeRating(){
    	return movieAgeRating;
    }

    /**
	* Changes the showing status of a movie
	* @param showingStatus, the new showing status
	*/
    public void setMovieShowingStatus(String showingStatus){
        this.showingStatus = showingStatus;
    }
    
    /**
	* Get showing status of a movie
	* @return this showing status.
	*/
    public String getMovieShowingStatus(){
    	return showingStatus;
    }

    /**
	* prints all the reviews of a movie
	*/
    public void displayMovieAndReviews()
    {
        System.out.println(movieTitle);
        for(int i = 0; i< listOfReviews.size(); i++)
        {
            System.out.println(listOfReviews.get(i));
        }

    }
    /**
	* Adds a review to array list of movie reviews
	*/
    public void addReview(String review)
    {
        listOfReviews.add(review);
    }
    /**
	* Adds a cast to array list of cast members
	*/
    public void addCast(String cast)
    {
        listOfCast.add(cast);
    }

    /**
	* Used in comparable method in RatingsReviewsManager
	*  to compare average rating of movies
	*  @param m, the movie object
	*/
    @Override
    public int compareTo(Movie m)
    {
        return (int)(m.getAverageRating() - averageRating);
    }
    /**
     * get number of tickets sold
     * @return number of tickets sold
     */
    public int getNoOfTicketSold()
    {
        return this.noOfTicketSold;
    }
    /**
     * adds number of tickets sold
     */
    public void addToNoOfTicketSold()
    {
        noOfTicketSold++;
    }
    /**
	* Allows input to CSV
	* @return String array
	*/
    public String[] toCsv(){

        String[] csv = {Integer.toString(this.movieID), this.movieTitle, this.showingStatus, Integer.toString(this.movieAgeRating),

                Integer.toString(movieAgeRating)

        };

        return csv;

    }
}


