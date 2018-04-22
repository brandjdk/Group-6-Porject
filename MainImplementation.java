import javax.swing.JOptionPane;
public class MainImplementation {
	
	public static void main(String args[]) {
		
		addVehicle();
		
	}
	
	public static void addVehicle() {
		
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
		
		
		
		
		
		
		
		
		

		
	}
}
