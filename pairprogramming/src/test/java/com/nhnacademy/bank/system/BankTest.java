package com.nhnacademy.bank.system;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BankTest {
    //SUT
    Bank bank;
    //DOC
    //Money money;
    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

//    @DisplayName("은행을 통해서 환전할 수 있다.")
//    @Test
//    void exchange(){
//        bank.exchange();
//    }

    @DisplayName("1,000원 -환전-> 1$")
    @Test
    void exchange_thousandWonToOneDollar() throws NegativeException {
        Money thousandWon = new Money(BigDecimal.valueOf(1_000L),"won");
        Money oneDollar = new Money(BigDecimal.valueOf(1),"dollar");

        Money result = bank.exchange(thousandWon);
        assertThat(result.equals(oneDollar)).isTrue();
    }

    @DisplayName("5.25$ -> 5,250원")
    @Test
    void exchange_decimalPointDollarToWon() throws NegativeException {
        Money amountWon = new Money(BigDecimal.valueOf(5_250L),"won");
        Money amountDollar = new Money(BigDecimal.valueOf(5.25),"dollar");

        Money result = bank.exchange(amountDollar);
        assertThat(result.equals(amountWon)).isTrue();


    }

    @Test
    void exchange_decimalPointDollarToWon_1() throws NegativeException {
        Money amountWon = new Money(BigDecimal.valueOf(5_250L), "won");
        Money amountDollar = new Money(BigDecimal.valueOf(5.25), "dollar");

        Money result = bank.exchange(amountDollar);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(5_250L));
    }

    @AfterEach
    void tearDown() {
    }
}