import java.util.ArrayList;

public class CineplexManager {

	public String nameOfCineplex;
	private String location;
	private int no_of_cinema;
	private ArrayList<Cinema> cinemaList;

	
	public CineplexManager(String name, String location, int no_of_cinema) {
		nameOfCineplex = name;
		this.location = location;
		this.no_of_cinema = no_of_cinema;
		this.cinemaList = new ArrayList<Cinema>();
		 
		for(int i=0; i<no_of_cinema ;i++) {
			cinemaList.add(new Cinema(i+1));
		}
		
	}
	
	//public void show_all_movies(MovieManager moviemanager){
		//
	
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
	
	// TIE in cinema, showtimes, movie to book seat
	
}
