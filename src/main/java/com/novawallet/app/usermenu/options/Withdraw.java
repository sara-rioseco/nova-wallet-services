package com.novawallet.app.usermenu.options;

import com.novawallet.app.MenuOption;
import com.novawallet.entity.Transaction;
import com.novawallet.entity.User;

import java.util.Scanner;

import static com.novawallet.entity.TransactionType.WITHDRAWAL;
import static java.lang.Integer.parseInt;

public abstract class Withdraw implements MenuOption {
    public static User run(User user) {
        System.out.println("\nHere you can withdraw money in " + user.getBalanceCurrency() + " from your account.\n------------------------------------------------------------");
        double amount;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.print("How much money are you going to withdraw in " + user.getBalanceCurrency() + "? : ");
            amount = parseInt(sc.nextLine());
            System.out.println(amount <= 0
                    ? "Invalid amount, withdraw failed. Please try again.\n------------------------------------------------------------"
                    : amount > user.getBalanceAmount()
                    ? "Not enough funds, withdraw failed. Please try again.\n------------------------------------------------------------"
                    : "Successfully withdraw funds.\n------------------------------------------------------------");
        } while (amount <= 0 || amount > user.getBalanceAmount());
        Transaction transaction = new Transaction(user.getTransactions().size()+1, amount, WITHDRAWAL, user.getId(), user.getId());
        user.withdrawMoney(amount);
        user.addTransaction(transaction);
        return user;
    }
}
