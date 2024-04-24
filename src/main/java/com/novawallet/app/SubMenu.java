package com.novawallet.app;

import com.novawallet.entity.User;

import java.util.Scanner;

public interface SubMenu {
    void optionSelect(User user, Scanner sc);
    void runMenu(User user);
}
