package com.novawallet.app.convertermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.User;

/**
 * The type See converted balance.
 */
public abstract class SeeConvertedBalance implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     */
    public static void run(User user) {
        System.out.println("------------------------------------------------------------");
        System.out.println(STR."Your current balance is $\{(int)user.getBalanceAmount()} \{user.getBalanceCurrency()}");
        System.out.println(STR."That is equivalent to \{user.getBalanceObject().convertToUSD()} USD and \{user.getBalanceObject().convertToEUR()} EUR.");
        System.out.println("------------------------------------------------------------");
    }
}
