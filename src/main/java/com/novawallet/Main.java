package com.novawallet;

import com.novawallet.app.mainmenu.*;
import com.novawallet.entity.*;
import java.util.ArrayList;

import static com.novawallet.Setup.createTestUsers;

public class Main {
    // ArrayList para almacenar usuarios
    public static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {

        MainMenu mainMenu = new MainMenu();
        createTestUsers(users);
        mainMenu.runMenu(users);
    }

}
