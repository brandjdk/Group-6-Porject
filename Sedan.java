public class Sedan extends Vehicle{
   private String type = "Sedan";
   
   public Sedan(){
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