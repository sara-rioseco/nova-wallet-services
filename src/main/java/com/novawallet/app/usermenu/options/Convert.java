package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.app.convertermenu.converter.Converter;
import com.novawallet.entity.User;

public class Convert implements MenuOption {
    public static void run(User user) {
        System.out.println("\nHere you can convert an amount of money from one currency to another.\n------------------------------------------------------------");
        new Converter().converter(user);
    }
}
