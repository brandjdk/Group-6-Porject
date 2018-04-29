public abstract class Vehicle{
   private String plateNum, make, model, color;
   private Boolean oversizedTires, syntheticOil;
   private static int numVehicles = 0;
   
   public Vehicle(){
      numVehicles++;
   }
   
   public Vehicle(String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil){
      this.plateNum = plateNum;
      this.make = make;
      this.model = model;
      this.color = color;
      this.oversizedTires = oversizedTires;
      this.syntheticOil = syntheticOil;
      numVehicles++;
   }
   
   public void setPlateNum(String plateNum) {
      if (plateNum == null || plateNum.equals("")) {
         throw new IllegalArgumentException("Plate number can't be blank!");
      }
      this.plateNum = plateNum;
   }
   
   public String getPlateNum(){
      return plateNum;
   }
   
   public void setMake(String make){
      if (make == null || make.equals("")) {
         throw new IllegalArgumentException("Car maker can't be blank!");
      }
      this.make = make;
   }
   
   public String getMake(){
      return make;
   }
   
   public void setModel(String model){
      if (model == null || model.equals("")) {
         throw new IllegalArgumentException("Car model can't be blank!");
      }
      this.model = model;
   }
   
   public String getModel(){
      return model;
   }
   
   public void setColor(String color){
      if (color == null || color.equals("")) {
         throw new IllegalArgumentException("Car color can't be blank!");
      }
      this.color = color;
   }
   
   public String getColor(){
      return color;
   }
   
   public void setTireSize(boolean oversizedTires){
      this.oversizedTires = oversizedTires;
   }
   
   public boolean hasOversizedTires(){
      return oversizedTires;
   }
   
   public void setOilType(boolean syntheticOil){
      this.syntheticOil = syntheticOil;
   }
   
   public boolean usesSyntheticOil(){
      return syntheticOil;
   }
   
   public static int getNumVehicles(){
      return numVehicles;
   }
   
   public abstract String getType();
   
   public String toString(){
      String output = "Vehicle: \nPlate Num: " + plateNum + "\nType: *TYPE*\nMake: " + make + "\nModel: " + model
         + "\nColor: " + color + "\nHas Oversized Tires: " + oversizedTires + "\nUses Synthetic Oil: " + syntheticOil;
      return output;
   }
   
   public String saveFormat() {
      return "%%*TYPE*&&" + plateNum + "&&" + make + "&&" + model + "&&" + color + "&&" + oversizedTires + "&&" + syntheticOil;
   }
}