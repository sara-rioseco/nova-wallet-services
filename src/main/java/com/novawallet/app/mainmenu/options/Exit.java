package com.novawallet.app.mainmenu.options;

import com.novawallet.app.MenuOption;

public class Exit implements MenuOption {

    public void run() {
        System.out.println("\n        Thank you for choosing us. Have a good day!\n------------------------------------------------------------");
        System.exit(0);
    }
}