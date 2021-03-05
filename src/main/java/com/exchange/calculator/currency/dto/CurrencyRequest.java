package com.exchange.calculator.currency.dto;

import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

/**
 * 화폐 계산 요청 명세서.
 */
@Getter
public class CurrencyRequest {
    /**
     * 화폐 단위
     */
    @NotBlank
    private String unit;

    /**
     * 송금액.
     */
    @Positive(message = "송금액이 바르지 않습니다")
    @Max(value = 10000, message = "송금액이 바르지 않습니다")
    private BigDecimal amount;
}
