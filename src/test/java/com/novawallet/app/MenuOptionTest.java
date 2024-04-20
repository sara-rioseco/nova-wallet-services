package com.novawallet.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

class MenuOptionTest {

    @Test
    void testRun() {
        MenuOption mockMenuOption = mock(MenuOption.class);
        doNothing().when(mockMenuOption).run();
        mockMenuOption.run();
    }
}