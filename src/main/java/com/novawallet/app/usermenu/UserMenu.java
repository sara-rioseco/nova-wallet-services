package com.novawallet.app.usermenu;

import java.util.Scanner;
import com.novawallet.app.Menu;
import com.novawallet.app.SubMenu;
import com.novawallet.app.mainmenu.options.Exit;
import com.novawallet.app.usermenu.options.*;
import com.novawallet.entity.User;
import static com.novawallet.app.Color.*;
import static java.lang.Integer.parseInt;

/**
 * The type User menu.
 */
public class UserMenu implements Menu, SubMenu {

    /**
     * The User.
     */
    protected User user;

    @Override
    public void runMenu(User loggedInUser) {
        Scanner sc = new Scanner(System.in);
        optionSelect(loggedInUser, sc);
    }

    @Override
    public void optionSelect(User loggedInUser, Scanner sc) {
        int opt;
        System.out.print(STR."Hello, \{loggedInUser.getFullName()}. ");
        do {
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    user = SeeBalance.run(loggedInUser);
                    break;
                case 2:
                    user = Deposit.run(loggedInUser);
                    break;
                case 3:
                    user = Withdraw.run(loggedInUser);
                    break;
                case 4:
                    user = Transfer.run(loggedInUser);
                    break;
                case 5:
                    user = Convert.run(loggedInUser);
                    break;
                case 6:
                    user = SeeUserInfo.run(loggedInUser);
                    break;
                default:
                    Exit exit = new Exit();
                    exit.run();
            }
        } while (opt > 0 && opt < 7);
    }

    @Override
    public void printOptions() {
        System.out.println("What do you want to do?\n");
        System.out.println(STR."  \{GREEN.getColor()}1\{RESET.getColor()}.See my balance\n  \{GREEN.getColor()}2\{
            RESET.getColor()}.Deposit funds\n  \{GREEN.getColor()}3\{RESET.getColor()}.Withdraw funds\n  \{
            GREEN.getColor()}4\{RESET.getColor()}.Transfer funds\n  \{GREEN.getColor()}5\{
            RESET.getColor()}.Convert currency\n  \{GREEN.getColor()}6\{RESET.getColor()}.See user information\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To log out and exit, \{RED.getColor()}press any other number\{RESET.getColor()}.");
        System.out.println("------------------------------------------------------------");
        System.out.print("Please chose an option: ");
    }
}
