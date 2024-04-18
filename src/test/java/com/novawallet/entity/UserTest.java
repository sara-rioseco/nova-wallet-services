package com.novawallet.entity;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class UserTest {

    @Test
    public void testGetId() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        int id = user.getId();
        assertEquals(1, id);
    }

    @Test
    public void testGetName() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String name = user.getName();
        assertEquals("John", name);
    }

    @Test
    public void testSetName() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    public void testAddBalance() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.addBalance(50.0);
        assertEquals(150.0, user.getBalance(), 0.0);
    }

    @Test
    public void testWithdrawMoney() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.withdrawMoney(50.0);
        assertEquals(50.0, user.getBalance(), 0.0);
    }

    @Test
    public void testAddTransaction() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        Transaction transaction = mock(Transaction.class);
        user.addTransaction(transaction);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().get(0));
    }

    @Test
    public void testAddContact() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        Contact contact = mock(Contact.class);
        user.addContact(contact);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().get(0));
    }

    @Test
    public void testGetFullName() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String fullName = user.getFullName();
        assertEquals("John Doe", fullName);
    }
}