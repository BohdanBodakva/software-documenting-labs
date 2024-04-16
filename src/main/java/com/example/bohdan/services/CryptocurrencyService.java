package com.example.bohdan.services;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;

public interface CryptocurrencyService{
    List<Cryptocurrency> getAllCryptocurrency();
    Cryptocurrency getCryptocurrencyById(Long id) throws InvalidFinancialDataIdException;
    List<Cryptocurrency> getAllCryptocurrencyByDateTime(LocalDateTime dateTime);
    Cryptocurrency saveCryptocurrency(Cryptocurrency cryptocurrency);
    Cryptocurrency updateCryptocurrencyById(Long id, Cryptocurrency cryptocurrency) throws InvalidFinancialDataIdException;

    void deleteCryptocurrencyById(Long id) throws InvalidFinancialDataIdException;
}
