

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffController extends CineplexManager
{
	PriceManager priceManager;
	StaffController(){
//		this.priceManager = new PriceManager();
		PriceManager trial = null;
		try {
			System.out.println("Reading from PriceManager.dat -----------");
			ObjectInputStream in = FileIOHelper.getSerialReader("PriceManager.dat");
			trial = (PriceManager)in.readObject() ; // reads from movie and showtime
			this.priceManager = trial; // tries to assign the arraylist of objects to current listofmovie and hsowtimes
			in.close();
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}

	}
	//private ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
	//private MovieManager movieManager;
	public PriceManager getPriceManager(){
		return this.priceManager;
	}
	 public void printWelcomePage(RatingsReviewsManager ratingReviewsManager)
	 {
	     int userChoice;
	     int option; 
	     do {
	     Scanner sc = new Scanner(System.in);

	     System.out.println("");
	     System.out.println("");

	     System.out.println("*********WELCOME STAFF!*********");
	     System.out.println("Option 1: Create a movie");
	     System.out.println("Option 2: Display all movies (global)");
	     System.out.println("Option 3: Create a cineplex");
	     System.out.println("Option 4: Assign movies to cineplex");
	     System.out.println("Option 5: Display available movies in cineplex (local)");
	     System.out.println("Option 6: Add showtimes to movie");
	     System.out.println("Option 7: Remove showtimes from movie");
	     System.out.println("Option 8: Update showtimes of movie");
	     System.out.println("Option 9: Update details to movie");
	     System.out.println("Option 10: List Top 5 movies by rating/ticket sales");
	     System.out.println("Option 11: change ticket price");
	     System.out.println("Option 12: Update showing status of movie for cineplex");
	     System.out.println("Option 13: Display showtimes in a Cinema");
	     System.out.println("Option 14: Display reviews for a movie");
	     System.out.println("Option 15: Save Data");
	     System.out.println("Option 16: Exit");


	     System.out.println("");
	     System.out.println("Please choose an option to do:");

	     userChoice = sc.nextInt();
	
	 
	         switch (userChoice){ 
	
	             case 1:
	            	 //create a movie
	            	 movieManager.createMovieCreator();
	                 break;
	             case 2:
	            	 //display all movies
	            	 //displayAllMovies(movieManager);
	            	 movieManager.printDetails(movieManager.getListOfMovieAndShowtimes());

	                 break;
	             case 3:
	            	 //create a cineplex
	            	 createCineplex();
	                 break;
	
	             case 4:
	            	 //assign movies to cineplex
	            	 printCineplexlist();
	            	 System.out.println("Choose the cineplex ID");
	            	 int ID = sc.nextInt();
	            	 
	            	 movieManager.printGlobalListOfMovieIDs();
	            	 System.out.println("Choose the movie ID");

	            	 int movieID = sc.nextInt();
	            	 
	            	 assignMoviesToCineplex(selectCineplex(ID), movieID);
	                 break;
	
	             case 5:
	            	 //display available movies in cineplex


	            	 printCineplexlist();
	            	 System.out.println("Choose the cineplex ID");
	            	 int cineplexID = sc.nextInt();
	            	 
	            	 Cineplex c = selectCineplex(cineplexID);


	            	 c.displayAvailableMovies();
	            	 
	                 break;
	             case 6:
	            	 //add showtimes to movie
	            	 printCineplexlist();
	            	 System.out.println("Choose the cineplex ID you want to add showtimes to");
	            	 int cineplexID1 = sc.nextInt();
	            	 
	            	 Cineplex c1 = selectCineplex(cineplexID1);	
	            	 c1.createShowtimesAndAssignToCinema();
	                 break;
	                
	             case 7: 
	            	 //delete showtimes of a cinema
	            	 printCineplexlist();
	            	 System.out.println("");
	            	 System.out.println("Choose the cineplex ID you want to delete showtimes from");
	            	 int cineplexID2 = sc.nextInt();
	            	 
	            	 Cineplex c2 = selectCineplex(cineplexID2);	
	            	 c2.deleteShowTimeToMovie();
	                 break;
	                 
	             case 8:
	            	 //update showtimes of a cinema
	            	 printCineplexlist();
	            	 System.out.println("Choose the cineplex ID you want to update showtimes from");
	            	 int cineplexID3 = sc.nextInt();
	            	 
	            	 Cineplex c3 = selectCineplex(cineplexID3);	
	            	 c3.updateShowtimeToMovie();
	                 break;
	            
	             case 9: 
	            	 
	            	// movieManager.printGlobalListOfMovieIDs();
	            	 movieManager.printDetails(movieManager.getListOfMovieAndShowtimes());
	            	 System.out.println("");
	            	 movieManager.updateDetailsToMovie();
	            	 
	            	 //update details to movie
	            	 break;
	             
	             case 10:
	            	 //list top 5 by ratings/ticket sales
	            	 System.out.println("Choose an option: ");
	            	 System.out.println("1. Rank by ratings");
	            	 System.out.println("2. Rank by ticket sales");
	            	 
	            	 int choice = sc.nextInt();
	            	 
	            	 if(choice == 1)
	            	 {
	            		 ratingReviewsManager.displayByRank(movieManager);
	            	 }
	            	 else
	            	 {
	            		 System.out.println("test");
	            	 }
	            	 break;
	             case 11:
	            	 //change ticket price
	            	 priceManager.changeRates();
					 try {
						 System.out.println("Saving PriceManager.dat-----");
						 ObjectOutputStream out = FileIOHelper.getSerialWriter("PriceManager.dat");
						 out.writeObject(priceManager);
						 out.close();
					 } catch (IOException e) {
						 e.printStackTrace();
					 }
					 // saves here

	            	 break;
	             case 12:
	            	 //update showing status of a movie

	            	 System.out.println("");
					 changeShowingStatusAndRemoveMovieInCineplex();

	            	 break;
	             case 13:
	            	 //show the showtimes of a certain cinema in a Cineplex

	            	 printCineplexlist();
	            	 System.out.println("Choose the cineplex ID you want to see the showtimes");
	            	 int cineplexID5 = sc.nextInt();
	            	 
	            	 Cineplex c5 = selectCineplex(cineplexID5);	
	            	 
	            	 printCinemaIdForCineplex(cineplexID5);
	            	 System.out.println("Choose a cinema to display the showtimes");
	            	 int cinemaID= sc.nextInt();
	            	 c5.displayShowTimesForCinema(cinemaID);
	            	 break;
				 case 14:
				 	ratingReviewsManager.displayMovieAndReviews(movieManager);
				 	break;
				 case 15: // might be useless for this one; most likely is // steps is to find
					 // the class or possibly the constructor that initiates the use of moviemanager once
					 // note to save the data as .dat instead of ser
					 // initializes once
				 	System.out.println("Saving MovieAndShowtimes before");
					 MainCSVHelper.writeSerializedObject("MovieAndShowtimes.dat", getMovieManager().getListOfMovieAndShowtimes());
				 	System.out.println("Saving MovieANdShowtimes After");

					 System.out.println("Saving Cineplex.dat Before");
				 	MainCSVHelper.writeSerializedObject("Cineplex.dat", this.cineplexList);
					 System.out.println("Saving Cineplex.dat After");



			 }
	         
	         System.out.println("Get back to Option Page");
	         System.out.println("(1) Yes");
	         System.out.println("(2) No");
	         
	         option = sc.nextInt();
	         
	           
	     	}while(option==1);
	     }
	 
}


	//inherited methods
	// 1. createMovie(MovieManager m): void (in globalList)
	// 2. displayAllMovies(MovieManager m): void
	// 3. createCineplex(): void
	// 4. selectCineplex(int cineplexID): Cineplex
	// 6. displayMovieListOfCineplex(): void
	// 7 . assignMoviesToCineplex(MovieManager m): void 
