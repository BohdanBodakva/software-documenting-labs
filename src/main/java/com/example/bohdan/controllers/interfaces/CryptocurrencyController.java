package com.example.bohdan.controllers.interfaces;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import org.springframework.ui.Model;

import java.time.LocalDateTime;
import java.util.List;

public interface CryptocurrencyController {
    String getAllCryptocurrency(Model model);
    String getCryptocurrencyById(Long id);
    String getAllCryptocurrencyByDateTime(String dateTime);
    String saveCryptocurrency(Cryptocurrency cryptocurrency);
    String updateCryptocurrencyById(Long id, Cryptocurrency cryptocurrency) throws InvalidFinancialDataIdException;

    String deleteCryptocurrencyById(Long id) throws InvalidFinancialDataIdException;
}
