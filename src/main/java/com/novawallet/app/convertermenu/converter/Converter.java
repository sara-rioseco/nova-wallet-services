package com.novawallet.app.convertermenu.converter;

import com.novawallet.app.usermenu.UserMenu;
import com.novawallet.entity.User;

import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Converter {

    static final String ANSI_RESET = "\u001B[0m";
    static final String ANSI_RED = "\u001B[31m";
    static final String ANSI_YELLOW = "\u001B[33m";

    public void converter(User user) {
        int opt;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nWhat conversion do you want to do?\n");
            System.out.println("""
                      1.Convert from USD to CLP
                      2.Convert from CLP to USD
                      3.Convert from USD to EUR
                      4.Convert from EUR to USD
                      5.Convert from CLP to EUR
                      6.Convert from EUR to CLP
                    """);
            System.out.println("Once you write the option, " + ANSI_YELLOW + "press ENTER" + ANSI_RESET + ".");
            System.out.println("To go back to the main manu " + ANSI_RED + "press any other number" + ANSI_RESET + ".\n");
            System.out.print("Please chose an option: ");
            opt = parseInt(sc.nextLine());
            switch (opt) {
                case 1:
                    System.out.print("\nPlease enter the amount in USD to convert to CLP: ");
                    UsDollar usDollar1 = new UsDollar(parseDouble(sc.nextLine()));
                    System.out.println("\n" + usDollar1.getAmount() + " " +  usDollar1.getSymbol()
                            + " is equal to $" + usDollar1.convertToCLP()
                            + " CLP\n----------------------------------------");
                    break;
                case 2:
                    System.out.print("\nPlease enter the amount in CLP to convert to USD: ");
                    ChileanPeso chileanPeso1 = new ChileanPeso(parseDouble(sc.nextLine()));
                    System.out.println("\n" + chileanPeso1.getAmount() + " " +  chileanPeso1.getSymbol()
                            + " is equal to $" + chileanPeso1.convertToUSD()
                            + " USD\n----------------------------------------");
                    break;
                case 3:
                    System.out.print("\nPlease enter the amount in USD to convert to EUR: ");
                    UsDollar usDollar2 = new UsDollar(parseDouble(sc.nextLine()));
                    System.out.println("\n" + usDollar2.getAmount() + " " +  usDollar2.getSymbol()
                            + " is equal to $" + usDollar2.convertToEUR()
                            + " EUR\n----------------------------------------");
                    break;
                case 4:
                    System.out.print("\nPlease enter the amount in EUR to convert to USD: ");
                    Euro euro1 = new Euro(parseDouble(sc.nextLine()));
                    System.out.println("\n" + euro1.getAmount() + " " +  euro1.getSymbol()
                            + " is equal to $" + euro1.convertToUSD()
                            + " USD\n----------------------------------------");
                    break;
                case 5:
                    System.out.print("\nPlease enter the amount in CLP to convert to EUR: ");
                    ChileanPeso chileanPeso2 = new ChileanPeso(parseDouble(sc.nextLine()));
                    System.out.println("\n" + chileanPeso2.getAmount() + " " + chileanPeso2.getSymbol()
                            + " is equal to $" + chileanPeso2.convertToEUR()
                            + " EUR\n----------------------------------------");
                    break;
                case 6:
                    System.out.print("\nPlease enter the amount in EUR to convert to CLP: ");
                    Euro euro2 = new Euro(parseDouble(sc.nextLine()));
                    System.out.println("\n" + euro2.getAmount() + " " +  euro2.getSymbol()
                            + " is equal to $" + euro2.convertToCLP()
                            + " CLP\n----------------------------------------");
                    break;
                default:
                    System.out.println("----------------------------------------\n    You'll go back to the main menu.\n----------------------------------------");
                    UserMenu menu = new UserMenu();
                    menu.userMenu(user);
            }
        } while (opt > 0 && opt < 7);
    }
}