package com.novawallet.app.convertermenu.options;

import java.util.Scanner;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.USDBalance;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.capitalize;
import static java.lang.Integer.parseInt;

public abstract class ConvertUSD implements MenuOption {
    public static void run(User user) {
        System.out.println(STR."""

Hello \{capitalize(user.getName())}, here you can convert USD into CLP and EUR.
------------------------------------------------------------""");
        USDBalance amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money in USD do you want to convert? : ");
            amount = new USDBalance(parseInt(sc.nextLine()));
            System.out.println(amount.getAmount() <= 0
                    ? "Invalid amount, conversion failed. Please try again.\n------------------------------------------------------------"
                    : "$" + amount.getAmount() + " USD is equivalent to "
                        + "$" +(int)amount.convertToCLP() + " CLP and "
                        + "$" + Math.round(amount.convertToEUR()*100)/100 + " EUR.\n------------------------------------------------------------");
        } while (amount.getAmount() <= 0);
    }
}
