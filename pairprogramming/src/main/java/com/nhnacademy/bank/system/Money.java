package com.nhnacademy.bank.system;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
    BigDecimal amount;
    String currency;

    public Money(BigDecimal amount, String currency) throws NegativeException {
        BigDecimal zero = BigDecimal.valueOf(0);
        if (amount.compareTo(zero) == -1) {
            throw new NegativeException("Number is negative");
        }
        this.amount = amount;
        this.currency = currency;
    }

    public Money add(Money money) throws NegativeException, DifferentCurrencyException {
        if (!(this.currency.equals(money.getCurrency()))) {
            throw new DifferentCurrencyException("different currency");
        }
        return new Money(this.amount.add(money.getAmount()), "dollar");

    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        Money money = (Money) o;
        return Objects.equals(amount, money.getAmount());
    }

    public void sub(Money money2) throws ImpossibleSubtractException {
        if (this.amount.compareTo(money2.getAmount()) == -1) {
            throw new ImpossibleSubtractException("impossible subtract");
        }
        // TODO: sub 구현
    }
}
