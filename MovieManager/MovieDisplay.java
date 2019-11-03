public class MovieDisplay {
    public void printDetails(int movieID, String movieTitle, int movieRating, int movieAgeRating, String showingStatus)
    {
        System.out.println("Movie ID: " + movieID);
        System.out.println("Movie Title: " + movieTitle);
        System.out.println("Movie Rating: " + movieRating);
        System.out.println("Minimum age to enter: " + movieAgeRating);
        System.out.println("Showing Status: " + showingStatus);
    }
}

