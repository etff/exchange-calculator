package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.predicate;
import static org.junit.jupiter.api.Assertions.assertAll;


class InMemoryCurrencyRateClientTest {

    @DisplayName("미리 저장된 환율 데이터를 가져옵니다.")
    @Test
    void getInMemoryData() {
        InMemoryCurrencyRateClient inMemoryCurrencyRateAPI = new InMemoryCurrencyRateClient();

        ApiResponse actual = inMemoryCurrencyRateAPI.retrieveCurrency();

        assertAll(
                () -> assertThat(actual.isSuccess()).isNotNull(),
                () -> assertThat(actual.getSource()).isNotNull(),
                () -> assertThat(actual.getPrivacy()).isNotNull()
        );
    }

    @DisplayName("화폐단위에 해당하는 환율정보를 가져옵니다.")
    @Test
    void getQuotesData() {
        InMemoryCurrencyRateClient inMemoryCurrencyRateAPI = new InMemoryCurrencyRateClient();

        ApiResponse actual = inMemoryCurrencyRateAPI.retrieveCurrency();
        String existUnit = "KRW";

        assertThat(actual.getAmount(existUnit)).isNotNull();
    }
}
