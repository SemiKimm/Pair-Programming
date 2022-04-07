package com.nhnacademy.bank.system;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bank {
    public static Money exchange(Money money) throws NegativeException {
//    public static Money exchange(Money money,Currency currency) throws NegativeException {
//        Money money;
//        Currency currency = money.getCurrency();
//        if(currency.value.equals("won")) {
//            money = currency.wonToForeignCurrency(money.getAmount(),currency);
//        }
//        money = currency.foreignCurrencyToWon();
//        return money;


        if (money.getCurrency().equals("dollar")) {
            BigDecimal exchangeAmt =
                money.getAmount().multiply(BigDecimal.valueOf(1_000)).setScale(0);
            if (exchangeAmt.remainder(BigDecimal.valueOf(10)).compareTo(BigDecimal.valueOf(5)) ==
                0 ||
                exchangeAmt.remainder(BigDecimal.valueOf(10)).compareTo(BigDecimal.valueOf(5)) ==
                    1) {
                BigDecimal a =
                    BigDecimal.valueOf(10).subtract(exchangeAmt.remainder(BigDecimal.valueOf(10)));
                exchangeAmt = exchangeAmt.add(a);
            }
            return new Money(exchangeAmt, "won");
        } else if (money.getCurrency().equals("won")) {
            BigDecimal exchangeAmt = money.getAmount().divide(BigDecimal.valueOf(1_000));
            exchangeAmt = exchangeAmt.setScale(2, RoundingMode.HALF_UP);
            BigDecimal a = exchangeAmt.setScale(0, RoundingMode.FLOOR);
            if (exchangeAmt.compareTo(a) == 0) {
                exchangeAmt = exchangeAmt.setScale(0);
            }
            return new Money(exchangeAmt, "dollar");
        } else if (money.getCurrency().equals("won")) {
            BigDecimal exchangeAmt = money.getAmount().divide(BigDecimal.valueOf(1_300));
            exchangeAmt = exchangeAmt.setScale(2, RoundingMode.HALF_UP);
            BigDecimal a = exchangeAmt.setScale(0, RoundingMode.FLOOR);
            if (exchangeAmt.compareTo(a) == 0) {
                exchangeAmt = exchangeAmt.setScale(0);
            }
            return new Money(exchangeAmt, "euro");

        } else {
            return null;
        }
    }
}

