import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RatingsReviewManager
{
	//private Movie movie;
		
	public void addRating(Movie m)
	{
		System.out.println("Add movie rating: ");
		Scanner sc = new Scanner(System.in);
		int e = sc.nextInt();
		
		m.addRating(e);
	}
	
	public void displayByRank(MovieManager m) //sorts movies based on ratings and display the top 5 movies
	{
		
		ArrayList<Movie> tempArrayList = m.getGlobalListOfMovieObjects(); //temporary array list to store all movies
		
		Collections.sort(tempArrayList); //sort the movies based on AverageRating
		
		for(Movie m : tempArrayList) //display top 5 movies based on average ratings
		{
			System.out.println("1. " + tempArrayList.get(0).getMovieTitle() + "Average Rating: " + tempArrayList.get(0).getAverageRating());
			System.out.println("2. " + tempArrayList.get(1).getMovieTitle() + "Average Rating: " + tempArrayList.get(1).getAverageRating());
			System.out.println("3. " + tempArrayList.get(2).getMovieTitle() + "Average Rating: " + tempArrayList.get(2).getAverageRating());
			System.out.println("4. " + tempArrayList.get(3).getMovieTitle() + "Average Rating: " + tempArrayList.get(3).getAverageRating());
			System.out.println("5. " + tempArrayList.get(4).getMovieTitle() + "Average Rating: " + tempArrayList.get(4).getAverageRating());

		}	
	}
	
	public void addReview(Movie m)
	{
		System.out.println("Add movie review: ");
		Scanner sc = new Scanner(System.in);
		String review = sc.nextLine();
		
		m.addReview(review);
	}
	
	private void displayMovieAndReviews(Movie m)
	{
		m.displayMovieAndReviews();
	}
	
}
