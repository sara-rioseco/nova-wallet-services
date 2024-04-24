package com.novawallet.entity;

public interface Balance {
    String getSymbol();
    float getAmount();

    default float convertToUSD() {
        return 0;
    }

    default double convertToCLP() {
        return 0;
    }

    default float convertToEUR() {
        return 0;
    }
}
