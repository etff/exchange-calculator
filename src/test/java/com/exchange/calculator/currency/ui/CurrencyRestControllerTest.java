package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.application.CurrencyApplication;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("CurrencyRestController 클래스")
class CurrencyRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyApplication currencyApplication;

    @Autowired
    protected ObjectMapper objectMapper;

    @Nested
    @DisplayName("GET /api/getCurrency는")
    class Describe_getCurrency {
        @Nested
        @DisplayName("환율 정보와 화폐단위가 주어지면")
        class Context_with_currency_with_unit {
            CurrencyResponse response;
            String unit = "KRW";

            @BeforeEach
            void setUp() throws UnsupportedEncodingException {
                response = new CurrencyResponse(true, BigDecimal.valueOf(1000));

                given(currencyApplication.getCurrencyData(eq(unit)))
                        .willReturn(response);
            }

            @DisplayName("200 OK 와 환율 정보 응답한다.")
            @Test
            void It_responds_ok_with_currency() throws Exception {
                mockMvc.perform(get("/api/currency").param("unit", unit))
                        .andExpect(status().isOk())
                        .andExpect(content().string(objectMapper.writeValueAsString(response)));
            }
        }
    }

    @Nested
    @DisplayName("post /api/currency/calculate 는")
    class Describe_calculate {

        @Nested
        @DisplayName("유효한 환율 계산 요청이 주어지면")
        class Context_with_valid_currency_request {
            CurrencyRequest request;
            CurrencyResponse response;

            @BeforeEach
            void setUp() throws UnsupportedEncodingException {
                request = new CurrencyRequest("KRW", BigDecimal.valueOf(100));
                response = new CurrencyResponse(true, BigDecimal.valueOf(1000));

                given(currencyApplication.calculateCurrency(any(CurrencyRequest.class)))
                        .willReturn(response);
            }

            @DisplayName("200 OK 와 환율 정보 응답한다.")
            @Test
            void It_responds_ok_with_currency() throws Exception {
                mockMvc.perform(post("/api/currency/calculate")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isOk())
                        .andExpect(content().string(objectMapper.writeValueAsString(response)));
            }
        }

        @Nested
        @DisplayName("10000 보다 큰 금액 환율 계산 요청이 주어지면")
        class Context_with_invalid_amount_currency_request {
            CurrencyRequest request;

            @BeforeEach
            void setUp() throws UnsupportedEncodingException {
                request = new CurrencyRequest("KRW", BigDecimal.valueOf(1000_000));
            }

            @DisplayName("200 OK 와 환율 정보 응답한다.")
            @Test
            void It_responds_bad_request() throws Exception {
                mockMvc.perform(post("/api/currency/calculate")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(request)))
                        .andExpect(status().isBadRequest());
            }
        }
    }
}