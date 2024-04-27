package com.novawallet.app.usermenu.options;

import java.util.ArrayList;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.TransactionType;
import com.novawallet.entity.User;
import static com.novawallet.app.Color.*;
import static com.novawallet.app.Utils.*;
import static java.lang.StringTemplate.STR;

/**
 * The type See user info.
 */
public abstract class SeeUserInfo implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     * @return the user
     */
    public static User run(User user) {
        System.out.println(STR."""
------------------------------------------------------------
               This is your user information
------------------------------------------------------------

\t\{WHITE.getColor()}Name:\{RESET.getColor()} \{user.getFullName()}
\t\{WHITE.getColor()}Email:\{RESET.getColor()} \{user.getEmail()}
\t\{WHITE.getColor()}Currency:\{RESET.getColor()} \{user.getBalanceCurrency()}
\t\{WHITE.getColor()}Balance:\{RESET.getColor()} \{(int)user.getBalanceAmount()}
\t\{WHITE.getColor()}Contacts:\{RESET.getColor()}\s
\{getContactsAsString(user.getContacts())}
\t\{WHITE.getColor()}Transactions:\{RESET.getColor()}\s
\{getTransactionsAsString(user.getTransactions(), user)}
------------------------------------------------------------""");
        return user;
    }

    /**
     * Gets contacts as string.
     *
     * @param contacts the contacts
     * @return the contacts as string
     */
    public static String getContactsAsString (ArrayList<Contact> contacts) {
        StringBuilder res = new StringBuilder();
        if (contacts.isEmpty()) {
            res.append("\t\tYou don't have any contacts yet.");
        } else {
            for (Contact contact : contacts) {
                res.append(STR."\t\t\{GREEN.getColor()}\{contacts.indexOf(contact) + 1}\{RESET.getColor()}. \{contact.getFullName()}, email: \{contact.getEmail()}\n");
            }
        }
        return res.toString();
    }

    /**
     * Gets transactions as string.
     *
     * @param transactions the transactions
     * @param user the user
     * @return the transactions as string
     */
    private static String getTransactionsAsString (ArrayList<Transaction> transactions, User user) {
        StringBuilder res = new StringBuilder();
        if (transactions.isEmpty()) {
            res.append("\t\tYou don't have any transactions yet.\n");
        } else {
            for (Transaction transaction : transactions) {
                res.append(STR."\t\t\{GREEN.getColor()}\{transactions.indexOf(transaction) + 1}\{RESET.getColor()}. On \{formatDate(transaction.getDate())} at \{
                    formatTime(transaction.getDate())}, you \{getTransactionAction(transaction, user)} \{(int)transaction.getAmount()} \{transaction.getCurrency()}.\n");
            }
        }
        return res.toString();
    }

    /**
     * Gets transaction action as string.
     *
     * @param transaction the transaction
     * @param user the user
     * @return the transaction action as string
     */
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

