package com.josiahebhomenye.thirdparty.capgemini.domain;

import static java.util.stream.Collectors.*;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

/**
 * Created by Josiah on 4/7/2016.
 */
@RequiredArgsConstructor
public class BuyOneGetOneFree implements Offer {
	private final Product product;


	@Override
	public List<LineItem> apply(List<LineItem> items) {
		long count = items.stream().map(LineItem::getProduct).filter((it) -> it.equals(product)).count();

		if(count > 0){
			Money zeroCost = items.get(0).getCost().zero();
			LineItem freeItem = new LineItem(product, zeroCost );
			LongStream.range(0, count).forEach((i) -> items.add(freeItem));
		}

		return items;
	}
}
