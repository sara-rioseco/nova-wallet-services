package com.novawallet.app.convertermenu;

import com.novawallet.app.Menu;
import com.novawallet.app.mainmenu.options.Exit;
import com.novawallet.entity.User;
import com.novawallet.app.convertermenu.options.*;

import java.util.Scanner;

import static com.novawallet.app.Color.*;
import static com.novawallet.app.Color.RESET;
import static java.lang.Integer.parseInt;

public class ConverterMenu implements Menu {

    public void converterMenu(User user) {
        int opt;
        do {
            Scanner sc = new Scanner(System.in);
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    SeeConvertedBalance.run(user);
                    break;
                case 2:
                    ConvertCLP.run(user);
                    break;
                case 3:
                    ConvertUSD.run(user);
                    break;
                case 4:
                    ConvertEUR.run(user);
                    break;
                default:
                    System.out.println("------------------------------------------------------------\n             You'll go back to the user menu.\n------------------------------------------------------------");
            }
        } while (opt > 0 && opt < 5);
    }

    public void printOptions() {
        System.out.println("What conversion do you want to do?\n");
        System.out.println("  1.See my balance in other currencies\n  2.Convert CLP\n  3.Convert USD\n  4.Convert EUR\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To go back, \{RED.getColor()}press any other number\{RESET.getColor()}.\n");
        System.out.print("Please chose an option: ");
    }
}
