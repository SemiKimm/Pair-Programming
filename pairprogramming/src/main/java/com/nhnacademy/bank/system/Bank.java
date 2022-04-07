package com.nhnacademy.bank.system;

import java.math.BigDecimal;

public class Bank {


    public Money exchange(Money money) throws NegativeException {
        if (money.getCurrency().equals("dollar")) {
            BigDecimal exchangeAmt = money.getAmount().multiply(BigDecimal.valueOf(1_000)).setScale(0);
            return new Money(exchangeAmt, "won");

        } else {
            BigDecimal exchangeAmt = money.getAmount().divide(BigDecimal.valueOf(1_000));
            return new Money(exchangeAmt, "dollar");
        }

    }
}


