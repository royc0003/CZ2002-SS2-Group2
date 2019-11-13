public class MovieDisplay {
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