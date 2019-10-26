package SS2Assignment;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowTime{
	private Date showBegins, showEnds;
	// (Use the name of the other classes to create there objects;
	// Movie movie = new Movie;
	// Cinema cinema new Cinema;
	// SeatAllocation seatAllocation = new SeatAllocatino;
	private final double weekdayRate = 1.0;
	private final double weekendRate = 1.5;
	private double priceRate;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
	private static final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
	
	public ShowTime(Date showBegins, Date showEnds, Cinema cinema) {
		this(showBegins, showEnds, null, cinema);
	}
	public ShowTime(Date showBegins, Date showEnds, Movie movie, Cinema cinema) {
		this.showBegins = showBegins;
		this.showEnds = showEnds;
		// depends on other class names: 
		//this.movie = movie;
		//this.cinema = cinema;
		//this.seatAllocations = cinema.getSeatAllocation();
		setPriceRate();
	}
	private void setPriceRate(){
		Calendar c = Calendar.getInstance();
		c.setTime(showBegins);
		
		int day = c.get(Calendar.DAY_OF_WEEK);
		int time = c.get(Calendar.HOUR_OF_DAY);
		
		if(day != Calendar.SATURDAY || day != Calendar.SUNDAY){
			priceRate = weekdayRate;
		}
		else 
			priceRate *= weekendRate;
	}
	public Date getshowBegins() {
		return showBegins;
	}

	public void setshowBegins(Date showBegins) {
		this.showBegins = showBegins;
	}

	public Date getshowEnds() {
		return showEnds;
	}

	public void setshowEnds(Date showEnds) {
		this.showEnds = showEnds;
	}
	
	public double getPriceRate() {
		return priceRate;
	}
	
	//public boolean hasMovie(){
	//	return movie != null;
	//}
	
	//public Movie getMovie() {
	//	return movie;
	//}

	//public void setMovie(Movie movie) {
	//	this.movie = movie;
	//	if(movie != null) movie.addShowTime(this);
	//}
	
	//public Cinema getCinema() {
	//	return cinema;
	//}
	
	//public SeatAllocation getSeatAllocations() {
	//	return seatAllocations;
	//}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("ShowTime: " + String.format("%s, %s - %s", dateFormat.format(showBegins), timeFormat.format(showBegins), timeFormat.format(showEnds)) + "\n");
		//sb.append("Movie: " + ((movie != null) ? movie.getTitle() : "<None>") + "\n");
		//sb.append("Cinema: " + cinema.getId() + "\n");
		return sb.toString();
	}
}
