package com.novawallet.app;

public enum Color {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    CYAN("\u001B[36m"),
    BLUE("\u001B[34m"),
    WHITE("\u001B[37m"),
    PURPLE("\u001B[35m"),
    BLACK("\u001B[30m");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
