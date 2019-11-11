import java.util.ArrayList;
// purpose of the customer controller
// to allow for control over login to store data into the customerStorage page

public class CustomerController {
    private BookingManager bookingManager;
    private ArrayList<Customer> customerStorage; //customerStorage for login
    private CustomerUI customerUI;

    public CustomerController(BookingManager bookingManager, CustomerUI customerUI){
        this.bookingManager = bookingManager;
        this.customerUI = customerUI;
    }

    public ArrayList<Customer> getCustomerStorage(){
        return this.customerStorage;
    }
    public void startCustomer(){
        // begin storage program to ask user
        customerUI.loginPage(customerStorage); // calls login
        Customer currentCustomerAccount = customerStorage.get(customerStorage.size()-1);
        customerUI.printWelcomePage(currentCustomerAccount.getCustomerID(),bookingManager);
    }




}
