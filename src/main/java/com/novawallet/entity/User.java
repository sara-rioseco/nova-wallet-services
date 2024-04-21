package com.novawallet.entity;

import java.util.ArrayList;

import static com.novawallet.app.Utils.capitalize;

public class User {
    private final int id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String role = "user";
    private Balance balance = new CLPBalance(0);
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private ArrayList<Contact> contacts = new ArrayList<>();


    public User(int id, String name, String lastname, String email, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String lastname, String email, String password, double balance) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.balance = new CLPBalance(balance);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBalanceCurrency() {
        return balance.getSymbol();
    }

    public double getBalanceAmount() {
        return balance.getAmount();
    }

    public Balance getBalanceObject() { return balance; }

    public void addBalance(double amount) {
        this.balance = new CLPBalance(this.balance.getAmount() + amount);
    }

    public void withdrawMoney(double amount) {
        this.balance = new CLPBalance(this.balance.getAmount() - amount);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public String getFullName() {
        return STR."\{capitalize(name)} \{capitalize(lastname)}";
    }

}
