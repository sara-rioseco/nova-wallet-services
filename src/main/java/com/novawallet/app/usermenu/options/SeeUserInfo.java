package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;
import com.novawallet.app.Utils.*;

import java.util.ArrayList;

import static java.lang.StringTemplate.STR;

public class SeeUserInfo implements MenuOption {
    public static void run(User user) {
        System.out.println(STR."""
This is your user information

Name: \{user.getFullName()}
Email: \{user.getEmail()}
Currency: \{user.getCurrency()}
Balance: \{user.getBalance()}
Contacts:\s
\{getContactsAsString(user.getContacts())}
Transactions: \{getTransactionsAsString(user.getTransactions())}
------------------------------------------------------------""");
    }

    private static String getContactsAsString (ArrayList<Contact> contacts) {
        StringBuilder res = new StringBuilder();
        if (contacts.isEmpty()) {
            res.append("You don't have any contacts yet.\n");
        } else {
            for (Contact contact : contacts) {
                res.append(STR."   \{contacts.indexOf(contact) + 1}. \{contact.getFullname()}");
            }
        }
        return res.toString();
    }

    private static String getTransactionsAsString (ArrayList<Transaction> transactions) {
        StringBuilder res = new StringBuilder();
        if (transactions.isEmpty()) {
            res.append("You don't have any transactions yet.\n");
        } else {
            for (Transaction transaction : transactions) {
                res.append(STR."   \{transactions.indexOf(transaction) + 1}. \{transaction.getDate()}");
            }
        }
        return res.toString();
    }
}
