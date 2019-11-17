import java.io.Serializable;	
/**
	 * Print out all the movies in the cineplex along with its movie id, title, and rating
	 * The movies are sorted according to their movie id
	 */
public class MovieDisplay {
	
	/**
	 * @param movieID the movieID 
	 * @param movieTitle the title of the movie
	 * @param movieAgeRating the age appropriateness of the movie
	 * @param movieAverageRaing the average ratings for the movie 
	 * @param movieDuration the duration of the movie
	 * @param showingStatus the status of the movie showing
	 */
    public void printDetails(int movieID, String movieTitle, int movieAgeRating, int movieAverageRating, int movieDuration, String showingStatus)
    {
        
    	System.out.println("*********************************************");
        System.out.println("Movie ID: " + movieID);
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Movie Rating: " + movieAverageRating);
        System.out.println("Minimum age to enter: " + movieAgeRating);
        System.out.println("Movie Duration: " + movieDuration);
        System.out.println("Showing Status: " + showingStatus);
        System.out.println("*********************************************");
    }
}