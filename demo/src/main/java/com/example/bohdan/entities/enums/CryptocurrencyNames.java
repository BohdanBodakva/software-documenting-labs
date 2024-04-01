package com.example.bohdan.entities.enums;

public enum CryptocurrencyNames {
    BTC("Bitcoin"),
    ETH("Ethereum"),
    USDT("USD Tether"),
    BNB("Binance Coin");

    private final String cryptoCurrency;

    CryptocurrencyNames(String cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }

    public String getCryptoCurrency(){
        return cryptoCurrency;
    }
}
