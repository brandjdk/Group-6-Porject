import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class TestCases {
	
	ArrayList<Customer> cList = new ArrayList<Customer>();
	
	@Test
	public void Test() {
		Customer c1 = new Customer("Billy", "7031231234", "123 Fake St");
		Customer c2 = new Customer("Tim", "1233211234", "456 Make Believe Rd");
		
		//Test for duplicate. Should not be added to the array list
		Customer c3 = new Customer("Billy", "7031231234", "456 Fake St"); 
		
		
		//AssertEquals for customer variables
		String c1name = "Billy";
		String c1phoneNum = "7031231234";
		String c1address = "123 Fake St";
		assertEquals(c1name, c1.getName());
		assertEquals(c1phoneNum, c1.getPhoneNum());
		assertEquals(c1address, c1.getAddress());
		
		String c2name = "Tim";
		String c2phoneNum = "1233211234";
		String c2address = "456 Make Believe Rd";
		assertEquals(c2name, c2.getName());
		assertEquals(c2phoneNum, c2.getPhoneNum());
		assertEquals(c2address, c2.getAddress());
		
		//Test to make sure equals method works
		assertTrue(c3.equals(c1));
		
		//Test for number of customer
		assertTrue(Customer.getNumCustomers() == 3);
		
		
		
		//AssertEquals for Vehicle variables
		Vehicle v1 = new SUV();
		v1.setMake("BMW");
		v1.setModel("M3");
		v1.setColor("Black");
		v1.setOilType(true);
		v1.setPlateNum("123-QWRA");
		v1.setTireSize(true);
		
		assertEquals("BMW", v1.getMake());
		assertEquals("M3", v1.getModel());
		assertEquals("Black", v1.getColor());
		assertEquals(true, v1.usesSyntheticOil());
		assertEquals("123-QWRA", v1.getPlateNum());
		assertEquals(true, v1.hasOversizedTires());
		
		Vehicle v2 = new Sedan();
		v2.setMake("Toyota");
		v2.setModel("Camry");
		v2.setColor("Blue");
		v2.setOilType(false);
		v2.setPlateNum("123-QWRA");
		v2.setTireSize(true);
		
		assertEquals("Toyota", v2.getMake());
		assertEquals("Camry", v2.getModel());
		assertEquals("Blue", v2.getColor());
		assertEquals(false, v2.usesSyntheticOil());
		assertEquals("123-QWRA", v2.getPlateNum());
		assertEquals(true, v2.hasOversizedTires());
		
		//Test to make sure vehicles are successfully added to a customer's vehicle list 
		c1.addVehicle(v1);
		assertNotNull(c1.getVehicle(v1.getPlateNum()));
		
		//Test to check number of vehicles in list is correct
		assertEquals(c1.getVehicles().size(), 1);
		
		//Test for duplicate vehicle
		assertTrue(v1.equals(v2));
		
		//Test to make sure customers are successfully added to array list
		cList.add(c1);
		assertNotNull(cList.get(0));
		
		//Test to make sure vehicle access in customer vehicle list works
		assertNotNull(cList.get(0).getVehicle("123-QWRA"));
		
		
		//No tests are being done. Just to show the output of the receipt to verify total cost
		HipHipCars.performCarDetailing(c1); //Total cost should be 26.34
		HipHipCars.doAnOilChange(c1);  //Total cost should be 47.70
		HipHipCars.doInspection(c1);  //Total cost should be 16.96 
		HipHipCars.rotateTire(c1);  //Total cost should be 37.00
		
		
	}
}
