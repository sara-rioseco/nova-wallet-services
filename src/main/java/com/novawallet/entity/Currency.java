package com.novawallet.entity;

public interface Currency {
    String getSymbol();
    double getAmount();

    default double convertToUSD() {
        return 0;
    }

    default double convertToCLP() {
        return 0;
    }

    default double convertToEUR() {
        return 0;
    }
}
