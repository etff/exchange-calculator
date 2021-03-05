package com.exchange.calculator.currency.application;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.currency.infra.CurrencyRateClient;
import com.exchange.calculator.currency.infra.InMemoryCurrencyRateClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CurrencyApplicationTest {
    private CurrencyApplication currencyApplication;
    private ApiResponse apiResponse;
    private CurrencyRequest request;

    @Mock
    private CurrencyRateClient currencyRateClient;

    @BeforeEach
    void setUp() {
        currencyApplication = new CurrencyApplication(currencyRateClient);

        Map<String, BigDecimal> map = new HashMap<>() {
            {
                put("USDKRW", BigDecimal.valueOf(1121.41));
            }
        };

        apiResponse =  ApiResponse.builder()
                .success(true)
                .privacy("https://currencylayer.com/privacy")
                .terms("https://currencylayer.com//terms")
                .source("USD")
                .quotes(map)
                .timestamp(1545881647)
                .build();

        request = new CurrencyRequest("KRW", BigDecimal.valueOf(100));
    }

    @DisplayName("환율 정보를 가져와 성공여부와 환율 금액을 리턴합니다.")
    @Test
    void getCurrencyData() throws UnsupportedEncodingException {
        given(currencyRateClient.retrieveCurrency()).willReturn(apiResponse);

        String existUnit = "KRW";
        CurrencyResponse currencyData = currencyApplication.getCurrencyData(existUnit);

        assertThat(currencyData.isSuccess()).isTrue();
        assertThat(currencyData.getAmount()).isEqualTo("1,121.41");
    }

    @DisplayName("송금 금액에 해당하는 환율 수취금액 리턴합니다.")
    @Test
    void calculateCurrency() throws UnsupportedEncodingException {
        given(currencyRateClient.retrieveCurrency()).willReturn(apiResponse);

        CurrencyResponse currencyData = currencyApplication.calculateCurrency(request);

        assertThat(currencyData.isSuccess()).isTrue();
        assertThat(currencyData.getAmount()).isEqualTo("112,141.00");
    }
}