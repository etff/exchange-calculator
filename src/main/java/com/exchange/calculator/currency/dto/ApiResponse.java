package com.exchange.calculator.currency.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Getter
public class ApiResponse {
    private final String PREFIX = "USD";

    private boolean success;
    private String terms;
    private String privacy;
    private int timestamp;
    private String source;
    private Map<String, BigDecimal> quotes = new HashMap<>();

    public BigDecimal getAmount(String unit) {
        Optional<BigDecimal> amount = Optional.ofNullable(quotes.get(PREFIX + unit));
        if (amount.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return amount.get().setScale(2, RoundingMode.FLOOR);
    }
}
