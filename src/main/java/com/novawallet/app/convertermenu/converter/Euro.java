package com.novawallet.app.convertermenu.converter;

public class Euro implements Currency{
    private final double amount;
    private String symbol = "EUR";
    private double conversionRateInCLP = 1021; // Al 11 de abril
    private double conversionRateInUSD = 1.0803; // Al 11 de abril

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

    @Override
    public double convertToEUR() {
        System.out.println("It is not possible to convert EUR to EUR.");
        return amount;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getConversionRateInCLP() {
        return conversionRateInCLP;
    }

    public double getConversionRateInUSD() {
        return conversionRateInUSD;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setConversionRateInCLP(double conversionRateInCLP) {
        this.conversionRateInCLP = conversionRateInCLP;
    }

    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
    }

    public double getAmount() {
        return amount;
    }
}

