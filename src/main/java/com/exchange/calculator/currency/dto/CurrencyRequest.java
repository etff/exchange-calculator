package com.exchange.calculator.currency.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyRequest {
    private String target;
    private int amount;
}
