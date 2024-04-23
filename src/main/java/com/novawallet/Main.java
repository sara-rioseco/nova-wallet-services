package com.novawallet;

import com.novawallet.app.mainmenu.*;
import com.novawallet.entity.*;
import java.util.ArrayList;

import static com.novawallet.entity.TransactionType.TRANSFER;


public class Main {
    // ArrayList para almacenar usuarios
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        // Creación de usuario admin
        User adminUser = new User(users.size() + 1, "admin", "user", "admin@novawallet.com", "admin", 50000);
        Contact contact1 = new Contact(adminUser.getContacts().size()+1, "test", "user", "test@novawallet.com" );
        adminUser.addContact(contact1);
        Transaction transaction1 = new Transaction(adminUser.getTransactions().size()+1, 50000, TRANSFER, 2, 1);
        adminUser.addTransaction(transaction1);
        users.add(adminUser);

        // Creación de usuario test
        User testUser = new User(users.size()+ 1, "test", "user", "test@novawallet.com", "superSecurePassword123");
        Contact contact2 = new Contact(testUser.getContacts().size()+1, "admin", "user", "admin@novawallet.com" );
        testUser.addContact(contact2);
        Transaction transaction2 = new Transaction(testUser.getTransactions().size()+1, 50000, TRANSFER, 2, 1);
        testUser.addTransaction(transaction2);
        users.add(testUser);

        // Creación de usuario test2
        User testUser2 = new User(users.size()+ 1, "test2", "user2", "test2@novawallet.com", "password");
        users.add(testUser2);

        MainMenu mainMenu = new MainMenu();
        mainMenu.runMenu(users);
    }
}
