package com.josiahebhomenye.thirdparty.capgemini.domain;

import static com.josiahebhomenye.thirdparty.capgemini.domain.Currency.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Josiah on 4/7/2016.
 */
public class MoneyTest {

	@Test
	public void testAdd(){
		Money expected = new Money("1.00", GBP);
		Money actual = new Money("0.45", GBP).add(new Money("0.55", GBP));
		assertEquals(expected, actual);
	}

	@Test
	public void testTotal(){
		Money expected = new Money("15.00", GBP);
		Money tally = new Money("0.00", GBP);
		Money actual = tally.total(Arrays.asList(new Money("3.00", GBP), new Money("2.50", GBP), new Money("2.50", GBP), new Money("7.00", GBP)));
		assertEquals(expected, actual);
	}

	@Test(expected = Money.CurrencyMisMatchException.class)
	public void testAddFailsOnCurrencyMissMatch(){
		new Money("0.45", USD).add(new Money("0.55", GBP));
	}

	@Test
	public void testMultiply(){
		Money expected = new Money("4.00", GBP);
		Money actual = new Money("1.00", GBP).multiplyBy(4);

		assertEquals(expected, actual);
	}

	@Test
	public void testDivideBy(){
		Money expected = new Money("1.00", GBP);
		Money actual = new Money("4.00", GBP).divideBy(4);

		assertEquals(expected, actual);
	}
}
