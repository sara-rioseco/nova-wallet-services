package com.novawallet.ui;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

import com.novawallet.user.User;
import static com.novawallet.ui.UserMenuOptions.*;


public class UserMenu {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_YELLOW = "\u001B[33m";

    public static void userMenu(User user) {

        int opt;
        System.out.print("Hello, "+ user.getFullName() +". ");
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
}
