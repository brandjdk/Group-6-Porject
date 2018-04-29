public class SUV extends Vehicle{
   private String type = "SUV";
   
   public SUV(){
      super();
   }
    
   public SUV(String plateNum, String make, String model, String color, boolean oversizedTires, boolean syntheticOil){
      super(plateNum, make, model, color, oversizedTires, syntheticOil);
   }
   
   public String getType(){
      return type;
   }
   
   public String toString(){
      String output = super.toString();
      output = output.replace("*TYPE*", type);
      return output;
   }
   
   public String saveFormat() {
      String out = super.saveFormat();
      out = out.replace("*TYPE*", type);
      return out;
   }
}