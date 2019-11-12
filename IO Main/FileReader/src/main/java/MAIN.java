
import java.util.Scanner;
public class MAIN {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean isStaff = false;
		int choice;
        String Staff;
        String staffPassword;
        
        PriceManager priceManager = new PriceManager();
		RatingsReviewsManager ratingReviewsManager = new RatingsReviewsManager();
		CineplexManager cineplexManager = new CineplexManager() ; //this creates moviemanager too

        
        System.out.println("Are you a staff?");
        Staff = scan.next();
        if (Staff.equalsIgnoreCase("yes")) {
            System.out.println("Please enter staff password");
            staffPassword = scan.next();
            if (staffPassword.equals("000000")) {
                isStaff= true;
                }
            else {
                System.out.print("wrong password");
                }
            } 
        else if (Staff.equalsIgnoreCase("no")) {
            isStaff= false;
            }
        
        if(isStaff) {
        	choice = 1;}
        else {
        	choice = 2;
        }
		
		switch(choice) {
		case 1:
		    StaffController staffController =new StaffController();
		    staffController.printWelcomePage(ratingReviewsManager, priceManager);
			break;
		    
		case 2:
			CustomerUI customerUI = new CustomerUI();
			BookingManager bookingManager = new BookingManager();
			CustomerController custController = new CustomerController(bookingManager,customerUI,ratingReviewsManager, priceManager);
			custController.startCustomer();
			break;
		
			

		
	}
		
	}
	
}
		
		
	