package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.CurrencyResponse;

public interface CurrencyRateClient {
    CurrencyResponse retrieveCurrency();
}
