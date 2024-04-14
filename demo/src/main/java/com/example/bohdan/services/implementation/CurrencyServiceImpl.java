package com.example.bohdan.services.implementation;

import com.example.bohdan.entities.Currency;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import com.example.bohdan.repositories.CurrencyRepository;
import com.example.bohdan.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<Currency> getAllCurrency() {
        return currencyRepository.findAll();
    }

    @Override
    public Currency getCurrencyById(Long id) throws InvalidFinancialDataIdException {
        Currency currency = currencyRepository.findById(id).orElse(null);

        if(currency == null){
            throw new InvalidFinancialDataIdException("Currency with id=" + id + " doesn't exist");
        }

        return currency;
    }

    @Override
    public List<Currency> getAllCurrencyByDateTime(LocalDateTime dateTime) {
        return currencyRepository.getAllByDateTime(dateTime);
    }

    @Override
    public Currency saveCurrency(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency updateCurrencyById(Long id, Currency currency) throws InvalidFinancialDataIdException {
        Currency currencyFromDB = currencyRepository.findById(id).orElse(null);

        if(currencyFromDB != null){
            currencyFromDB = currency;
            currencyFromDB.setId(id);
            return currencyRepository.save(currencyFromDB);
        } else {
            throw new InvalidFinancialDataIdException("Currency with id=" + id + " doesn't exist");
        }
    }

    @Override
    public void deleteCurrencyById(Long id) throws InvalidFinancialDataIdException {
        Currency currency = currencyRepository.findById(id).orElse(null);

        if(currency != null){
            currencyRepository.deleteById(id);
        } else {
            throw new InvalidFinancialDataIdException("Currency with id=" + id + " doesn't exist");
        }
    }
}
