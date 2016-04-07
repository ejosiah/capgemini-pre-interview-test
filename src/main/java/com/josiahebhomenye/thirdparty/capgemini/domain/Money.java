package com.josiahebhomenye.thirdparty.capgemini.domain;

import lombok.Value;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by Josiah on 4/7/2016.
 */
@Value
public class Money implements Valuable<BigDecimal> {

	private final BigDecimal value;
	private final Currency currency;

	public Money(String value, Currency currency){
		this(new BigDecimal(value), currency);
	}

	public Money(BigDecimal value, Currency currency){
		this.value = value;
		this.currency = currency;
	}

	public Money add(Money money){
		checkCurrenciesMatch(money);
		return new Money(value.add(money.value), currency);
	}

	public void checkCurrenciesMatch(Money money){
		if(this.currency != money.currency){
			throw new CurrencyMisMatchException(this.currency, money.currency);
		}
	}

	public Money total(Collection<Money> moneys){
		return moneys.stream().reduce(this, Money::add);
	}

	public Money zero(){
		return new Money(BigDecimal.ZERO, currency);
	}

	@Override
	public String toString(){
		return currency.toString() + value.toString();
	}

	public static class CurrencyMisMatchException extends RuntimeException{

		public CurrencyMisMatchException(Currency a, Currency b){
			super(String.format("Currencies %s & %s don't match", a, b));
		}
	}
}
