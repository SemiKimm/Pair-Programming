package com.nhnacademy.bank.system;

public class DifferentCurrencyException extends Exception{
    public DifferentCurrencyException(String message) {
        super(message);
    }
}
