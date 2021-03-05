package com.exchange.calculator.currency.ui;

import com.exchange.calculator.currency.dto.CurrencyRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CurrencyController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("currency", new CurrencyRequest());
        model.addAttribute("name", "etff");
        return "index";
    }

    @PostMapping("/result")
    public String result(@ModelAttribute CurrencyRequest currency, Model model) {
        model.addAttribute("currency", currency);
        return "result";
    }
}
