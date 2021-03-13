package com.exchange.calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class CurrencyTest {
    @DisplayName("금액을 입력받아 가격객체를 생성한다")
    @Test
    void create() {
        Currency currency = Currency.of(1000);

        assertThat(currency.getAmount()).isEqualTo(BigDecimal.valueOf(1000));
    }

    @Test
    void plus() {
        Currency currency = Currency.of(1000);
        Currency currency2 = Currency.of(1000);

        Currency result = currency.plus(currency2);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(2000));
    }

    @Test
    void minus() {
        Currency currency = Currency.of(1000);
        Currency currency2 = Currency.of(1000);

        Currency result = currency.minus(currency2);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(0));
    }

    @Test
    void times() {
        Currency currency = Currency.of(1000);

        Currency result = currency.times(BigDecimal.TEN);
        assertThat(result.getAmount()).isEqualTo(BigDecimal.valueOf(10000.0));
    }
}
