package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface CryptocurrencyController {
    List<Cryptocurrency> getAllCryptocurrency();
    Cryptocurrency getCryptocurrencyById(Long id);
    List<Cryptocurrency> getAllCryptocurrencyByDateTime(String dateTime);
}
