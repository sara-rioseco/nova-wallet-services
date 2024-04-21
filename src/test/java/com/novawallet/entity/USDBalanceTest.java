package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class USDBalanceTest {

    USDBalance usdBalance;
    @BeforeEach
    public void setup() {
        usdBalance = new USDBalance(100);
    }

    @Test
    void testConvertToCLP() {
        double converted = usdBalance.convertToCLP();
        assertEquals(94500.0, converted);
    }

    @Test
    void testConvertToEUR() {
        double converted = usdBalance.convertToEUR();
        assertEquals(92.56, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = usdBalance.getSymbol();
        assertEquals("USD", symbol);
    }

    @Test
    void testGetAmount() {
        double amount = usdBalance.getAmount();
        assertEquals(100, amount);
    }

    @Test
    void testGetConversionRateInCLP() {
        double conversionRateInCLP = usdBalance.getConversionRateInCLP();
        assertEquals(945, conversionRateInCLP);
    }

    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = usdBalance.getConversionRateInEUR();
        assertEquals(0.9256, conversionRateInEUR);
    }

    @Test
    void testSetConversionRateInCLP() {
        usdBalance.setConversionRateInCLP(950);
        assertEquals(950, usdBalance.getConversionRateInCLP());
    }

    @Test
    void testSetConversionRateInEUR() {
        usdBalance.setConversionRateInEUR(0.93);
        assertEquals(0.93, usdBalance.getConversionRateInEUR());
    }
}