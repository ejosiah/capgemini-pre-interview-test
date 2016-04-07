package com.josiahebhomenye.thirdparty.capgemini.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static com.josiahebhomenye.thirdparty.capgemini.domain.LineItemTestData.*;
/**
 * Created by Josiah on 4/7/2016.
 */
public class BuyOneGetOneFreeTest {

	public BuyOneGetOneFree buyOneGetOneFree;

	@Before
	public void setup(){
		buyOneGetOneFree = new BuyOneGetOneFree(APPLE);
	}

	@Test
	public  void testBuyOneGetOneFree(){
		List<LineItem> items = new ArrayList<>(ITEMS_ONE_APPLE);
		List<LineItem> itemsAfterOfferApplied = buyOneGetOneFree.apply(items);
		assertEquals(2, itemsAfterOfferApplied.size());

		assertEquals(LINE_ITEM_APPLE, itemsAfterOfferApplied.get(0));
		assertEquals(FREE_APPLE, itemsAfterOfferApplied.get(1));
	}

	@Test
	public void testBuyOneGetOneFreeFor2Apples(){
		List<LineItem> items = new ArrayList<>(ITEMS_TWO_APPLES);
		List<LineItem> itemsAfterOfferApplied = buyOneGetOneFree.apply(items);
		assertEquals(4, itemsAfterOfferApplied.size());

		assertEquals(LINE_ITEM_APPLE, itemsAfterOfferApplied.get(0));
		assertEquals(LINE_ITEM_APPLE, itemsAfterOfferApplied.get(1));
		assertEquals(FREE_APPLE, itemsAfterOfferApplied.get(2));
		assertEquals(FREE_APPLE, itemsAfterOfferApplied.get(3));
	}

	@Test
	public void testOfferDoesNotApply(){
		List<LineItem> items = new ArrayList<>(ITEMS_TWO_ORANGES);
		List<LineItem> itemsAfterOfferApplied = buyOneGetOneFree.apply(items);
		assertEquals(2, itemsAfterOfferApplied.size());

		assertTrue(itemsAfterOfferApplied.stream().noneMatch((it) -> it.equals(FREE_APPLE)));

	}
}
