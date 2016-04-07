package com.josiahebhomenye.thirdparty.capgemini.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public class LineItemTestData {

	public static final Product APPLE = new Product("Apple");
	public static final Product ORANGE = new Product("Orange");

	public static final LineItem LINE_ITEM_APPLE = new LineItem(APPLE, new Money("0.60", Currency.GBP));
	public static final LineItem LINE_ITEM_ORANGE = new LineItem(ORANGE, new Money("0.25", Currency.GBP));

	public static final LineItem FREE_APPLE = new LineItem(APPLE, new Money("0.00", Currency.GBP));
	public static final LineItem FREE_ORANGE = new LineItem(ORANGE, new Money("0.00", Currency.GBP));

	public static final List<LineItem> ITEMS_THREE_APPLE_ONE_ORANGE = new ArrayList<>();
	public static final List<LineItem> ITEMS_ONE_APPLE = new ArrayList<>();
	public static final List<LineItem> ITEMS_TWO_APPLES = new ArrayList<>();
	public static final List<LineItem> ITEMS_TWO_ORANGES = new ArrayList<>();
	public static final List<LineItem> ITEMS_ONE_APPLE_ONE_ORANGE = new ArrayList<>();

	static{
		ITEMS_THREE_APPLE_ONE_ORANGE.add(LINE_ITEM_APPLE);
		ITEMS_THREE_APPLE_ONE_ORANGE.add(LINE_ITEM_APPLE);
		ITEMS_THREE_APPLE_ONE_ORANGE.add(LINE_ITEM_ORANGE);
		ITEMS_THREE_APPLE_ONE_ORANGE.add(LINE_ITEM_APPLE);

		ITEMS_ONE_APPLE.add(LINE_ITEM_APPLE);
		ITEMS_TWO_APPLES.add(LINE_ITEM_APPLE);
		ITEMS_TWO_APPLES.add(LINE_ITEM_APPLE);
		ITEMS_TWO_ORANGES.add(LINE_ITEM_ORANGE);
		ITEMS_TWO_ORANGES.add(LINE_ITEM_ORANGE);

		ITEMS_ONE_APPLE_ONE_ORANGE.add(LINE_ITEM_ORANGE);
		ITEMS_ONE_APPLE_ONE_ORANGE.add(LINE_ITEM_APPLE);
	}
}
