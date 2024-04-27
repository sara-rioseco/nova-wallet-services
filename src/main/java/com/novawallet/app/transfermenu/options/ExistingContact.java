package com.novawallet.app.transfermenu.options;

import com.novawallet.Main;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;
import java.util.ArrayList;
import java.util.Scanner;
import static com.novawallet.app.usermenu.options.SeeUserInfo.getContactsAsString;
import static com.novawallet.entity.TransactionType.TRANSFER;
import static java.lang.Integer.parseInt;

/**
 * The type Existing contact.
 */
public abstract class ExistingContact implements MenuOption {

    /**
     * Run option with user.
     *
     * @param user the user
     * @return the user
     */
    public static User run(User user) {
        ArrayList<User> currentUsers = Main.users;
        System.out.println("\nHere you can transfer funds from your account to any of your contacts.\n------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = user.getContacts();

        if (notEnoughFunds(user) != null) return user;

        int contactsLength = contacts.size();
        System.out.println("These are your contacts:\n");
        System.out.println(getContactsAsString(contacts));

        if(contactsLength <= 0) {
            System.out.println("You'll return to the transfer menu.\n------------------------------------------------------------");
            return user;
        }

        else {
            int option;
            Contact contact;
            do {
                System.out.print("Who do you want to transfer to?\nPlease enter contact number: ");
                option = parseInt(sc.nextLine());
                System.out.println(option <= 0 || option > contactsLength
                        ? "Invalid option, transfer failed. Please try again.\n------------------------------------------------------------"
                        : STR."""
You've selected contact \{contacts.get(option - 1).getFullName()}
------------------------------------------------------------""");
            } while (option <= 0 || option > contactsLength);

            contact = contacts.get(option - 1);

            return processTransfer(user, sc, contact);
        }
    }

    /**
     * Not enough funds user.
     *
     * @param user the user
     * @return the user
     */
    protected static User notEnoughFunds(User user) {
        double balance = user.getBalanceAmount();

        if (balance <=0 ) {
            System.out.println("You don't have enough funds to transfer. You'll go back to the transfer menu\n------------------------------------------------------------");
            return user;
        }
        return null;
    }

    /**
     * Process transfer user.
     *
     * @param user    the user
     * @param sc      the sc
     * @param contact the contact
     * @return the user
     */
    protected static User processTransfer(User user, Scanner sc, Contact contact) {
        int amount;
        do {
            System.out.print(STR."How much money are you going to transfer to \{contact.getFullName()}? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0
                ? "Invalid amount, transfer failed. Please try again.\n------------------------------------------------------------"
                : amount > user.getBalanceAmount()
                    ? "Not enough funds, transfer failed. Please try again.\n------------------------------------------------------------"
                    : "Successfully transferred funds.\n------------------------------------------------------------");
        } while (amount <= 0 || amount > user.getBalanceAmount());
        Transaction transaction = new Transaction(user.getTransactions().size()+1, amount, TRANSFER, user.getId(), contact.getId());
        user.withdrawMoney(amount);
        user.addTransaction(transaction);
        return user;
    }
}
