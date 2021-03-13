package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.application.CurrencyApplication;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import com.exchange.calculator.domain.Currency;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.UnsupportedEncodingException;

/**
 * 환율에 대한 사용자 요청을 처리한다.
 */
@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyRestController {
    private final CurrencyApplication currencyApplication;

    /**
     * 환율 정보를 가져온다.
     * @param unit 수취국가 화폐 단위
     * @return 수취국가 환율 정보
     * @throws UnsupportedEncodingException
     */
    @GetMapping
    public CurrencyResponse getCurrency(@RequestParam(value = "unit", required = false) String unit) throws UnsupportedEncodingException {
        return currencyApplication.getCurrencyData(unit);
    }

    /**
     * 환율 수취 금액을 계산한다.
     * @param request 환율 계산 요청
     * @return 계산된 환율 수취 금액
     * @throws UnsupportedEncodingException
     */
    @PostMapping("/calculate")
    public CurrencyResponse calculate(@Valid  @RequestBody CurrencyRequest request) throws UnsupportedEncodingException {

        return currencyApplication.calculateCurrency(request);
    }
}
