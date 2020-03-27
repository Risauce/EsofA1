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
		System.out.println("Tests a new Customer's getDiscountValue()") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Discount_5pack fivePack = new Discount_5pack();
		Discount_1000 oneThous = new Discount_1000();

		C.discounts.add(fivePack);
		C.discounts.add(oneThous);

		assertTrue(C.getDiscountValue() == 0) ; //Both of their discounts they are not applicable for.
	}


	@Test
	public void testGetParticipationGroups() {
		System.out.println("Tests a new Customer's getParticipationGroups()") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Service testServ = new Service(1,null,0);
		Participation p   = new Participation(C,testServ) ;
		C.participations.add(p);

		assertTrue(!C.getParticipationGroups().isEmpty()); //Tests that this isn't empty.
	}

	
	// and so on ...
}
