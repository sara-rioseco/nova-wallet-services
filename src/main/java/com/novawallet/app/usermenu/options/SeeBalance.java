package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

/**
 * The type See balance.
 */
public abstract class SeeBalance implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     * @return the user
     */
    public static User run(User user) {
        System.out.println(STR."""
Your current balance is: \{user.getBalanceCurrency()} $\{(int) user.getBalanceAmount()}
------------------------------------------------------------""");
        return user;
    }
}
