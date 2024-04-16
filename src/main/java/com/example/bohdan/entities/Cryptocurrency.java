package com.example.bohdan.entities;

import com.example.bohdan.entities.enums.BlockchainType;
import com.example.bohdan.entities.enums.CryptocurrencyNames;
import com.example.bohdan.entities.enums.FinancialDataType;
import com.example.bohdan.entities.interfaces.SerializableToCsv;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "crypto_currency")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cryptocurrency extends FinancialData implements SerializableToCsv {

    @Column(name = "volatility")
    private double volatility;

    @Column(name = "blockchain")
    private BlockchainType blockchain;

    @Column(name = "symbol")
    private CryptocurrencyNames symbol;

    @Column(name = "name")
    private String name;

    public Cryptocurrency(int volume,
                          LocalDateTime dateTime,
                          FinancialDataType type,
                          double percentChange,
                          double change,
                          double price,
                          double volatility,
                          BlockchainType blockchain,
                          CryptocurrencyNames symbol,
                          String name) {
        super(volume, dateTime, type, percentChange, change, price);
        this.volatility = volatility;
        this.blockchain = blockchain;
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
                getVolatility() + "," +
                getBlockchain() + "," +
                getSymbol() + "," +
                getName();
    }
}
