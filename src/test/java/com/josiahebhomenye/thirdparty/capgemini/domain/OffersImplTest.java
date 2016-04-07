package com.josiahebhomenye.thirdparty.capgemini.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by Josiah on 4/7/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class OffersImplTest {

	private OffersImpl offers;

	@Mock private Offer offer1;
	@Mock private Offer offer2;
	@Mock private Offer offer3;

	@Before
	public void setup(){
		offers = new OffersImpl();
		offers.add(offer1);
		offers.add(offer2);
		offers.add(offer3);
	}

	@Test
	public void testApplyOffers(){
		List<LineItem> items = Collections.emptyList();

		offers.apply(items);

		verify(offer1, times(1)).apply(items);
		verify(offer2, times(1)).apply(items);
		verify(offer3, times(1)).apply(items);
	}
}
