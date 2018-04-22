import java.util.*
import javax.swing.*;

public class HipHipCars{

   public static void main(String args[]){
	   ArrayList<Customer> customerList = new ArrayList<Customer>();
	   
	   AddCustomer(customerList);
	   
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
   
   public static void RemoveCustomer(){
      
   }
   
   public static void AccessCustomer(){
      
   }
   
   public static void Terminate(){
      
      System.exit(0);
   }
}