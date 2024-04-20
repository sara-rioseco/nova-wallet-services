package com.novawallet.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class UserTest {

    User user;

    @BeforeEach
        public void setup() {
            user = new User(1, "John", "Doe", "john.doe@example.com", "password");
    }

    @Test
    public void testGetId() {
        int id = user.getId();
        assertEquals(1, id);
    }

    @Test
    public void testGetName() {
        String name = user.getName();
        assertEquals("John", name);
    }

    @Test
    public void testSetName() {
        user.setName("Jane");
        assertEquals("Jane", user.getName());
    }

    @Test
    public void testAddBalance() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.addBalance(50.0);
        assertEquals(150.0, user.getBalanceAmount(), 0.0);
    }

    @Test
    public void testWithdrawMoney() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password", 100.0);
        user.withdrawMoney(50.0);
        assertEquals(50.0, user.getBalanceAmount(), 0.0);
    }

    @Test
    public void testAddTransaction() {
        Transaction transaction = mock(Transaction.class);
        user.addTransaction(transaction);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().getFirst());
    }

    @Test
    public void testAddContact() {
        Contact contact = mock(Contact.class);
        user.addContact(contact);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().getFirst());
    }

    @Test
    public void testGetFullName() {
        String fullName = user.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void testGetLastname(){
        String lastname = user.getLastname();
        assertEquals("Doe", lastname);
    }

    @Test
    public void testSetLastname() {
        user.setLastname("Smith");
        assertEquals("Smith", user.getLastname());
    }

    @Test
    public void testGetEmail(){
        String email= user.getEmail();
        assertEquals("john.doe@example.com", email);
    }

    @Test
    public void testSetEmail() {
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    public void testGetPassword(){
        String password = user.getPassword();
        assertEquals("password", password);
    }

    @Test
    public void testSetPassword() {
        user.setPassword("SuperSecurePassword");
        assertEquals("SuperSecurePassword", user.getPassword());
    }

    @Test
    public void testGetRole(){
        String role = user.getRole();
        assertEquals("user", role);
    }

    @Test
    public void testSetRole() {
        user.setRole("admin");
        assertEquals("admin", user.getRole());
    }

    @Test
    public void testGetBalanceCurrency(){
        String currency = user.getBalanceCurrency();
        assertEquals("CLP", currency);
    }

    @Test
    public void testGetBalanceObject(){
        Currency balance = user.getBalanceObject();
        assertEquals(0.0, balance.getAmount());
        assertEquals("CLP", balance.getSymbol());
    }

    @Test
    public void testSetTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = mock(Transaction.class);
        transactions.add(transaction);
        user.setTransactions(transactions);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().getFirst());
    }

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