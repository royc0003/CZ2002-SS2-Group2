
public class Cinema implements Serialization {
	private String type;
	private int seatingCapacity;
	public int cinema_no;
	private SeatManager seatManager;
	
	
	public Cinema(int cinema_no, String type) {
		seatManager = new SeatManager();
		this.cinema_no = cinema_no;
		this.seatingCapacity = 100;
		this.type = type;
		
		
	}
	
	public String getType() {
		return type;
	}
	
	public void showseats(){
		seatManager.seatmap();
		System.out.println("Number of Empty Seats:" + seatManager.getNumEmptySeats());
	}

	public void bookseat(String seat_id, int cust_id) {
		seatManager.assignSeat(seat_id, cust_id);
	}
	
	
	@Override
	public String[] toCsv() {
		String[] csv = {Integer.toString(this.cinema_no), this.type, Integer.toString(this.seatingCapacity)};
		return csv;
	}
		
		
		
	
	
}
