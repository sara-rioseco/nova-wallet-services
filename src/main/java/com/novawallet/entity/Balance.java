package com.novawallet.entity;

/**
 * The interface Balance.
 */
public interface Balance {
    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    String getSymbol();

    /**
     * Gets amount.
     *
     * @return the amount
     */
    float getAmount();

    /**
     * Convert to usd float.
     *
     * @return the float
     */
    default float convertToUSD() {
        return 0;
    }

    /**
     * Convert to clp double.
     *
     * @return the double
     */
    default double convertToCLP() {
        return 0;
    }

    /**
     * Convert to eur float.
     *
     * @return the float
     */
    default float convertToEUR() {
        return 0;
    }
}
