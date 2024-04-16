package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Currency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

public interface CurrencyController {
    String getAllCurrency(Model model);
    Currency getCurrencyById(Long id);
    List<Currency> getAllCurrencyByDateTime(String dateTime);
    Currency saveCurrency(Currency currency);
    Currency updateCurrencyById(Long id, Currency currency) throws InvalidFinancialDataIdException;

    void deleteCurrencyById(Long id) throws InvalidFinancialDataIdException;
}
