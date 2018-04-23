import javax.swing.*;
import java.util.*;

public class HipHipCars{

   public static void main(String args[]){
   //ToDo - Add File Accessing
      ArrayList<Customer> customerList = new ArrayList<Customer>();
      mainMenu(customerList);
   }
   
   public static void mainMenu(ArrayList<Customer> cList){
      boolean exit = false;
      while(!exit){
         String choice = JOptionPane.showInputDialog("What would you like to do?\n1. Add Customer\n2. Remove Customer\n3. Access a Customer\n4. Terminate the Program");
         if(choice == null){
            choice = "-1";
         }
         switch(choice){
            case "1": AddCustomer(cList);
               break;
            case "2": RemoveCustomer(cList);
               break;
            case "3": AccessCustomer(cList);
               break;
            case "4": Terminate(cList);
               break;
            default: JOptionPane.showMessageDialog(null, "Please only enter numbers corresponding to a menu option.");
               break;
         }
      }
   }
   
   public static void AddCustomer(ArrayList<Customer> cList) {
      try {
         String name = JOptionPane.showInputDialog("Enter the customer's name: ");
         String phoneNum = JOptionPane.showInputDialog("Enter the customer's phone number (Ex: XXXXXXXXXX): ");
         String address = JOptionPane.showInputDialog("Enter the customer's address: " );
         Customer newCustomer = new Customer(name, phoneNum, address);
      		   
         boolean isEquals = false;
         for (Customer customer : cList) {
            if (newCustomer.equals(customer)) {
               isEquals = true;
            }
         }
      		   
         if (isEquals) {
            JOptionPane.showMessageDialog(null, "Customer is a duplicate!");
         }
         else {
            cList.add(newCustomer);
            JOptionPane.showMessageDialog(null, "Customer added successfully!");
         }
      		   
      		   
         int choice = JOptionPane.showConfirmDialog(null, "Would you like to add a vehicle now?", "Add a Vehicle?", JOptionPane.YES_NO_OPTION);
         if (choice == JOptionPane.YES_OPTION) {
         		   
         }
         else {
            return;
         }
      		   
      		   
      		   
      		   
      }
      catch (IllegalArgumentException e) {
         JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
      }
   }
   
   public static void RemoveCustomer(ArrayList<Customer> cList){
      if(cList.isEmpty()){
         JOptionPane.showMessageDialog(null, "There are no customers stored in the system.");
         return;
      }
      String name = JOptionPane.showInputDialog("What is the name of the customer you wish to remove?");
      String phoneNum = JOptionPane.showInputDialog("What is the phone number of the customer you wish to remove?");
      Customer toRemove = null;
      try{
         Iterator<Customer> cIterator = cList.iterator();
         boolean found = false;
         while(cIterator.hasNext() && !found){
            Customer temp = cIterator.next();
            if(temp.getName().equals(name) && temp.getPhoneNum().equals(phoneNum)){
               toRemove = temp;
               found = true;
            }
         }
         if(!found){
            throw new Exception();
         }
      }catch(Exception e){
         JOptionPane.showMessageDialog(null, "The customer you tried to access was not found.\nReturnign to previous menu.");
         return;
      }
      if(toRemove != null){
         //ToDo
      }
      else{
         JOptionPane.showMessageDialog(null, "The customer you tried to access was not found.\nReturnign to previous menu.");
      }
   }
   
   public static void AccessCustomer(ArrayList<Customer> cList){
      if(cList.isEmpty()){
         JOptionPane.showMessageDialog(null, "There are no customers stored in the system.");
         return;
      }
      String name = JOptionPane.showInputDialog("What is the name of the customer you wish to access?");
      String phoneNum = JOptionPane.showInputDialog("What is the phone number of the customer you wish to access?");
      Customer accessed = null;
      try{
         Iterator<Customer> cIterator = cList.iterator();
         boolean found = false;
         while(cIterator.hasNext() && !found){
            Customer temp = cIterator.next();
            if(temp.getName().equals(name) && temp.getPhoneNum().equals(phoneNum)){
               accessed = temp;
               found = true;
            }
         }
         if(!found){
            throw new Exception();
         }
      }catch(Exception e){
         JOptionPane.showMessageDialog(null, "The customer you tried to access was not found.\nReturnign to previous menu.");
         return;
      }
      if(accessed != null){
         accessMenu(accessed);
      }
      else{
         JOptionPane.showMessageDialog(null, "The customer you tried to access was not found.\nReturnign to previous menu.");
      }
   }
   
   public static void accessMenu(Customer c){
      boolean exit = false;
      while(!exit){
         String choice = JOptionPane.showInputDialog("What would you like to do with this customer?\n1. Add Vehicle\n2. Remove Vehicle\n3. Do an Oil Change\n4. Perform a Car Detailing\n5. Rotate a Vehicle's Tires\n6. Do an Inspection\n7. Return to Previous Menu");
         if(choice == null){
            choice = "-1";
         }
         switch(choice){
            case "1": addVehicle(c);
               break;
            case "2": removeVehicle(c);
               break;
            case "3": doAnOilChange(c);
               break;
            case "4": performCarDetailing(c);
               break;
            case "5": rotateTire(c);
               break;
            case "6": doInspection(c);
               break;
            case "7": exit = true;
               break;
            default: JOptionPane.showMessageDialog(null, "Please only enter numbers corresponding to a menu option.");
               break;
         }
      }
   }
   
   public static void addVehicle(Customer c) {
      int choice = -1;
      String[] options = {"Sedan", "SUV"};
      Vehicle entryVehicle;
      String plateNum = null; 
      String make = null;
      String model = null;
      String color = null;
      boolean overSizedTires = false;
      String overSizedTiresS = null;
      boolean syntheticOil = false;
      String syntheticOilS = null;
   	
      while(choice != 0 && choice != 1) {
         try {
            choice = JOptionPane.showOptionDialog(null, "Enter Vehicle Choice: ", "Vehicle Choice", JOptionPane.DEFAULT_OPTION, 
               JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
         
         
         }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
         }
      }
   	
      if(choice == 0) {
         entryVehicle = new Sedan();
      }else {
         entryVehicle = new SUV();
      }
   	
      while(plateNum == null || plateNum.isEmpty()) {
      	
         try {
         	
            plateNum = JOptionPane.showInputDialog("Enter Vehicle Plate Number:");
         
            if(c.getVehicles().containsKey(plateNum)) {
               plateNum = null;
               JOptionPane.showMessageDialog(null, "The entered plate number is already in use. Please enter a different one.");
            }
         
         }catch(IllegalArgumentException e) {
         	
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            plateNum = null;
         	
         }
      	
      }
   	
      entryVehicle.setPlateNum(plateNum);
   	
      while(make == null || make.isEmpty()) {
         try {
            make = JOptionPane.showInputDialog("Enter Vehicle Make:");
         
         }catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            make = null;
         }
      }
   	
      entryVehicle.setMake(make);
   	
      while(model == null || model.isEmpty()) {
         try {
            model = JOptionPane.showInputDialog("Enter Vehicle Model:");
         }catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            model = null;
         }
      }
   	
      entryVehicle.setModel(model);
   	
   	
      while(color == null || color.isEmpty()) {
         try {
            color = JOptionPane.showInputDialog("Enter Vehicle Color:");
         
         }catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            color = null;
         }
      	
      }
   	
      entryVehicle.setColor(color);
   	
      while(overSizedTiresS == null || overSizedTiresS.isEmpty()) {
         try {
            overSizedTiresS = JOptionPane.showInputDialog("Are the Vehicle's Tires OverSized? ('Yes' or 'No'):");
            if(!(overSizedTiresS.equals("Yes") || overSizedTiresS.equals("No"))) {
               overSizedTiresS = null;
               JOptionPane.showMessageDialog(null, "Please Enter 'Yes' or 'No'");
            }
         
         }catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            overSizedTiresS = null;
         }
      	
      }
   	
      if(overSizedTiresS.equals("Yes")) {
         overSizedTires = true;
      }
      else {
         overSizedTires = false;
      }
   	
      entryVehicle.setTireSize(overSizedTires);	
   	
      while(syntheticOilS == null || syntheticOilS.isEmpty()) {
         try {
            syntheticOilS = JOptionPane.showInputDialog("Is the Vehicle using Synthetic Oil ('Yes' or 'No'):");
            if(!(syntheticOilS.equals("Yes") || syntheticOilS.equals("No"))) {
               syntheticOilS = null;
               JOptionPane.showMessageDialog(null, "Please Enter 'Yes' or 'No'");
            }
         
         }catch(IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
            syntheticOilS = null;
         }
      	
      }
   	
      if(syntheticOilS.equals("Yes")) {
         syntheticOil = true;
      }
      else {
         syntheticOil = false;
      }
   	
      entryVehicle.setOilType(syntheticOil);
   	
      JOptionPane.showMessageDialog(null, entryVehicle.toString());
   	
      c.addVehicle(entryVehicle);
   }
   
   public static void removeVehicle(Customer c){
      String plateNum =  JOptionPane.showInputDialog(null, "Enter plate number of Vehicle you would like to Remove: ");
   	
      if(c.getVehicles().containsKey(plateNum)) {
         Vehicle val = c.getVehicles().get(plateNum);
         c.removeVehicle(val);
      }
   }
   
   public static void doAnOilChange(Customer c){
      final double BASIC_COST = 30.00;
      final double SYNTH_COST = 45.00;//for synthetic oil.
      Vehicle work = chooseVehicle(c);
      if(work == null){
         return;
      }
      double total = 0.0;
      if(work.usesSyntheticOil()){
         total = SYNTH_COST * getTax();
      }
      else{
         total = BASIC_COST * getTax();
      }
      generateReceipt(c, work, "Oil Change", total);
   }
   
   public static void performCarDetailing(Customer c){
      final double SUV_COST = 24.85;
      final double SEDAN_COST = 17.85;
      Vehicle work = chooseVehicle(c);
      if(work == null){
         return;
      }
      double total = 0.0;
      if(work.getType().equals("SUV")){
         total = SUV_COST*getTax();
      }
      else{
         total = SEDAN_COST*getTax();
      }
      
      generateReceipt(c, work, "Car Detail", total);
   }
   
   public static void rotateTire(Customer c){
      final double OVERSIZE_FEE = 12.00;
      final double ROTATION_COST = 25.00;
      Vehicle work = chooseVehicle(c);
      if(work == null){
         return;
      }
      double total = ROTATION_COST;
      if(work.hasOversizedTires()){
         total += OVERSIZE_FEE;
      }
      generateReceipt(c, work, "Rotate Tires", total);
   }
   
   public static void doInspection(Customer c){
      final double INSPECT_COST = 16.00;
      Vehicle work = chooseVehicle(c);
      if(work == null){
         return;
      }
      double total = INSPECT_COST * getTax();
      
      generateReceipt(c, work, "Inspection", total);
      
   }
   
   public static Vehicle chooseVehicle(Customer c){
      Vehicle temp = null;
      boolean exit = false;
      boolean found = false;
      Object o = c;
      Map<String, Vehicle> vehicleList = c.getVehicles();
      if(vehicleList.isEmpty()){
         JOptionPane.showMessageDialog(null, "There are no vehicles associated with this customer.");
         return null;
      }
      Iterator keyIterate = vehicleList.keySet().iterator();
      String output = "Please enter the plate number associated with the vehicle you wish to access.\nOr enter -1 to cancel.";
      while(keyIterate.hasNext()){
         output += "\n" + keyIterate.next();
      }
      while(!exit && !found){
         String choice = JOptionPane.showInputDialog(output);
         if(choice.equals("-1")){
            JOptionPane.showMessageDialog(null, "Returning to previos menu.");
            exit = true;
         }
         else{
            temp = vehicleList.get(choice);
            if(temp != null){
               found = true;
            }
            else{
               JOptionPane.showMessageDialog(null, "The entered plate number does not match any vehicle associated with this customer.\nPlease reenter the plate number or enter -1 to cancel");
            } 
         }
      }
      return temp;
   }
   
   public static double getTax(){
      return 1.06;
   }
   
   public static void Terminate(ArrayList<Customer> cList){
      //ToDo - Add file updating
      System.exit(0);
   }
   
   
   public static void generateReceipt(Customer c, Vehicle v, String serviceType, double cost) {
      String receipt = "Customer: " + c.getName();	   
      receipt += "\nVehicle Serviced: " + v.getPlateNum() + "\nService Performed: " + serviceType + "\nTotal Cost: $" + cost;
      JOptionPane.showMessageDialog(null, receipt);
   }
}