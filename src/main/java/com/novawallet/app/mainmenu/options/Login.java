package com.novawallet.app.mainmenu.options;

import com.novawallet.Main;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Login implements MenuOption {

    public User run() {
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

            currentUser = currentUsers.stream().filter(u -> Objects.equals(u.getEmail(), finalEmail)).findFirst().orElse(null);

            System.out.println(!userExists || !isPasswordValid
                    ? "------------------------------------------------------------\nInvalid credentials. Please try again."
                    : "------------------------------------------------------------\n          You have successfully logged in");
            System.out.println("------------------------------------------------------------");
        } while (!userExists || !isPasswordValid);
        return currentUser;
    }
}
