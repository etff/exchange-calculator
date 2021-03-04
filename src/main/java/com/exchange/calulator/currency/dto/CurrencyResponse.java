package com.exchange.calulator.currency.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CurrencyResponse {
    private boolean success;
    private String terms;
    private boolean privacy;
    private int timestamp;
    private String source;
    private List<Quotes> quotes = new ArrayList<>();
}
