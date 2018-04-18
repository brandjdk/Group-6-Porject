public class SUV extends Vehicle{
   private String type = "SU";
   
   public SUV(){
      super();
   }
   
   public String getType(){
      return type;
   }
   
   public String toString(){
      String output = super.toString();
      output = output.replace("*TYPE*", type);
      return output;
   }
}