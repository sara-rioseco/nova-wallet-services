package com.novawallet.ui;

import com.novawallet.converter.Converter;
import com.novawallet.user.User;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class UserMenuOptions {

    protected static void seeBalance(User user) {
        System.out.println("Your current balance is: " + user.getCurrency() + " $" +user.getBalance()+"\n------------------------------------------------------------");
    }

    protected static void deposit(User user) {
        System.out.println("\nHere you can deposit funds in "+ user.getCurrency()+" to your account.\n------------------------------------------------------------");
        double amount;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money are you going to deposit? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0
                    ? "Invalid amount, deposit failed. Please try again.\n------------------------------------------------------------"
                    : "Successfully deposited funds.\n------------------------------------------------------------");
        } while (amount <= 0);
        user.addBalance(amount);
    }

    protected static void withdraw(User user) {
        System.out.println("\nHere you can withdraw money in " + user.getCurrency() + " from your account.\n------------------------------------------------------------");
        double amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money are you going to withdraw in " + user.getCurrency() + "? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0
                    ? "Invalid amount, withdraw failed. Please try again.\n------------------------------------------------------------"
                    : amount > user.getBalance()
                        ? "Not enough funds, withdraw failed. Please try again.\n------------------------------------------------------------"
                        : "Successfully withdraw funds.\n------------------------------------------------------------");
        } while (amount <= 0 || amount > user.getBalance());
        user.withdrawMoney(amount);
    }

    protected static void transfer(User user) {
        System.out.println("\nSorry "+ user.getFullName()+", this section is under maintenance.\n------------------------------------------------------------");
    }

    protected static void convert(User user) {
        System.out.println("\nHere you can convert an amount of money from one currency to another.\n------------------------------------------------------------");
        new Converter().converter(user);
    }

    protected static void logout() {
        System.out.println("------------------------------------------------------------\nThank you for choosing us. Have a good day!");
        System.exit(0);
    }
}
