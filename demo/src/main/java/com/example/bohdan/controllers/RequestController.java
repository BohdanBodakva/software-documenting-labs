package com.example.bohdan.controllers;

import com.example.bohdan.controllers.interfaces.CryptocurrencyController;
import com.example.bohdan.controllers.interfaces.CurrencyController;
import com.example.bohdan.controllers.interfaces.StockController;
import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.services.CryptocurrencyService;
import com.example.bohdan.services.CurrencyService;
import com.example.bohdan.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RequestController implements CurrencyController,
                                          StockController,
                                          CryptocurrencyController {
    private final CurrencyService currencyService;
    private final StockService stockService;
    private final CryptocurrencyService cryptocurrencyService;

    @Autowired
    public RequestController(CurrencyService currencyService,
                             StockService stockService,
                             CryptocurrencyService cryptocurrencyService){
        this.currencyService = currencyService;
        this.stockService = stockService;
        this.cryptocurrencyService = cryptocurrencyService;
    }


    @Override
    @GetMapping("/cryptocurrency")
    public List<Cryptocurrency> getAllCryptocurrency() {
        return null;
    }

    @Override
    @GetMapping("/cryptocurrency/{id}")
    public Cryptocurrency getCryptocurrencyById(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @GetMapping("/cryptocurrency/{dateTime}")
    public List<Cryptocurrency> getAllCryptocurrencyByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @Override
    @GetMapping("/currency")
    public List<Currency> getAllCurrency() {
        return null;
    }

    @Override
    @GetMapping("/currency/{id}")
    public Currency getCurrencyById(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @GetMapping("/currency/{dateTime}")
    public List<Currency> getAllCurrencyByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @Override
    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return null;
    }

    @Override
    @GetMapping("/stocks/{id}")
    public Stock getStockById(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @GetMapping("/stocks/{dateTime}")
    public List<Stock> getAllStocksByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }
}
