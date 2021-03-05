package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InMemoryCurrencyRateClient implements CurrencyRateClient {

    @Override
    public ApiResponse retrieveCurrency() {
        ObjectMapper mapper = new ObjectMapper();
        String sample = getSampleData();
        ApiResponse ApiResponse = null;

        try {
            ApiResponse = mapper.readValue(sample, ApiResponse.class);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
        }
        return ApiResponse;
    }

    public String getSampleData() {
        return "{\"success\": \"true\", \"terms\":\"https:\\/\\/currencylayer.com\\/terms\", " +
                "\"timestamp\":1545881647, \"source\":\"USD\", " +
                "\"privacy\":\"https:\\/\\/currencylayer.com\\/privacy\", " +
                "\"quotes\": {\"USDAED\":3.673197, \"USDAFN\":76.088502, \"USDKRW\":1121.419945, " +
                "\"USDJPY\":110.959498 , \"USDPHP\":52.72027}}";
    }
}
