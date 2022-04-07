package com.nhnacademy.bank.system;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {
    @BeforeEach
    void setUp() {
    }

    @DisplayName("1,000원 + 1,000원 = 2,000원")
    @Test
    void add(){
        Money money1 = new Money(1_000);
        Money money2 = new Money(1_000);

        Money result = money1.add(money2);

        assertThat(result.getAmount())
            .isEqualTo(2_000);
    }

    @DisplayName("2,000원과 2,000원은 같다.(equals)")
    @Test
    void equals(){
        Money money1 = new Money(2_000);
        Money money2 = new Money(2_000);

        assertThat(money1.equals(money2)).isTrue();
    }

    @Test
    void moneyIsNegative(){
        Money money1 = new Money(-1L);
        assertThatThrownBy(() -> new Money(-1L))
            .isInstanceOf(NegativeException.class)
            .hasMessageContainingAll("Number is negative");

    }


    @AfterEach
    void tearDown() {
    }
}