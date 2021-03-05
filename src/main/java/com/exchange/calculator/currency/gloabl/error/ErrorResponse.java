package com.exchange.calculator.currency.gloabl.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 에러 응답결과.
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    /**
     * 응답 성공여부.
     */
    private boolean success;
    /**
     * 응답 메시지.
     */
    private String message;

    public ErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
