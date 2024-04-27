package com.novawallet.app.convertermenu.options;

import java.util.Scanner;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.EURBalance;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.capitalize;
import static java.lang.Integer.parseInt;

/**
 * The type Convert eur.
 */
public abstract class ConvertEUR implements MenuOption {
    /**
     * Run option with user.
     *
     * @param user the user
     */
    public static void run(User user) {
        System.out.println(STR."""

Hello \{capitalize(user.getName())}, here you can convert EUR into USD and CLP.
------------------------------------------------------------""");
        EURBalance amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money in EUR do you want to convert? : ");
            amount = new EURBalance(parseInt(sc.nextLine()));
            System.out.println(amount.getAmount() <= 0
                    ? "Invalid amount, conversion failed. Please try again.\n------------------------------------------------------------"
                    : "$" + amount.getAmount() + " EUR is equivalent to "
                    + "$" + amount.convertToUSD() + " USD and "
                    + "$" + (int)amount.convertToCLP() + " CLP.\n------------------------------------------------------------");
        } while (amount.getAmount() <= 0);
    }
}
