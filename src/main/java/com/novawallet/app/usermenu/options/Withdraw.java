package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Withdraw implements MenuOption {
    public static void run(User user) {
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
}
