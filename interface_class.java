package oopdproj;
import java.util.ArrayList;
import java.util.Scanner;

public class interface_class {
	ArrayList<String> listOfObj = new ArrayList<String>();
	String email;	
	String name;
	int age;
	
	public interface_class() {
	}
	
	public void set_email(String mail) {
		email = mail;
	}
	
	public int login() {
		boolean exists=false;
		for(int i=0;i<listOfObj.size();i++) {
			//exists = checkExist(email,listOfObj);//check if the email exists in the database or not.
		}
		if (exists==true) {
			return 1;
		}
		else 
			return 0;
	}
	
	
	public void Book(String email) {
		System.out.print("YAY LETS BOOK");//type booking information
	}
	
	public void movie_det(String email) {
		//type view movie details code
	}
	
	public void reviews(String email) {
		//type review code
	}
	
	public void book_hist(String email) {
		//type booking history code details code
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String isStaff;
		String staffPassword, mail;
		int existance, userChoice;
		System.out.print("Are you a staff?");
		isStaff = scan.next();
		if(isStaff.equalsIgnoreCase("yes")) {
			System.out.print("Please enter staff password");
			staffPassword = scan.next();
			if(staffPassword.equals("000000")) {
				//call the staff system management function
			}
		}
		else if(isStaff.equalsIgnoreCase("no")) {
			System.out.print("Please enter your email ID");
			
			mail = scan.next();
			interface_class userLog = new interface_class();
			userLog.set_email(mail);
			existance = userLog.login();
			
			if(existance == 0) {
				System.out.print("Welcome " + userLog.email + "\nwhat would you like to do? \n1. book \n2. View movie details \n3. Reviews \n4.Check booking history");
				userChoice = scan.nextInt();
				if(userChoice == 1) {
					userLog.Book(userLog.email);
				}
				else if(userChoice == 2) {
					userLog.movie_det(userLog.email);
				}
				else if(userChoice == 3) {
					userLog.reviews(userLog.email);
				}
				else if(userChoice == 4) {
					userLog.book_hist(userLog.email);
				}
				
			}
			else if (existance == 1) {
				//createUser();
			}
			
			
		}
		
	}
}
