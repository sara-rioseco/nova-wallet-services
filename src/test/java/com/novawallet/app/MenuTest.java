package com.novawallet.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class MenuTest {

    @Test
    void printOptions() {
        Menu mockMenu = mock(Menu.class);
        doNothing().when(mockMenu).printOptions();
        mockMenu.printOptions();
    }
}