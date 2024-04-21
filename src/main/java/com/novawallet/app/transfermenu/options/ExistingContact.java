package com.novawallet.app.transfermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

public abstract class ExistingContact implements MenuOption {
    public static User run(User user) {
        System.out.println("\nHere you can transfer funds from your account to any of your contacts.\n------------------------------------------------------------");

        return user;
    }
}