package com.josiahebhomenye.thirdparty.capgemini.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.josiahebhomenye.thirdparty.capgemini.domain.ShoppingCartTestData.*;

/**
 * Created by Josiah on 4/7/2016.
 */
public class ShoppingCartTest {

	private ShoppingCart shoppingCart;

	@Before
	public void setup(){
		shoppingCart = new ShoppingCartImpl();
	}

	@Test
	public void testTotalCost(){
		List<LineItem> items = new ArrayList<>(ITEMS_A);
		String expected = String.format("[ Apple, Apple, Orange, Apple ] => %s2.05", Currency.GBP);
		String actual = shoppingCart.totalCostOf(items);
		assertEquals(expected, actual);
	}
}
