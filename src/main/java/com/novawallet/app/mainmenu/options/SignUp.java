package com.novawallet.app.mainmenu.options;

import com.novawallet.Main;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

import java.util.ArrayList;
import java.util.Scanner;

import static com.novawallet.app.Utils.capitalize;

public abstract class SignUp implements MenuOption {


    public static User run() {
        ArrayList<User> currentUsers = Main.users;
        String email;
        String password;
        String name;
        String lastname;
        boolean userExists;
        boolean isPasswordValid;
        User currentUser;

        Scanner sc = new Scanner(System.in);
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
                    : "------------------------------------------------------------\n     You have successfully signed up, " + capitalize(finalName)  +".");
            System.out.println("------------------------------------------------------------");
        } while (userExists);

        currentUser = new User(currentUsers.size()+1, name, lastname, email, password);
        return currentUser;
    }
}
