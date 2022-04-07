package com.nhnacademy.bank.system;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankTest {
    //SUT
    Bank bank;
    //DOC
    Money money;
    @BeforeEach
    void setUp() {
        bank = mock(Bank.class);
    }

    @AfterEach
    void tearDown() {
    }
}