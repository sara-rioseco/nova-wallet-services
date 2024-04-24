package com.novawallet.app.convertermenu.options;

import java.util.Scanner;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.CLPBalance;
import com.novawallet.entity.User;
import static com.novawallet.app.Utils.capitalize;
import static java.lang.Integer.parseInt;

public abstract class ConvertCLP implements MenuOption {
    public static void run(User user) {
        System.out.println(STR."""

Hello \{capitalize(user.getName())}, here you can convert CLP into USD and EUR.
------------------------------------------------------------""");
        CLPBalance amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money in CLP do you want to convert? : ");
            amount = new CLPBalance(parseInt(sc.nextLine()));
            System.out.println(amount.getAmount() <= 0
                    ? "Invalid amount, conversion failed. Please try again.\n------------------------------------------------------------"
                    : "$" + (int)amount.getAmount() + " CLP is equivalent to "
                    + "$" + Math.round(amount.convertToUSD()*100)/100 + " USD and "
                    + "$" + Math.round(amount.convertToEUR()*100)/100 + " EUR.\n------------------------------------------------------------");
        } while (amount.getAmount() <= 0);
    }
}