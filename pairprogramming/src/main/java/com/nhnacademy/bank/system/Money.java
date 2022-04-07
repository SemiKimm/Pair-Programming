package com.nhnacademy.bank.system;

import java.util.Objects;

public class Money {
    long amount;
    String currency;
    public Money(long amount, String dollar) throws NegativeException {
        if(amount < 0){
            throw new NegativeException("Number is negative");
        }
        this.amount = amount;
    }

    public long getAmount() {
        return this.amount;
    }

    public Money add(Money money) throws NegativeException {
        return new Money(this.amount+money.getAmount(), "dollar");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.getAmount());
    }
}
