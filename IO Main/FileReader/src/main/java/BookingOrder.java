import java.util.ArrayList;
import java.util.Scanner;
// assuming that CineplexManager is present
public class BookingOrder  { // purpose of BookingOrder is mainly to keep track

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


    //------------------------------------Have proper getSetMethods---------------------------------------------------------------------------------


    /*public BookingOrder(int customerID, int orderNo) {
        this.customerID = customerID;
        this.orderNo = orderNo;
    }

    public void calculateTotalPrice() {
        //PriceManager p = new PriceManager;
        //totalPrice = ;

    }


    public void bookingThroughCineplex() {

        System.out.println("Which cineplex would you prefer to watch at?");
        printCineplexlist();
        Scanner sc = new Scanner(System.in);
        int cin = sc.nextInt();

        int cinID = cineplexList.get(cin).cineplexID;   		//selectCineplex from CineplexManager
        Cineplex c = selectCineplex(cinID);
        displayMovieListOfCineplex(c); 							//print movielist of that cineplex


        System.out.println("Which movie do you want to watch?");
        int movieID = sc.nextInt();

        c.displayAllShowtimes(movieID);
        System.out.println("Which showtimes do you want to choose?");


        c.selectShowtime(String showtime);



        //select showtime which will return seatmap of the cinema that is assigned to that showtime
        //bookseatmap - assign the seat
        //noOfTickets ++;

    }

    public void bookingThroughMovieList(CineplexManager m) {

    }

    public void bookingOrder(int orderNo) {

    }

    public String getSeatID(int customerID) {
        return seatID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }*/



}