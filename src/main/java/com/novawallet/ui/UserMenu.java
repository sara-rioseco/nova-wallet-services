package com.novawallet.ui;

import com.novawallet.user.User;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class UserMenu {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_YELLOW = "\u001B[33m";

    protected static void userMenu(User user) {

        int opt;
        System.out.println("Hello, "+ user.getName() +".");
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("What do you want to do?\n");
            System.out.println("  1.See my balance\n  2.Deposit funds\n  3.Withdraw funds\n  4.Transfer funds\n  5.Convert currency\n");
            System.out.println("Once you write the option, " + ANSI_YELLOW + "press ENTER" + ANSI_RESET +".");
            System.out.println("To log out and close program " + ANSI_RED + "press any other number" + ANSI_RESET + ".\n");
            System.out.print("Please chose an option: ");
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    seeBalance(user);
                    break;
                case 2:
                    deposit(user);
                    break;
                case 3:
                    withdraw(user);
                    break;
                case 4:
                    transfer(user);
                    break;
                case 5:
                    convert(user);
                    break;
                default:
                    logout();
            }
        } while (opt > 0 && opt < 6);

    }

    protected static User seeBalance(User user) {
        System.out.println("Your current balance is: " + user.getBalance()+"\n");
        return user;
    }

    protected static User deposit(User user) {
        System.out.println("\nHere you can deposit funds to your account.\n----------------------------------------");
        double amount;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nHow much money are you going to deposit? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0 ? "Invalid amount, deposit failed. Please try again.": "Successfully deposited funds.");
        } while (amount <= 0);
        user.addBalance(amount);
        return user;
    }

    protected static User withdraw(User user) {
        System.out.println("\nHere you can withdraw money from your account.\n----------------------------------------");
        double amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("\nHow much money are you going to withdraw? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0 ? "Invalid amount, withdraw failed. Please try again.": "Successfully withdraw funds.");
        } while (amount <= 0);
        user.withdrawMoney(amount);

        return user;
    }

    protected static User transfer(User user) {
        System.out.println("\nHere you can transfer funds from your account to another user.\n----------------------------------------");
        return user;
    }

    protected static User convert(User user) {
        System.out.println("\nHere you can convert an amount of money from one currency to another.\n----------------------------------------");
        return user;
    }

    protected static void logout() {
        System.out.println("----------------------------------------\nThank you for choosing us. Have a good day!");
        System.exit(0);
    }
}
