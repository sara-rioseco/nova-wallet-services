package com.novawallet.app.convertermenu;

import com.novawallet.app.Menu;
import com.novawallet.app.mainmenu.options.Exit;
import com.novawallet.entity.User;

import java.util.Scanner;

import static com.novawallet.app.Color.*;
import static com.novawallet.app.Color.RESET;
import static java.lang.Integer.parseInt;

public class ConverterMenu implements Menu {

    public void converterMenu(User user) {
        int opt;
        System.out.print(STR."Hello, \{user.getFullName()}. What conversion do you want to do?");
        do {
            Scanner sc = new Scanner(System.in);
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    //TODO ExistingContact.run(user);
                    break;
                case 2:
                    //TODO NewContact.run(user);
                    break;
                case 3:
                    //TODO NewContact.run(user);
                    break;
                case 4:
                    //TODO NewContact.run(user);
                    break;
                default:
                    Exit exit = new Exit();
                    exit.run();
            }
        } while (opt > 0 && opt < 3);
    }

    public void printOptions() {
        System.out.println("What do you want to do?\n");
        System.out.println("  1.See my balance in other currencies\n  2.Convert CLP\n  3.Convert USD\n  4.Convert EUR");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To go back, \{RED.getColor()}press any other number\{RESET.getColor()}.\n");
        System.out.print("Please chose an option: ");
    }
}
