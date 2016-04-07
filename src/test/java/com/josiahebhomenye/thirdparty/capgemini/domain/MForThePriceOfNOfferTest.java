package com.josiahebhomenye.thirdparty.capgemini.domain;

import static org.junit.Assert.*;
import static com.josiahebhomenye.thirdparty.capgemini.domain.LineItemTestData.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public class MForThePriceOfNOfferTest {

	public static final int OFFER = 3;
	public static final int ANOTHER_OFFER = 4;
	public static final int THRESHOLD = 2;

	public static final Money INITIAL_COST = new Money("0.60", Currency.GBP);
	public static final Money NEW_COST = new Money("0.40", Currency.GBP);
	public static final Money NEW_COST_2 = new Money("0.30", Currency.GBP);

	private MForThePriceOfNOffer offer;

	@Before
	public void setup(){
		offer = new MForThePriceOfNOffer(OFFER, THRESHOLD);
	}

	@Test
	public void testWhenOfferApplies(){
		List<LineItem> items = new ArrayList<>(ITEMS_THREE_APPLE_ONE_ORANGE);
		assertEquals(4, items.size());
		assertEquals(INITIAL_COST, items.get(0).getCost());

		List<LineItem> itemsAfterOfferApplied = offer.apply(items);
		assertEquals(5, itemsAfterOfferApplied.size());

		LineItem expectedNewItem = LINE_ITEM_APPLE.newCost(NEW_COST);
		assertEquals(3, itemsAfterOfferApplied.stream().filter( (it) -> it.equals(expectedNewItem)).count());
	}

	@Test
	public void testWhenAnotherOfferApplies(){
		offer = new MForThePriceOfNOffer(ANOTHER_OFFER, THRESHOLD);

		List<LineItem> items = new ArrayList<>(ITEMS_TWO_APPLES);
		assertEquals(2, items.size());
		assertEquals(INITIAL_COST, items.get(0).getCost());

		List<LineItem> itemsAfterOfferApplied = offer.apply(items);
		assertEquals(4, itemsAfterOfferApplied.size());

		LineItem expectedNewItem = LINE_ITEM_APPLE.newCost(NEW_COST_2);
		assertEquals(4, itemsAfterOfferApplied.stream().filter( (it) -> it.equals(expectedNewItem)).count());
	}

	@Test
	public void testOfferNotAppliedWhenNoMatches(){
		List<LineItem> items = new ArrayList<>(ITEMS_ONE_APPLE_ONE_ORANGE);
		assertEquals(2, items.size());

		List<LineItem> itemsAfterOfferApplied = offer.apply(items);
		assertEquals(2, itemsAfterOfferApplied.size());

		assertEquals(items, itemsAfterOfferApplied);
	}
}
