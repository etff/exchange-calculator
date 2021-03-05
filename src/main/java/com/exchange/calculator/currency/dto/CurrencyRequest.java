package com.exchange.calculator.currency.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
public class CurrencyRequest {
    @NotBlank
    private String unit;

    @Positive(message = "송금액이 바르지 않습니다")
    @Max(value = 10000, message = "송금액이 바르지 않습니다")
    private BigDecimal amount;
}
