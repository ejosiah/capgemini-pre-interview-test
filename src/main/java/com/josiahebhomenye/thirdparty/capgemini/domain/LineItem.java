package com.josiahebhomenye.thirdparty.capgemini.domain;

import lombok.Value;
import lombok.experimental.Delegate;

import java.math.BigDecimal;

/**
 * Created by Josiah on 4/7/2016.
 */

@Value
public class LineItem {

	@Delegate
	private final Product product;

	private final Money cost;
}
