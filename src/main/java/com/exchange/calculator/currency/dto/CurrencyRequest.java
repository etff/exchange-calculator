package com.exchange.calculator.currency.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Getter
public class CurrencyRequest {
    @NotBlank
    private String target;

    @Positive(message = "송금액이 바르지 않습니다")
    @Max(value = 10000, message = "aaaa")
    private int amount;
}
