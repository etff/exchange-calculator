package com.exchange.calulator.currency.infra;

import com.exchange.calulator.currency.dto.CurrencyResponse;
import org.springframework.stereotype.Component;

@Component
public class InmemoryCurrencyRateAPI implements CurrencyRateAPI{

    @Override
    public CurrencyResponse retrieveCurrency() {
        return null;
    }
}
