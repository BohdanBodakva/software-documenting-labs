package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface StockController {
    List<Stock> getAllStocks();
    Stock getStockById(Long id);
    List<Stock> getAllStocksByDateTime(String dateTime);
}
