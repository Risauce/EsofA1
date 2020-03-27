package Participation;
import org.junit.* ;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.* ;

/**
 * ALL DONE
 */
public class Customer_test {

	@Test
	public void testCustomerGetCostToPay() {
		System.out.println("Tests a new Customer's getCostToPay()") ;
		Customer C = new Customer(0,"Duffy Duck","") ;
		Customer H = new Customer("Duffy Duck","") ; //Might as well hit the other constructor.
		assertTrue(C.getCostToPay() == 0) ; //Because they currently have no services assigned.
	}

	@Test
	public void testParticipationValue() {
		System.out.println("Tests a new Customer's getParticipationValue()") ;
		Customer C = new Customer(0,"Duffy Duck","") ;
		assertTrue(C.participationValue() == 0) ; //Because they currently have no services assigned.
	}


	@Test
	public void testGetDiscountValue() {
		System.out.println("Tests a new Customer's getDiscountValue() when they have an applicable discount.") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Discount_5pack fivePack = new Discount_5pack();
		Discount_1000 oneThous = new Discount_1000();

		Service pricey = new Service(1, "pricey", 1100);
		Participation p1 = new Participation(C, pricey);

		C.participations.add(p1);

		C.discounts.add(fivePack); //Add discounts so that it runs through the if
		C.discounts.add(oneThous);

		assertTrue(C.getDiscountValue() == 50) ; //They are applicable for the 1000 discount.
	}


	@Test
	public void testGetParticipationGroups() {
		System.out.println("Tests a new Customer's getParticipationGroups()") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Service testServ = new Service(1,null,0);
		Participation p   = new Participation(C,testServ) ; //Add participation so it runs through the if.
		C.participations.add(p);

		assertFalse(C.getParticipationGroups().isEmpty()); //Tests that this isn't empty.
	}

	
	// and so on ...
}
