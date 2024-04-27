package com.novawallet;

import com.novawallet.app.mainmenu.*;
import com.novawallet.entity.*;
import java.util.ArrayList;

import static com.novawallet.Setup.createTestUsers;

/**
 * The type Main.
 */
public class Main {
    /**
     * The constant users.
     */
    public static ArrayList<User> users = new ArrayList<>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        createTestUsers(users);
        mainMenu.runMenu(users);
    }

}
