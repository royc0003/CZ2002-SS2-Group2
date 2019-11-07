import java.util.ArrayList;

public class Cineplex {

	public String nameOfCineplex;
	public int cineplexID;
	private String location;
	private int no_of_cinema;
	private ArrayList<Cinema> cinemaList;
	private ArrayList<MovieAndShowtimes> listOfMovieAndShowTimes; // would store the movie objects for the cinema

	
	public Cineplex(String name, String location, int no_of_cinema) {
		nameOfCineplex = name;
		this.location = location;
		this.no_of_cinema = no_of_cinema;
		this.cinemaList = new ArrayList<Cinema>();
		 
		for(int i=0; i<no_of_cinema ;i++) {
			cinemaList.add(new Cinema(i+1));
		}
		
		
	}
	public int getcineplexID() {
		return cineplexID;
	}
	
	public void addMovieToCineplex(MovieAndShowtimes object) {
		//ADD MOVIE AND SHOWTIMES 

		listOfMovieAndShowTimes.add(object);
	}
	
	public String getlocationCineplex() {
		return location;
	}
	
	public void setlocationCineplex(String location) {
		this.location = location;
	}
	
	public int getnumberofcinema() {
		return no_of_cinema;
	}
	
	public void getseatmapofcinema(int cinema_no) {
		cinemaList.get(cinema_no).showseats();

	}
	
	public void bookseatatcinema(int cinema_no, String seat_id, int cust_id) {
		cinemaList.get(cinema_no).bookseat(seat_id, cust_id);
		
	}
	
	public void assignShowtimeToCinema() {
			
	}
	
	public void selectShowtime() {
		
	}
	
	public void printMovieList() {
		
	}
}
