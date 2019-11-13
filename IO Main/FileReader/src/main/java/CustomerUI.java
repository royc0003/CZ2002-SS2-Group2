import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUI {
	private int custID;

    public ArrayList<Customer> loginPage(ArrayList<Customer> customerStorage) {
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
                    	int tempID;
                    	for(Customer n : customerStorage) {
                    		if(n.getUserName().equalsIgnoreCase(userName)) {
                    			this.custID = n.getCustomerID();
                    		}
                    	}
                        break;
                    }
                    System.out.println("Enter username: ");
                    userName = sc.next();
                    count--;
                }
                if(count == 0){
                	customerStorage = createCustomerAccountPage(customerStorage);
                }
                break;
            case 2:
            	System.out.println("IT IS CREATING");
            	customerStorage = createCustomerAccountPage(customerStorage);
            	this.custID = customerStorage.size()+1;
        }
        
        return customerStorage;
    }
    public int custID() {
    	return this.custID;
    }

    private boolean checkExist(ArrayList<Customer> customerStorage, String userName){


    	
    	if(customerStorage.size() > 0) {
    		
	        for(Customer n: customerStorage){
	        	if(n.getUserName().equalsIgnoreCase(userName)){  
	                return true;
	            }
	        }
    	}
    	

        return false;
    }

    //basic check to see if the username exist or not

    private ArrayList<Customer> createCustomerAccountPage(ArrayList<Customer> customerStorage){
    	Customer newCustomer;
        Scanner sc = new Scanner(System.in);
        System.out.println("************************************************************");
        System.out.println("***************Customer Account Creation Page***************");
        newCustomer = new Customer(customerStorage.size()+1);
        
        
        System.out.println("Created a new customer object");
        
   

       // Customer tempAccount = customerStorage.get(customerStorage.size()-1); // retrives the last object
        System.out.println("Create username: ");
        String userName = sc.next();
        
        // if exist is true then need to prompt to recreate a new one
        while(checkExist(customerStorage, userName)){
           System.out.println("Create username: ");
            userName = sc.next(); // if not exist then can exit the loop meaning not exist in the db system
        }
        System.out.println("Username Successfully Created!");
        newCustomer.setUserName(userName);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Enter Name: ");
        String name = sc.next();
        newCustomer.setName(name);
        System.out.println("Enter Mobile: ");
        String mobile = sc.next();
        newCustomer.setMobile(mobile);
        System.out.println("Enter Email: ");
        String email = sc.next();
        newCustomer.setEmail(email);
        
        System.out.println("Enter age: ");
        int age = sc.nextInt();
        newCustomer.setAge(age);
        
        
        customerStorage.add(newCustomer);
        return customerStorage;

    }


    public void printWelcomePage(int customer_ID, BookingManager bookingManager, RatingsReviewsManager ratingsReviewsManager, PriceManager priceManager) {
        Scanner scan = new Scanner(System.in);
        int userChoice;
        int option;
    	bookingManager.movieManager.initializeMovie();

        do{
        	System.out.println("************************WELCOME TO CineVillage************************");
	        System.out.println("OPTIONS:");
	        System.out.println("Option 1: Make A Booking");
	        System.out.println("Option 2: View Movie Details");
	        System.out.println("Option 3: Get Reviews for a Movie");
	        System.out.println("Option 4: Add Ratings");
	        System.out.println("Option 5: Add Reviews");
	        System.out.println("Option 6: Check Booking History");
	        System.out.println("Option 7: Display Top 5 Movies by Rating");
	        System.out.println("Option 8: Exit");
	        
	        System.out.println("Please choose an option: ");
	        userChoice = scan.nextInt();

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
                	bookingManager.movieManager.saveMovieAndShowtimesCSV(bookingManager.movieManager.listOfMovieAndShowtimes);

                    break; 
                case 5:
                	ratingsReviewsManager.addReview(bookingManager.movieManager);

                    break;
                case 6:
                	System.out.println("CUSTOMER ID ---- "+ customer_ID);
                   bookingManager.viewBookingHistory(customer_ID);
                    break;
                case 7:
                	ratingsReviewsManager.displayByRank(bookingManager.movieManager);
                	break;
            }
            
            System.out.println("");
            System.out.println("Get back to Customer Option Page");
	         System.out.println("(1) Yes");
	         System.out.println("(2) No");
	         
	         option = scan.nextInt();
	         
        }while(option==1);
        	
        
    }
    
    }


