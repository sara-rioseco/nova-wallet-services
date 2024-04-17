package com.novawallet.app.convertermenu.converter;

public interface Currency {
    double convertToUSD();
    double convertToCLP();
    double convertToEUR();
    String getSymbol();
    double getAmount();
}
