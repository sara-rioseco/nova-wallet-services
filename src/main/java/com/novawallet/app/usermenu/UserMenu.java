package com.novawallet.app.usermenu;

import java.util.Scanner;
import static java.lang.Integer.parseInt;

import com.novawallet.app.Menu;
import com.novawallet.app.mainmenu.options.Exit;
import com.novawallet.app.usermenu.options.*;
import com.novawallet.entity.User;
import static com.novawallet.app.Color.*;

public class UserMenu implements Menu {

    public void userMenu(User user) {
        int opt;
        System.out.print(STR."Hello, \{user.getFullName()}. ");
        do {
            Scanner sc = new Scanner(System.in);
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    SeeBalance.run(user);
                    break;
                case 2:
                    Deposit.run(user);
                    break;
                case 3:
                    Withdraw.run(user);
                    break;
                case 4:
                    Transfer.run(user);
                    break;
                case 5:
                    Convert.run(user);
                    break;
                case 6:
                    SeeUserInfo.run(user);
                    break;
                default:
                    Exit exit = new Exit();
                    exit.run();
            }
        } while (opt > 0 && opt < 7);
    }

    public void printOptions() {
        System.out.println("What do you want to do?\n");
        System.out.println("  1.See my balance\n  2.Deposit funds\n  3.Withdraw funds\n  4.Transfer funds\n  5.Convert currency\n  6.See user information\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To log out and go back, \{RED.getColor()}press any other number\{RESET.getColor()}.");
        System.out.print("Please chose an option: ");
    }
}
