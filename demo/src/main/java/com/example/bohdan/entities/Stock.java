package com.example.bohdan.entities;

import com.example.bohdan.entities.enums.FinancialDataType;
import com.example.bohdan.entities.enums.StockNames;
import com.example.bohdan.entities.interfaces.SerializableToCsv;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock extends FinancialData implements SerializableToCsv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "stockType")
    private StockNames stockType;

    @Column(name = "exchangeInfo")
    private String exchangeInfo;

    @Column(name = "marketCap")
    private double marketCap;

    @Column(name = "name")
    private String name;

    public Stock(int volume,
                 LocalDateTime dateTime,
                 FinancialDataType type,
                 double percentChange,
                 double change,
                 double price,
                 StockNames stockType,
                 String exchangeInfo,
                 double marketCap,
                 String name) {
        super(volume, dateTime, type, percentChange, change, price);
        this.stockType = stockType;
        this.exchangeInfo = exchangeInfo;
        this.marketCap = marketCap;
        this.name = name;
    }

    public String toCsv(){
        return getVolume() + "," +
                getDateTime() + "," +
                getType() + "," +
                getPercentChange() + "," +
                getChange() + "," +
                getPrice() + "," +
                getStockType() + "," +
                getExchangeInfo() + "," +
                getMarketCap() + "," +
                getName();
    }
}
