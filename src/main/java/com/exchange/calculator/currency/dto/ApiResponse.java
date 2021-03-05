package com.exchange.calculator.currency.dto;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * API 응답데이터.
 */
@Getter
public class ApiResponse {
    private final String PREFIX = "USD";

    /**
     * 응답 성공 여부.
     */
    private boolean success;
    /**
     * 사이트 이용약관.
     */
    private String terms;

    /**
     * 사이트 개인정보 정책.
     */
    private String privacy;

    /**
     * 요청시간.
     */
    private int timestamp;

    /**
     * 기준 화폐 단위.
     */
    private String source;

    /**
     * 기준 화폐 대비 환율 정보.
     */
    private Map<String, BigDecimal> quotes = new HashMap<>();

    public BigDecimal getAmount(String unit) {
        Optional<BigDecimal> amount = Optional.ofNullable(quotes.get(PREFIX + unit));
        if (amount.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return amount.get().setScale(2, RoundingMode.FLOOR);
    }
}
