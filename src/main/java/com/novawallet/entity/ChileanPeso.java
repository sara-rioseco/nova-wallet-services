package com.novawallet.entity;

public class ChileanPeso implements Currency {
    private final double amount;
    private String symbol = "CLP";
    private double conversionRateInUSD = 0.00106; // Al 11 de abril
    private double conversionRateInEUR = 0.00098; // Al 11 de abril

    public ChileanPeso(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUSD() {
        float rounded = Math.round(amount*conversionRateInUSD*100);
        return rounded / 100;
    }

    @Override
    public double convertToEUR() {
        float rounded = Math.round(amount*conversionRateInEUR*100);
        return rounded / 100;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getConversionRateInUSD() {
        return conversionRateInUSD;
    }

    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
    }

    public void setConversionRateInEUR(double conversionRateInEUR) {
        this.conversionRateInEUR = conversionRateInEUR;
    }

    public double getAmount() {
        return amount;
    }
}
