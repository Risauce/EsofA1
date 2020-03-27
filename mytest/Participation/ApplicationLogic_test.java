package Participation;
import org.junit.* ;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.* ;

/**
 * This is just a simple template for Junit test-class for testing
 * the class ApplicationLogic. Testing this class is a bit more
 * complicated. It uses database, which form an implicit part of
 * the state of ApplicationLogic. After each test case, you need to
 * reset the content of the database to the value it had, before
 * the test case. Otherwise, multiple test cases will interfere
 * with each other, which makes debugging hard should you find error.
 * 
 */
public class ApplicationLogic_test {

	/**
	 * Provide a functionality to reset the database. Here I will just
	 * delete the whole database file. 
	 */
	private void setupDB() {
		Persistence.wipedb() ;
	}
	
	
	@Test
	public void test1() {
		// We'll always begin by resetting the database. This makes sure
		// the test start from a clean, well defined state of the database.
		// In this case it would be just an empty database, though it 
		// doesn't have to be like that.
		setupDB() ;
		
		System.out.println("** Testing add customer...") ;
		
		// Creating the target thing you want to test:
		ApplicationLogic SUT = new ApplicationLogic() ;
		
		// Now let's perform some testing. If we add a customer to the system,
		// test that this customer should then be really added to the system:
		int duffyID = SUT.addCustomer("Duffy Duck", "") ;
		Customer C = SUT.findCustomer(duffyID) ;
		assertTrue(C.getName().equals("Duffy Duck")) ;
		assertTrue(C.getEmail().equals("")) ;
	}
	
	// Another example...
	@Test
	public void test2() {
		setupDB() ;
		ApplicationLogic SUT = new ApplicationLogic() ;
		
		System.out.println("** Testing getCostToPay ...") ;
		
		int duffyID = SUT.addCustomer("Duffy Duck", "") ;
		int flowerServiceID = SUT.addService("Flowers online shop", 100) ;
		// let Duffy but 2x participations on Flower-online:
		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ;

		// Now let's check if the system correctly calculates the participation
		// cost of Duffy:
		Customer C = SUT.findCustomer(duffyID) ;
		assertTrue(C.getCostToPay() == 200) ;
	}

	@Test
	public void testRemoveService() {
		setupDB() ;
		ApplicationLogic SUT = new ApplicationLogic() ;

		System.out.println("** Testing removeService ...") ;

		int duffyID = SUT.addCustomer("Duffy Duck", "") ;
		int flowerServiceID = SUT.addService("Flowers online shop", 100) ;
		// let Duffy but 2x participations on Flower-online:
		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ;

		SUT.removeService(flowerServiceID); //Should remove the service from the list of services and
		//All participations.

		Customer C = SUT.findCustomer(duffyID) ;
		assertTrue(C.getCostToPay() == 0) ; //Because there are no services.
		assertTrue(SUT.getServices().isEmpty()); //No services
	}

	@Test
	public void testResolve() {
		setupDB() ;
		ApplicationLogic SUT = new ApplicationLogic() ;

		System.out.println("** Testing resolve() ...") ;

		int duffyID = SUT.addCustomer("Duffy Duck", "") ;
		int secondID = SUT.addCustomer("The Dude", "") ;
		int flowerServiceID = SUT.addService("Flowers online shop", 100) ;
		int magServiceID = SUT.addService("Magazine service", 1001) ;

		Discount_5pack fivePack = new Discount_5pack();
		Discount_1000 oneThou = new Discount_1000();

		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ;
		SUT.addParticipation(duffyID, flowerServiceID) ; //five parts for the discount

		SUT.addParticipation(secondID, magServiceID) ; //For the 1000

		Map<Customer,Integer> payment = new HashMap<Customer,Integer>() ; //The test hashmap

		//SUT.awardDiscount(duffyID, "D1000eur");
		SUT.awardDiscount(duffyID, "D5pack");
		SUT.awardDiscount(secondID, "D1000eur");



		Customer C = SUT.findCustomer(secondID) ;
		Customer H = SUT.findCustomer(duffyID);
		payment.put(C, C.getCostToPay());
		payment.put(H, H.getCostToPay());
		System.out.println("Discount value before: " + H.getDiscountValue());

		Map<Customer,Integer> actualValue = SUT.resolve();

		assertTrue(actualValue.equals(payment) ) ; //Should be the same.
		System.out.println("Discount value: " + H.getDiscountValue());
		//assertTrue(H.getDiscounts().isEmpty()); //It should remove all of the applicable discounts
	}
	
}
