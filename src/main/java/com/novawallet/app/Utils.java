package com.novawallet.app;

import java.text.DateFormat;

public class Utils {
    public static String getInitial(String word) {
        return String.valueOf(word.charAt(0)).toUpperCase();
    }
    public static String capitalize(String word) {
        return getInitial(word) + word.substring(1);
    }
    public static String formatDate(DateFormat date){
        return date.toString();
    }
}
