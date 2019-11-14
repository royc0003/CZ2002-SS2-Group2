import java.io.Serializable;

/**
 Represents a seat object in the cinema. There are many seats
 in a cinema.*/

public class Seat implements Serializable {
	/**
	 * The ID of the seat which is made by adding row and column.
	 */
	private String seatID;
	/**
	 * The row and column of the seat in the cinema.
	 */
	private int row, col;
	/**
	 * The type of the seat.
	 */
	private String typeOfSeat;
	/**
	 * The ID of the customer assigned to the seat.
	 */
	private int customerID;
	/**
	 * Shows if seat is assigned.
	 */
	private boolean assigned = false;

	 /**
	 * Creates a new Seat with the given row and column of the seat.
	 * @param row row of the seat
	 * @param col column of the seat
	 */

	public Seat(int row, int col) {
		this.row = row;
		this.col = col;
		this.seatID = Integer.toString(row) + "." + Integer.toString(col);
	}
	
	 /**
		 * Get Seat ID of the Seat object
		 *  @return this seat id
		 */

	public String getSeatID(){
		return seatID;
	}
	
	/**
	 * Get Customer ID assigned to the seat
	 *  @return this customer id
	 */
	
	public int getCustomerID() {
		return customerID;
	}
	
	/**
	 * Show if this seat is occupied
	 * @return a boolean if seat is assigned 
	 */
	
	public boolean isOccupied() {
		return assigned;
	}
	
	/**
	 * Assign this seat to a single customer
	 * @param the id of the customer that wants to book the seat 
	 */
	
	public void assign(int cust_id) {
		assigned = true;
		customerID= cust_id;
	}
	
	/**
	 * Unassign the seat from the customer
	 */
	
	public void unAssign() {
		assigned = false;
	}
	
	
}

	
