package com.nhnacademy.bank.system;

import java.math.BigDecimal;

public class Bank {
    public Money exchange(Money thousandWon) throws NegativeException {
        BigDecimal exchangeAmt = thousandWon.getAmount().divide(BigDecimal.valueOf(1_000));
        return new Money(exchangeAmt,"dollar");
    }
}
