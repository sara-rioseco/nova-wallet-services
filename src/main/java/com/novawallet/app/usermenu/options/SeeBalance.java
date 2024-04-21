package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

public abstract class SeeBalance implements MenuOption {
    public static User run(User user) {
        System.out.println("Your current balance is: " + user.getBalanceCurrency()
                + " $" + (int)user.getBalanceAmount()
                +"\n------------------------------------------------------------");
        return user;
    }
}
