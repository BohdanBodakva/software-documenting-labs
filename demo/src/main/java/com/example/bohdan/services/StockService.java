package com.example.bohdan.services;

import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface StockService {
    List<Stock> getAllStocks();
    Stock getStockById(Long id) throws InvalidFinancialDataIdException;
    List<Stock> getAllStocksByDateTime(LocalDateTime dateTime);
}
