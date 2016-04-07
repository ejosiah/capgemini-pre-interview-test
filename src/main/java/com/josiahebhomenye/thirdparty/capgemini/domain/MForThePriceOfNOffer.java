package com.josiahebhomenye.thirdparty.capgemini.domain;

import lombok.RequiredArgsConstructor;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by Josiah on 4/7/2016.
 */
@RequiredArgsConstructor
public class MForThePriceOfNOffer implements Offer {

	private final int offer;
	private final int threshold;

	@Override
	public List<LineItem> apply(List<LineItem> items) {
		Map<Product, List<LineItem>> itemsByProduct = items.stream().collect(groupingBy(LineItem::getProduct));
		List<LineItem> newItems = new ArrayList<>();

		itemsByProduct.forEach( (product, list) -> {
			int size = list.size();
			int applications = size/threshold;

			if (applications > 0) {
				LineItem oldItem = list.get(0);
				Money newCost = oldItem.getCost().multiplyBy(threshold).divideBy(offer);
				LineItem newItem = oldItem.newCost(newCost);
				int leftOvers = size%threshold;

				IntStream.range(0, leftOvers).forEach((i) -> newItems.add(oldItem) );

				IntStream.range(0, applications).forEach((i) -> {
					IntStream.range(i, threshold + i).forEach((j) -> {
						newItems.add(newItem);
					});
					newItems.add(newItem);
				});
			}else{
				newItems.addAll(list);
			}
		});

		return newItems;
	}
}
