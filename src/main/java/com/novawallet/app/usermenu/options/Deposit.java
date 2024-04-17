package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public abstract class Deposit implements MenuOption {
    public static void run(User user) {
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
}
