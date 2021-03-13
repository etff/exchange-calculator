package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import com.exchange.calculator.domain.Currency;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

/**
 * 환율 정보를 다룬다.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class CurrencyApplication {
    private final CurrencyRateClient currencyRateClient;

    /**
     * 환율 정보를 가져온다.
     * @param unit 수취국가 화폐 단위
     * @return 수취국가 환율 정보
     * @throws UnsupportedEncodingException
     */
    public CurrencyResponse getCurrencyData(String unit) throws UnsupportedEncodingException {
        final ApiResponse apiResponse = getApiResponse();
        return new CurrencyResponse(apiResponse.isSuccess(), Currency.of(apiResponse.getAmount(unit)));
    }

    /**
     * 환율 수취 금액을 계산한다.
     * @param request 환율 계산 요청
     * @return 계산된 환율 수취 금액
     * @throws UnsupportedEncodingException
     */
    public CurrencyResponse calculateCurrency(CurrencyRequest request) throws UnsupportedEncodingException {
        final ApiResponse apiResponse = getApiResponse();

        final BigDecimal apiResponseAmount = apiResponse.getAmount(request.getUnit());
        final Currency unitCurrency = Currency.of(apiResponseAmount);
        final Currency currencyResult = unitCurrency.times(request.getAmount());

        return new CurrencyResponse(apiResponse.isSuccess(), currencyResult);
    }

    private ApiResponse getApiResponse() throws UnsupportedEncodingException {
        return currencyRateClient.retrieveCurrency();
    }
}
