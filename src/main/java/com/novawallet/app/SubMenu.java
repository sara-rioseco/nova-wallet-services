package com.novawallet.app;

import com.novawallet.entity.User;
import java.util.Scanner;

/**
 * The interface Sub menu.
 */
public interface SubMenu {
    /**
     * Option select.
     *
     * @param user the user
     * @param sc   the sc
     */
    void optionSelect(User user, Scanner sc);

    /**
     * Run menu.
     *
     * @param user the user
     */
    void runMenu(User user);
}
