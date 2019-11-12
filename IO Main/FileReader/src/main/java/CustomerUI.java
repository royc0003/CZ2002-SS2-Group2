import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUI {


    public void loginPage(ArrayList<Customer> customerStorage) {
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************************************");
        System.out.println("***************Welcome To Customer Login Page***************");
        System.out.println("Option 1: Login (Already have an account?)");
        System.out.println("Option 2: Create New Account (No existing account?)");
        System.out.println("************************************************************");
        int choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter username: ");
                String userName = sc.next();
                //if login fails bring customer to createCustomerPage
                // enter a few times to login
                int count = 3;
                while (count > 0) {
                    if (!checkExist(customerStorage, userName)) {
                        System.out.println("ERROR: USERNAME DOES NOT EXIST ");
                    }
                    else{
                        break;
                    }
                    System.out.println("Enter username: ");
                    userName = sc.next();
                    count--;
                }
                if(count == 0){
                    createCustomerAccountPage(customerStorage);
                }
                break;
            case 2:
                createCustomerAccountPage(customerStorage);
        }
    }

    private boolean checkExist(ArrayList<Customer> customerStorage, String userName){

        for(Customer n: customerStorage){
        	if(customerStorage.size() == 1) {

        		return false;
        	}
            if(n.getUserName().equals(userName)){

                return true;
            }
        }

        return false;
    }

    //basic check to see if the username exist or not

    private void createCustomerAccountPage(ArrayList<Customer> customerStorage){
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************************************");
        System.out.println("***************Customer Account Creation Page***************");
        customerStorage.add(new Customer());
        
        System.out.println("made new customer object");
        
        Customer tempAccount = customerStorage.get(customerStorage.size()-1); // retrives the last object
        System.out.println("Create username: ");
        String userName = sc.next();
        
        // if exist is true then need to prompt to recreate a new one
        while(checkExist(customerStorage, userName)){
            System.out.println("Create username: ");
            userName = sc.next(); // if not exist then can exit the loop meaning not exist in the db system
        }
        System.out.println("Username Successfully Created!");
        tempAccount.setUserName(userName);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Name: ");
        String name = sc.next();
        tempAccount.setName(name);
        System.out.println("Enter Mobile: ");
        String mobile = sc.next();
        tempAccount.setMobile(mobile);
        System.out.println("Enter Email: ");
        String email = sc.next();
        tempAccount.setEmail(email);

    }


    public void printWelcomePage(int customer_ID, BookingManager bookingManager, RatingsReviewsManager ratingsReviewsManager, PriceManager priceManager) {
        Scanner scan = new Scanner(System.in);
        int userChoice;
        System.out.println("************************WELCOME TO CLARITA&KOKLIANG's CineVillage************************");
        System.out.println("OPTIONS:");
        System.out.println("Option 1: Make A Booking");
        System.out.println("Option 2: View Movie Details");
        System.out.println("Option 3: Get Reviews for a Movie");
        System.out.println("Option 4: Add Reviews");
        System.out.println("Option 5: Add Ratings");
        System.out.println("Option 6: Check Booking History");
        System.out.println("Option 7: Display Top 5 Movies by Rating");
        System.out.println("Option 8: Exit");
        userChoice = scan.nextInt();
        while(userChoice>= 1 && userChoice<=7){

            switch (userChoice){
                case 1:
                    //Book
           
                    bookingManager.makeNewOrder(customer_ID, priceManager);
                    break;
                case 2:
                    //movie details
                   //bookingManager.movieManager.printDetails(bookingManager.movieManager.getListOfMovieAndShowtimes());
                    bookingManager.movieManager.printDetails(bookingManager.movieManager.getListOfMovieAndShowtimes());

                    break;
                case 3:
                    //get reviews
                	ratingsReviewsManager.displayMovieAndReviews(bookingManager.movieManager);
                    //ratingsReviewsManager.
                	
                    break;
                case 4:
                	ratingsReviewsManager.addRating(bookingManager.movieManager);
                    break; 
                case 5:
                	ratingsReviewsManager.addReview(bookingManager.movieManager);

                    break;
                case 6:
                   bookingManager.viewBookingHistory(customer_ID);
                    break;
                case 7:
                	ratingsReviewsManager.displayByRank(bookingManager.movieManager);
                	break;
            }
        }
        
    }
    }


