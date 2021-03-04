package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class InMemoryCurrencyRateClient implements CurrencyRateClient {

    @Override
    public CurrencyResponse retrieveCurrency(String target) {
        ObjectMapper mapper = new ObjectMapper();
        String sample = getSampleData();
        CurrencyResponse currencyResponse = null;

        try {
            currencyResponse = mapper.readValue(sample, CurrencyResponse.class);

        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
        }
        return currencyResponse;
    }

    public String getSampleData() {
        return "{\"success\": \"true\", \"terms\":\"https:\\/\\/currencylayer.com\\/terms\", " +
                "\"timestamp\":1545881647, \"source\":\"USD\", " +
                "\"privacy\":\"https:\\/\\/currencylayer.com\\/privacy\", " +
                "\"quotes\": {\"USDAED\":3.673197, \"USDAFN\":76.088502, \"USDKRW\":1121.419945, " +
                "\"USDJPY\":110.959498 , \"USDPHP\":52.72027}}";
    }
}
