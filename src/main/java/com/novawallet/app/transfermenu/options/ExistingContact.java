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

public abstract class ExistingContact implements MenuOption {

    public static User run(User user) {
        ArrayList<User> currentUsers = Main.users;
        System.out.println("\nHere you can transfer funds from your account to any of your contacts.\n------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = user.getContacts();
        int contactsLength = contacts.size();
        System.out.println("These are your contacts: ");
        System.out.println(getContactsAsString(contacts));

        int option;
        Contact contact;
        do {
            System.out.print("Who do you want to transfer to? Option number: ");
            option = parseInt(sc.nextLine());
            System.out.println(option <= 0 || option > contactsLength
                ? "Invalid option, transfer failed. Please try again.\n------------------------------------------------------------"
                : "You've selected contact " + contacts.get(option - 1).getFullName() + "\n------------------------------------------------------------");
        } while (option <= 0 || option > contactsLength);

        contact = contacts.get(option - 1);

        int amount;
        do {
            System.out.print("How much money are you going to transfer to " + contact.getFullName() + "? : ");
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
