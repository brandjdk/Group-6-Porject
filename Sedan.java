/**
* The Sedan class is a child class of the Vehilce abstract class used to create a SUV object
* that stores the type of vehicle it is, as well as all of what is inherited from the Vehicle class.
* Get, and print out methods are provided.
* @authors Austin, Brandon, Tadhg
*/

public class Sedan extends Vehicle{
   private final String type = "Sedan";
   
   /**
	 * Default Sedan Constructor.
	 * Calls the default constructor for the Vehicle class.
	 */
   public Sedan(){
      super();
   }
   
   /**
	 * Sedan Constructor
	 * Sets plateNum, make, model, color, oversizedTires, and syntheticOil based using the Vehicle constructor
    * which calls for the same parameters.
    * @params String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil.
	 */
   public Sedan(String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil){
      super(plateNum, make, model, color, oversizedTires, syntheticOil);
   }
   
   /**
  	 * Returns the type of vehicle.
  	 * @returns string type.
  	 */ 
   public String getType(){
      return type;
   }
   
   /**
 	 * Returns an output which holds all of the vehicle information.
    * Replaces the section '*TYPE*' of the Vehicle's toString method with the type of vehicle.
 	 * @returns String output.
 	 */ 
   public String toString(){
      String output = super.toString();
      output = output.replace("*TYPE*", type);
      return output;
   }
   
   /**
 	 * Vehicle information is put together in a format that is to be used when stored in a file.
    * Replaces the section '*TYPE*' of the Vehicle's toString method with the type of vehicle.
    * The various pieces of vehicle information are seperated by the '&&' delimeter.
 	 * @returns String output for vehicle information.
 	 */ 
   public String saveFormat() {
      String out = super.saveFormat();
      out = out.replace("*TYPE*", type);
      return out;
   }
}