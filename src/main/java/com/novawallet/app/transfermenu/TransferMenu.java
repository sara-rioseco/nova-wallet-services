package com.novawallet.app.transfermenu;

import com.novawallet.app.Menu;
import com.novawallet.app.mainmenu.options.Exit;
import com.novawallet.app.transfermenu.options.ExistingContact;
import com.novawallet.app.transfermenu.options.NewContact;
import com.novawallet.app.usermenu.options.*;
import com.novawallet.entity.User;

import java.util.Scanner;

import static com.novawallet.app.Color.*;
import static com.novawallet.app.Color.RESET;
import static java.lang.Integer.parseInt;

public class TransferMenu implements Menu {

    public void transferMenu(User user) {
        int opt;
        System.out.print(STR."Hello, \{user.getFullName()}. Who do you want to transfer to?");
        do {
            Scanner sc = new Scanner(System.in);
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    ExistingContact.run(user);
                    break;
                case 2:
                    NewContact.run(user);
                    break;
                default:
                    System.out.println("------------------------------------------------------------\n             You'll go back to the user menu.\n------------------------------------------------------------");
            }
        } while (opt > 0 && opt < 3);
    }

    public void printOptions() {
        System.out.println("What do you want to do?\n");
        System.out.println("  1.Existing contact\n  2.New contact\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To go back, \{RED.getColor()}press any other number\{RESET.getColor()}.\n");
        System.out.print("Please chose an option: ");
    }
}
