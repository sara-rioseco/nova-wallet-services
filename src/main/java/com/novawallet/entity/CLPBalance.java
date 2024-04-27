package com.novawallet.entity;

/**
 * The type Clp balance.
 */
public class CLPBalance implements Balance {
    private final double amount;
    private double conversionRateInUSD = 0.00106; // Al 11 de abril
    private double conversionRateInEUR = 0.00098; // Al 11 de abril

    /**
     * Instantiates a new Clp balance.
     *
     * @param amount the amount
     */
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

    @Override
    public float getAmount() {
        return (float)amount;
    }

    @Override
    public String getSymbol() {
        return "CLP";
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
     * Gets conversion rate in eur.
     *
     * @return the conversion rate in eur
     */
    public double getConversionRateInEUR() {
        return conversionRateInEUR;
    }

    /**
     * Sets conversion rate in usd.
     *
     * @param conversionRateInUSD the conversion rate in usd
     */
    public void setConversionRateInUSD(double conversionRateInUSD) {
        this.conversionRateInUSD = conversionRateInUSD;
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
