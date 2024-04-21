package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EURBalanceTest {

    EURBalance eurBalance;
    @BeforeEach
    public void setup() {
        eurBalance = new EURBalance(100);
    }

    @Test
    void testConvertToUSD() {
        double converted = eurBalance.convertToUSD();
        assertEquals(108.0, converted);
    }

    @Test
    void testConvertToCLP() {
        double converted = eurBalance.convertToCLP();
        assertEquals(102100.0, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = eurBalance.getSymbol();
        assertEquals("EUR", symbol);
    }

    @Test
    void testGetAmount() {
        double amount = eurBalance.getAmount();
        assertEquals(100, amount);
    }

    @Test
    void testGetConversionRateInCLP() {
        double conversionRateInCLP = eurBalance.getConversionRateInCLP();
        assertEquals(1021, conversionRateInCLP);
    }

    @Test
    void testGetConversionRateInUSD() {
        double conversionRateInUSD = eurBalance.getConversionRateInUSD();
        assertEquals(1.08, conversionRateInUSD);
    }

    @Test
    void testSetConversionRateInCLP() {
        eurBalance.setConversionRateInCLP(1030);
        assertEquals(1030, eurBalance.getConversionRateInCLP());
    }

    @Test
    void testSetConversionRateInUSD() {
        eurBalance.setConversionRateInUSD(1.1);
        assertEquals(1.1, eurBalance.getConversionRateInUSD());
    }
}