package com.nhnacademy.bank.system;

import java.math.BigDecimal;

public class Bank {
    public static Money exchange(Money money) throws NegativeException {
        if (money.getCurrency().equals("dollar")) {
            BigDecimal exchangeAmt = money.getAmount().multiply(BigDecimal.valueOf(1_000)).setScale(0);
            if(exchangeAmt.remainder(BigDecimal.valueOf(10)).compareTo(BigDecimal.valueOf(5))==0){
                exchangeAmt = exchangeAmt.add(BigDecimal.valueOf(5));
            }
            return new Money(exchangeAmt, "won");
        } else {
            BigDecimal exchangeAmt = money.getAmount().divide(BigDecimal.valueOf(1_000));
            return new Money(exchangeAmt, "dollar");
        }
    }
}

