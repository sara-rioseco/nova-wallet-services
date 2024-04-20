package com.novawallet.app;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UtilsTest {

    @Test
    void getInitialTest() {
        String string = "test";
        assertEquals("T", Utils.getInitial(string));
    }

    @Test
    void capitalizeTest() {
        String string = "test";
        assertEquals("Test", Utils.capitalize(string));
    }

    @Test
    void formatDateTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String date = Utils.formatDate(localDateTime);
        assertEquals(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(localDateTime), date);
    }

    @Test
    void formatTimeTest() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String time = Utils.formatTime(localDateTime);
        assertEquals(DateTimeFormatter.ofPattern("hh:mm a").format(localDateTime), time);
    }
}