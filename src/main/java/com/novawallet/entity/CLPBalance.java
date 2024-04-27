package com.novawallet.entity;

public class CLPBalance implements Balance {
    private final double amount;
    private double conversionRateInUSD = 0.00106; // Al 11 de abril
    private double conversionRateInEUR = 0.00098; // Al 11 de abril

    public CLPBalance(double amount) {
        this.amount = amount;
    }

    @Override
    public float convertToUSD() {
        float rounded = Math.round(amount*conversionRateInUSD*100);
        return rounded / 100;
    }

    @Override
    public float convertToEUR() {
        float rounded = Math.round(amount*conversionRateInEUR*100);
        return rounded / 100;
    }

    public float getAmount() {
        return (float)amount;
    }

    public String getSymbol() {
        return "CLP";
    }

    public double getConversionRateInUSD() {
        return conversionRateInUSD;
    }

    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
    }

    public void setConversionRateInEUR(double conversionRateInEUR) {
        this.conversionRateInEUR = conversionRateInEUR;
    }

}
