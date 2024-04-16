package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

public interface StockController {
    String getAllStocks(Model model);
    Stock getStockById(Long id);
    List<Stock> getAllStocksByDateTime(String dateTime);
    Stock saveStock(Stock stock);
    Stock updateStockById(Long id, Stock stock) throws InvalidFinancialDataIdException;

    void deleteStockById(Long id) throws InvalidFinancialDataIdException;
}
