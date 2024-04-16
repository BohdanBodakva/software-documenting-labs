package com.example.bohdan.services;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(Long id) throws InvalidFinancialDataIdException;
    List<Stock> getAllStocksByDateTime(LocalDateTime dateTime);
    Stock saveStock(Stock stock);
    Stock updateStockById(Long id, Stock stock) throws InvalidFinancialDataIdException;

    void deleteStockById(Long id) throws InvalidFinancialDataIdException;
}
