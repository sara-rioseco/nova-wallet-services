package com.novawallet.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColorTest {

    @Test
    void testGetColor() {
        String expectedColor = "\u001B[0m";
        Color color = Color.RESET;
        String actualColor = color.getColor();
        assertEquals(expectedColor, actualColor);
    }

    @Test
    void testValues() {
        String[] expectedColors = {
                "\u001B[0m", "\u001B[31m", "\u001B[32m", "\u001B[33m",
                "\u001B[36m", "\u001B[34m", "\u001B[37m", "\u001B[35m", "\u001B[30m"
        };
        String[] actualColors = new String[Color.values().length];
        for (int i = 0; i < Color.values().length; i++) {
            actualColors[i] = Color.values()[i].getColor();
        }
        assertArrayEquals(expectedColors, actualColors);
    }

    @Test
    void testValueOf() {
        String colorName = "RED";
        Color expectedColor = Color.RED;
        Color actualColor = Color.valueOf(colorName);
        assertEquals(expectedColor, actualColor);
    }
}