package com.exchange.calculator.currency.dto;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CurrencyResponse {
    private BigDecimal amount;

    public CurrencyResponse(BigDecimal amount) {
        this.amount = amount;
    }

    public String getAmount() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return df.format(amount);
    }
}
