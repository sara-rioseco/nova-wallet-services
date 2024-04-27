package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.app.transfermenu.TransferMenu;
import com.novawallet.entity.User;

/**
 * The type Transfer.
 */
public abstract class Transfer implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     * @return the user
     */
    public static User run(User user) {
        System.out.println("\nHere you can transfer money to another account.\n------------------------------------------------------------");
        TransferMenu transferMenu = new TransferMenu();
        transferMenu.runMenu(user);
        return user;
    }
}
