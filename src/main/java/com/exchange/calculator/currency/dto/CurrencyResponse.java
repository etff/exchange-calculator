package com.exchange.calculator.currency.dto;

import com.exchange.calculator.domain.Currency;

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
    private Currency amount;

    public CurrencyResponse(boolean success, Currency amount) {
        this.success = success;
        this.amount = amount;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getAmount() {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(amount.getAmount());
    }
}
