//{"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"}

public class Movies {
    private int movieID;
    private String movieTitle;
    private int movieRating;
    private int movieAgeRating;
    private String showingStatus;
    public Movies(String[] item){
        this.movieID = Integer.parseInt(item[0]);
        this.movieTitle = item[1];
        this.movieRating  = Integer.parseInt(item[2]);
        this.movieAgeRating = Integer.parseInt(item[3]);
        this.showingStatus = item[4];
    }
    public Movies(int movieID, String movieTitle, int movieRating, int movieAgeRating, String showingStatus){
        this.movieID = movieID;
        this.movieTitle = movieTitle;
        this.movieRating = movieRating;
        this.movieAgeRating = movieAgeRating;
        this.showingStatus = showingStatus;
    }


    public String convertToString(int i) {
        return Integer.toString(i);
    }
    public String[] toCsv(){
        String[] csv = {convertToString(this.movieID), this.movieTitle, convertToString(this.movieRating),
        convertToString(this.movieAgeRating), this.showingStatus};
        return csv;
    }
}
