package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the type Usd balance.
 */
class USDBalanceTest {

    /**
     * The Usd balance.
     */
    USDBalance usdBalance;

    /**
     * Sets .
     */
    @BeforeEach
    public void setup() {
        usdBalance = new USDBalance(100);
    }

    /**
     * Test convert to clp.
     */
    @Test
    void testConvertToCLP() {
        double converted = usdBalance.convertToCLP();
        assertEquals(94500.0, converted);
    }

    /**
     * Test convert to eur.
     */
    @Test
    void testConvertToEUR() {
        double converted = usdBalance.convertToEUR();
        assertEquals(92.56, converted, 0.1);
    }

    /**
     * Test get symbol.
     */
    @Test
    void testGetSymbol() {
        String symbol = usdBalance.getSymbol();
        assertEquals("USD", symbol);
    }

    /**
     * Test get amount.
     */
    @Test
    void testGetAmount() {
        double amount = usdBalance.getAmount();
        assertEquals(100, amount);
    }

    /**
     * Test get conversion rate in clp.
     */
    @Test
    void testGetConversionRateInCLP() {
        double conversionRateInCLP = usdBalance.getConversionRateInCLP();
        assertEquals(945, conversionRateInCLP);
    }

    /**
     * Test get conversion rate in eur.
     */
    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = usdBalance.getConversionRateInEUR();
        assertEquals(0.9256, conversionRateInEUR);
    }

    /**
     * Test set conversion rate in clp.
     */
    @Test
    void testSetConversionRateInCLP() {
        usdBalance.setConversionRateInCLP(950);
        assertEquals(950, usdBalance.getConversionRateInCLP());
    }

    /**
     * Test set conversion rate in eur.
     */
    @Test
    void testSetConversionRateInEUR() {
        usdBalance.setConversionRateInEUR(0.93);
        assertEquals(0.93, usdBalance.getConversionRateInEUR());
    }
}