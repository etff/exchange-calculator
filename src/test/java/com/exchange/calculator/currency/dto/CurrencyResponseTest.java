package com.exchange.calculator.currency.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyResponseTest {

    @Test
    void currencyConvert() {
        CurrencyResponse currencyResponse = new CurrencyResponse(true, new BigDecimal(1234));

        assertThat(currencyResponse.getAmount()).isEqualTo("1,234.00");
    }

}
