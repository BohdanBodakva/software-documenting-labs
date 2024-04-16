package com.example.bohdan.entities.enums;

public enum CurrencyNames {
    USD("USA Dollar"),
    EUR("Euro"),
    HRYVNIA("Ukrainian Hryvnia"),
    GBP("Pound Sterling");

    private final String currency;

    CurrencyNames(String currency) {
        this.currency = currency;
    }

    public String getCurrency(){
        return currency;
    }
}
