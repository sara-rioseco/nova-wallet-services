package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuroTest {

    Euro euro;
    @BeforeEach
    public void setup() {
        euro = new Euro(100);
    }

    @Test
    void testConvertToUSD() {
        double converted = euro.convertToUSD();
        assertEquals(108.0, converted);
    }

    @Test
    void testConvertToCLP() {
        double converted = euro.convertToCLP();
        assertEquals(102100.0, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = euro.getSymbol();
        assertEquals("EUR", symbol);
    }

    @Test
    void testGetAmount() {
        double amount = euro.getAmount();
        assertEquals(100, amount);
    }

    @Test
    void testGetConversionRateInCLP() {
        double conversionRateInCLP = euro.getConversionRateInCLP();
        assertEquals(1021, conversionRateInCLP);
    }

    @Test
    void testGetConversionRateInUSD() {
        double conversionRateInUSD = euro.getConversionRateInUSD();
        assertEquals(1.08, conversionRateInUSD);
    }

    @Test
    void testSetConversionRateInCLP() {
        euro.setConversionRateInCLP(1030);
        assertEquals(1030, euro.getConversionRateInCLP());
    }

    @Test
    void testSetConversionRateInUSD() {
        euro.setConversionRateInUSD(1.1);
        assertEquals(1.1, euro.getConversionRateInUSD());
    }
}