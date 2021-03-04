package com.exchange.calulator.currency.infra;

import com.exchange.calulator.currency.dto.CurrencyResponse;
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
