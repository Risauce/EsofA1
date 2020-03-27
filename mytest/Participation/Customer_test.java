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
	public void testParticipationValueZero() {
		System.out.println("Tests a new Customer's getParticipationValue(): 0") ;
		Customer C = new Customer(0,"Duffy Duck","") ;
		assertTrue(C.participationValue() == 0) ; //Because they currently have no services assigned.
	}

	@Test
	public void testParticipationValuePositive() {
		System.out.println("Tests a new Customer's getParticipationValue(): +") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Service pricey = new Service(1, "pricey", 1000);
		Service s2 = new Service(2, "2", 1000);


		Participation p1 = new Participation(C, pricey);
		Participation p2 = new Participation(C, s2);



		C.participations.add(p1);
		C.participations.add(p2);


		assertTrue(C.participationValue() == 2000) ; //Two services assigned.
	}

	@Test
	public void testParticipationValueNeg() {
		System.out.println("Tests a new Customer's getParticipationValue(): -") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Service pricey = new Service(1, "pricey", -1000);
		Service s2 = new Service(2, "2", -10);


		Participation p1 = new Participation(C, pricey);
		Participation p2 = new Participation(C, s2);



		C.participations.add(p1);
		C.participations.add(p2);

		assertTrue(C.participationValue() == -1010) ; //Two negative services
	}


	@Test
	public void testGetDiscountValue() {
		System.out.println("Tests a new Customer's getDiscountValue() when they have 2 applicable discounts.") ;
		Customer C = new Customer(0,"Duffy Duck","") ;

		Discount_5pack fivePack = new Discount_5pack();
		Discount_1000 oneThous = new Discount_1000();

		Service pricey = new Service(1, "pricey", 1000);
		Service s2 = new Service(2, "2", 1000);
		Service s3 = new Service(3, "3", 1999);
		Service s4 = new Service(4, "4", 1001);
		Service s5 = new Service(5, "5", 999);

		Participation p1 = new Participation(C, pricey);
		Participation p2 = new Participation(C, s2);
		Participation p3 = new Participation(C, s3);
		Participation p4 = new Participation(C, s4);
		Participation p5 = new Participation(C, s5);


		C.participations.add(p1);
		C.participations.add(p2);
		C.participations.add(p3);
		C.participations.add(p4);
		C.participations.add(p5);

		C.discounts.add(fivePack); //Add discounts so that it runs through the if
		C.discounts.add(oneThous);

		System.out.println(C.getDiscountValue()	);

		assertTrue(C.getDiscountValue() == 260) ; //They are applicable for both discounts. One 5 times, the other once.
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

	

}
