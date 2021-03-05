package com.exchange.calculator.currency.infra;

import com.exchange.calculator.currency.dto.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;

/**
 * 외부 API를 이용해 환율정보를 가져옵니다.
 */
@Component
@Primary
@Slf4j
public class ApiCurrencyRateClient implements CurrencyRateClient {
    private static String BASE_URL = "http://www.apilayer.net/api/live";
    private static String UTF8 = "UTF-8";

    @Value("${currency-layer.key}")
    private String serviceKey;

    /**
     * 환율 정보를 가져옵니다.
     * @return API 응답결과
     * @throws UnsupportedEncodingException
     */
    @Override
    public ApiResponse retrieveCurrency() throws UnsupportedEncodingException {
        final ObjectMapper mapper = new ObjectMapper();
        final ResponseEntity<String> respEntity = getCurrencyFromApi();
        final String body = respEntity.getBody();
        ApiResponse ApiResponse;

        try {
            ApiResponse = mapper.readValue(body, ApiResponse.class);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
            ApiResponse = new ApiResponse();
        }
        return ApiResponse;
    }

    private ResponseEntity<String> getCurrencyFromApi() throws UnsupportedEncodingException {
        final String decodeServiceKey = URLDecoder.decode(serviceKey, UTF8);
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName(UTF8)));    //Response Header to UTF-8

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
                .queryParam("access_key", decodeServiceKey)
                .build(false);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, new HttpEntity<String>(headers), String.class);
    }
}
