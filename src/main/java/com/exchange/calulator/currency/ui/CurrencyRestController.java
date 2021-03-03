package com.exchange.calulator.currency.ui;

import com.exchange.calulator.currency.dto.CurrencyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class CurrencyRestController {

    @GetMapping
    public CurrencyResponse getCurrency(@RequestParam(value = "source", required = false) String source) {
        return null;
    }
}
