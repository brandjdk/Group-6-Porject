import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Customer {

   private String name;
   private int id;
   private String phoneNum;
   private String address;
   private Map<String, Vehicle> vehicleList;
	
	//Static Variables
   private static int numCustomers;
   private static int lastId = 1;
   public static final int MAX_PHONENUM_LENGTH = 10;
	
	
   public Customer(String name, String phoneNum, String address) {
      if (name == null || name.equals("")) {
         throw new IllegalArgumentException("Name can't be blank!");
      }
      if (phoneNum == null || phoneNum.equals("")) {
         throw new IllegalArgumentException("Phone number can't be blank!");
      }
      if (!validatePhoneNum(phoneNum)) {
         throw new IllegalArgumentException("Phone number format is invalid!");
      }
      if (address == null || address.equals("")) {
         throw new IllegalArgumentException("Address can't be blank!");
      }		
      this.name = name;
      this.phoneNum = phoneNum;
      this.address = address;
      this.id = lastId++;
      vehicleList = new HashMap<String, Vehicle>();
      numCustomers++;
   }
	
   public Customer(String name, String phoneNum, String address, int id) {
      this.name = name;
      this.phoneNum = phoneNum;
      this.address = address;
      this.id = id;
      vehicleList = new HashMap<String, Vehicle>();
   }
	
   public Customer(){
      vehicleList = new HashMap<String, Vehicle>();
      this.id = lastId++;
   }
	
   public void setName(String name) {
      if (name == null || name.equals("")) {
         throw new IllegalArgumentException("Name can't be blank.");
      }
      this.name = name;
   }
	
   public String getName() {
      return this.name;
   }
	
	
   public void setPhoneNum(String phoneNum) {
      if (phoneNum == null || phoneNum.equals("")) {
         throw new IllegalArgumentException("Phone number can't be blank.");
      }
      if (!validatePhoneNum(phoneNum)) {
         throw new IllegalArgumentException("Format is invalid. (Ex: XXX-XXX-XXXX)");
      }
      this.phoneNum = phoneNum;
   }
	
	
   public String getPhoneNum() {
      return this.phoneNum;
   }
	
	
   public void setAddress(String address) {
      if (address == null || address.equals("")) {
         throw new IllegalArgumentException("Address can't be blank.");
      }
      this.address = address;
   }
	
	
   public String getAddress() {
      return this.address;
   }
	
	
   public void addVehicle(Vehicle v) {
      if (v == null) {
         throw new IllegalArgumentException("Vehicle object was null.");
      }
      vehicleList.put(v.getPlateNum(), v);
   }
	
   public Vehicle removeVehicle(Vehicle v) {
      if (vehicleList.containsKey(v.getPlateNum())) {
         Vehicle returnVehicle = v;
         vehicleList.remove(v.getPlateNum());
         return returnVehicle;
      }
      else {
         return null;
      }
   }
	
	
   public Map<String, Vehicle> getVehicles() {
      return vehicleList;
   }
	
	
   public static int getNumCustomers() {
      return numCustomers;
   }
	
   @Override 
   public boolean equals(Object o) {
      if (o == null) {
         return false;
      }
      if (!(o instanceof Customer)) {
         return false;
      }
      Customer c = (Customer)o;
      if (c.getName().equals(this.getName()) && c.getPhoneNum().equals(this.getPhoneNum())) {
         --lastId;
         return true;
      }
      else {
         return false;
      }
   }
	
	
   public String toString() {
      return "Customer ID: " + id + "\nName: " + name + "\nAddress: " + address +
         		"\nPhone: " + phoneNum;
   	
   	//Not sure if we want the vehicle list part of the customer toString()
   	//"Vehicle list: \n" + this.getVehicles();
   			
   }
	
   public String saveFormat() {
      String customerFormat = id + "&&" + name + "&&" + address + "&&" + phoneNum;
      String vehicleFormat = "";
      for (Vehicle v : vehicleList.values()) {
         vehicleFormat += v.saveFormat();
      }
      return customerFormat + vehicleFormat;
   	
   }
	
	
   public static boolean validatePhoneNum(String phoneNum) {
      if (phoneNum.length() == MAX_PHONENUM_LENGTH) {
         return true;
      }
      else {
         return false;
      }
   }
	
	
}
