package com.novawallet.entity;

public class USDBalance implements Balance {
    private final double amount;
    private double conversionRateInCLP = 945; // Al 11 de abril
    private double conversionRateInEUR = 0.9256; // Al 11 de abril

    public USDBalance(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToCLP() {
        return amount*conversionRateInCLP;
    }

    @Override
    public float convertToEUR() {
        float rounded = Math.round(amount*conversionRateInEUR*100);
        return rounded / 100;
    }

    public String getSymbol() {
        return "USD";
    }

    public double getAmount() {
        return amount;
    }

    public double getConversionRateInCLP() {
        return conversionRateInCLP;
    }

    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    public void setConversionRateInCLP(double conversionRateInCLP) {
        this.conversionRateInCLP = conversionRateInCLP;
    }

    public void setConversionRateInEUR(double conversionRateInEUR) {
        this.conversionRateInEUR = conversionRateInEUR;
    }

}

