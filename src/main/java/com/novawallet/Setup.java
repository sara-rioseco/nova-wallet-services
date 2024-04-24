package com.novawallet;

import com.novawallet.entity.Contact;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;

import java.util.ArrayList;

import static com.novawallet.entity.TransactionType.TRANSFER;

public class Setup {
    protected static void createTestUsers(ArrayList<User> users) {

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

    }
}
