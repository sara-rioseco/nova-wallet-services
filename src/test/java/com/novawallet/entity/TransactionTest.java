package com.novawallet.entity;

import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TransactionTest {

    @Test
    public void testGetId() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        int id = transaction.getId();
        assertEquals(1, id);
    }

    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        double amount = transaction.getAmount();
        assertEquals(100.0, amount, 0.0);
    }

    @Test
    public void testGetCurrency() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        String currency = transaction.getCurrency();
        assertEquals("CLP", currency);
    }

    @Test
    public void testGetSenderId() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        int senderId = transaction.getSenderId();
        assertEquals(1001, senderId);
    }

    @Test
    public void testGetReceiverId() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        int receiverId = transaction.getReceiverId();
        assertEquals(1002, receiverId);
    }

    @Test
    public void testGetDate() {
        LocalDateTime mockDateTime = LocalDateTime.of(2022, 1, 1, 12, 0);
        Transaction transaction = mock(Transaction.class);
        when(transaction.getDate()).thenReturn(mockDateTime);
        LocalDateTime date = transaction.getDate();
        assertEquals(mockDateTime, date);
    }

    @Test
    public void testGetDateAgain() {
        Transaction transaction = new Transaction(1, 100.0, 1001, 1002);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = transaction.getDate();
        assertEquals(now.toLocalDate(), dateTime.toLocalDate());
    }

}