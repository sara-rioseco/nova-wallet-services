package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CLPBalanceTest {

    CLPBalance clpBalance;
    @BeforeEach
    public void setup() {
        clpBalance = new CLPBalance(100000);
    }

    @Test
    void testConvertToUSD() {
        double converted = clpBalance.convertToUSD();
        assertEquals(106.0, converted);
    }

    @Test
    void testConvertToEUR() {
        double converted = clpBalance.convertToEUR();
        assertEquals(98.0, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = clpBalance.getSymbol();
        assertEquals("CLP", symbol);
    }

    @Test
    void testGetConversionRateInUSD() {
        double conversionRateInUSD = clpBalance.getConversionRateInUSD();
        assertEquals(0.00106, conversionRateInUSD);
    }

    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = clpBalance.getConversionRateInEUR();
        assertEquals(0.00098, conversionRateInEUR);
    }

    @Test
    void testSetConversionRateInUSD() {
        clpBalance.setConversionRateInUSD(0.00108);
        assertEquals(0.00108, clpBalance.getConversionRateInUSD());
    }

    @Test
    void testSetConversionRateInEUR() {
        clpBalance.setConversionRateInEUR(0.00099);
        assertEquals(0.00099, clpBalance.getConversionRateInEUR());
    }

    @Test
    void testGetAmount() {
        double amount = clpBalance.getAmount();
        assertEquals(100000.0, amount);
    }
}