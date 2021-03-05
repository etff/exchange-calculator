package com.exchange.calculator.currency.dto;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ApiResponseTest {

    @Test
    void test() {
        ApiResponse apiResponse = new ApiResponse();
        BigDecimal aaa = apiResponse.getAmount("aaa");

        assertThat(aaa).isEqualTo(444);
    }
}
