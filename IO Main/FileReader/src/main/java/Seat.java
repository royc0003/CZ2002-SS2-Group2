
public class Seat {
	private String seatID;
	private int row, col;
	private String typeOfSeat;
	private int customerID;
	private boolean assigned = false;

	public Seat(int row, int col) {
		this.row = row;
		this.col = col;
		this.seatID = Integer.toString(row) + "." + Integer.toString(col);
	}

	public String getSeatID(){
		return seatID;
	}
	
	public int getCustomerID() {
		return customerID;
	}
	
	public boolean isOccupied() {
		return assigned;
	}
	
	public void assign(int cust_id) {
		assigned = true;
		customerID= cust_id;
	}
	
	public void unAssign() {
		assigned = false;
	}
	
	
}

	
