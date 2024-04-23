package com.novawallet.app.transfermenu.options;

import com.novawallet.Main;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

import static com.novawallet.entity.TransactionType.TRANSFER;
import static java.lang.Integer.parseInt;

public abstract class NewContact implements MenuOption {
    public static User run(User user) {
        ArrayList<User> currentUsers = Main.users;
        System.out.println("\nHere you can transfer funds from your account to a new contact.\n------------------------------------------------------------");

        String name;
        String lastname;
        String email;
        boolean userExists;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter contact email: ");
            email = sc.nextLine();
            String finalEmail = email;
            userExists = currentUsers.stream().anyMatch(userItem -> userItem.getEmail().equals(finalEmail));
            System.out.print("Enter contact name: ");
            name = sc.nextLine();

            System.out.print("Enter contact lastname: ");
            lastname = sc.nextLine();
            System.out.println(!userExists
                ? "------------------------------------------------------------\n     That email is not associated with any user. Please try again."
                : "------------------------------------------------------------\n     " + user.getFullName()  +", your contact has been added.");
            System.out.println("------------------------------------------------------------");
        } while (!userExists);

        ArrayList<Contact> contacts = user.getContacts();
        Contact contact = new Contact(contacts.size()+1, name, lastname, email);
        user.addContact(contact);
        User contactUser = currentUsers.stream().filter(userItem -> userItem.getEmail().equals(contact.getEmail())).findFirst().orElse(null);
        double amount;
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
