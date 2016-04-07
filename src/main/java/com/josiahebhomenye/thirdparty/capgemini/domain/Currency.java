package com.josiahebhomenye.thirdparty.capgemini.domain;

import lombok.Value;

/**
 * Created by Josiah on 4/7/2016.
 */
public enum Currency {

	GBP("\u00A3"),
	USD("\u0024"),
	EUR("\u20ac");

	private Currency(String symbol){
		this.symbol = symbol;
	}

	private final String symbol;

	@Override
	public String toString(){
		return symbol;
	}
}
