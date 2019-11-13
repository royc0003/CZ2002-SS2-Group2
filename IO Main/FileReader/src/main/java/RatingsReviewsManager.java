import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RatingsReviewsManager
{
	//private Movie movie;
    public RatingsReviewsManager() {
    	System.out.println("In the  RATING MANAGER");
    }
	
	public void addRating(MovieManager m)
	{   
		m.printGlobalListOfMovieIDs();

		System.out.println("Enter the movie ID you want to add the rating to: ");
		Scanner sc2 = new Scanner(System.in);
		int ID = sc2.nextInt();
		int i;
		for( i = 0; i< m.getGlobalListOfMovieObjects().size(); i++)
		{
			if(ID == m.getGlobalListOfMovieObjects().get(i).getMovieID())
			{
				System.out.println("Add movie rating: ");
				Scanner sc = new Scanner(System.in);
				int rating = sc.nextInt();
				m.getGlobalListOfMovieObjects().get(i).addToAverageRating(rating);
				break;
			}
			
		}
		if(i == m.getGlobalListOfMovieObjects().size()) {
			System.out.println("Movie can't be found!");
		}
	}
	
	public void displayByRank(MovieManager m) //sorts movies based on ratings and display the top 5 movies
	{
		
		ArrayList<Movie> tempArrayList = m.getGlobalListOfMovieObjects(); //temporary array list to store all movies
		
		Collections.sort(tempArrayList); //sort the movies based on AverageRating
		System.out.println("=========== TOP 5 MOVIES BY RATING ==========");
		for(Movie x : tempArrayList) //display top 5 movies based on average ratings
		{
			System.out.println("1. " + tempArrayList.get(0).getMovieTitle() + " Average Rating: " + tempArrayList.get(0).getAverageRating());
			System.out.println("2. " + tempArrayList.get(1).getMovieTitle() + " Average Rating: " + tempArrayList.get(1).getAverageRating());
			System.out.println("3. " + tempArrayList.get(2).getMovieTitle() + " Average Rating: " + tempArrayList.get(2).getAverageRating());
			System.out.println("4. " + tempArrayList.get(3).getMovieTitle() + " Average Rating: " + tempArrayList.get(3).getAverageRating());
			System.out.println("5. " + tempArrayList.get(4).getMovieTitle() + " Average Rating: " + tempArrayList.get(4).getAverageRating());
			break;
		}	
	}
	
	public void addReview(MovieManager m)
	{
		
		System.out.println("In the Reviews");
		m.printGlobalListOfMovieIDs();

		System.out.println("Enter the movie ID you want to add the review to: ");
		Scanner sc2 = new Scanner(System.in);
		int ID = sc2.nextInt();
		
		for(int i = 0; i< m.getGlobalListOfMovieObjects().size(); i++)
		{
			if(ID == m.getGlobalListOfMovieObjects().get(i).getMovieID())
			{
				System.out.println("Add movie review: ");
				Scanner sc = new Scanner(System.in);
				String review = sc.nextLine();
				m.getGlobalListOfMovieObjects().get(i).addReview(review);
			}
			else
			{
				System.out.println("No such movie found!");
			}
		}
	}
	
	public void displayMovieAndReviews(MovieManager movieManager)//display movie and all its reviews for a specific movie
	{
		System.out.println("Type the movieID you want to add review to");
		movieManager.printGlobalListOfMovieIDs();
		
		Scanner sc = new Scanner(System.in);
		int movieID = sc.nextInt();
		
		for(int i = 0; i< movieManager.getGlobalListOfMovieObjects().size(); i++)
		{
			if(movieID == movieManager.getGlobalListOfMovieObjects().get(i).getMovieID())
			{
				movieManager.getGlobalListOfMovieObjects().get(i).displayMovieAndReviews();
	
			}
		}
	
}
	

	
}