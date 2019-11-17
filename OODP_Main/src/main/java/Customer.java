/**
 * Represents a customer that uses our program
 * There can be many customers
 */
public class Customer implements Serialization {

	/**
	 * The age of the customer
	 */
    private int age;
    /**
     * The user name of the customer (username will be unique)
     */
    private String userName;
    /**
     * The name of the customer
     */
    private String name;
    /**
     * Mobile number of the customer
     */
    private String mobile;
    /**
     * Email of the customer
     */
    private String email;
    /**
     * ID of customer, it will be unique and assigned to a customer based on count
     */
    private int customerID; //note for customerID it'll be set as static
   // private static int count = 0;
    
    public Customer(int customerID){
        this.customerID = customerID;
    }
    
    /**
     * Initializes object and stores it to CSV
     * @param String array
     */
    public Customer(String[] item){

        this.age = Integer.parseInt(item[0]);

        this.userName = item[1];



        this.name = item[2];

        this.mobile = item[3];

        this.email = item[4];

        this.customerID = Integer.parseInt(item[5]);
    }

    /**
     * Changes the age of the customer
     * @param age New age of customer
     */
    public void setAge(int age){
        this.age = age;
    }
    
    /**
     * Gets the age of the customer
     * @return this Customer's age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Changes the name of the customer
     * @param name New name of customer
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Gets the name of the customer
     * @return this Customer's name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Changes the email of the customer
     * @param email New email of customer
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * Gets the email of the customer
     * @return This customer's age
     */

    public String getEmail(){
        return this.email;
    }
    
    /**
     * Gets the ID of the customer
     * @return ID of customer
     */
    public int getCustomerID(){ // note this is a static function
        return customerID;
    }

    /**
     * Changes the username of customer
     * @param userName new user name of customer
     */
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    /**
     * Gets the user name of customer
     * @return user name of customer
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * Changes the mobile number of customer
     * @param mobile New mobile number of customer
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    /**
     * Gets the mobile number of customer
     * @return mobile number of customer
     */
    public String getMobile(){
        return this.mobile;
    }

    /**
     * inputs data to CSV 
     * @return String array
     */
    public String[] toCsv(){
        String[] Csv = {Integer.toString(this.age),this.userName, this.name, this.mobile, this.email, Integer.toString(this.customerID)};
        return Csv;
    }

}