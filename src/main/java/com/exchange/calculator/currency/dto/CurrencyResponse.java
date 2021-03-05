package com.exchange.calculator.currency.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 환율 수취 금액.
 */
public class CurrencyResponse {
    /**
     * 응답 성공 여부.
     */
    private boolean success;
    /**
     * 수취 금액.
     */
    private BigDecimal amount;

    public CurrencyResponse(boolean success, BigDecimal amount) {
        this.success = success;
        this.amount = amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAmount() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(amount);
    }
}
