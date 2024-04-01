package com.example.bohdan.repositories;

import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
//    List<Stock> getAllStocks();
//    Optional<Stock> getStockById(Long id);
    List<Stock> getAllByDateTime(LocalDateTime dateTime);
}
