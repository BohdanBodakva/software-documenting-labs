package com.example.bohdan.services.implementation;

import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import com.example.bohdan.repositories.CryptocurrencyRepository;
import com.example.bohdan.services.CryptocurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CryptocurrencyServiceImpl implements CryptocurrencyService {
    private final CryptocurrencyRepository cryptocurrencyRepository;

    @Autowired
    public CryptocurrencyServiceImpl(CryptocurrencyRepository cryptocurrencyRepository) {
        this.cryptocurrencyRepository = cryptocurrencyRepository;
    }

    @Override
    public List<Cryptocurrency> getAllCryptocurrency() {
        return cryptocurrencyRepository.findAll();
    }

    @Override
    public Cryptocurrency getCryptocurrencyById(Long id) throws InvalidFinancialDataIdException {
        Cryptocurrency cryptocurrency = cryptocurrencyRepository.findById(id).orElse(null);

        if(cryptocurrency == null){
            throw new InvalidFinancialDataIdException("Currency with id=" + id + " doesn't exist");
        }

        return cryptocurrency;
    }

    @Override
    public List<Cryptocurrency> getAllCryptocurrencyByDateTime(LocalDateTime dateTime) {
        return cryptocurrencyRepository.getAllByDateTime(dateTime);
    }
}
