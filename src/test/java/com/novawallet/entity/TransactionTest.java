package com.novawallet.entity;

import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.novawallet.entity.TransactionType.TRANSFER;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Test the type Transaction.
 */
class TransactionTest {

    /**
     * The Transaction.
     */
    Transaction transaction;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setUp() {
        transaction = new Transaction(1, 100.0, TRANSFER, 1001, 1002);
    }

    /**
     * Test get id.
     */
    @Test
    public void testGetId() {
        int id = transaction.getId();
        assertEquals(1, id);
    }

    /**
     * Test get amount.
     */
    @Test
    public void testGetAmount() {
        double amount = transaction.getAmount();
        assertEquals(100.0, amount, 0.0);
    }

    /**
     * Test get type.
     */
    @Test
    public void testGetType() {
        TransactionType type = transaction.getType();
        assertEquals(TRANSFER, type);
    }

    /**
     * Test get currency.
     */
    @Test
    public void testGetCurrency() {
        String currency = transaction.getCurrency();
        assertEquals("CLP", currency);
    }

    /**
     * Test get sender id.
     */
    @Test
    public void testGetSenderId() {
        int senderId = transaction.getSenderId();
        assertEquals(1001, senderId);
    }

    /**
     * Test get receiver id.
     */
    @Test
    public void testGetReceiverId() {
        int receiverId = transaction.getReceiverId();
        assertEquals(1002, receiverId);
    }

    /**
     * Test get date with mock.
     */
    @Test
    public void testGetDate() {
        LocalDateTime mockDateTime = LocalDateTime.of(2022, 1, 1, 12, 0);
        Transaction transaction = mock(Transaction.class);
        when(transaction.getDate()).thenReturn(mockDateTime);
        LocalDateTime date = transaction.getDate();
        assertEquals(mockDateTime, date);
    }

    /**
     * Test get date.
     */
    @Test
    public void testGetDateAgain() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dateTime = transaction.getDate();
        assertEquals(now.toLocalDate(), dateTime.toLocalDate());
    }

}