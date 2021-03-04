package com.exchange.calculator.currency.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
public class CurrencyResponse {
    private boolean success;
    private String terms;
    private String privacy;
    private int timestamp;
    private String source;
    private Map<String, BigDecimal> quotes = new HashMap<>();
}
