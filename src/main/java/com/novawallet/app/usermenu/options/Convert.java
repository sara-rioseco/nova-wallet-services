package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.app.convertermenu.ConverterMenu;
import com.novawallet.entity.User;

/**
 * The type Convert.
 */
public abstract class Convert implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     * @return the user
     */
    public static User run(User user) {
        System.out.println("\nHere you can convert an amount of money from one currency to another.\n------------------------------------------------------------");
        ConverterMenu converterMenu = new ConverterMenu();
        converterMenu.runMenu(user);
        return user;
    }
}
