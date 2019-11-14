import java.io.Serializable;

/**
 Represents a manager in control of creating/managing the seats of the cinema.
 There is only one seat manager per cinema.
*/


public class SeatManager implements Serializable {
	
	 /**
	 * The total number of empty seats in the cinema
	 */
	private int numEmptyseats;
	
	/**
	 * A double array of seats objects where the double array is [row][column]
	 */
	private Seat[][] seats;
	/**
	* Creates a new Seat Manager
	* initializes 100 seats
	  */
	public SeatManager() {
		numEmptyseats = 100;
		seats = new Seat[10][10];
		int i =0;
		for(i=0; i<10 ; i++) {
			for(int j=0; j<10 ; j++) {
				seats[i][j] = new Seat(i, j);}}
		
	}
	/**
	* Displays a seat map of the cinema by printing all the seat objects
	  */

	public void seatmap() {
		int j =0;
		System.out.println("The seat map: ");
		System.out.print(" ");
		for(int i=0; i<10 ; i++) {
			System.out.print(" " + Integer.toString(i) + " ");
		}
		System.out.println("");
		
		for(int i=0; i<10 ; i++) {
			System.out.print(Integer.toString(i));
			for(j=0; j<10 ; j++) {
				
				if(!seats[i][j].isOccupied()) {
					System.out.print("[ ]");
				}
				else {
					System.out.print("[x]");
				}
				
			}
			System.out.println("");
		}
		
	}
	
	/**
	* Show the IDs of the seats that are empty in the cinema
	  */
	public void showEmptyseats() {
		System.out.println("The  following seats are empty: ");
		for(int i=0; i<10 ; i++) {
			for(int j=0; j<10 ; j++) {
				if(!seats[i][j].isOccupied()) {
					System.out.println("Empty Seat id: "+ seats[i][j].getSeatID());
				}
		}
		}
		
	}
	
	/**
	* Assign the seat id to the customer id 
	* @param seatID the seat id the customer id is booking
	* @param cust_id the id of the customer that is booking
	  */
	
	public void assignSeat(String seatId, int cust_id) {
		
		for(int i=0; i<10 ; i++) {
			for(int j=0; j<10 ; j++) {
				if(seatId.equals(seats[i][j].getSeatID()) && !seats[i][j].isOccupied()) {
					seats[i][j].assign(cust_id);
					--numEmptyseats;
					System.out.println("Seat assigned! ");

			}}
		}
		
	}
	
	/**
	* Get the number of empty seats in the cinema
	* @return the number of empty seats 
	  */
	

	public int getNumEmptySeats() {
		return numEmptyseats;
	}


		
	 
}
