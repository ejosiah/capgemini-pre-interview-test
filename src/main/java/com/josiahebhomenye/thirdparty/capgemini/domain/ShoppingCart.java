package com.josiahebhomenye.thirdparty.capgemini.domain;

import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public interface ShoppingCart {

	String totalCostOf(List<LineItem> items);
}
