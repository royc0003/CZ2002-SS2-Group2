import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
// assuming that CineplexManager is present
/**
 * Keeps track of all the orders made by customer
 */	
public class BookingOrder implements Serialization, Serializable { // purpose of BookingOrder is mainly to keep track
	/**
	 * number of tickets booked
	 */	
    private int noOfTickets;
    /**
	 * the order number
	 */
    private int orderNo;
     /**
	 * showtime of the movie
	 */	
    private String showTime;
     /**
	 * Seat ID list
	 */	
    private ArrayList<String> listOfSeatID;
    /**
	 * unique ID of the movie
	 */	
    private int movieID;
    /**
	 * unique ID of the customer
	 */	
    private int customerID; //
    /**
	 * total Price of the tickets booked, after calculating discounts
	 */	
    private double totalPrice;
     /**
	 * unique ID of the cineplex
	 */	
    private int cineplexID;
    //------------------------------------Constructors---------------------------------------------------------------------------------
    /**
     * @param customerID unique ID of the customer
     * @param orderNo Order number
     */
    public BookingOrder(int customerID, int orderNo){
        this.customerID = customerID;
        this.orderNo = orderNo;

        this.listOfSeatID = new ArrayList<String>();
        
        
    }
    /**
     * @param items
     */
    public BookingOrder(String[] items){
        this.listOfSeatID = new ArrayList<String>();
        
        this.noOfTickets = Integer.parseInt(items[0]);
        this.orderNo = Integer.parseInt(items[1]);
        this.showTime = items[2];
        this.movieID = Integer.parseInt(items[3]);
        this.customerID = Integer.parseInt(items[4]);
        this.totalPrice = Double.parseDouble(items[5]);
        this.cineplexID = Integer.parseInt(items[6]);

    }
    public void initializeListOfSeatID(){
    	this.listOfSeatID = new ArrayList<String>();
    }
    /**
     * Gets the total number of tickets booked
     * @return number of tickets
     */
    public int getNoOfTickets(){
        return this.noOfTickets;
    }
    /**
     * Sets the total number of tickets booked
     * @param noOfTickets the number of tickets booked
     */
    public void setNoOfTickets(int noOfTickets){
        this.noOfTickets = noOfTickets;
    }
    /**
     * Gets the order number
     * @return the order number
     */
    public int getOrderNo(){
        return this.orderNo;
    }
    /**
     * Gets the movie ID
     * @return the movie ID
     */
    public int getMovieID(){
        return this.movieID;
    }
    /**
     * gets the Cineplex ID
     * @return the Cineplex ID
     */
    public int getCineplexID(){
        return this.cineplexID;
    }
    /**
     * Sets the Movie ID
     * @param movieID the unique ID of the movie
     */
    public void setMovieID(int movieID){
        this.movieID = movieID;
    }
    /**
     * Sets the Cineplex ID
     * @param cineplexID the unique ID of the cineplex
     */
    public void setCineplexID(int cineplexID){
        this.cineplexID = cineplexID;
    }
    
    /**
     * gets the Customer ID
     * @return the Customer ID
     */
    public int getCustomerID(){
        return this.customerID;
    }
    
    /**
     * sets the Customer ID
     * @param customerID the unique ID of the customer
     */
    public void setCustomerID(int customerID){
        this.customerID =customerID;
    }
    
    /**
     * gets the total price
     * @return the total price
     */
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    /**
     * sets the total Price
     * @param totalPrice the total Price
     */
    public void setTotalPrice(double totalPrice){
        this.totalPrice =totalPrice;
    }
    
    /**
     * gets the Show time
     * @return show time
     */
    public String getShowTime(){
        return this.showTime;
    }
    
    /**
     * sets the Show time
     * @param showTime show time
     */
    public void setShowTime(String showTime){
        this.showTime = showTime;
    }
    
    /**
     * sets the Seat ID
     * @param seatID seat ID
     */
    public void setSeatID(String seatID){
        listOfSeatID.add(seatID);
    }
    
    /**
     * @return arraylist of seat IDs
     */
    public ArrayList<String> getListOfSeatID(){
        return this.listOfSeatID;
    }

    /**
     * converts integer to string
     * @param i an integer
     * @return string i
     */
    public String converToString(int i){
        return Integer.toString(i);
    }
    
    /**
     * Converts String to csv
     * @return csv 
     */
    @Override
    public String[] toCsv() {
       String[] csv = {converToString(this.noOfTickets),
       converToString(this.orderNo), this.showTime, converToString(this.movieID),
               converToString(this.customerID),Double.toString(this.totalPrice),
       converToString(this.cineplexID)};
       return csv;
       }
}

