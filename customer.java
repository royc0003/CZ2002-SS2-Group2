package oopdproj;

public abstract class customer {
	private int age;
	private String name;
	private String mobile;
	private String email;
	private static int userID;
	//private BookingManager bookingOrder;
	
	public void set_age(int age) {
		this.age = age;
	}
	
	public void set_name(String name) {
		this.name = name;
	}
	
	public void set_mobile(String mobile) {
		this.mobile = mobile;
	}
	
	public void set_email(String email) {
		this.email = email;
	}
	
	public void set_userID(int userID) {
		customer.userID = userID;
	}
	
	public int get_age() {
		return age;
	}
	
	public String get_name() {
		return  name;
	}
	
	public String get_mobile() {
		return mobile;
	}
	
	public String get_email() {
		return email;
	}
	
	public static int get_userID() {
		return userID;
	}

}
