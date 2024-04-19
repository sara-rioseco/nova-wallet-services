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
        assertEquals(transaction, user.getTransactions().getFirst());
    }

    @Test
    public void testAddContact() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        Contact contact = mock(Contact.class);
        user.addContact(contact);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().getFirst());
    }

    @Test
    public void testGetFullName() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String fullName = user.getFullName();
        assertEquals("John Doe", fullName);
    }

    @Test
    public void testGetLastname(){
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String lastname = user.getLastname();
        assertEquals("Doe", lastname);
    }

    @Test
    public void testSetLastname() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        user.setLastname("Smith");
        assertEquals("Smith", user.getLastname());
    }

    @Test
    public void testGetEmail(){
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String email= user.getEmail();
        assertEquals("john.doe@example.com", email);
    }

    @Test
    public void testSetEmail() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        user.setEmail("newemail@example.com");
        assertEquals("newemail@example.com", user.getEmail());
    }

    @Test
    public void testGetPassword(){
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String password = user.getPassword();
        assertEquals("password", password);
    }

    @Test
    public void testSetPassword() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        user.setPassword("SuperSecurePassword");
        assertEquals("SuperSecurePassword", user.getPassword());
    }

    @Test
    public void testGetRole(){
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String role = user.getRole();
        assertEquals("user", role);
    }

    @Test
    public void testSetRole() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        user.setRole("admin");
        assertEquals("admin", user.getRole());
    }

    @Test
    public void testGetCurrency(){
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        String currency = user.getCurrency();
        assertEquals("CLP", currency);
    }

    @Test
    public void testSetTransactions() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        ArrayList<Transaction> transactions = new ArrayList<>();
        Transaction transaction = mock(Transaction.class);
        transactions.add(transaction);
        user.setTransactions(transactions);
        assertEquals(1, user.getTransactions().size());
        assertEquals(transaction, user.getTransactions().getFirst());
    }

    @Test
    public void testSetContacts() {
        User user = new User(1, "John", "Doe", "john.doe@example.com", "password");
        ArrayList<Contact> contacts = new ArrayList<>();
        Contact contact = mock(Contact.class);
        contacts.add(contact);
        user.setContacts(contacts);
        assertEquals(1, user.getContacts().size());
        assertEquals(contact, user.getContacts().getFirst());
    }
}