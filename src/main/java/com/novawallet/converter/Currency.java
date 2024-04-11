package com.novawallet.converter;

public interface Currency {
    String getSymbol();
    double getConversionRate();

    double convert(double amount);
}
