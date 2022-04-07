package com.nhnacademy.bank.system;

import java.util.Objects;

public class Money {
    long amount;
    public Money(long amount) throws NegativeException {
        this.amount = amount;

        if(amount < 0){
            throw new NegativeException("Number is negative");
        }
    }

    public long getAmount() {
        return this.amount;
    }

    public Money add(Money money) {
        return new Money(this.amount+money.getAmount());
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
