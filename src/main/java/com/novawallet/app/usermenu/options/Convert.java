package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.app.convertermenu.ConverterMenu;
import com.novawallet.entity.User;

public abstract class Convert implements MenuOption {
    public static User run(User user) {
        System.out.println("\nHere you can convert an amount of money from one currency to another.\n------------------------------------------------------------");
        ConverterMenu converterMenu = new ConverterMenu();
        converterMenu.runMenu(user);
        return user;
    }
}
