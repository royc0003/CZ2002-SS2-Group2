import java.util.ArrayList;
import java.io.IOException;
// purpose of the customer controller
// to allow for control over login to store data into the customerStorage page

public class CustomerController {
    private BookingManager bookingManager;
    private RatingsReviewsManager ratingsReviewsManager;
    private ArrayList<Customer> customerStorage; //customerStorage for login
    private PriceManager priceManager;
    private CustomerUI customerUI;

    public CustomerController(BookingManager bookingManager, CustomerUI customerUI, RatingsReviewsManager ratingReviewsManager, PriceManager priceManager){
        this.bookingManager = bookingManager;
        this.ratingsReviewsManager = ratingsReviewsManager;
        this.customerUI = customerUI;
        this.priceManager = priceManager;
    }

    public ArrayList<Customer> getCustomerStorage(){
        return this.customerStorage;
    }
    public void startCustomer(){
        // begin storage program to ask user
    	
    	System.out.println("INSIDE START CUS");
    	ArrayList<Customer> custStorage = new ArrayList<Customer>();
    	initializeCustomer();

        customerUI.loginPage(custStorage); // calls login

        this.customerStorage = custStorage;
        saveCustomerCSV(customerStorage);

        
        
        Customer currentCustomerAccount = customerStorage.get(customerStorage.size()-1);
        customerUI.printWelcomePage(currentCustomerAccount.getCustomerID(),bookingManager, ratingsReviewsManager, priceManager);
        System.out.println("Thank you for using our THIS SUCKS J'DETESTE oodp");
    }

    //-------------------CSV RELATED FUNCTIONS------------------------------------------------------------------------------------------------------------
    public void initializeCustomer(){
        MainCSVHelper csvHelper = new MainCSVHelper();
        try {
            System.out.println("**************************Initializing Objects....");
            this.customerStorage = csvHelper.readFromCustomerCSV();

        }
        catch(IOException e){
            e.getStackTrace();
            System.out.println("Could not find the file");
        }
    }
    public void saveCustomerCSV(ArrayList<Customer> customerStorage){
        MainCSVHelper csvHelper = new MainCSVHelper();
        try{
            System.out.println("***********************************Saving to CSV....");
            csvHelper.writeToCustomerCSV(customerStorage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}