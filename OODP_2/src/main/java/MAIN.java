
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
public class MAIN {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean isStaff = false;
		int choice;
        String Staff;
        String staffPassword;



		RatingsReviewsManager ratingReviewsManager = new RatingsReviewsManager();
		BookingManager bookingManager = new BookingManager();
		CineplexManager cineplexManager = new CineplexManager() ; //this creates moviemanager too
        StaffController staffController =new StaffController();
        CustomerUI customerUI = new CustomerUI();
        CustomerController custController = new CustomerController(bookingManager,customerUI,ratingReviewsManager, staffController.getPriceManager());

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

		    staffController.printWelcomePage(ratingReviewsManager);
		   // MainCSVHelper csvHelper = new MainCSVHelper();
		   // csvHelper.writeSerilizable(cineplexManager);
			break;
		    
		case 2:
	
			//bookingManager.initializeBookingOrder();

			custController.startCustomer();
			break;
		
			

		
	}
        System.out.println(" ");
        System.out.println("Thank you for using our program!");
        System.out.println("Merci Beaucoup!");
        System.out.println("By Group 2: Royce, Clarita, KokLiang, Rishab and Bisakha");
	}
	
}
		
		
	