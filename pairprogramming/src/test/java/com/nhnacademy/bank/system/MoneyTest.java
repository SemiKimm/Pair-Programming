package com.nhnacademy.bank.system;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void add() throws NegativeException {
        Money money1 = new Money(1_000, "dollar");
        Money money2 = new Money(1_000, "dollar");

        Money result = money1.add(money2);

        assertThat(result.getAmount())
            .isEqualTo(2_000);
    }

    @DisplayName("2,000원과 2,000원은 같다.(equals)")
    @Test
    void equals() throws NegativeException {
        Money money1 = new Money(2_000, "dollar");
        Money money2 = new Money(2_000, "dollar");

        assertThat(money1.equals(money2)).isTrue();
    }

    @DisplayName("돈은 음수일 수 없다.")
    @Test
    void moneyIsNegative(){
        assertThatThrownBy(() -> new Money(-1L, "dollar"))
            .isInstanceOf(NegativeException.class)
            .hasMessageContainingAll("Number is negative");
    }

    @DisplayName("5$ + 5$ = 10$")
    @Test
    void add_fiveDollarPlusFiveDollar() throws NegativeException {
        Money money1 = new Money(5,"dollar");
        Money money2 = new Money(5,"dollar");
        Money result = money1.add(money2);
        assertThat(result.amount).isEqualTo(10);
    }

    @Test
    void add_fiveDollarPlusFiveWon_throwsException() throws NegativeException {
        Money money1 = new Money(5, "dollar");
        Money money2 = new Money(5, "won");
        assertThatThrownBy(()->money1.add(money2))
            .isInstanceOf(DifferentCurrency.class)
            .hasMessageContainingAll("different currency");
    }


    @AfterEach
    void tearDown() {
    }
}