package com.novawallet.app.convertermenu.options;

import java.util.Scanner;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.EURBalance;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.capitalize;
import static java.lang.Integer.parseInt;

public abstract class ConvertEUR implements MenuOption {
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
                    + "$" + Math.round(amount.convertToUSD()*100)/100 + " USD and "
                    + "$" + (int)amount.convertToCLP() + " CLP.\n------------------------------------------------------------");
        } while (amount.getAmount() <= 0);
    }
}
