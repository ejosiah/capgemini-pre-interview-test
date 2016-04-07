package com.josiahebhomenye.thirdparty.capgemini.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import static com.josiahebhomenye.thirdparty.capgemini.domain.LineItemTestData.*;

/**
 * Created by Josiah on 4/7/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartTest {

	private ShoppingCart shoppingCart;

	@Mock private Offers offers;

	@Before
	public void setup(){
		shoppingCart = new ShoppingCartImpl(offers);
	}

	@Test
	public void testTotalCost(){
		List<LineItem> items = new ArrayList<>(ITEMS_THREE_APPLE_ONE_ORANGE);
		String expected = String.format("[ Apple, Apple, Orange, Apple ] => %s2.05", Currency.GBP);
		when(offers.apply(items)).thenReturn(items);

		String actual = shoppingCart.totalCostOf(items);

		assertEquals(expected, actual);
	}
}
