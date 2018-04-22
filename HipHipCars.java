import javax.swing.*;
import java.util.*;

public class HipHipCars{

   public static void main(String args[]){
   
   }
   
   public static void AddCustomer(){
      
   }
   
   public static void RemoveCustomer(ArrayList<Customer> cList){
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
         String choice = JOptionPane.showInputDialog("");
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
      int choice = 0;
      Vehicle entryVehicle;
      String plateNum = null; 
      String make = null;
      String model = null;
      String color = null;
      boolean overSizedTires = false;
      String overSizedTiresS = null;
      boolean syntheticOil = false;
      String syntheticOilS = null;
   	
      while(choice != 1 && choice != 2) {
      	
         try {
         
            choice = Integer.parseInt(JOptionPane.showInputDialog("Enter Vehicle Choice:\n 1- Sedan \n 2- SUV"));
         
         }catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Please enter appropriate entry value.");
         }
      
      }
   	
      if(choice == 1) {
         entryVehicle = new Sedan();
      	
      }else {
         entryVehicle = new SUV();
      }
   	
      while(plateNum == null || plateNum.isEmpty()) {
         try {
            plateNum = JOptionPane.showInputDialog("Enter Vehicle Plate Number:");
         
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
      
   }
   
   public static void doAnOilChange(Customer c){
      
   }
   
   public static void performCarDetailing(Customer c){
      
   }
   
   public static void rotateTire(Customer c){
      
   }
   
   public static void doInspection(Customer c){
      
   }
   
   public static Vehicle chooseVehicle(Customer c){
      Vehicle temp = null;
      return temp;
   }
   
   public static void Terminate(){
      
      System.exit(0);
   }
}