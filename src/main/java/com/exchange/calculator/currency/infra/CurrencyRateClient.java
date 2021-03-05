package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;

import java.io.UnsupportedEncodingException;

public interface CurrencyRateClient {
    ApiResponse retrieveCurrency() throws UnsupportedEncodingException;
}
