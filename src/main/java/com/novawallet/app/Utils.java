package com.novawallet.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String getInitial(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }
    public static String capitalize(String word) {
        return getInitial(word) + word.substring(1);
    }
    public static String formatDate(LocalDateTime dateTime){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatDate.format(dateTime);
    }

    public static String formatTime(LocalDateTime dateTime){
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");
        return formatTime.format(dateTime);
    }
}
