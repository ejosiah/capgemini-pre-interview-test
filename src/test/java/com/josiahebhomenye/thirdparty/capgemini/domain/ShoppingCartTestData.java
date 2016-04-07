package com.josiahebhomenye.thirdparty.capgemini.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public class ShoppingCartTestData {

	public static final Product APPLE = new Product("Apple");
	public static final Product ORANGE = new Product("Orange");

	public static final LineItem LINE_ITEM_APPLE = new LineItem(APPLE, new Money("0.60", Currency.GBP));
	public static final LineItem LINE_ITEM_ORANGE = new LineItem(ORANGE, new Money("0.25", Currency.GBP));

	public static final List<LineItem> ITEMS_A = new ArrayList<>();

	static{
		ITEMS_A.add(LINE_ITEM_APPLE);
		ITEMS_A.add(LINE_ITEM_APPLE);
		ITEMS_A.add(LINE_ITEM_ORANGE);
		ITEMS_A.add(LINE_ITEM_APPLE);
	}
}
