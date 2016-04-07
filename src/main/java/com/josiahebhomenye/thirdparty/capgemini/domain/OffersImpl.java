package com.josiahebhomenye.thirdparty.capgemini.domain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Josiah on 4/7/2016.
 */
public class OffersImpl {
	private final List<Offer> offerChain = new LinkedList<>();

	public void add(Offer offer){
		offerChain.add(offer);
	}

	public List<LineItem> apply(List<LineItem> items){
		List<LineItem> result = new ArrayList<>(items);

		for(Offer offer : offerChain){
			result = offer.apply(result);
		}

		return result;
	}
}
