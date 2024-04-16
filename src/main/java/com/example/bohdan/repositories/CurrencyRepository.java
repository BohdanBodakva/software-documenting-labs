package com.example.bohdan.repositories;

import com.example.bohdan.entities.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Long> {
//    List<Currency> getAllCurrency();
//    Optional<Currency> getCurrencyById(Long id);
    List<Currency> getAllByDateTime(LocalDateTime dateTime);
}
