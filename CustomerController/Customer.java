public class Customer {
    private int age;
    private String userName;
    private String name;
    private String mobile;
    private String email;
    private static int customerID; //note for customerID it'll be set as static
    public Customer(){
        customerID++;// ++ whenever new log-in
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return this.email;
    }
    public int getCustomerID(){ // note this is a static function
        return customerID;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return this.userName;
    }
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    public String getMobile(){
        return this.mobile;
    }


}
