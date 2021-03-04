package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrencyApplication {
    private final CurrencyRateClient currencyRateClient;

    public CurrencyResponse getCurrencyData(String target) {
        CurrencyResponse currencyResponse = currencyRateClient.retrieveCurrency(target);
        return currencyResponse;
    }
}
