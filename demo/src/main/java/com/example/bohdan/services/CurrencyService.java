package com.example.bohdan.services;

import com.example.bohdan.entities.Currency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CurrencyService {
    List<Currency> getAllCurrency();
    Currency getCurrencyById(Long id) throws InvalidFinancialDataIdException;
    List<Currency> getAllCurrencyByDateTime(LocalDateTime dateTime);
}
