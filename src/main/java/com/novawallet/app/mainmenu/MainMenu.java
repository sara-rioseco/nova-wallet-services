package com.novawallet.app.mainmenu;

import java.util.ArrayList;
import java.util.Scanner;

import com.novawallet.app.Menu;
import com.novawallet.app.MenuOption;
import com.novawallet.app.mainmenu.options.*;
import com.novawallet.app.usermenu.UserMenu;
import com.novawallet.entity.User;
import static com.novawallet.app.Color.*;
import static java.lang.Integer.parseInt;

public class MainMenu implements Menu {

    public void runMenu(ArrayList<User> users){
        // Almacenar usuario actual
        User currentUser;
        User newUser;

        // Ejecución de programa
        System.out.println("--------------------------------------------------------");
        System.out.println(STR."""
      ~ Welcome to \{WHITE.getColor()}NovaWallet\{RESET.getColor()} financial services ~
--------------------------------------------------------""");

        Scanner sc = new Scanner(System.in);
        int opt;
        do {
            printOptions();
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    MenuOption login = new Login();
                    currentUser = login.run();
                    UserMenu menuLogin = new UserMenu();
                    menuLogin.userMenu(currentUser);
                    break;
                case 2:
                    MenuOption signUp = new SignUp();
                    newUser = signUp.run();
                    users.add(newUser);
                    UserMenu menuSignUp = new UserMenu();
                    menuSignUp.userMenu(newUser);
                    break;
                default:
                    Exit exit = new Exit();
                    exit.run();
            }
        } while (opt > 0 && opt < 3);

        System.out.println(STR."\{RED.getColor()}Program closed.\{RESET.getColor()}");
    }

    public void printOptions() {
        System.out.println("What do you want to do?\n\n  1.Login\n  2.Sign Up\n");
        System.out.println(STR."Once you write the option, \{YELLOW.getColor()}press ENTER\{RESET.getColor()}.");
        System.out.println(STR."To close program \{RED.getColor()}press any other number\{RESET.getColor()}.");
        System.out.print("Please chose an option: ");
    }
}
