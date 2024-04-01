package com.example.bohdan.entities;

import com.example.bohdan.entities.enums.Countries;
import com.example.bohdan.entities.enums.CurrencyNames;
import com.example.bohdan.entities.enums.FinancialDataType;
import com.example.bohdan.entities.interfaces.SerializableToCsv;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency extends FinancialData implements SerializableToCsv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "country")
    private Countries country;

    @Column(name = "exchangeRate")
    private double exchangeRate;

    @Column(name = "symbol")
    private CurrencyNames symbol;

    @Column(name = "name")
    private String name;

    public Currency(int volume,
                    LocalDateTime dateTime,
                    FinancialDataType type,
                    double percentChange,
                    double change,
                    double price,
                    Countries country,
                    double exchangeRate,
                    CurrencyNames symbol,
                    String name) {
        super(volume, dateTime, type, percentChange, change, price);
        this.country = country;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
        this.name = name;
    }

    public String toCsv(){
        return getVolume() + "," +
                getDateTime() + "," +
                getType() + "," +
                getPercentChange() + "," +
                getChange() + "," +
                getPrice() + "," +
                getCountry() + "," +
                getExchangeRate() + "," +
                getSymbol() + "," +
                getName();
    }
}
