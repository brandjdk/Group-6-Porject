import javax.swing.JOptionPane;
public class MainImplementation {
	
	public static void main(String args[]) {
		
		Customer c = new Customer();
		addVehicle(c);
		
	}
	
	
	public static void removeVehicle(Customer c) {
		
		String plateNum =  JOptionPane.showInputDialog(null, "Enter plate number of Vehicle you would like to Remove: ");
		
		if(c.getVehiclesList().containsKey(plateNum)) {
			
			Vehicle val = c.getVehiclesList().get(plateNum);
			
			c.removeVehicle(val);
			
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
			
			if(c.getVehiclesList().containsKey(plateNum)) {
				
				plateNum = null;
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
			
			if(!(overSizedTiresS.equalsIgnoreCase("Yes") || overSizedTiresS.equalsIgnoreCase("No"))) {
				
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
			
			if(!(syntheticOilS.equalsIgnoreCase("Yes") || syntheticOilS.equalsIgnoreCase("No"))) {
				
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
		
		
		
		
		
		
		
		
		

		
	}
}
