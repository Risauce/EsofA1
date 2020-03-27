package Participation;
import org.junit.* ;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.* ;


/**ALL DONE */
public class Discount_1000_test {

    @Test
    public void testApplicableNo() {
        System.out.println("Tests whether a Customer is applicable for _1000 discount: NO") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_1000 oneThous = new Discount_1000();
        C.discounts.add(oneThous);

        assertFalse(oneThous.applicable(C)); ; //Because they currently have no services assigned.
    }

    @Test
    public void testApplicableYes() {
        System.out.println("Tests whether a Customer is applicable for _1000 discount: YES") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_1000 oneThous = new Discount_1000();
        C.discounts.add(oneThous);

        Service pricey = new Service(1, "pricey", 1001);
        Participation p1 = new Participation(C, pricey);

        C.participations.add(p1);

        assertTrue(oneThous.applicable(C)); ; //Should be yes, because they have at least 1000 in services.
    }

    @Test
    public void testCalcDiscountZero() {
        System.out.println("Tests CalcDiscount: 0") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_1000 oneThous = new Discount_1000();
        C.discounts.add(oneThous);

        /*Service pricey = new Service(1, "pricey", 1001);
        Participation p1 = new Participation(C, pricey);

        C.participations.add(p1);*/



        assertTrue(oneThous.calcDiscount(C) == 0); ; //Will be 0, because there are no services.
    }

    @Test
    public void testCalcDiscountFifty() {
        System.out.println("Tests CalcDiscount: 50") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_1000 oneThous = new Discount_1000();
        C.discounts.add(oneThous);

        Service pricey = new Service(1, "pricey", 1100);
        Participation p1 = new Participation(C, pricey);

        C.participations.add(p1);



        assertTrue(oneThous.calcDiscount(C) == 50); ; //Will be 50 because there is exactly 1000.
    }



    @Test
    public void testDesc() {
        System.out.println("Tests Description") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_1000 oneThous = new Discount_1000();
        String test = "50 eur. discount for each 1000 euro participation-value.";

        assertTrue(oneThous.description().equals(test)); ; //Just to get 100%
    }

}
