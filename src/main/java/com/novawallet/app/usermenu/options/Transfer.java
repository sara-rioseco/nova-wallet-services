package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.app.convertermenu.ConverterMenu;
import com.novawallet.app.transfermenu.TransferMenu;
import com.novawallet.entity.User;

public abstract class Transfer implements MenuOption {
    public static User run(User user) {
        System.out.println("\nHere you can transfer money to another account.\n------------------------------------------------------------");
        TransferMenu transferMenu = new TransferMenu();
        transferMenu.transferMenu(user);
        return user;
    }
}
