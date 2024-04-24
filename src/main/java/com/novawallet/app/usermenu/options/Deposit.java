package com.novawallet.app.usermenu.options;

import java.util.Scanner;
import com.novawallet.app.MenuOption;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;
import static com.novawallet.entity.TransactionType.DEPOSIT;
import static java.lang.Integer.parseInt;

public abstract class Deposit implements MenuOption {

    public static User run(User user) {

        System.out.println("\nHere you can deposit funds in "+ user.getBalanceCurrency()+" to your account.\n------------------------------------------------------------");
        double amount;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money are you going to deposit? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0
                    ? "Invalid amount, deposit failed. Please try again.\n------------------------------------------------------------"
                    : "Successfully deposited funds.\n------------------------------------------------------------");
        } while (amount <= 0);

        Transaction transaction = new Transaction(user.getTransactions().size()+1, amount, DEPOSIT, user.getId(), user.getId());
        user.addBalance(amount);
        user.addTransaction(transaction);
        return user;
    }
}
