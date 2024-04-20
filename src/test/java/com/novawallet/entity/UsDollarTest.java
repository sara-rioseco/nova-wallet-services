package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsDollarTest {

    UsDollar dollar;
    @BeforeEach
    public void setup() {
        dollar = new UsDollar(100);
    }

    @Test
    void testConvertToCLP() {
        double converted = dollar.convertToCLP();
        assertEquals(94500.0, converted);
    }

    @Test
    void testConvertToEUR() {
        double converted = dollar.convertToEUR();
        assertEquals(92.56, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = dollar.getSymbol();
        assertEquals("USD", symbol);
    }

    @Test
    void testGetAmount() {
        double amount = dollar.getAmount();
        assertEquals(100, amount);
    }

    @Test
    void testGetConversionRateInCLP() {
        double conversionRateInCLP = dollar.getConversionRateInCLP();
        assertEquals(945, conversionRateInCLP);
    }

    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = dollar.getConversionRateInEUR();
        assertEquals(0.9256, conversionRateInEUR);
    }

    @Test
    void testSetConversionRateInCLP() {
        dollar.setConversionRateInCLP(950);
        assertEquals(950, dollar.getConversionRateInCLP());
    }

    @Test
    void testSetConversionRateInEUR() {
        dollar.setConversionRateInEUR(0.93);
        assertEquals(0.93, dollar.getConversionRateInEUR());
    }
}