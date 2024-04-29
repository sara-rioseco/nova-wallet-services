package com.novawallet.entity;

import java.time.LocalDateTime;

/**
 * The type Transaction.
 */
public class Transaction {
    private final int id;
    private final Balance balance;
    private final TransactionType type;
    private final int senderId;
    private final int receiverId;
    private final LocalDateTime date = LocalDateTime.now();

    /**
     * Instantiates a new Transaction.
     *
     * @param id         the id
     * @param balance    the balance
     * @param type       the type
     * @param senderId   the sender id
     * @param receiverId the receiver id
     */
    public Transaction(int id, double balance, TransactionType type, int senderId, int receiverId) {
        this.id = id;
        this.balance = new CLPBalance(balance);
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
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
     * Gets amount.
     *
     * @return the amount
     */
    public float getAmount() {
        return balance.getAmount();
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public TransactionType getType() {
        return type;
    }

    /**
     * Gets currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return balance.getSymbol();
    }

    /**
     * Gets sender id.
     *
     * @return the sender id
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * Gets receiver id.
     *
     * @return the receiver id
     */
    public int getReceiverId() {
        return receiverId;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public LocalDateTime getDate() {
        return date;
    }
}
