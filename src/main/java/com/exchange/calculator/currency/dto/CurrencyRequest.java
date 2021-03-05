package com.exchange.calculator.currency.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class CurrencyRequest {
    private String target;

    @Positive
    @Max(value = 10000)
    private int amount;
}
