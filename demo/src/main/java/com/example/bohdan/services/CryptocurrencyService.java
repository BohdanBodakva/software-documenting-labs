package com.example.bohdan.services;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CryptocurrencyService{
    List<Cryptocurrency> getAllCryptocurrency();
    Cryptocurrency getCryptocurrencyById(Long id) throws InvalidFinancialDataIdException;
    List<Cryptocurrency> getAllCryptocurrencyByDateTime(LocalDateTime dateTime);
}
