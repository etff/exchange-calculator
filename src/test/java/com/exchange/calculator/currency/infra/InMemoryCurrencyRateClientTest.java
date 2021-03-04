package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.CurrencyResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InMemoryCurrencyRateClientTest {


    @Test
    void test() {
        InMemoryCurrencyRateClient inmemoryCurrencyRateAPI = new InMemoryCurrencyRateClient();

        CurrencyResponse actual = inmemoryCurrencyRateAPI.retrieveCurrency();

        assertThat(actual).isNotNull();
    }
}
