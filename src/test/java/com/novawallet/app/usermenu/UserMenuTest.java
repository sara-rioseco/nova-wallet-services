package com.novawallet.app.usermenu;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import com.novawallet.entity.User;
import com.novawallet.app.usermenu.UserMenu;
import com.novawallet.app.usermenu.options.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Disabled
class UserMenuTest {

    private UserMenu userMenuMock;

    @BeforeEach
    public void setup() {
        userMenuMock = spy(new UserMenu());
    }

    @Test
    void testRunMenu() {
        User loggedInUser = mock(User.class);
        String simulatedInput = "1\n7\n";
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner sc = new Scanner(inputStream);

        userMenuMock.runMenu(loggedInUser);

        verify(userMenuMock).optionSelect(eq(loggedInUser), any(Scanner.class));
        verify(userMenuMock).printOptions();
    }

    @Test
    void testOptionSelect() {
        User loggedInUser = mock(User.class);
        Scanner sc = mock(Scanner.class);
        when(sc.nextLine()).thenReturn("1", "7");
        userMenuMock.optionSelect(loggedInUser, sc);
        verify(userMenuMock).printOptions();
        verify(userMenuMock).runMenu(eq(loggedInUser));
    }

    @Test
    void testPrintOptions() {
    }
}