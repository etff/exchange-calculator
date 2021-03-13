package com.exchange.calculator.domain;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * 환율 금액.
 */
@Getter
public class Currency {
    private static final BigDecimal ZERO = BigDecimal.ZERO;
    private BigDecimal amount;

    private Currency(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 가격이 더해진 값을 리턴한다.
     */
    public Currency plus(Currency currency) {
        return new Currency(this.amount.add(currency.amount));
    }

    /**
     * 가격이 뺴진 값을 리턴한다.
     */
    public Currency minus(Currency currency) {
        return new Currency(this.amount.subtract(currency.amount));
    }

    /**
     * 가격의 곱을 리턴한다.
     */
    public Currency times(BigDecimal amount) {
        return new Currency(this.amount.multiply(amount));
    }

    public static Currency of(long money) {
        return new Currency(BigDecimal.valueOf(money));
    }

    public static Currency of(BigDecimal money) {
        return new Currency(money);
    }

    /**
     * 가격객체가 동등한 객체라면 true를 리턴하고, 그렇지 않다면 false를 리턴합니다.
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        return Objects.equals(amount, other.amount);
    }

    /**
     * 가격 객체의 해쉬 정보를 리턴합니다.
     */
    public int hashCode() {
        return Objects.hashCode(amount);
    }
}
