package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 * Test the type User.
 */
class UserTest {

    /**
     * The User.
     */
    User user;

    /**
     * Sets up.
     */
    @BeforeEach
    public void setup() {
            user = new User(1, "John", "Doe", "john.doe@example.com", "password");
    }

    /**
     * Test get id.
     */
    @Test
    public void testGetId() {
        int id = user.getId();
        assertEquals(1, id);
    }

    /**
     * Test get name.
     */
    @Test
    public void testGetName() {
        String name = user.getName();
        assertEquals("John", name);
    }

    /**
     * Test set name.
     */
    @Test
    public void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    /**
     * Test add balance.
     */
    @Test
    public void testAddBalance() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.addBalance(50.0);
        assertEquals(150.0, user.getBalanceAmount(), 0.0);
    }

    /**
     * Test withdraw money.
     */
    @Test
    public void testWithdrawMoney() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.withdrawMoney(50.0);
        assertEquals(50.0, user.getBalanceAmount(), 0.0);
    }

    /**
     * Test add transaction.
     */
    @Test
    public void testAddTransaction() {
        Transaction transaction = mock(Transaction.class);
        user.addTransaction(transaction);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().getFirst());
    }

    /**
     * Test add contact.
     */
    @Test
    public void testAddContact() {
        Contact contact = mock(Contact.class);
        user.addContact(contact);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().getFirst());
    }

    /**
     * Test get full name.
     */
    @Test
    public void testGetFullName() {
        String fullName = user.getFullName();
        assertEquals("John Doe", fullName);
    }

    /**
     * Test get lastname.
     */
    @Test
    public void testGetLastname(){
        String lastname = user.getLastname();
        assertEquals("Doe", lastname);
    }

    /**
     * Test set lastname.
     */
    @Test
    public void testSetLastname() {
        user.setLastname("Smith");
        assertEquals("Smith", user.getLastname());
    }

    /**
     * Test get email.
     */
    @Test
    public void testGetEmail(){
        String email= user.getEmail();
        assertEquals("john.doe@example.com", email);
    }

    /**
     * Test set email.
     */
    @Test
    public void testSetEmail() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    /**
     * Test get password.
     */
    @Test
    public void testGetPassword(){
        String password = user.getPassword();
        assertEquals("password", password);
    }

    /**
     * Test set password.
     */
    @Test
    public void testSetPassword() {
        user.setPassword("SuperSecurePassword");
        assertEquals("SuperSecurePassword", user.getPassword());
    }

    /**
     * Test get balance currency.
     */
    @Test
    public void testGetBalanceCurrency(){
        String currency = user.getBalanceCurrency();
        assertEquals("CLP", currency);
    }

    /**
     * Test get balance object.
     */
    @Test
    public void testGetBalanceObject(){
        Balance balance = user.getBalanceObject();
        assertEquals(0.0, balance.getAmount());
        assertEquals("CLP", balance.getSymbol());
    }

    /**
     * Test set transactions.
     */
    @Test
    public void testSetTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = mock(Transaction.class);
        transactions.add(transaction);
        user.setTransactions(transactions);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().getFirst());
    }

    /**
     * Test set contacts.
     */
    @Test
    public void testSetContacts() {
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = mock(Contact.class);
        contacts.add(contact);
        user.setContacts(contacts);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().getFirst());
    }
}