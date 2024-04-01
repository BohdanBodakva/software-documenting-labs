package com.example.bohdan.csv;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.entities.enums.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;

@Service
public class CsvGenerator {
    private final Random random = new Random();

    public Stock getRandomStock(){
        return new Stock(
                generateRandomInteger(1, 100),
                generateRandomDateTime(
                        LocalDateTime.of(LocalDate.of(2022, 1, 1),
                        LocalTime.now()), LocalDateTime.now()
                ),
                FinancialDataType.STOCK,
                generateRandomDouble(0, 35),
                generateRandomDouble(0, 55),
                generateRandomDouble(0, 150),

                generateRandomStockType(),
                generateRandomString(15),
                generateRandomDouble(1, 100),
                generateRandomString(7)
        );
    }

    public Currency getRandomCurrency(){
        CurrencyNames currencyName = generateRandomCurrencyName();

        return new Currency(
                generateRandomInteger(1, 100),
                generateRandomDateTime(
                        LocalDateTime.of(LocalDate.of(2022, 1, 1),
                                LocalTime.now()), LocalDateTime.now()
                ),
                FinancialDataType.CURRENCY,
                generateRandomDouble(0, 35),
                generateRandomDouble(0, 55),
                generateRandomDouble(0, 150),

                generateRandomCountry(),
                generateRandomDouble(1, 4),
                currencyName,
                currencyName.getCurrency()
        );
    }

    public Cryptocurrency getRandomCryptocurrency(){
        CryptocurrencyNames cryptocurrencyName = generateRandomCryptocurrencyName();

        return new Cryptocurrency(
                generateRandomInteger(1, 100),
                generateRandomDateTime(
                        LocalDateTime.of(LocalDate.of(2022, 1, 1),
                                LocalTime.now()), LocalDateTime.now()
                ),
                FinancialDataType.CRYPTOCURRENCY,
                generateRandomDouble(0, 35),
                generateRandomDouble(0, 55),
                generateRandomDouble(0, 150),

                generateRandomDouble(1, 5),
                generateRandomBlockchainType(),
                cryptocurrencyName,
                cryptocurrencyName.getCryptoCurrency()
        );
    }



// private generation functions for different data types
    private int generateRandomInteger(int min, int max){
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
    private LocalDateTime generateRandomDateTime(LocalDateTime min, LocalDateTime max){
        int minYear = min.getYear();
        int minMonth = min.getMonthValue();
        int minDay = min.getDayOfMonth();

        int maxYear = max.getYear();
        int maxMonth = max.getMonthValue();
        int maxDay = max.getDayOfMonth();

        int year = random.ints(minYear, maxYear)
                .findFirst()
                .getAsInt();
        int month;
        if(year == minYear){
            month = random.ints(minMonth, 12)
                    .findFirst()
                    .getAsInt();
        } else if (year == maxYear) {
            month = random.ints(1, maxMonth)
                    .findFirst()
                    .getAsInt();
        } else {
            month = random.ints(1, 12)
                    .findFirst()
                    .getAsInt();
        }
        int day;
        if(month == minMonth){
            day = random.ints(minDay, 28)
                    .findFirst()
                    .getAsInt();
        } else if (month == maxMonth) {
            day = random.ints(1, maxDay)
                    .findFirst()
                    .getAsInt();
        } else {
            day = random.ints(1, 28)
                    .findFirst()
                    .getAsInt();
        }

        LocalDateTime generatedDateTime = LocalDateTime.of(LocalDate.of(year, month, day), LocalTime.now());
        return generatedDateTime;
    }

    private double generateRandomDouble(int min, int max){
        return random.doubles(min, max)
                .findFirst()
                .getAsDouble();
    }

    private StockNames generateRandomStockType(){
        int randomNumber = random.ints(0, StockNames.values().length)
                .findFirst()
                .getAsInt();

        return StockNames.values()[randomNumber];
    }

    private BlockchainType generateRandomBlockchainType(){
        int randomNumber = random.ints(0, BlockchainType.values().length)
                .findFirst()
                .getAsInt();

        return BlockchainType.values()[randomNumber];
    }

    private Countries generateRandomCountry(){
        int randomNumber = random.ints(0, Countries.values().length)
                .findFirst()
                .getAsInt();

        return Countries.values()[randomNumber];
    }

    private String generateRandomString(int symbolNumber){
        return RandomString.getAlphaNumericString(symbolNumber);
    }

    private CryptocurrencyNames generateRandomCryptocurrencyName(){
        int randomNumber = random.ints(0, CryptocurrencyNames.values().length)
                .findFirst()
                .getAsInt();

        return CryptocurrencyNames.values()[randomNumber];
    }

    private CurrencyNames generateRandomCurrencyName(){
        int randomNumber = random.ints(0, CurrencyNames.values().length)
                .findFirst()
                .getAsInt();

        return CurrencyNames.values()[randomNumber];
    }

}
