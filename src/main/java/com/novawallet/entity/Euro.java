package com.novawallet.entity;

public class Euro implements Currency {
    private final double amount;
    private double conversionRateInCLP = 1021; // Al 11 de abril
    private double conversionRateInUSD = 1.08; // Al 11 de abril

    public Euro(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUSD() {
        float rounded = Math.round(amount*conversionRateInUSD*100);
        return rounded / 100;
    }

    @Override
    public double convertToCLP() {
        float rounded = Math.round(amount*conversionRateInCLP*100);
        return rounded / 100;
    }

    public String getSymbol() {
        return "EUR";
    }

    public double getAmount() {
        return amount;
    }

    public double getConversionRateInCLP() {
        return conversionRateInCLP;
    }

    public double getConversionRateInUSD() {
        return conversionRateInUSD;
    }

    public void setConversionRateInCLP(double conversionRateInCLP) {
        this.conversionRateInCLP = conversionRateInCLP;
    }

    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
    }
}

