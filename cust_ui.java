package oopdproj;

import java.util.ArrayList;
import java.util.Scanner;

public class cust_ui {

	private String email;
	private String name;
	private int age;
	private String[][] listOfObj;

	public cust_ui() {
		String[][] listOfObj = new String[1000000000][3];
		String email;
		String name;
		int age;
	}

	public cust_ui(String email, String name, int age) {
		ArrayList<String> listOfObj = new ArrayList<String>();
		this.email = email;
		this.name = name;
		this.age = age;

	}


	public int login() {
		boolean exists = false;
		// for(int i=0;i<listOfObj.size();i++) {
		// exists = checkExist(email,listOfObj);//check if the email exists in the
		// database or not.
		// }
		if (exists == true) {
			return 1;
		} else
			return 0;
	}

	public void Book(String email) {
		System.out.print("YAY LETS BOOK");// type booking information
	}

	public void movie_det(String email) {
		// type view movie details code
	}

	public void reviews(String email) {
		// type review code
	}

	public void book_hist(String email) {
		// type booking history code details code
	}

	public void print_welcome_page() {
		Scanner scan = new Scanner(System.in);
		int userChoice;
		System.out.print("Welcome " + email
				+ "\nwhat would you like to do? \n1. book \n2. View movie details \n3. Reviews \n4.Check booking history");
		userChoice = scan.nextInt();
		if (userChoice == 1) {
			Book(email);
		} else if (userChoice == 2) {
			movie_det(email);
		} else if (userChoice == 3) {
			reviews(email);
		} else if (userChoice == 4) {
			book_hist(email);
		}
	}

	public boolean isStaff() {
		Scanner scan = new Scanner(System.in);
		String Staff;
		String staffPassword;
		while (true) {
			System.out.print("Are you a staff?");
			Staff = scan.next();
			if (Staff.equalsIgnoreCase("yes")) {
				System.out.print("Please enter staff password");
				staffPassword = scan.next();
				if (staffPassword.equals("000000")) {
					return true;
				} else {
					System.out.print("wrong password");
					continue;
				}
			} else if (Staff.equalsIgnoreCase("no")) {
				return false;

			}
		}
	}

	
			
			
//				System.out.print("Please enter your email ID");
//				mail = scan.next();
//				
//				userLog.set_email(mail);
//			existance = userLog.login();
	//			
	//			if(existance == 0) {
	//				//userLog.printWelcomePage();
	//				
	//			}
	//			else if (existance == 1) {
					
		//		}	
		//	}
		//}
	
}

