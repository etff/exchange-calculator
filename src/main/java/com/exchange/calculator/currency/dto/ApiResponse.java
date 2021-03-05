package com.exchange.calculator.currency.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class ApiResponse {
    private boolean success;
    private String terms;
    private String privacy;
    private int timestamp;
    private String source;
    private Map<String, BigDecimal> quotes = new HashMap<>();

    public BigDecimal getAmount(String unit) {
        Optional<BigDecimal> amount = Optional.ofNullable(quotes.get(unit));
        if (amount.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return amount.get();
    }
}
