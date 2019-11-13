import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*Note the main purpose of this class is to act as a controller
- Understand that since CSV rewrite will occur; update can still occur but ensure that CSV is being rewritten first
The following implementation will be made for these:
-movieDetails
movieID|||movieTitle|||movieRating|||movieAgeRating|||showingStatus
showtimeDetails
movieTitle|||movieDate|||movieShowTimes|||screenNo
ticketDetails
- have an option to select between the various classes
*/

// also note that FileIOHelper is already there to help with implementation
// of read/writeBuffer

public class MainCSVHelper extends csvHelper{ //contains read and write CSV
    private String movieDetails = "movieDetails.csv";
    private String showTimeDetails = "showTimeDetails.csv";
    private String cineplexDetails = "cineplexDetails.csv";
    private String customerDetails = "customerDetails.csv";
    private String bookingOrderDetails = "bookingOrderDetails.csv";
    private String cinemaDetails = "cinemaDetails.csv";

    /*private String showTimeDetails = "showTimeDetails.csv";
    private String ticketDetails = "ticketDetails.csv";
    public String updateCSV() {
        System.out.println("Select which detail to update/modify: ");
        System.out.println("Choice 1 ----------update Movie Details ");
        System.out.println("Choice 2 ----------update Show Time Details: ");
        System.out.println("Choice 3 ----------update ticketDetails:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        while(choice < 1 || choice > 3){
            System.out.println("Select which detail to update/modify: ");
            System.out.println("Choice 1 ----------update Movie Details ");
            System.out.println("Choice 2 ----------update Show Time Details: ");
            System.out.println("Choice 3 ----------update ticketDetails:");
            choice = sc.nextInt();
        }
        switch(choice) {
            case 1:
                return this.movieDetails;
            case 2:
                return this.showTimeDetails;
            case 3:
                return this.ticketDetails;
        }
        return "NIL";
    }*/
    public ArrayList<MovieAndShowtimes> readFromMoviesCSV() throws IOException{
        if(!FileIOHelper.exists(this.movieDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<MovieAndShowtimes>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.movieDetails);
        List<String[]> movieLists = readAll(moviesCSV,1);
        ArrayList<Movie> results = new ArrayList<Movie>();
        if(movieLists.size() == 0) { return new ArrayList<MovieAndShowtimes>();}
        for(String[] item: movieLists){
            System.out.println(Arrays.toString(item));
            Movie mov = new Movie(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        ArrayList<MovieAndShowtimes> tempArray = new ArrayList<MovieAndShowtimes>();
        for(int i = 0 ; i < movieLists.size(); i++){
            tempArray.add(new MovieAndShowtimes());
        }
        int j = 0;
        for(MovieAndShowtimes n: tempArray){
            n.setMovie(results.get(j));
            j++;
        }
        return tempArray;
    }

	/*
	 * public ArrayList<Movie> readFromMoviesCSV() throws IOException{
	 * if(!FileIOHelper.exists(this.movieDetails)) {
	 * System.out.println("File does not exist!"); return new ArrayList<Movie>();}
	 * BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.movieDetails);
	 * List<String[]> movieLists = readAll(moviesCSV,1); ArrayList<Movie> results =
	 * new ArrayList<Movie>(); if(movieLists.size() == 0) return results;
	 * for(String[] item: movieLists){ System.out.println(Arrays.toString(item));
	 * Movie mov = new Movie(item); //instantiates new objects that'll be kept in
	 * array results.add(mov); } return results; }
	 */
    public ArrayList<ShowTime> readFromShowTimeCSV() throws IOException{
        if(!FileIOHelper.exists(this.showTimeDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<ShowTime>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.showTimeDetails);
        List<String[]> showList = readAll(moviesCSV,1);
        ArrayList<ShowTime> results = new ArrayList<ShowTime>();
        if(showList.size() == 0) return results;
        for(String[] item: showList){
            System.out.println(Arrays.toString(item));
            ShowTime mov = new ShowTime(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        return results;
    }
    public ArrayList<Cineplex> readFromCineplexDetailsCSV() throws IOException{
        if(!FileIOHelper.exists(this.cineplexDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<Cineplex>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.cineplexDetails);
        List<String[]> movieLists = readAll(moviesCSV,1);
        ArrayList<Cineplex> results = new ArrayList<Cineplex>();
        if(movieLists.size() == 0) return results;
        for(String[] item: movieLists){
            System.out.println(Arrays.toString(item));
            Cineplex mov = new Cineplex(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        return results;
    }
    public ArrayList<Customer> readFromCustomerCSV() throws IOException{
        if(!FileIOHelper.exists(this.customerDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<Customer>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.customerDetails);
        List<String[]> movieLists = readAll(moviesCSV,1);
        ArrayList<Customer> results = new ArrayList<Customer>();
        if(movieLists.size() == 0) return results;
        for(String[] item: movieLists){
            System.out.println(Arrays.toString(item));
            Customer mov = new Customer(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        return results;
    }
    public ArrayList<BookingOrder> readFromBookingOrderCSV() throws IOException{
        if(!FileIOHelper.exists(this.bookingOrderDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<BookingOrder>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this. bookingOrderDetails);
        List<String[]> movieLists = readAll(moviesCSV,1);
        ArrayList<BookingOrder> results = new ArrayList<BookingOrder>();
        if(movieLists.size() == 0) return results;
        for(String[] item: movieLists){
            System.out.println(Arrays.toString(item));
            BookingOrder mov = new BookingOrder(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        return results;
    }
    public ArrayList<Cinema> readFromCinemaCSV() throws IOException{
        if(!FileIOHelper.exists(this.cinemaDetails)) {
            System.out.println("File does not exist!");
            return new ArrayList<Cinema>();}
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.cinemaDetails);
        List<String[]> movieLists = readAll(moviesCSV,1);
        ArrayList<Cinema> results = new ArrayList<Cinema>();
        if(movieLists.size() == 0) return results;
        for(String[] item: movieLists){
            System.out.println(Arrays.toString(item));
            Cinema mov = new Cinema(item); //instantiates new objects that'll be kept in array
            results.add(mov);
        }
        return results;
    }
    /*public ArrayList<ShowTime> readFromShowTimeCSV() throws IOException{
        if(!FileIOHelper.exists(this.showTimeDetails)) return new ArrayList<ShowTime>();
        BufferedReader showTimeCSV = FileIOHelper.getBufferedReader(this.showTimeDetails);
        List<String[]> showLists = readAll(showTimeCSV);
        ArrayList<ShowTime> results = new ArrayList<ShowTime>();
        if(results.size() == 0) return results;
        for(String[] item: showLists){
            ShowTime show = new ShowTime(item); //instantiates new objects that'll be kept in array
            results.add(show);
        }
        return results;
    }
    public ArrayList<Tickets> readFromTicketCSV() throws IOException{
        if(!FileIOHelper.exists(this.ticketDetails)) return new ArrayList<Tickets>();
        BufferedReader ticketsCSV = FileIOHelper.getBufferedReader(this.ticketDetails);
        List<String[]> ticketLists = readAll(ticketsCSV);
        ArrayList<Tickets> results = new ArrayList<Tickets>();
        if(results.size() == 0) return results;
        for(String[] item: ticketLists){
            Tickets tix = new Tickets(item); //instantiates new objects that'll be kept in array
            results.add(tix);
        }
        return results;
    }*/

    public void writeToMovieAndShowtimeCSV(ArrayList<MovieAndShowtimes> movies) throws IOException{
        String[] header = {"movieID", "movieTitle", "totalRating", "totalRaters", "showingStatus", "movieAgeRating", "averageRating","duration"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.movieDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        ArrayList<Movie> tempArray = new ArrayList<Movie>();
        for(MovieAndShowtimes x: movies){
            tempArray.add(x.getMovie());
        }
        for(Movie x: tempArray){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
  
    public void writeToShowTimeCSV(ArrayList<ShowTime> movies) throws IOException{
        String[] header = {"showBegins", "showEnds", "cinemaID"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.showTimeDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(ShowTime x: movies){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
    public void writeToCineplexCSV(ArrayList<Cineplex> movies) throws IOException{
        String[] header = {"cineplexID", "nameOfCineplex", "location", "no_of_cinema"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.cineplexDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(Cineplex x: movies){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
    public void writeToCustomerCSV(ArrayList<Customer> movies) throws IOException{
        String[] header = {"age", "userName", "name", "mobile", "email", "customerID"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.customerDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(Customer x: movies){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
    public void writeToBookingOrderCSV(ArrayList<BookingOrder> movies) throws IOException{
        String[] header = {"noOfTickets", "orderNo", "showTime", "movieID", "customerID", "totalPrice", "cineplexID"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.bookingOrderDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(BookingOrder x: movies){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
    public void writeToCinemaCSV(ArrayList<Cinema> movies) throws IOException{
        String[] header = {"Type", "seatingCapacity", "cinema_no" , "cineplexID"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.cinemaDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(Cinema x: movies){
            movieList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(movieList, movieCSV);
    }
    
    

    /*public void writeToShowTimeCSV(ArrayList<ShowTime> shows) throws IOException{
        String[] header = {"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"};
        BufferedWriter showTimeCSV = FileIOHelper.getBufferedWriter(this.showTimeDetails);
        ArrayList<String[]> showList = new ArrayList<>();
        showList.add(header); // adds the current header
        for(ShowTime x: shows){
            showList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(showList, showTimeCSV);
    }
    public void writeToTicketCSV(ArrayList<Tickets> tix) throws IOException{
        String[] header = {"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"};
        BufferedWriter ticetsCSV = FileIOHelper.getBufferedWriter(this.ticketDetails);
        ArrayList<String[]> ticketList = new ArrayList<>();
        ticketList.add(header); // adds the current header
        for(Tickets x: tix){
            ticketList.add(x.toCsv()); // require a function that gives a String[] of items to be converted
        }
        writeToCSVFile(ticketList, ticetsCSV);
    }
*/
    
}