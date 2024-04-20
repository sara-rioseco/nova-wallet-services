package com.novawallet.entity;

import java.time.LocalDateTime;

public class Transaction {
    private final int id;
    private final Currency amount;
    private final int senderId;
    private final int receiverId;
    private final LocalDateTime date = LocalDateTime.now();

    public Transaction(int id, double amount, int senderId, int receiverId) {
        this.id = id;
        this.amount = new ChileanPeso(amount);
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount.getAmount();
    }

    public String getCurrency() {
        return amount.getSymbol();
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
