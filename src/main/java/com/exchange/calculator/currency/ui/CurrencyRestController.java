package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.application.CurrencyApplication;
import com.exchange.calculator.currency.dto.ApiResponse;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
@RequiredArgsConstructor
public class CurrencyRestController {

    private final CurrencyApplication currencyApplication;

    @GetMapping
    public CurrencyResponse getCurrency(@RequestParam(value = "target", required = false) String target) {
        return currencyApplication.getCurrencyData(target);
    }
}
