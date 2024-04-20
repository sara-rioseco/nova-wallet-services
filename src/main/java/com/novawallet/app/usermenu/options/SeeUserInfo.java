package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.*;

import java.util.ArrayList;
import static java.lang.StringTemplate.STR;

public abstract class SeeUserInfo implements MenuOption {
    public static void run(User user) {
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
    }

    private static String getContactsAsString (ArrayList<Contact> contacts) {
        StringBuilder res = new StringBuilder();
        if (contacts.isEmpty()) {
            res.append("\t\tYou don't have any contacts yet.");
        } else {
            for (Contact contact : contacts) {
                res.append(STR."\t\t\{contacts.indexOf(contact) + 1}. \{contact.getFullName()}, email: \{contact.getEmail()}");
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
                res.append(STR."\t\t\{transactions.indexOf(transaction) + 1}. On \{formatDate(transaction.getDate())} at \{formatTime(transaction.getDate())}, you \{ transaction.getSenderId() == user.getId() ? "transferred" : "received"} \{transaction.getAmount()} \{transaction.getCurrency()}.");
            }
        }
        return res.toString();
    }
}
