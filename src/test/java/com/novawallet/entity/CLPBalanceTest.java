package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test the type Clp balance.
 */
class CLPBalanceTest {

    /**
     * The Clp balance.
     */
    CLPBalance clpBalance;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setup() {
        clpBalance = new CLPBalance(100000);
    }

    /**
     * Test convert to usd.
     */
    @Test
    void testConvertToUSD() {
        double converted = clpBalance.convertToUSD();
        assertEquals(106.0, converted);
    }

    /**
     * Test convert to eur.
     */
    @Test
    void testConvertToEUR() {
        double converted = clpBalance.convertToEUR();
        assertEquals(98.0, converted);
    }

    /**
     * Test get symbol.
     */
    @Test
    void testGetSymbol() {
        String symbol = clpBalance.getSymbol();
        assertEquals("CLP", symbol);
    }

    /**
     * Test get conversion rate in usd.
     */
    @Test
    void testGetConversionRateInUSD() {
        double conversionRateInUSD = clpBalance.getConversionRateInUSD();
        assertEquals(0.00106, conversionRateInUSD);
    }

    /**
     * Test get conversion rate in eur.
     */
    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = clpBalance.getConversionRateInEUR();
        assertEquals(0.00098, conversionRateInEUR);
    }

    /**
     * Test set conversion rate in usd.
     */
    @Test
    void testSetConversionRateInUSD() {
        clpBalance.setConversionRateInUSD(0.00108);
        assertEquals(0.00108, clpBalance.getConversionRateInUSD());
    }

    /**
     * Test set conversion rate in eur.
     */
    @Test
    void testSetConversionRateInEUR() {
        clpBalance.setConversionRateInEUR(0.00099);
        assertEquals(0.00099, clpBalance.getConversionRateInEUR());
    }

    /**
     * Test get amount.
     */
    @Test
    void testGetAmount() {
        double amount = clpBalance.getAmount();
        assertEquals(100000.0, amount);
    }
}