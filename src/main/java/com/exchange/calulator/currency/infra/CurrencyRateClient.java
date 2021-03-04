package com.exchange.calulator.currency.infra;

import com.exchange.calulator.currency.dto.CurrencyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CurrencyRateClient {
    CurrencyResponse retrieveCurrency() throws JsonProcessingException;
}
