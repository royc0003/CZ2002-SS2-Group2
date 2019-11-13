import java.util.ArrayList;
import java.util.Scanner;
// assuming that CineplexManager is present
public class BookingOrder implements Serialization  { // purpose of BookingOrder is mainly to keep track

    private int noOfTickets;
    private int orderNo;
    private String showTime;
    private ArrayList<String> listOfSeatID;
    private int movieID;
    private int customerID; //
    private double totalPrice;
    private int cineplexID;
    //------------------------------------Constructors---------------------------------------------------------------------------------
    public BookingOrder(int customerID, int orderNo){
        this.customerID = customerID;
        this.orderNo = orderNo;
        System.out.println("IN CONSTRUCTOR 1");

        this.listOfSeatID = new ArrayList<String>();
        
        
    }
    
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
    public int getNoOfTickets(){
        return this.noOfTickets;
    }
    public void setNoOfTickets(int noOfTickets){
        this.noOfTickets = noOfTickets;
    }
    public int getOrderNo(){
        return this.orderNo;
    }

    public int getMovieID(){
        return this.movieID;
    }
    
    public int getCineplexID(){
        return this.cineplexID;
    }
    public void setMovieID(int movieID){
        this.movieID = movieID;
    }
    public void setCineplexID(int cineplexID){
        this.cineplexID = cineplexID;
    }
    public int getCustomerID(){
        return this.customerID;
    }
    public void setCustomerID(int customerID){
        this.customerID =customerID;
    }
    public double getTotalPrice(){
        return this.totalPrice;
    }
    public void setTotalPrice(double totalPrice){
        this.totalPrice =totalPrice;
    }
    public String getShowTime(){
        return this.showTime;
    }
    public void setShowTime(String showTime){
        this.showTime = showTime;
    }
    public void setSeatID(String seatID){
        listOfSeatID.add(seatID);
    }
    public ArrayList<String> getListOfSeatID(){
        return this.listOfSeatID;
    }


    public String converToString(int i){
        return Integer.toString(i);
    }
    @Override
    public String[] toCsv() {
       String[] csv = {converToString(this.noOfTickets),
       converToString(this.orderNo), this.showTime, converToString(this.movieID),
               converToString(this.customerID),Double.toString(this.totalPrice),
       converToString(this.cineplexID)};
       return csv;
    }

}