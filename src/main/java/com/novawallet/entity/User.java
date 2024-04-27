package com.novawallet.entity;

import java.util.ArrayList;
import static com.novawallet.app.Utils.capitalize;

/**
 * The type User.
 */
public class User {
    private final int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private Balance balance = new CLPBalance(0);
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private ArrayList<Contact> contacts = new ArrayList<>();


    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param name     the name
     * @param lastname the lastname
     * @param email    the email
     * @param password the password
     */
    public User(int id, String name, String lastname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param name     the name
     * @param lastname the lastname
     * @param email    the email
     * @param password the password
     * @param balance  the balance
     */
    public User(int id, String name, String lastname, String email, String password, double balance) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.balance = new CLPBalance(balance);
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets lastname.
     *
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * Sets lastname.
     *
     * @param lastname the lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * Gets full name.
     *
     * @return the full name
     */
    public String getFullName() {
        return STR."\{capitalize(name)} \{capitalize(lastname)}";
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets balance currency.
     *
     * @return the balance currency
     */
    public String getBalanceCurrency() {
        return balance.getSymbol();
    }

    /**
     * Gets balance amount.
     *
     * @return the balance amount
     */
    public double getBalanceAmount() {
        return balance.getAmount();
    }

    /**
     * Gets balance object.
     *
     * @return the balance object
     */
    public Balance getBalanceObject() { return balance; }

    /**
     * Add balance.
     *
     * @param amount the amount
     */
    public void addBalance(double amount) {
        this.balance = new CLPBalance(this.balance.getAmount() + amount);
    }

    /**
     * Withdraw money.
     *
     * @param amount the amount
     */
    public void withdrawMoney(double amount) {
        this.balance = new CLPBalance(this.balance.getAmount() - amount);
    }

    /**
     * Gets transactions.
     *
     * @return the transactions
     */
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Sets transactions.
     *
     * @param transactions the transactions
     */
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Add transaction.
     *
     * @param transaction the transaction
     */
    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    /**
     * Gets contacts.
     *
     * @return the contacts
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    /**
     * Sets contacts.
     *
     * @param contacts the contacts
     */
    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Add contact.
     *
     * @param contact the contact
     */
    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
