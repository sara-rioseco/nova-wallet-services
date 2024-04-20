package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChileanPesoTest {

    ChileanPeso chileanPeso;
    @BeforeEach
    public void setup() {
        chileanPeso = new ChileanPeso(100000);
    }

    @Test
    void testConvertToUSD() {
        double converted = chileanPeso.convertToUSD();
        assertEquals(106.0, converted);
    }

    @Test
    void testConvertToEUR() {
        double converted = chileanPeso.convertToEUR();
        assertEquals(98.0, converted);
    }

    @Test
    void testGetSymbol() {
        String symbol = chileanPeso.getSymbol();
        assertEquals("CLP", symbol);
    }

    @Test
    void testGetConversionRateInUSD() {
        double conversionRateInUSD = chileanPeso.getConversionRateInUSD();
        assertEquals(0.00106, conversionRateInUSD);
    }

    @Test
    void testGetConversionRateInEUR() {
        double conversionRateInEUR = chileanPeso.getConversionRateInEUR();
        assertEquals(0.00098, conversionRateInEUR);
    }

    @Test
    void testSetSymbol() {
        chileanPeso.setSymbol("CLP $");
        assertEquals("CLP $", chileanPeso.getSymbol());
    }

    @Test
    void testSetConversionRateInUSD() {
        chileanPeso.setConversionRateInUSD(0.00108);
        assertEquals(0.00108, chileanPeso.getConversionRateInUSD());
    }

    @Test
    void testSetConversionRateInEUR() {
        chileanPeso.setConversionRateInEUR(0.00099);
        assertEquals(0.00099, chileanPeso.getConversionRateInEUR());
    }

    @Test
    void testGetAmount() {
        double amount = chileanPeso.getAmount();
        assertEquals(100000.0, amount);
    }
}