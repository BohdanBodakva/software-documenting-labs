package com.example.bohdan.services.implementation;

import com.example.bohdan.csv.CsvHeader;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.repositories.CryptocurrencyRepository;
import com.example.bohdan.repositories.CurrencyRepository;
import com.example.bohdan.repositories.StockRepository;
import com.example.bohdan.services.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<String> keys = new ArrayList<>();
        List<List<String>> values = new ArrayList<>();
        for(Map.Entry<List<String>, List<List<String>>> entry : parsedCsv.entrySet()){
            if(entry.getKey().equals(CsvHeader.stockCsvHeader)){
                for(int i = 0; i < entry.getValue().size(); i++){
                    Stock stock = new Stock(
                            Integer.parseInt(entry.getValue().get(0)),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1),
                            entry.getValue().get(1)
                    );
                }
            }
        }
    }
}
