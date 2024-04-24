package com.novawallet.app.transfermenu.options;

import com.novawallet.Main;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.Contact;
import com.novawallet.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

import static com.novawallet.app.transfermenu.options.ExistingContact.*;

public abstract class NewContact implements MenuOption {
    public static User run(User user) {
        ArrayList<User> currentUsers = Main.users;

        System.out.println("\nHere you can transfer funds from your account to a new contact.\n------------------------------------------------------------");

        if (notEnoughFunds(user) != null) return user;

        String name;
        String lastname;
        String email;
        boolean userExists;
        boolean contactExists;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter contact email: ");
            email = sc.nextLine();
            String finalEmail = email;
            userExists = currentUsers.stream().anyMatch(userItem -> userItem.getEmail().equals(finalEmail));
            contactExists = user.getContacts().stream().anyMatch(contactItem -> contactItem.getEmail().equals(finalEmail));
            System.out.print("Enter contact name: ");
            name = sc.nextLine();

            System.out.print("Enter contact lastname: ");
            lastname = sc.nextLine();
            System.out.println( contactExists ? "------------------------------------------------------------\n     That user is already your contact. Please try again." : !userExists
                ? "------------------------------------------------------------\n     That email is not associated with any user. Please try again."
                : STR."""
------------------------------------------------------------
     \{user.getFullName()}, your contact has been added.""");
            System.out.println("------------------------------------------------------------");
        } while (contactExists || !userExists);

        ArrayList<Contact> contacts = user.getContacts();
        Contact contact = new Contact(contacts.size()+1, name, lastname, email);
        user.addContact(contact);
//        User contactUser = currentUsers.stream().filter(userItem -> userItem.getEmail().equals(contact.getEmail())).findFirst().orElse(null);

        return processTransfer(user, sc, contact);
    }

}
