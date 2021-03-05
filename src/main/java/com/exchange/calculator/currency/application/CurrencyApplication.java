package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CurrencyApplication {
    private final CurrencyRateClient currencyRateClient;

    public CurrencyResponse getCurrencyData(String unit) {
        ApiResponse apiResponse = getApiResponse();
        return new CurrencyResponse(apiResponse.isSuccess(), apiResponse.getAmount(unit));
    }

    public CurrencyResponse calculateCurrency(CurrencyRequest currencyRequest) {
        ApiResponse apiResponse = getApiResponse();

        return null;
    }

    private ApiResponse getApiResponse() {
        return currencyRateClient.retrieveCurrency();
    }
}
