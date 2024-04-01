package com.example.bohdan.services.implementation;

import com.example.bohdan.csv.CsvHeader;
import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.entities.enums.*;
import com.example.bohdan.repositories.CryptocurrencyRepository;
import com.example.bohdan.repositories.CurrencyRepository;
import com.example.bohdan.repositories.StockRepository;
import com.example.bohdan.services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CsvServiceImpl implements CsvService {
    private final StockRepository stockRepository;
    private final CurrencyRepository currencyRepository;
    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CsvServiceImpl(CurrencyRepository currencyRepository,
                          StockRepository stockRepository,
                          CryptocurrencyRepository cryptocurrencyRepository) {
        this.currencyRepository = currencyRepository;
        this.stockRepository = stockRepository;
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }
    @Override
    public void writeCsvData(Map<List<String>, List<List<String>>> parsedCsv) {
        for(Map.Entry<List<String>, List<List<String>>> entry : parsedCsv.entrySet()){
            if(entry.getKey().equals(Arrays.asList(CsvHeader.stockCsvHeader.split(",")))){
                for(int i = 0; i < entry.getValue().size(); i++){
                    Stock stock = new Stock(
                            Integer.parseInt(entry.getValue().get(i).get(0)),
                            LocalDateTime.parse(entry.getValue().get(i).get(1)),
                            FinancialDataType.valueOf(entry.getValue().get(i).get(2)),
                            Double.parseDouble(entry.getValue().get(i).get(3)),
                            Double.parseDouble(entry.getValue().get(i).get(4)),
                            Double.parseDouble(entry.getValue().get(i).get(5)),
                            StockNames.valueOf(entry.getValue().get(i).get(6)),
                            entry.getValue().get(i).get(7),
                            Double.parseDouble(entry.getValue().get(i).get(8)),
                            entry.getValue().get(i).get(9)
                    );

                    stockRepository.save(stock);
                }
            } else if(entry.getKey().equals(Arrays.asList(CsvHeader.currencyCsvHeader.split(",")))){
                for(int i = 0; i < entry.getValue().size(); i++){
                    Currency currency = new Currency(
                            Integer.parseInt(entry.getValue().get(i).get(0)),
                            LocalDateTime.parse(entry.getValue().get(i).get(1)),
                            FinancialDataType.valueOf(entry.getValue().get(i).get(2)),
                            Double.parseDouble(entry.getValue().get(i).get(3)),
                            Double.parseDouble(entry.getValue().get(i).get(4)),
                            Double.parseDouble(entry.getValue().get(i).get(5)),
                            Countries.valueOf(entry.getValue().get(i).get(6)),
                            Double.parseDouble(entry.getValue().get(i).get(7)),
                            CurrencyNames.valueOf(entry.getValue().get(i).get(8)),
                            entry.getValue().get(i).get(9)
                    );

                    currencyRepository.save(currency);
                }
            } else if(entry.getKey().equals(Arrays.asList(CsvHeader.cryptocurrencyCsvHeader.split(",")))){
                for(int i = 0; i < entry.getValue().size(); i++){
                    Cryptocurrency cryptocurrency = new Cryptocurrency(
                            Integer.parseInt(entry.getValue().get(i).get(0)),
                            LocalDateTime.parse(entry.getValue().get(i).get(1)),
                            FinancialDataType.valueOf(entry.getValue().get(i).get(2)),
                            Double.parseDouble(entry.getValue().get(i).get(3)),
                            Double.parseDouble(entry.getValue().get(i).get(4)),
                            Double.parseDouble(entry.getValue().get(i).get(5)),
                            Double.parseDouble(entry.getValue().get(i).get(6)),
                            BlockchainType.valueOf(entry.getValue().get(i).get(7)),
                            CryptocurrencyNames.valueOf(entry.getValue().get(i).get(8)),
                            entry.getValue().get(i).get(9)
                    );

                    cryptocurrencyRepository.save(cryptocurrency);
                }
            }
        }
    }
}
