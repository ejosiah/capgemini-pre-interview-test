package com.josiahebhomenye.thirdparty.capgemini.domain;

import static java.util.stream.Collectors.*;

import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public class ShoppingCartImpl implements ShoppingCart {

	@Override
	public String totalCostOf(List<LineItem> items) {
		Money total = evaluateTotal(items);
		String description = getDescription(items);
		return String.format("[ %s ] => %s", description, total);
	}

	protected Money evaluateTotal(List<LineItem> items){
		List<Money> costs = items.stream().map(LineItem::getCost).collect(toList());
		Money tally = costs.get(0).zero();
		return tally.total(costs);
	}

	public String getDescription(List<LineItem> items){
		return items.stream().map(LineItem::getName).collect(joining(", "));
	}
}
