
import java.io.IOException;
import java.io.ObjectInputStream;
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
		BookingManager bookingManager = new BookingManager();
		CineplexManager cineplexManager = new CineplexManager() ; //this creates moviemanager too
		/*try {
			System.out.println("This is working");
			ObjectInputStream os = FileIOHelper.getSerialReader("cineplexManagerDetails.ser");
			cineplexManager = (CineplexManager) os.readObject();
			os.close();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {

			System.out.println("Employee class not found");
			c.printStackTrace();
			return;
		}*/


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
		   // MainCSVHelper csvHelper = new MainCSVHelper();
		   // csvHelper.writeSerilizable(cineplexManager);
			break;
		    
		case 2:
	
			bookingManager.initializeBookingOrder();
			CustomerUI customerUI = new CustomerUI();
			CustomerController custController = new CustomerController(bookingManager,customerUI,ratingReviewsManager, priceManager);
			custController.startCustomer();
			break;
		
			

		
	}
		
	}
	
}
		
		
	