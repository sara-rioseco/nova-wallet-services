package com.novawallet;

import com.novawallet.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@Disabled
class MainTest {
    private ArrayList<User> usersMock;

    @BeforeEach
    public void setup() {
        // Create a mock ArrayList<User> for testing
        usersMock = mock(ArrayList.class);
    }

    @Test
    public void testMainMethod() {
        // Arrange
        Main main = new Main();


        // Mock the behavior of ArrayList<User> to return a mock user list
        when(usersMock.size()).thenReturn(0);
        when(usersMock.add(any(User.class))).thenReturn(true);
        when(usersMock.get(anyInt())).thenReturn(mock(User.class));

        // Create simulated input for the main method
        String simulatedInput = "3\n"; // Simulate entering "1" as input
        InputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(inputStream);

        // Act
        main.main(new String[0]);

        // Assert
        // Add your assertions here based on the expected behavior of the main method
        // For example, verify that certain methods were called on the mock objects
        verify(usersMock, atLeastOnce()).size();
        verify(usersMock, atLeastOnce()).add(any(User.class));
        verify(usersMock, atLeastOnce()).get(anyInt());
    }
}