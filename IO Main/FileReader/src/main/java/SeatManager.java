public class SeatManager {
	
	
	private int numEmptyseats;
	private Seat[][] seats;
	
	public SeatManager() {
		numEmptyseats = 100;
		seats = new Seat[10][10];
		int i =0;
		for(i=0; i<10 ; i++) {
			for(int j=0; j<10 ; j++) {
				seats[i][j] = new Seat(i, j);}}
		
	}
	

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

	public int getNumEmptySeats() {
		return numEmptyseats;
	}


		
	 
}
