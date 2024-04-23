package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.TransactionType;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.*;

import java.util.ArrayList;
import static java.lang.StringTemplate.STR;

public abstract class SeeUserInfo implements MenuOption {
    public static User run(User user) {
        System.out.println(STR."""
This is your user information
\tName: \{user.getFullName()}
\tEmail: \{user.getEmail()}
\tCurrency: \{user.getBalanceCurrency()}
\tBalance: \{(int)user.getBalanceAmount()}
\tContacts:\s
\{getContactsAsString(user.getContacts())}
\tTransactions:\s
\{getTransactionsAsString(user.getTransactions(), user)}
------------------------------------------------------------""");
        return user;
    }

    public static String getContactsAsString (ArrayList<Contact> contacts) {
        StringBuilder res = new StringBuilder();
        if (contacts.isEmpty()) {
            res.append("\t\tYou don't have any contacts yet.");
        } else {
            for (Contact contact : contacts) {
                res.append(STR."\t\t\{contacts.indexOf(contact) + 1}. \{contact.getFullName()}, email: \{contact.getEmail()}\n");
            }
        }
        return res.toString();
    }

    private static String getTransactionsAsString (ArrayList<Transaction> transactions, User user) {
        StringBuilder res = new StringBuilder();
        if (transactions.isEmpty()) {
            res.append("\t\tYou don't have any transactions yet.");
        } else {
            for (Transaction transaction : transactions) {
                res.append(STR."\t\t\{transactions.indexOf(transaction) + 1}. On \{formatDate(transaction.getDate())} at \{
                        formatTime(transaction.getDate())}, you \{getTransactionAction(transaction, user)} \{(int)transaction.getAmount()} \{transaction.getCurrency()}.\n");
            }
        }
        return res.toString();
    }

    private static String getTransactionAction(Transaction transaction, User user) {
        if (transaction.getType() == TransactionType.TRANSFER) {
            if (transaction.getSenderId() == user.getId()) {
                return "transferred";
            } else {
                return "received";
            }
        } else if (transaction.getType() == TransactionType.DEPOSIT) {
            return "deposited";
        } else {
            return "withdraw";
        }
    }
}

