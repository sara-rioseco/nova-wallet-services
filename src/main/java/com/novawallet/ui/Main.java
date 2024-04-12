package com.novawallet.ui;

import com.novawallet.user.Contact;
import com.novawallet.user.Transaction;
import com.novawallet.user.User;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    // ArrayList para almacenar usuarios
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {


        // Constantes para imprimir en colores por consola
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_BLACK = "\u001B[30m";

        // Creación de usuario admin
        User adminUser = new User(users.size() + 1, "admin", "user", "admin@novawallet.com", "admin");
        Contact contact1 = new Contact(adminUser.getContacts().size()+1, "test", "user", "test@novawallet.com" );
        adminUser.addContact(contact1);
        Transaction transaction1 = new Transaction(adminUser.getTransactions().size()+1, 50000, 2, 1);
        adminUser.addTransaction(transaction1);
        users.add(adminUser);

        // Creación de usuario test
        User testUser = new User(users.size()+ 1, "test", "user", "test@novawallet.com", "superSecurePassword123");
        Contact contact2 = new Contact(testUser.getContacts().size()+1, "admin", "user", "admin@novawallet.com" );
        testUser.addContact(contact2);
        Transaction transaction2 = new Transaction(testUser.getTransactions().size()+1, 50000, 2, 1);
        testUser.addTransaction(transaction2);
        users.add(testUser);

        // Almacenar usuario actual

        User currentUser;
        User newUser;
        // Ejecución de programa
        System.out.println("--------------------------------------------------------");
        System.out.println("      ~ Welcome to "+ANSI_WHITE+"NovaWallet"+ANSI_RESET+" financial services ~\n--------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            System.out.println("What do you want to do?\n\n  1.Login\n  2.Sign Up\n");
            System.out.println("Once you write the option, " + ANSI_YELLOW + "press ENTER" + ANSI_RESET +".");
            System.out.println("To close program " + ANSI_RED + "press any other number" + ANSI_RESET + ".\n");
            System.out.print("Please chose an option: ");
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    currentUser = Menu.login();
                    UserMenu.userMenu(currentUser);
                    break;
                case 2:
                    newUser = Menu.signup();
                    users.add(newUser);
                    UserMenu.userMenu(newUser);
                    break;
                default:
                    Menu.exit();
            }
        } while (opt > 0 && opt < 3);

        System.out.println(ANSI_RED + "Program closed." + ANSI_RESET);
    }
}
