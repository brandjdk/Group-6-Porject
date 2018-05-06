/*
 * This class implements the Vehicle and customer classes to create a customer management application. This application can add and remove customers, add
 * and remove vehicles, and generate receipts on different services performed on customer's vehicles. Customer and vehicle information are saved to a file
 * on termination and loaded every startup. 
 * 
 * @authors Tadhg O'Brien, Austin Moody, Brandon Longworth
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class HipHipCars {
	

   public static void main(String args[]) {
      ArrayList<Customer> customerList = new ArrayList<Customer>();
      readFile(customerList);
      mainMenu(customerList);
   }
	
	/*
	 * Displays the main menu to users with 4 options. 
	 * @param ArrayList cList
	 */
   public static void mainMenu(ArrayList<Customer> cList) {
      boolean exit = false;
      while (!exit) {
         String choice = JOptionPane.showInputDialog(
            	"What would you like to do?\n1. Add Customer\n2. Remove Customer\n3. Access a Customer\n4. Terminate the Program");
         if (choice == null) {
            choice = "-1";
         }
         switch (choice) {
            case "1":
               AddCustomer(cList);
               sortCustomerList(cList);
               break;
            case "2":
               RemoveCustomer(cList);
               break;
            case "3":
               AccessCustomer(cList);
               break;
            case "4":
               Terminate(cList);
               break;
            default:
               JOptionPane.showMessageDialog(null, "Please only enter numbers corresponding to a menu option.");
               break;
         }
      }
   }
	
	/*
	 * Creates a customer object and adds it to the customer list. The customer object is validated and checked for duplicates before being added.
	 * If the customer was successfully added, it will then ask the user if he/she would like to add a vehicle. 
	 * @param ArrayList cList
	 */
   public static void AddCustomer(ArrayList<Customer> cList) {
   
      Customer newCustomer = new Customer();
   
      boolean isNameValid = false;
      while (!isNameValid) {
         try {
            newCustomer.setName(JOptionPane.showInputDialog("Enter the customer's name: "));
            isNameValid = true;
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            isNameValid = false;
         }
      }
   
      boolean isPhoneValid = false;
      while (!isPhoneValid) {
         try {
            newCustomer.setPhoneNum(
               	JOptionPane.showInputDialog("Enter the customer's phone number (Ex: XXXXXXXXXX): "));
            isPhoneValid = true;
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            isPhoneValid = false;
         }
      }
   
      boolean isAddressValid = false;
      while (!isAddressValid) {
         try {
            newCustomer.setAddress(JOptionPane.showInputDialog("Enter the customer's address: "));
            isAddressValid = true;
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            isAddressValid = false;
         }
      }
   
      boolean isEquals = false;
      for (Customer customer : cList) {
         if (customer.equals(newCustomer)) {
            isEquals = true;
         }
      }
   
      if (isEquals) {
         JOptionPane.showMessageDialog(null, "This customer already exists. Returning to the main menu.");
      } else {
         cList.add(newCustomer);
         JOptionPane.showMessageDialog(null, "Customer added successfully!");
         int choice = JOptionPane.showConfirmDialog(null, "Would you like to add a vehicle now?", "Add a Vehicle?",
            	JOptionPane.YES_NO_OPTION);
         while (choice == JOptionPane.YES_OPTION) {
            addVehicle(newCustomer);
            choice = JOptionPane.showConfirmDialog(null, "Would you like to add another vehicle?",
               	"Another vehicle?", JOptionPane.YES_NO_OPTION);
         }
      }
   }
	
	
	/*
	 * Removes a customer from the customer list based on user name and phone number. If the customer is not found, an exception is thrown.
	 * @param ArrayList, cList
	 * 
	 */
   public static void RemoveCustomer(ArrayList<Customer> cList) {
      if (cList.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Customer list is empty!");
         return;
      }
      String name = JOptionPane.showInputDialog("What is the name of the customer you wish to remove?");
      String phoneNum = JOptionPane.showInputDialog("What is the phone number of the customer you wish to remove?");
      Customer toRemove = searchCustomer(cList, name, phoneNum);
      if (toRemove != null) {
         cList.remove(toRemove);
         JOptionPane.showMessageDialog(null, "Customer has been removed.");
      } else {
         JOptionPane.showMessageDialog(null,
            	"The customer you tried to access was not found.\nReturning to previous menu.", "Error",
            	JOptionPane.ERROR_MESSAGE);
      }
   }
	
	
	/*
	 * This method will find a customer in the customer list based on name and phone number. IF the customer if found, a menu of options will appear.
	 * If not, an exception is thrown.
	 * @param ArrayList cList
	 * 
	 */
   public static void AccessCustomer(ArrayList<Customer> cList) {
      if (cList.isEmpty()) {
         JOptionPane.showMessageDialog(null, "Customer list is empty!", "Error", JOptionPane.ERROR_MESSAGE);
         return;
      }
      String name = JOptionPane.showInputDialog("What is the name of the customer you wish to access?");
      String phoneNum = JOptionPane.showInputDialog("What is the phone number of the customer you wish to access?");
      Customer accessed = searchCustomer(cList, name, phoneNum);
      if (accessed != null) {
         accessMenu(accessed);
      } else {
         JOptionPane.showMessageDialog(null,
            	"The customer you tried to access was not found.\nReturning to previous menu.", "Error",
            	JOptionPane.ERROR_MESSAGE);
      }
   }
	
	/*
	 * This menu is displayed after a user accesses a customer in the list. It gives options such as adding/removing vehicles and generating receipts
	 * for performed services
	 * @param Customer c
	 * 
	 */
   public static void accessMenu(Customer c) {
      boolean exit = false;
      while (!exit) {
         String choice = JOptionPane.showInputDialog(
            	"What would you like to do with this customer?\n1. Add Vehicle\n2. Remove Vehicle\n3. Do an Oil Change\n4. Perform a Car Detailing\n5. Rotate a Vehicle's Tires\n6. Do an Inspection\n7. Return to Previous Menu");
         if (choice == null) {
            choice = "-1";
         }
         switch (choice) {
            case "1":
               addVehicle(c);
               break;
            case "2":
               removeVehicle(c);
               break;
            case "3":
               doAnOilChange(c);
               break;
            case "4":
               performCarDetailing(c);
               break;
            case "5":
               rotateTire(c);
               break;
            case "6":
               doInspection(c);
               break;
            case "7":
               exit = true;
               break;
            default:
               JOptionPane.showMessageDialog(null, "Please only enter numbers corresponding to a menu option.",
                  "Error", JOptionPane.ERROR_MESSAGE);
               break;
         }
      }
   }
	
	/*
	 * This method will add a vehicle to a customer's list of vehicles. If at any time information from the user is invalid, an exception is thrown
	 * @param Customer c
	 */
   public static void addVehicle(Customer c) {
      int choice = -1;
      String[] options = { "Sedan", "SUV" };
      Vehicle entryVehicle;
      String plateNum = null;
      String make = null;
      String model = null;
      String color = null;
      boolean overSizedTires = false;
      String overSizedTiresS = null;
      boolean syntheticOil = false;
      String syntheticOilS = null;
   
      while (choice != 0 && choice != 1) {
         try {
            choice = JOptionPane.showOptionDialog(null, "Enter Vehicle Choice: ", "Vehicle Choice",
               	JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         
         } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.", "Error",
               	JOptionPane.ERROR_MESSAGE);
         }
      }
   
      if (choice == 0) {
         entryVehicle = new Sedan();
      } else {
         entryVehicle = new SUV();
      }
   
      while (plateNum == null || plateNum.isEmpty()) {
      
         try {
         
            plateNum = JOptionPane.showInputDialog("Enter Vehicle Plate Number:");
         
            if (!Vehicle.checkPlateNum(plateNum)) {
               plateNum = null;
               JOptionPane.showMessageDialog(null,
                  	"The entered plate number is already in use. Please enter a different one.", "Error",
                  	JOptionPane.ERROR_MESSAGE);
            }
         
         } catch (IllegalArgumentException e) {
         
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.", "Error",
               	JOptionPane.ERROR_MESSAGE);
            plateNum = null;
         
         }
      
      }
   
      entryVehicle.setPlateNum(plateNum);
   
      while (make == null || make.isEmpty()) {
         try {
            make = JOptionPane.showInputDialog("Enter Vehicle Make:");
            entryVehicle.setMake(make);
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.", "Error",
               	JOptionPane.ERROR_MESSAGE);
            make = null;
         }
      }
   
      while (model == null || model.isEmpty()) {
         try {
            model = JOptionPane.showInputDialog("Enter Vehicle Model:");
            entryVehicle.setModel(model);
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.", "Error",
               	JOptionPane.ERROR_MESSAGE);
            model = null;
         }
      }
   
      while (color == null || color.isEmpty()) {
         try {
            color = JOptionPane.showInputDialog("Enter Vehicle Color:");
            entryVehicle.setColor(color);
         } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.", "Error",
               	JOptionPane.ERROR_MESSAGE);
            color = null;
         }
      
      }
   
      while (overSizedTiresS == null || overSizedTiresS.isEmpty()) {
         overSizedTiresS = JOptionPane.showInputDialog("Are the Vehicle's Tires OverSized? ('Yes' or 'No'):");
         if (!(overSizedTiresS.equalsIgnoreCase("Yes") || overSizedTiresS.equalsIgnoreCase("No"))) {
            overSizedTiresS = null;
            JOptionPane.showMessageDialog(null, "Please Enter 'Yes' or 'No'", "Error",
                  	JOptionPane.ERROR_MESSAGE);
         }
      }
   
      if (overSizedTiresS.equalsIgnoreCase("Yes")) {
         overSizedTires = true;
      } else {
         overSizedTires = false;
      }
   
      entryVehicle.setTireSize(overSizedTires);
   
      while (syntheticOilS == null || syntheticOilS.isEmpty()) {
         syntheticOilS = JOptionPane.showInputDialog("Is the Vehicle using Synthetic Oil ('Yes' or 'No'):");
         if (!(syntheticOilS.equalsIgnoreCase("Yes") || syntheticOilS.equalsIgnoreCase("No"))) {
            syntheticOilS = null;
            JOptionPane.showMessageDialog(null, "Please Enter 'Yes' or 'No'", "Error",
                  	JOptionPane.ERROR_MESSAGE);
         }
      }
   
      if (syntheticOilS.equalsIgnoreCase("Yes")) {
         syntheticOil = true;
      } else {
         syntheticOil = false;
      }
   
      entryVehicle.setOilType(syntheticOil);
   
      JOptionPane.showMessageDialog(null, entryVehicle.toString());
   
      c.addVehicle(entryVehicle);
   }
	
	/*
	 * This method will remove a vehicle based on the plate number provided by the user. If not the vehicle is not found, an exception is thrown. 
	 * @param Customer c
	 */
   public static void removeVehicle(Customer c) {
      if (c.getVehicles().isEmpty()) {
         JOptionPane.showMessageDialog(null, "There are no vehicles associated with this customer.", "Error",
            	JOptionPane.ERROR_MESSAGE);
         return;
      }
      String plateNum = null;
   
      try {
      
         plateNum = JOptionPane.showInputDialog(null, "Enter plate number of Vehicle you would like to Remove: ");
      
         if (plateNum.isEmpty() || plateNum.equals(null)) {
         
            JOptionPane.showMessageDialog(null, "Invalid Plate Number.", "Error", JOptionPane.ERROR_MESSAGE);
         }
      
      } catch (IllegalArgumentException e) {
      
         JOptionPane.showMessageDialog(null, "Invalid Plate Number.", "Error", JOptionPane.ERROR_MESSAGE);
      }
   
      if (c.getVehicles().containsKey(plateNum)) {
         Vehicle val = c.getVehicles().get(plateNum);
         String tempPlate = val.getPlateNum();
         c.removeVehicle(val);
         JOptionPane.showMessageDialog(null, "Vehicle with plate number: " + tempPlate + " was removed.",
            	"Delete Confirmation", JOptionPane.INFORMATION_MESSAGE);
      } else {
         JOptionPane.showMessageDialog(null, "Vehicle could not be found!", "Error", JOptionPane.ERROR_MESSAGE);
      }
   }
	
	/*
	 * This method calculate the price of an oil change based on a customer's vehicle. A receipt is generated listing information about the 
	 * service and what car it was performed on.
	 * @param Customer c
	 * 
	 */
   public static void doAnOilChange(Customer c) {
      final double BASIC_COST = 30.00;
      final double SYNTH_COST = 45.00;// for synthetic oil.
      Vehicle work = chooseVehicle(c);
      if (work == null) {
         return;
      }
      double total = 0.0;
      if (work.usesSyntheticOil()) {
         total = SYNTH_COST * getTax();
      } else {
         total = BASIC_COST * getTax();
      }
      generateReceipt(c, work, "Oil Change", total);
   }
	
	
	/*
	 * This method calculates the cost of performing car detailing. It will generate a receipt with the information.
	 * @param Customer c
	 *
	 */
   public static void performCarDetailing(Customer c) {
      final double SUV_COST = 24.85;
      final double SEDAN_COST = 17.85;
      Vehicle work = chooseVehicle(c);
      if (work == null) {
         return;
      }
      double total = 0.0;
      if (work.getType().equals("SUV")) {
         total = SUV_COST * getTax();
      } else {
         total = SEDAN_COST * getTax();
      }
   
      generateReceipt(c, work, "Car Detail", total);
   }
	
	/*
	 * This method calculates the cost of performing a tire rotation. It will generate a receipt with the information.
	 * @param Customer c
	 *
	 */
   public static void rotateTire(Customer c) {
      final double OVERSIZE_FEE = 12.00;
      final double ROTATION_COST = 25.00;
      Vehicle work = chooseVehicle(c);
      if (work == null) {
         return;
      }
      double total = ROTATION_COST;
      if (work.hasOversizedTires()) {
         total += OVERSIZE_FEE;
      }
      total = total * getTax();
      generateReceipt(c, work, "Rotate Tires", total);
   }
	
	/*
	 * This method calculates the cost of performing a car inspection. It will generate a receipt with the information.
	 * @param Customer c
	 *
	 */
   public static void doInspection(Customer c) {
      final double INSPECT_COST = 16.00;
      Vehicle work = chooseVehicle(c);
      if (work == null) {
         return;
      }
      double total = INSPECT_COST * getTax();
   
      generateReceipt(c, work, "Inspection", total);
   
   }
	
	/*
	 * This method will allow the user to select a vehicle from the customer's list of vehicles. The user is notified if the vehicle could not be
	 * found
	 * @param Customer c
	 *
	 */
   public static Vehicle chooseVehicle(Customer c) {
      Vehicle temp = null;
      boolean exit = false;
      boolean found = false;
      Object o = c;
      Map<String, Vehicle> vehicleList = c.getVehicles();
      if (vehicleList.isEmpty()) {
         JOptionPane.showMessageDialog(null, "There are no vehicles associated with this customer.", "Error",
            	JOptionPane.ERROR_MESSAGE);
         return null;
      }
      Iterator<String> keyIterate = vehicleList.keySet().iterator();
      String output = "Please enter the plate number associated with the vehicle you wish to access.\nOr enter -1 to cancel.";
      while (keyIterate.hasNext()) {
         output += "\n" + keyIterate.next();
      }
      while (!exit && !found) {
         String choice = JOptionPane.showInputDialog(output);
         if (choice.equals("-1")) {
            JOptionPane.showMessageDialog(null, "Returning to previous menu.");
            exit = true;
         } else {
            temp = vehicleList.get(choice);
            if (temp != null) {
               found = true;
            } else {
               JOptionPane.showMessageDialog(null,
                  	"The entered plate number does not match any vehicle associated with this customer.\nPlease reenter the plate number or enter -1 to cancel",
                  	"Error", JOptionPane.ERROR_MESSAGE);
            }
         }
      }
      return temp;
   }
	
	/*
	 * This method returns the sales tax which is 6%.
	 * @return double 1.06
	 *
	 */
   public static double getTax() {
      return 1.06;
   }

	/*
	 * This method terminates the program and saves the customer list to a file before exiting.
	 * @param ArrayList cList
	 *
	 */
   public static void Terminate(ArrayList<Customer> cList) {
      sortCustomerList(cList);
      addCustomerToFile(cList); 
      System.exit(0);
   }
	
	
	/*
	 * This method reads customer and vehicle information from a text file a populates the customer list. 
	 * @param ArrayList cList
	 *
	 */
   public static void readFile(ArrayList<Customer> cList) {
      try {
         Scanner scan = new Scanner(new FileInputStream(new File("customer.txt")));
         do {
            cList.add(generateCustomer(scan.nextLine()));
         } while (scan.hasNextLine());
         scan.close();
      } catch (FileNotFoundException e) {
         JOptionPane.showMessageDialog(null, "File does not exist or was not found. Creating new file.");
      } catch (NoSuchElementException e) {
      
      }
   }
	
	/*
	 * This method will generate a customer object and the list of vehicles from the text file.
	 * @param String data
	 * @return Customer temp
	 *
	 */
   public static Customer generateCustomer(String data) {
      String[] values = data.split("%%");
      Customer temp = populateCustomer(values[0]);
      for (int x = 1; x < values.length; x++) {
         temp.addVehicle(populateVehicle(values[x]));
      }
      return temp;
   }
	
	/*
	 * This method will create a Customer object from the text file
	 * @param String data
	 * @return Customer temp;
	 *
	 */
   public static Customer populateCustomer(String data) {
      String[] values = data.split("&&");
      int ID = Integer.parseInt(values[0]);
      Customer temp = new Customer(values[1], values[2], values[3], ID);
      return temp;
   }

	/*
	 * This method will populate a vehicle with information from the text file
	 * @param String data
	 * @return Vehicle temp
	 *
	 */
   public static Vehicle populateVehicle(String data) {
      String[] values = data.split("&&");
      boolean tires = false;
      boolean oil = false;
      Vehicle temp = null;
      if (values[5].equals("true")) {
         tires = true;
      }
      if (values[6].equals("true")) {
         oil = true;
      }
      if (values[0].equals("SUV")) {
         temp = new SUV(values[1], values[2], values[3], values[4], tires, oil);
      } else if (values[0].equals("Sedan")) {
         temp = new Sedan(values[1], values[2], values[3], values[4], tires, oil);
      }
      return temp;
   }

	/*
	 * This method generates a receipt with information about the customer and their vehicle that was serviced. The receipt also shows the cost
	 * of the service performed.
	 * @param Customer c, Vehicle v, String serviceType, double cost
	 */
   public static void generateReceipt(Customer c, Vehicle v, String serviceType, double cost) {
      String receipt = "Customer: " + c.getName();
      receipt += "\nVehicle Serviced: " + v.getPlateNum() + "\nService Performed: " + serviceType + "\nTotal Cost: $"
         	+ String.format("%.2f", cost);
      JOptionPane.showMessageDialog(null, receipt);
   }

	/*
	 * This method adds the list of customer objects to a text file for storage. 
	 * @param ArrayList cList
	 *
	 */
   public static void addCustomerToFile(ArrayList<Customer> cList) {
   
      FileOutputStream fos = null;
      PrintWriter pw = null;
   
      File file = new File("customer.txt");
   
      try {
         fos = new FileOutputStream(file);
         pw = new PrintWriter(fos);
      
         Iterator<Customer> it = cList.iterator();
      
         while (it.hasNext()) {
         
            Customer next = (Customer) it.next();
            pw.write(next.saveFormat() + "\r\n");
         }
      
      } catch (FileNotFoundException e) {
      
         e.printStackTrace();
      }
   
      pw.close();
   
   }
   /*
    * Sorts the customer list alphabetically using insertion sort
    * 
    */
   public static ArrayList<Customer> sortCustomerList(ArrayList<Customer> cList) {
      int n = cList.size();
      for (int i = 1; i < n; i++) {
         Customer cust = cList.get(i);
         int j = i;
         while (j > 0 && cList.get(j - 1).getName().compareTo(cust.getName()) > 0) {
            cList.set(j, cList.get(j - 1));
            j--;
         }
         cList.set(j, cust);	   
      }
      return cList;
   }
   
   public static Customer searchCustomer(ArrayList<Customer> cList, String name, String phoneNum){
      int start = 0;
      int end = cList.size();
      while(start < end){
         int mid = (start + end)/2;
         if(name.equals(cList.get(mid).getName()) && phoneNum.equals(cList.get(mid).getPhoneNum())){
            return cList.get(mid);
         }
         else if(name.compareTo(cList.get(mid).getName()) < 0){
            end = mid;
         }
         else{
            start = mid + 1;
         }
      }
      return null;
   }
}
