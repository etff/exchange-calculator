package com.exchange.calculator.currency.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * API 응답데이터.
 */
@Getter
@NoArgsConstructor
public class ApiResponse {
    private static final String PREFIX = "USD";
    private static final int DECIMAL_POINT = 2;

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

    @Builder
    public ApiResponse(boolean success, String terms, String privacy, int timestamp, String source, Map<String, BigDecimal> quotes) {
        this.success = success;
        this.terms = terms;
        this.privacy = privacy;
        this.timestamp = timestamp;
        this.source = source;
        this.quotes = quotes;
    }

    public BigDecimal getAmount(String unit) {
        Optional<BigDecimal> amount = Optional.ofNullable(quotes.get(PREFIX + unit));
        if (amount.isEmpty()) {
            return BigDecimal.ZERO;
        }
        return amount.get().setScale(DECIMAL_POINT, RoundingMode.FLOOR);
    }
}
