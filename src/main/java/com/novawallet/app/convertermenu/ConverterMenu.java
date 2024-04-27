package com.novawallet.app.convertermenu;

import java.util.Scanner;
import com.novawallet.app.Menu;
import com.novawallet.app.SubMenu;
import com.novawallet.entity.User;
import com.novawallet.app.convertermenu.options.*;
import static com.novawallet.app.Color.*;
import static java.lang.Integer.parseInt;

/**
 * The type Converter menu.
 */
public class ConverterMenu implements Menu, SubMenu {

    @Override
    public void runMenu(User user) {
        Scanner sc = new Scanner(System.in);
        optionSelect(user, sc);
    }

    @Override
    public void optionSelect(User user, Scanner sc) {
        int opt;
        do {
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

    @Override
    public void printOptions() {
        System.out.println("What conversion do you want to do?\n");
        System.out.println(STR."  \{GREEN.getColor()}1\{RESET.getColor()}.See my balance in other currencies\n  \{
                GREEN.getColor()}2\{RESET.getColor()}.Convert CLP\n  \{GREEN.getColor()}3\{
                RESET.getColor()}.Convert USD\n  \{GREEN.getColor()}4\{RESET.getColor()}.Convert EUR\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To go back, \{RED.getColor()}press any other number\{RESET.getColor()}.\n");
        System.out.print("Please chose an option: ");
    }
}
