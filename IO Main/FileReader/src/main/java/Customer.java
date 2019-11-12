public class Customer implements Serialization {
    private int age;
    private String userName;
    private String name;
    private String mobile;
    private String email;
    private int customerID; //note for customerID it'll be set as static
    private static int count = 0;
    public Customer(){
        count++;// ++ whenever new log-in
        this.customerID = count;
    }
    
    public Customer(String[] item){
        this.age = Integer.parseInt(item[0]);
        this.userName = item[1];

        this.name = item[2];
        this.mobile = item[3];
        this.email = item[4];
        this.customerID = Integer.parseInt(item[5]);


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
    public String[] toCsv(){
        String[] Csv = {Integer.toString(this.age),this.userName, this.name, this.mobile, this.email, Integer.toString(this.customerID)};
        return Csv;
    }

}