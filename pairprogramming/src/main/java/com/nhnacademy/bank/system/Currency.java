package com.nhnacademy.bank.system;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Currency {
    String value;
    BigDecimal rate;

    public Currency(String value, BigDecimal rate) {
        this.value = value;
        this.rate = rate;
    }

    public Money wonToForeignCurrency(BigDecimal amount, Currency currency) throws NegativeException {
        BigDecimal exchangeAmt = amount.divide(currency.rate);
        exchangeAmt = exchangeAmt.setScale(2, RoundingMode.HALF_UP);
        BigDecimal a = exchangeAmt.setScale(0, RoundingMode.FLOOR);
        if (exchangeAmt.compareTo(a) == 0) {
            exchangeAmt = exchangeAmt.setScale(0);
        }
        return new Money(exchangeAmt, currency);
    }

    public Money foreignCurrencyToWon() {
        return null;
    }
}
