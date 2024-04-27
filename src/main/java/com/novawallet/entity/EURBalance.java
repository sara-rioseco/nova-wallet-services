package com.novawallet.entity;

/**
 * The type Eur balance.
 */
public class EURBalance implements Balance {
    private final float amount;
    private double conversionRateInCLP = 1021; // Al 11 de abril
    private double conversionRateInUSD = 1.08; // Al 11 de abril

    /**
     * Instantiates a new Eur balance.
     *
     * @param amount the amount
     */
    public EURBalance(double amount) {
        this.amount = (float)amount;
    }

    @Override
    public float convertToUSD() {
        float rounded = Math.round(amount*conversionRateInUSD*100);
        return rounded / 100;
    }

    @Override
    public double convertToCLP() {
        float rounded = Math.round(amount*conversionRateInCLP*100);
        return rounded / 100;
    }

    @Override
    public String getSymbol() {
        return "EUR";
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
     * Gets conversion rate in usd.
     *
     * @return the conversion rate in usd
     */
    public double getConversionRateInUSD() {
        return conversionRateInUSD;
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
     * Sets conversion rate in usd.
     *
     * @param conversionRateInUSD the conversion rate in usd
     */
    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
    }
}

