package com.novawallet.app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Utils.
 */
public class Utils {
    /**
     * Gets initial.
     *
     * @param word the word
     * @return the initial
     */
    public static String getInitial(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }

    /**
     * Capitalize string.
     *
     * @param word the word
     * @return the string
     */
    public static String capitalize(String word) {
        return getInitial(word) + word.substring(1);
    }

    /**
     * Format date string.
     *
     * @param dateTime the date time
     * @return the string
     */
    public static String formatDate(LocalDateTime dateTime){
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return formatDate.format(dateTime);
    }

    /**
     * Format time string.
     *
     * @param dateTime the date time
     * @return the string
     */
    public static String formatTime(LocalDateTime dateTime){
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm a");
        return formatTime.format(dateTime);
    }
}
