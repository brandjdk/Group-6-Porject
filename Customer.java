/**
* The Customer class is used to create a customer object that stores name, id, phone number, address, and vehicles.
* Get, set, validate, and print out methods are provided as well as vehicle add and removal methods. 
* All created code is documented below.
* @authors Brandon, Tadhg, Austin
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Customer {

	// Customer variables and list of vehicles for customer.
	private String name;
	private int id;
	private String phoneNum;
	private String address;
	private Map<String, Vehicle> vehicleList;

	// Static Variables
	private static int numCustomers;
	private static int lastId = 1;
	public static final int MAX_PHONENUM_LENGTH = 10;

	/**
	 * Customer Constructor Sets name, phone number, and address based on validated
	 * input. Initialize a list of vehicles. Increment the id and the number of
	 * customers.
	 * 
	 * @params string name, string phone number, string address
	 * 
	 */

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

	/**
	 * Customer Constructor Sets name, phone number, id, and address. Initialize a
	 * list of vehicles.
	 * 
	 * @params string name, string phone number, string address, int id
	 */

	public Customer(String name, String phoneNum, String address, int id) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.id = id;
		vehicleList = new HashMap<String, Vehicle>();
	}

	/**
	 * Default Customer Constructor Initializes new vehicle list and adds new ID.
	 * Initialize a list of vehicles.
	 */

	public Customer() {
		vehicleList = new HashMap<String, Vehicle>();
		this.id = lastId++;
	}

	/**
	 * Set the validated customer name based on user input.
	 * 
	 * @params string name
	 */
	/**
	 * Set the validated customer name based on user input.
	 * 
	 * @params string name
	 */

	public void setName(String name) {
		if (name == null || name.equals("")) {
			throw new IllegalArgumentException("Name can't be blank.");
		}
		this.name = name;
	}

	/**
	 * Returns the set customer name.
	 * 
	 * @returns string name
	 */

	public String getName() {
		return this.name;
	}

	/**
	 * Set the validated customer phone number based on user input. Customer phone
	 * number must be in the proper format or exception will be thrown.
	 * 
	 * @params string phone number.
	 */

	public void setPhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.equals("")) {
			throw new IllegalArgumentException("Phone number can't be blank.");
		}
		if (!validatePhoneNum(phoneNum)) {
			throw new IllegalArgumentException("Format is invalid. (Ex: XXXXXXXXXX)");
		}
		this.phoneNum = phoneNum;
	}

	/**
	 * Returns the set customer phone number.
	 * 
	 * @returns string phone number.
	 */

	public String getPhoneNum() {
		return this.phoneNum;
	}

	/**
	 * Set the validated customer address based on user input. Customer address must
	 * be filled in or exception will be thrown.
	 * 
	 * @params string address.
	 */

	public void setAddress(String address) {
		if (address == null || address.equals("")) {
			throw new IllegalArgumentException("Address can't be blank.");
		}
		this.address = address;
	}

	/**
	 * Returns the set customer address.
	 * 
	 * @returns string address.
	 */

	public String getAddress() {
		return this.address;
	}

	/**
	 * Adds a vehicle to the vehicle list based on validation. Vehicle must not be
	 * null or exception will be thrown.
	 * 
	 * @params vehicle object
	 */

	public void addVehicle(Vehicle v) {
		if (v == null) {
			throw new IllegalArgumentException("Vehicle object was null.");
		}
		vehicleList.put(v.getPlateNum(), v);
	}

	/**
	 * Removes a vehicle from the vehicle list based on validation. Checks plate
	 * number to see if vehicle object is in vehicle list. Vehicle must not be null
	 * or exception will be thrown.
	 * 
	 * @params vehicle object
	 * @return removed vehicle or null if not found
	 */

	public Vehicle removeVehicle(Vehicle v) {
		if (vehicleList.containsKey(v.getPlateNum())) {
			Vehicle returnVehicle = v;
			vehicleList.remove(v.getPlateNum());
			return returnVehicle;
		} else {
			return null;
		}
	}

	/**
	 * Returns the vehicle list.
	 * 
	 * @returns vehicle list.
	 */

	public Map<String, Vehicle> getVehicles() {
		return vehicleList;
	}

	/**
	 * Returns the number of customers.
	 * 
	 * @returns int number of customers.
	 */

	public static int getNumCustomers() {
		return numCustomers;
	}

	/**
	 * Equals method to compare customer objects. Compares customers based on phone
	 * number and name.
	 * 
	 * @params object for comparison
	 * @returns true if customers are equal and false if customers are not equal,
	 *          null, or not an instance of customer.
	 */

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Customer)) {
			return false;
		}
		Customer c = (Customer) o;
		if (c.getName().equals(this.getName()) && c.getPhoneNum().equals(this.getPhoneNum())) {
			--lastId;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ToString method to print out customer details in a display format.
	 * 
	 * @returns String display output.
	 */

	public String toString() {
		return "Customer ID: " + id + "\nName: " + name + "\nAddress: " + address + "\nPhone: " + phoneNum;

		// Not sure if we want the vehicle list part of the customer toString()
		// "Vehicle list: \n" + this.getVehicles();

	}

	/**
	 * Customer printout format with vehicles attached based on the list of
	 * vehicles. Customer details and vehicle details are separated with delimiters
	 * for file read and writes.
	 * 
	 * @returns String output for customer information.
	 */

	public String saveFormat() {
		String customerFormat = id + "&&" + name + "&&" + phoneNum + "&&" + address;
		String vehicleFormat = "";
		for (Vehicle v : vehicleList.values()) {
			vehicleFormat += v.saveFormat();
		}
		return customerFormat + vehicleFormat;

	}

	/**
	 * Customer phone number validation based on phone number length.
	 * 
	 * @params phone number to check.
	 * @returns boolean based on validation results
	 */

	public static boolean validatePhoneNum(String phoneNum) {
		if (phoneNum.length() == MAX_PHONENUM_LENGTH) {
			return true;
		} else {
			return false;
		}
	}
}
