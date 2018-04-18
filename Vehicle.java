public abstract class Vehicle{
   private String plateNum, make, model, color;
   private Boolean oversizedTires, syntheticOil;
   private static int numVehicles = 0;
   
   public Vehicle(){
      numVehicles++;
   }
   
   public void setPlateNum(String plateNum){
      this.plateNum = plateNum;
   }
   
   public String getPlateNum(){
      return plateNum;
   }
   
   public void setMake(String make){
      this.make = make;
   }
   
   public String getMake(){
      return make;
   }
   
   public void setModel(String model){
      this.model = model;
   }
   
   public String getModel(){
      return model;
   }
   
   public void setColor(String color){
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
}