/**
 * The Vehicle abstract class is used to create a vehicle object that stores
 * plate number, make, model, color, if it has oversized tires, and if it uses synthetic oil.
 * Get, set, and print out methods are provided.
 * @authors Austin, Brandon, Tadhg
 */

public abstract class Vehicle{
   private String plateNum, make, model, color;
   private Boolean oversizedTires, syntheticOil;
   private static int numVehicles = 0;
   
   /**
	  * Default Vehicle Constructor.
	  * Incriments the total number of vehicle objects that have been created.
	  */
   public Vehicle(){
      numVehicles++;
   }
   
   /**
	  * Vehicle Constructor
	  * Sets plateNum, make, model, color, oversizedTires, and syntheticOil.
    * No validation occurs, as the constructor is only to be used when it is known that
    * every paramater is valid.
	  * Incriments the total number of vehicle objects that have been created.
	  * @params String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil.
	  */
   public Vehicle(String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil){
      this.plateNum = plateNum;
      this.make = make;
      this.model = model;
      this.color = color;
      this.oversizedTires = oversizedTires;
      this.syntheticOil = syntheticOil;
      numVehicles++;
   }
   
   /**
	  * Set the plate number of the vehicle. 
    * A plate number is valid as long as it is not blank.
	  * @params string plateNum
	  */
   public void setPlateNum(String plateNum) {
      if (plateNum == null || plateNum.equals("")) {
         throw new IllegalArgumentException("Plate number can't be blank!");
      }
      this.plateNum = plateNum;
   }
   
   /**
  	* Returns the set vehicle plate number.
  	* @returns string plateNum
  	*/ 
   public String getPlateNum(){
      return plateNum;
   }
   
   /**
	  * Set the make of the vehicle. 
    * The make is valid as long as it is not blank.
	  * @params string make
	  */
   public void setMake(String make){
      if (make == null || make.equals("")) {
         throw new IllegalArgumentException("Car maker can't be blank!");
      }
      this.make = make;
   }
   
   /**
    * Returns the set vehicle make.
  	* @returns string make
  	*/ 
   public String getMake(){
      return make;
   }
   
   /**
	  * Set the model of the vehicle. 
    * The model is valid as long as it is not blank.
	  * @params string model
	  */
   public void setModel(String model){
      if (model == null || model.equals("")) {
         throw new IllegalArgumentException("Car model can't be blank!");
      }
      this.model = model;
   }
   
   /**
  	* Returns the set vehicle model.
  	* @returns string model
  	*/ 
   public String getModel(){
      return model;
   }
   
   /**
	  * Set the color of the vehicle. 
    * The color is valid as long as it is not blank.
	  * @params string plateNum
	  */
   public void setColor(String color){
      if (color == null || color.equals("")) {
         throw new IllegalArgumentException("Car color can't be blank!");
      }
      this.color = color;
   }
   
   /**
  	* Returns the set vehicle color.
  	* @returns string color
  	*/ 
   public String getColor(){
      return color;
   }
   
   /**
	  * Set if the car has oversizedTires or not.
	  * @params boolean oversizedTires
	  */
   public void setTireSize(boolean oversizedTires){
      this.oversizedTires = oversizedTires;
   }
   
   /**
  	* Returns if the vehicle has oversized tires.
  	* @returns boolean oversizedTires
  	*/ 
   public boolean hasOversizedTires(){
      return oversizedTires;
   }
   
   /**
	  * Set if the car has synthetic oil or not.
	  * @params boolean syntheticOil
	  */
   public void setOilType(boolean syntheticOil){
      this.syntheticOil = syntheticOil;
   }
   
   /**
  	* Returns if the vehicle uses synthetic oil.
  	* @returns boolean syntheticOil
  	*/ 
   public boolean usesSyntheticOil(){
      return syntheticOil;
   }
   
   /**
  	* Returns the total number of vehicle objects created.
  	* @returns int numVehicles
  	*/ 
   public static int getNumVehicles(){
      return numVehicles;
   }
   
   /**
  	* Returns the type of vehicle.
    * Must be implemented by child classes.
  	* @returns string type.
  	*/ 
   public abstract String getType();
   
   /**
 	  * Returns an output which holds all of the vehicle information.
 	  * @returns String output.
 	  */  
   public String toString(){
      String output = "Vehicle: \nPlate Num: " + plateNum + "\nType: *TYPE*\nMake: " + make + "\nModel: " + model
         + "\nColor: " + color + "\nHas Oversized Tires: " + oversizedTires + "\nUses Synthetic Oil: " + syntheticOil;
      return output;
   }
   
   /**
 	  * Vehicle information is put together in a format that is to be used when stored in a file.
    * The various pieces of vehicle information are seperated by the '&&' delimeter.
 	  * @returns String output for vehicle information.
 	  */ 
   public String saveFormat() {
      return "%%*TYPE*&&" + plateNum + "&&" + make + "&&" + model + "&&" + color + "&&" + oversizedTires + "&&" + syntheticOil;
   }
}