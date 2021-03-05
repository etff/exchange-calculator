package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.dto.CurrencyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currency", new CurrencyRequest());
        return "index";
    }

}
