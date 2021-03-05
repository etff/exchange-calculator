package com.exchange.calculator.currency.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CurrencyResponse {
    private boolean success;
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
