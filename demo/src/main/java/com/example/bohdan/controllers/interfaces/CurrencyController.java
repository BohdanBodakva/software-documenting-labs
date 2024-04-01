package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Currency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface CurrencyController {
    List<Currency> getAllCurrency();
    Currency getCurrencyById(Long id);
    List<Currency> getAllCurrencyByDateTime(String dateTime);
}