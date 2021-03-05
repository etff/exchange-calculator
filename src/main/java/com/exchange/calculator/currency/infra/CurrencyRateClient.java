package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;

public interface CurrencyRateClient {
    ApiResponse retrieveCurrency(String target);
}
