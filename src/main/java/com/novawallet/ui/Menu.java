package com.novawallet.ui;

import com.novawallet.user.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Menu {

    protected static User login() {
        ArrayList<User> currentUsers = Main.users;
        Scanner sc = new Scanner(System.in);
        String email;
        String password;
        boolean userExists;
        boolean isPasswordValid;
        User currentUser;

        do {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            String finalEmail = email;
            userExists = currentUsers.stream().anyMatch(user -> user.getEmail().equals(finalEmail));

            System.out.print("Enter your password: ");
            password = sc.nextLine();
            String finalPassword = password;
            isPasswordValid = currentUsers.stream().anyMatch(user -> user.getPassword().equals(finalPassword));

            currentUser = currentUsers.stream().filter(u -> Objects.equals(u.getEmail(), finalEmail)).findFirst().get();

            System.out.println(!userExists || !isPasswordValid
                    ? "------------------------------------------------------------\nInvalid credentials. Please try again."
                    : "------------------------------------------------------------\n          You have successfully logged in, " + currentUser.getName() +".");
            System.out.println("------------------------------------------------------------");
        } while (!userExists || !isPasswordValid);
        return currentUser;
    }

    protected static User signup() {
        ArrayList<User> currentUsers = Main.users;
        Scanner sc = new Scanner(System.in);
        String email;
        String password;
        String name;
        String lastname;
        boolean userExists;
        boolean isPasswordValid;
        User currentUser;

        do {
            System.out.print("Enter your email: ");
            email = sc.nextLine();
            String finalEmail = email;
            userExists = currentUsers.stream().anyMatch(user -> user.getEmail().equals(finalEmail));

            System.out.print("Enter your password: ");

            password = sc.nextLine();

            System.out.print("Enter your name: ");
            name = sc.nextLine();
            String finalName = name;

            System.out.print("Enter your lastname: ");
            lastname = sc.nextLine();

            System.out.println(userExists
                    ? "------------------------------------------------------------\n     That email is already registered. Please try again."
                    : "------------------------------------------------------------\n     You have successfully signed up, " + getInitial(finalName) + finalName.substring(1)  +".");
            System.out.println("------------------------------------------------------------");
        } while (userExists);

        currentUser = new User(currentUsers.size()+1, name, lastname, email, password);
        return currentUser;
    }

    protected static void exit() {
        System.out.println("\n        Thank you for choosing us. Have a good day!\n------------------------------------------------------------");
    }

    public static String getInitial(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }
}
