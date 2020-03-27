package Participation;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** ALL DONE*/

public class Discount_5pack_test {

    @Test
    public void testApplicableNo() {
        System.out.println("Tests whether a Customer is applicable for _5pack discount: NO") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_5pack fivePack = new Discount_5pack();
        C.discounts.add(fivePack);

        assertFalse(fivePack.applicable(C)); ; //Because they currently have no services assigned.
    }

    @Test
    public void testApplicableYes() {
        System.out.println("Tests whether a Customer is applicable for _5pack discount: YES") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_5pack fivePack = new Discount_5pack();
        C.discounts.add(fivePack);

        //Have to make 5 different services and 5 different participations.
        Service s1 = new Service(1, "pricey", 1001);
        Service s2 = new Service(2, "2", 415);
        Service s3 = new Service(3, "3", 233);
        Service s4 = new Service(4, "4", 244);
        Service s5 = new Service(5, "5", 433);

        Participation p1 = new Participation(C, s1);
        Participation p2 = new Participation(C, s2);
        Participation p3 = new Participation(C, s3);
        Participation p4 = new Participation(C, s4);
        Participation p5 = new Participation(C, s5);

        C.participations.add(p1);
        C.participations.add(p2);
        C.participations.add(p3);
        C.participations.add(p4);
        C.participations.add(p5);


        assertTrue(fivePack.applicable(C)) ; //Should be yes, because they have at least 5 services
    }

    @Test
    public void testCalcDiscountZero() {
        System.out.println("Tests CalcDiscount: 0") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_5pack fivePack = new Discount_5pack();
        C.discounts.add(fivePack);


        assertTrue(fivePack.calcDiscount(C) == 0) ; //Should be 0, they don't have 5 services.
    }

    @Test
    public void testCalcDiscountTen() {
        System.out.println("Tests CalcDiscount: 10") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_5pack fivePack = new Discount_5pack();
        C.discounts.add(fivePack);

        //Have to make 5 different services and 5 different participations.
        Service s1 = new Service(1, "pricey", 1001);
        Service s2 = new Service(2, "2", 415);
        Service s3 = new Service(3, "3", 233);
        Service s4 = new Service(4, "4", 244);
        Service s5 = new Service(5, "5", 433);

        Participation p1 = new Participation(C, s1);
        Participation p2 = new Participation(C, s2);
        Participation p3 = new Participation(C, s3);
        Participation p4 = new Participation(C, s4);
        Participation p5 = new Participation(C, s5);

        C.participations.add(p1);
        C.participations.add(p2);
        C.participations.add(p3);
        C.participations.add(p4);
        C.participations.add(p5);


        assertTrue(fivePack.calcDiscount(C) == 10) ; //Should be yes, because they have at least 5 services
    }



    @Test
    public void testDesc() {
        System.out.println("Tests Description") ;
        Customer C = new Customer(0,"Duffy Duck","") ;

        Discount_5pack fivePack = new Discount_5pack();
        String test = "10 eur. discount if the customer participates in at least 5 services, "
                + "each with value at least 100 eur.";

        assertTrue(fivePack.description().equals(test)); ; //Just to get 100%
    }


}
