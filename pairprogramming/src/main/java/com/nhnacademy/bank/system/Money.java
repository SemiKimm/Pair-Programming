package com.nhnacademy.bank.system;

public class Money {
    long amount;
    public Money(long amount) {
        this.amount = amount;
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


}
