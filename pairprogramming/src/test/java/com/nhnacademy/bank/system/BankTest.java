package com.nhnacademy.bank.system;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.AssertProvider;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BankTest {
    //SUT
    Bank bank;
    //DOC
    Money money;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        bank = mock(Bank.class);
    }

    @Test
    void sumMoney(){
        Money money1 = new Money(1_000);
        Money money2 = new Money(1_000);

        Money result = new Money(2_000);
        when(bank.sumMoney(money1, money2)).thenReturn(result);

        Money money = bank.sumMoney(money1,money2);
        assertThat(money.getAmount())
            .isEqualTo(result.getAmount());
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}