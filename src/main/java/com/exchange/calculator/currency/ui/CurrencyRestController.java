package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.application.CurrencyApplication;
import com.exchange.calculator.currency.dto.CurrencyRequest;
import com.exchange.calculator.currency.dto.CurrencyResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/currency")
@RequiredArgsConstructor
public class CurrencyRestController {

    private final CurrencyApplication currencyApplication;

    @GetMapping
    public CurrencyResponse getCurrency(@RequestParam(value = "unit", required = false) String unit) {
        return currencyApplication.getCurrencyData(unit);
    }

    @PostMapping("/calculate")
    public CurrencyResponse calculate(@Valid  @RequestBody CurrencyRequest request) {
        return currencyApplication.calculateCurrency(request);
    }
}
