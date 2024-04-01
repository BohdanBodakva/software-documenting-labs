package com.example.bohdan.services.implementation;

import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import com.example.bohdan.repositories.StockRepository;
import com.example.bohdan.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long id) throws InvalidFinancialDataIdException {
        Stock stock = stockRepository.findById(id).orElse(null);

        if(stock == null){
            throw new InvalidFinancialDataIdException("Stock with id=" + id + " doesn't exist");
        }

        return stock;
    }

    @Override
    public List<Stock> getAllStocksByDateTime(LocalDateTime dateTime) {
        return stockRepository.getAllByDateTime(dateTime);
    }
}
