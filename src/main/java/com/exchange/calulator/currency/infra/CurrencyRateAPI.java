package com.exchange.calulator.currency.infra;

import com.exchange.calulator.currency.dto.CurrencyResponse;

public interface CurrencyRateAPI {
    CurrencyResponse retrieveCurrency();
}
