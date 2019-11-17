import java.util.ArrayList;
import java.io.IOException;
/** purpose of the customer controller
* to allow for control over login to store data into the customerStorage page
 */
public class CustomerController {
	/**
	 * BookingManager object
	 */
    private BookingManager bookingManager;
    /**
     * RatingsReviewsManager object
     */
    private RatingsReviewsManager ratingsReviewsManager;
    /**
     * Array list of customers
     */
    private ArrayList<Customer> customerStorage; //customerStorage for login
    /**
     * PriceManager object
     */
    private PriceManager priceManager;
    /**
     * CustomerUI object
     */
    private CustomerUI customerUI;


    /**
     * Creates a customer controller object
     * @param bookingManager BookingManager object
     * @param customerUI CustomerUI object
     * @param ratingReviewsManager RatingsReviewsManager object
     * @param priceManager PriceManager object
     */
    public CustomerController(BookingManager bookingManager, CustomerUI customerUI, RatingsReviewsManager ratingsReviewsManager, PriceManager priceManager){
        this.bookingManager = bookingManager;
        this.ratingsReviewsManager = ratingsReviewsManager;
        this.customerUI = customerUI;
        this.priceManager = priceManager;
    	this.customerStorage = new ArrayList<Customer>();

    }
    /**
     * Returns an array list of customer objects
     * @return array list of customers
     */
    public ArrayList<Customer> getCustomerStorage(){

        return this.customerStorage;

    }
    
    /**
     * If staff == 'No' in main, this method would be called
     * @throws IOException 
     */
    public void startCustomer() throws IOException{
        // begin storage program to ask user
    	
    
    	initializeCustomer();
    	
        System.out.println("Customer size after initialization: " + customerStorage.size());

        
    	this.customerStorage = customerUI.loginPage(customerStorage); // calls login
        System.out.println("Customer size after loginpage: " + customerStorage.size());
        
        saveCustomerCSV(customerStorage);
        int i =0;
        
        System.out.println("Customer ID" + customerUI.custID());
        Customer currentCustomerAccount = null;
        for(Customer n: customerStorage) {
        	System.out.println("Customer in Storage " + n.getCustomerID());
        	if(n.getCustomerID() == customerUI.custID()) {
                currentCustomerAccount = customerStorage.get(i);
                customerUI.printWelcomePage(currentCustomerAccount.getCustomerID(), bookingManager, ratingsReviewsManager, priceManager);
        		break;
        	}
        	i++;
        }

    }

    //-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------
    /**
	 * Helps retrieve previously stored data if program crashes or exits
	 */
    public void initializeCustomer(){
        MainCSVHelper csvHelper = new MainCSVHelper();
        try {
            System.out.println("**************************Initializing Objects....");
            this.customerStorage = csvHelper.readFromCustomerCSV();
            System.out.println("Customer size in initialization: " + customerStorage.size());

        }
        catch(IOException e){
            e.getStackTrace();
            System.out.println("Could not find the file");
        }
    }
    /**
	 * Saves data to a csv file
	 * @param Array list of customer objects
	 */
    public void saveCustomerCSV(ArrayList<Customer> customerStorage){
        MainCSVHelper csvHelper = new MainCSVHelper();
        try{
            System.out.println("***********************************Saving to CSV....");
            csvHelper.writeToCustomerCSV(customerStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

	 /* public void initializeBookingOrder(){ 
		  MainCSVHelper csvHelper = new MainCSVHelper(); 
		  try {
	  System.out.println("**************************Initializing Objects....");
	  bookingManager.orderList = csvHelper.readFromBookingOrderCSV();
	  
	  } catch(IOException e){ e.getStackTrace();
	  System.out.println("Could not find the file"); 
	  }
		  }*/
	 


}