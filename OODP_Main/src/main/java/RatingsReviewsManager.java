/**
 * This class allows customers/staff to add ratings, add reviews, display top 5 movies by ratings,
 * display reviews of a specified movie. There will only be one RatingsReviewsManager object.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class RatingsReviewsManager
{
    //private Movie movie;
	/**
	 * Adds rating to a movie
	 * @param m MovieManager object
	 */
    public void addRating(MovieManager m)
    {
        m.printGlobalListOfMovieIDs();

        System.out.println("Enter the movie ID you want to add the rating to: ");
        Scanner sc2 = new Scanner(System.in);
        int ID = sc2.nextInt();

        for(int i = 0; i< m.getGlobalListOfMovieObjects().size(); i++)
        {
            if(ID == m.getGlobalListOfMovieObjects().get(i).getMovieID())
            {
                System.out.println("Add movie rating: ");
                Scanner sc = new Scanner(System.in);
                int rating = sc.nextInt();
                m.getGlobalListOfMovieObjects().get(i).addToAverageRating(rating);
                return;
            }

        }

            System.out.println("No such movie found!");

    }
    
    /**
	 * Sorts movies based on average ratings and displays the top 5 movies
	 * @param m MovieManager object
	 */
    public void displayByRank(MovieManager m) //sorts movies based on ratings and display the top 5 movies

    {
        System.out.println("Choose an option: ");
        System.out.println("1. Rank Top 5 By rating");
        System.out.println("2. Rank Top 5 Movies by number of tickets sold");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if(choice == 1) //rank by rating
        {
            ArrayList<Movie> tempArrayList = m.getGlobalListOfMovieObjects(); //temporary array list to store all movies
            Collections.sort(tempArrayList); //sort the movies based on AverageRating

            System.out.println("========= TOP 5 MOVIES BY RATINGS ============");

            if(tempArrayList.size() >= 5){
                System.out.println("1. " + tempArrayList.get(0).getMovieTitle() + " Average Rating: " + tempArrayList.get(0).getAverageRating());
                System.out.println("2. " + tempArrayList.get(1).getMovieTitle() + " Average Rating: " + tempArrayList.get(1).getAverageRating());
                System.out.println("3. " + tempArrayList.get(2).getMovieTitle() + " Average Rating: " + tempArrayList.get(2).getAverageRating());
                System.out.println("4. " + tempArrayList.get(3).getMovieTitle() + " Average Rating: " + tempArrayList.get(3).getAverageRating());
                System.out.println("5. " + tempArrayList.get(4).getMovieTitle() + " Average Rating: " + tempArrayList.get(4).getAverageRating());
            }

            else
            {
                int i = 0;
                for (Movie x : tempArrayList)
                {
                    System.out.println((i+1) + x.getMovieTitle() + "Average Rating: " + x.getAverageRating());
                    i++;
                }
            }
        }
        else if (choice == 2)
        {
            MovieAndShowtimes[] tempArray2 = new MovieAndShowtimes[sortMovieByNoOfTicketSold(m).length];
            for(int i=0; i<sortMovieByNoOfTicketSold(m).length; i++)
            {
                tempArray2[i] = sortMovieByNoOfTicketSold(m)[i];
            }
            System.out.println("=========== TOP 5 MOVIES BY TICKET SALES =============");
            if(tempArray2.length >= 5)
            {
                System.out.println("1. " + tempArray2[0].getMovieTitle() + " No Of Tickets Sold: " + tempArray2[0].getNoOfTicketSold());
                System.out.println("2. " + tempArray2[1].getMovieTitle() + " No Of Tickets Sold: " + tempArray2[1].getNoOfTicketSold());
                System.out.println("3. " + tempArray2[2].getMovieTitle() + " No Of Tickets Sold: " + tempArray2[2].getNoOfTicketSold());
                System.out.println("4. " + tempArray2[3].getMovieTitle() + " No Of Tickets Sold: " + tempArray2[3].getNoOfTicketSold());
                System.out.println("5. " + tempArray2[4].getMovieTitle() + " No Of Tickets Sold: " + tempArray2[4].getNoOfTicketSold());
            }
            else
            {
                int i = 0;
                for(MovieAndShowtimes x: tempArray2)
                {
                    System.out.println((i+1) + x.getMovieTitle() + "No Of Tickets Sold: "  + x.getNoOfTicketSold());
                }
            }
        }
        else
        {
            System.out.println("Invalid choice");
        }
    }
    /**
	 * Adds a review to a movie
	 * @param m MovieManager object
	 */
    public void addReview(MovieManager m)
    {
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
                return;
            }

        }

            System.out.println("No such movie found!");

    }
    /**
	 * Display all reviews of a specified movie
	 * @param movieManager MovieManager object
	 */
    public void displayMovieAndReviews(MovieManager movieManager)//display movie and all its reviews for a specific movie
    {
        System.out.println("Type the movieID you want to see reviews for");
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

    public MovieAndShowtimes[] sortMovieByNoOfTicketSold(MovieManager m)
    {

        MovieAndShowtimes[] SortMovieCopy= new MovieAndShowtimes[m.listOfMovieAndShowtimes.size()];

        for(int i=0; i<m.listOfMovieAndShowtimes.size(); i++)
        {
            SortMovieCopy[i]= m.listOfMovieAndShowtimes.get(i);
        }

        if(SortMovieCopy.length > 1)
        {
            for (int i = 1; i < SortMovieCopy.length; i++)
            {
                for (int j = i; j > 0; j--)
                {
                    if (SortMovieCopy[i].getNoOfTicketSold() > SortMovieCopy[j - 1].getNoOfTicketSold())
                    {
                        MovieAndShowtimes temp = SortMovieCopy[j];
                        SortMovieCopy[j] = SortMovieCopy[j - 1];
                        SortMovieCopy[j - 1] = temp;
                    }
                }
            }
        }
        return SortMovieCopy;
    }

}