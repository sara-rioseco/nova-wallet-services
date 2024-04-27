package com.novawallet.entity;

/**
 * The type Usd balance.
 */
public class USDBalance implements Balance {
    private final float amount;
    private double conversionRateInCLP = 945; // Al 11 de abril
    private double conversionRateInEUR = 0.9256; // Al 11 de abril

    /**
     * Instantiates a new Usd balance.
     *
     * @param amount the amount
     */
    public USDBalance(double amount) {
        this.amount = (float)amount;
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

    @Override
    public String getSymbol() {
        return "USD";
    }

    @Override
    public float getAmount() {
        return amount;
    }

    /**
     * Gets conversion rate in clp.
     *
     * @return the conversion rate in clp
     */
    public double getConversionRateInCLP() {
        return conversionRateInCLP;
    }

    /**
     * Gets conversion rate in eur.
     *
     * @return the conversion rate in eur
     */
    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    /**
     * Sets conversion rate in clp.
     *
     * @param conversionRateInCLP the conversion rate in clp
     */
    public void setConversionRateInCLP(double conversionRateInCLP) {
        this.conversionRateInCLP = conversionRateInCLP;
    }

    /**
     * Sets conversion rate in eur.
     *
     * @param conversionRateInEUR the conversion rate in eur
     */
    public void setConversionRateInEUR(double conversionRateInEUR) {
        this.conversionRateInEUR = conversionRateInEUR;
    }
}

