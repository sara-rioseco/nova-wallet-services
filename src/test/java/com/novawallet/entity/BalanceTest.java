package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BalanceTest {

    Balance balance;
    @BeforeEach
        public void setUp() { balance = spy(Balance.class);}

    @Test
    void testGetSymbol() {
        when(balance.getSymbol()).thenReturn("USD");
        String symbol = balance.getSymbol();
        assertEquals("USD", symbol);
    }

    @Test
    void testGetAmount() {
        when(balance.getAmount()).thenReturn(100.0F);
        double amount = balance.getAmount();
        assertEquals(100.0, amount);
    }

    @Test
    void testConvertToUSD() {
        balance.convertToUSD();
        verify(balance).convertToUSD();
        assertEquals(0.0, balance.convertToUSD());
    }

    @Test
    void testConvertToCLP() {
        balance.convertToCLP();
        verify(balance).convertToCLP();
        assertEquals(0.0, balance.convertToCLP());
    }

    @Test
    void testConvertToEUR() {
        balance.convertToEUR();
        verify(balance).convertToEUR();
        assertEquals(0.0, balance.convertToEUR());
    }
}