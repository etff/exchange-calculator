package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyApplication {
    private final String PREFIX = "USD";
    private final CurrencyRateClient currencyRateClient;

    public CurrencyResponse getCurrencyData(String target) {
        ApiResponse apiResponse = currencyRateClient.retrieveCurrency(target);
        BigDecimal amount = apiResponse.getAmount(PREFIX + target);
        return new CurrencyResponse(apiResponse.isSuccess(), amount);
    }
}
