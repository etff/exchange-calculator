package com.exchange.calculator.currency.gloabl.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private boolean success;
    private String message;
    private Object data;

    public ErrorResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
