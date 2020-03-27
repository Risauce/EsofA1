package Participation;

import java.io.Serializable;
import java.util.*;

/**
 * This discount token gives 50 euro discount to every 1000 euro
 * participations.
 * 
 * <p>See also { Participation.Discount}.
 */
public class Discount_1000 extends Discount implements Serializable {

	static public final String DESC
		= 
		"50 eur. discount for each 1000 euro participation-value." ;
	
	public Discount_1000() { }	
	
	@Override
	public String description() { return DESC ; }
	
	/**
	 * {@inheritDoc} 
	 * This discount token in only applicable when the customer has at least
	 * 1000 euro participation value.
	 */
	@Override
	public boolean applicable(Customer c) {
		return c.participationValue() >= 1000 ;
	} //ERROR WAS HERE: Must be 1000

	/**
	 * {@inheritDoc}
	 * This token gives 50 euro discount to every 1000 euro participations.
	 * This should only run IF the customer c is applicable to this discount. Otherwise this is incorrect.
	 */
	@Override
	public int calcDiscount(Customer c) {
		if (applicable(c) ) { return 50 * (c.participationValue() / (1000 )) ; }
		return 0;
		 //ERROR WAS HERE: Must be 50 * ... and 1000. Not 1000 * 100
	}

}
