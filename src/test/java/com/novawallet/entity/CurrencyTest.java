package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CurrencyTest {

    Currency currency;
    @BeforeEach
        public void setUp() { currency = spy(Currency.class);}

    @Test
    void testGetSymbol() {
        when(currency.getSymbol()).thenReturn("USD");
        String symbol = currency.getSymbol();
        assertEquals("USD", symbol);
    }

    @Test
    void testGetAmount() {
        when(currency.getAmount()).thenReturn(100.0);
        double amount = currency.getAmount();
        assertEquals(100.0, amount);
    }

    @Test
    void testConvertToUSD() {
        currency.convertToUSD();
        verify(currency).convertToUSD();
        assertEquals(0.0, currency.convertToUSD());
    }

    @Test
    void testConvertToCLP() {
        currency.convertToCLP();
        verify(currency).convertToCLP();
        assertEquals(0.0, currency.convertToCLP());
    }

    @Test
    void testConvertToEUR() {
        currency.convertToEUR();
        verify(currency).convertToEUR();
        assertEquals(0.0, currency.convertToEUR());
    }
}