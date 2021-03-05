package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyApplication {
    private final CurrencyRateClient currencyRateClient;

    public CurrencyResponse getCurrencyData(String unit) {
        ApiResponse apiResponse = getApiResponse();
        return new CurrencyResponse(apiResponse.isSuccess(), apiResponse.getAmount(unit));
    }

    public CurrencyResponse calculateCurrency(CurrencyRequest request) {
        ApiResponse apiResponse = getApiResponse();
        BigDecimal result = apiResponse.getAmount(request.getUnit()).multiply(request.getAmount());
        return new CurrencyResponse(apiResponse.isSuccess(), result);
    }

    private ApiResponse getApiResponse() {
        try {
            return currencyRateClient.retrieveCurrency();
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ApiResponse();
        }
    }
}
