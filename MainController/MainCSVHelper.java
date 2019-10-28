import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
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
    }

    public ArrayList<Movies> readFromMoviesCSV() throws IOException{
        if(!FileIOHelper.exists(this.movieDetails)) return new ArrayList<Movies>();
        BufferedReader moviesCSV = FileIOHelper.getBufferedReader(this.movieDetails);
        List<String[]> movieLists = readAll(moviesCSV);
        ArrayList<Movies> results = new ArrayList<Movies>();
        if(results.size() == 0) return results;
        for(String[] item: movieLists){
            Movies mov = new Movies(item); //instantiates new objects that'll be kept in array
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

    public void writeToMovieCSV(ArrayList<Movies> movies) throws IOException{
        String[] header = {"movieID", "movieTitle", "movieRating", "movieAgeRating", "showingStatus"};
        BufferedWriter movieCSV = FileIOHelper.getBufferedWriter(this.movieDetails);
        ArrayList<String[]> movieList = new ArrayList<>();
        movieList.add(header); // adds the current header
        for(Movies x: movies){
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
