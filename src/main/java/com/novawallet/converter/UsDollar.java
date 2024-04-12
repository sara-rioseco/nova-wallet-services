package com.novawallet.converter;

public class UsDollar implements Currency{
    private final double amount;
    private String symbol = "USD";
    private double conversionRateInCLP = 945; // Al 11 de abril
    private double conversionRateInEUR = 0.9256; // Al 11 de abril

    public UsDollar(double amount) {
        this.amount = amount;
    }

    @Override
    public double convertToUSD() {
        System.out.println("It is not possible to convert USD to USD.");
        return amount;
    }

    @Override
    public double convertToCLP() {
        return amount*conversionRateInCLP;
    }

    @Override
    public double convertToEUR() {
        return amount*conversionRateInEUR;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getConversionRateInCLP() {
        return conversionRateInCLP;
    }

    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setConversionRateInCLP(double conversionRateInCLP) {
        this.conversionRateInCLP = conversionRateInCLP;
    }

    public void setConversionRateInEUR(double conversionRateInEUR) {
        this.conversionRateInEUR = conversionRateInEUR;
    }

    public double getAmount() {
        return amount;
    }
}

