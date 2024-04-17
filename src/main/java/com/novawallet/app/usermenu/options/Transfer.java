package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

public class Transfer implements MenuOption {
    public static void run(User user) {
        System.out.println(STR."""

Sorry \{user.getFullName()}, this section is under maintenance.
------------------------------------------------------------""");
    }
}
