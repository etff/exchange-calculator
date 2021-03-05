package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 메모리상의 환율 정보를 가져옵니다.
 */
@Component
@Slf4j
public class InMemoryCurrencyRateClient implements CurrencyRateClient {

    /**
     * 환율 정보를 가져옵니다.
     */
    @Override
    public ApiResponse retrieveCurrency() {
        final ObjectMapper mapper = new ObjectMapper();
        final String sample = getSampleData();
        ApiResponse apiResponse;

        try {
            apiResponse = mapper.readValue(sample, ApiResponse.class);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
            apiResponse = new ApiResponse();
        }
        return apiResponse;
    }

    public String getSampleData() {
        return "{\"success\": \"true\", \"terms\":\"https:\\/\\/currencylayer.com\\/terms\", " +
                "\"timestamp\":1545881647, \"source\":\"USD\", " +
                "\"privacy\":\"https:\\/\\/currencylayer.com\\/privacy\", " +
                "\"quotes\": {\"USDAED\":3.673197, \"USDAFN\":76.088502, \"USDKRW\":1121.419945, " +
                "\"USDJPY\":110.959498 , \"USDPHP\":52.72027}}";
    }
}
