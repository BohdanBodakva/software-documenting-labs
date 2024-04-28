package com.example.bohdan.controllers;

import com.example.bohdan.csv.CsvParser;
import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.entities.enums.*;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import com.example.bohdan.services.CryptocurrencyService;
import com.example.bohdan.services.CsvService;
import com.example.bohdan.services.CurrencyService;
import com.example.bohdan.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api")
public class RequestController {
    private final CurrencyService currencyService;
    private final StockService stockService;
    private final CryptocurrencyService cryptocurrencyService;
    private final CsvService csvService;

    @Autowired
    public RequestController(CurrencyService currencyService,
                             StockService stockService,
                             CryptocurrencyService cryptocurrencyService,
                             CsvService csvService){
        this.currencyService = currencyService;
        this.stockService = stockService;
        this.cryptocurrencyService = cryptocurrencyService;
        this.csvService = csvService;
    }

    @GetMapping("/write-csv-to-db")
    public String writeCsvToDB(){
        csvService.writeCsvData(
                CsvParser.parseCsv("result.csv")
        );
        return "successfully_written_to_db";
    }

    @GetMapping("/")
    public String getAllFinancialData(Model model) {
        List<Cryptocurrency> cryptocurrencyList = cryptocurrencyService.getAllCryptocurrency();
        List<Currency> currencyList = currencyService.getAllCurrency();
        List<Stock> stockList = stockService.getAllStocks();

        model.addAttribute("cryptocurrencyList", cryptocurrencyList);
        model.addAttribute("currencyList", currencyList);
        model.addAttribute("stockList", stockList);

        model.addAttribute("showCryptocurrency", true);
        model.addAttribute("showCurrency", true);
        model.addAttribute("showStock", true);

        return "index";
    }

// ========================== Cryptocurrency ================================

    @GetMapping("/cryptocurrency")
    public String getAllCryptocurrency(Model model) {
        List<Cryptocurrency> cryptocurrencyList = cryptocurrencyService.getAllCryptocurrency();

        model.addAttribute("cryptocurrencyList", cryptocurrencyList);
        model.addAttribute("showCryptocurrency", true);

        return "index";
    }


    @GetMapping("/cryptocurrency/{id}")
    public Stock getCryptocurrencyById(@PathVariable(name = "id") Long id) {
        return null;
    }


    @GetMapping("/cryptocurrency/{dateTime}")
    public List<Cryptocurrency> getAllCryptocurrencyByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @GetMapping("/add-cryptocurrency")
    public String saveCryptocurrency(Model model) {
        model.addAttribute("cryptocurrency", new Cryptocurrency());
        model.addAttribute("blockchainTypes", BlockchainType.values());
        model.addAttribute("cryptocurrencyNames", CryptocurrencyNames.values());
        model.addAttribute("showCryptocurrency", true);
        model.addAttribute("addCryptocurrency", true);
        return "add_data";
    }

    @PostMapping("/cryptocurrency")
    public String saveCryptocurrency(@ModelAttribute Cryptocurrency cryptocurrency, Model model) {
        cryptocurrency.setDateTime(LocalDateTime.now());
        cryptocurrency.setType(FinancialDataType.CRYPTOCURRENCY);

        cryptocurrencyService.saveCryptocurrency(cryptocurrency);

        model.addAttribute("cryptocurrency", cryptocurrency);
        model.addAttribute("showCryptocurrency", true);

        return "data_added";
    }

    @GetMapping("/update-cryptocurrency/{id}")
    public String updateCryptocurrency(@PathVariable(name = "id") Long id, Model model) {
        Cryptocurrency cryptocurrency;
        try {
            cryptocurrency = cryptocurrencyService.getCryptocurrencyById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("cryptocurrency", cryptocurrency);
        model.addAttribute("id", id);
        model.addAttribute("country", Countries.values());
        model.addAttribute("blockchainTypes", BlockchainType.values());
        model.addAttribute("currencyNames", CurrencyNames.values());
        model.addAttribute("showCryptocurrency", true);
        model.addAttribute("updateCryptocurrency", true);
        return "add_data";
    }

    @PutMapping("/cryptocurrency/{id}")
    public String updateCryptocurrency(@PathVariable(name = "id") Long id, @ModelAttribute Cryptocurrency cryptocurrency, Model model) {
        cryptocurrency.setDateTime(LocalDateTime.now());
        cryptocurrency.setType(FinancialDataType.STOCK);

        try {
            cryptocurrencyService.updateCryptocurrencyById(id, cryptocurrency);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("cryptocurrency", cryptocurrency);
        model.addAttribute("showCryptocurrency", true);
        model.addAttribute("updatedCryptocurrency", true);

        return "data_added";
    }

    @DeleteMapping("/cryptocurrency/{id}")
    public String deleteCryptocurrencyById(@PathVariable(name = "id") Long id, Model model) {
        try {
            cryptocurrencyService.deleteCryptocurrencyById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        return getAllFinancialData(model);

    }
// ========================== Currency ================================

    @GetMapping("/currency")
    public String getAllCurrency(Model model) {
        List<Currency> currencyList = currencyService.getAllCurrency();

        model.addAttribute("currencyList", currencyList);
        model.addAttribute("showCurrency", true);

        return "index";
    }


    @GetMapping("/currency/{id}")
    public Stock getCurrencyById(@PathVariable(name = "id") Long id) {
        return null;
    }


    @GetMapping("/currency/{dateTime}")
    public List<Currency> getAllCurrencyByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @GetMapping("/add-currency")
    public String saveCurrency(Model model) {
        model.addAttribute("currency", new Currency());
        model.addAttribute("countryList", Countries.values());
        model.addAttribute("currencyNames", CurrencyNames.values());
        model.addAttribute("showCurrency", true);
        model.addAttribute("addCurrency", true);
        return "add_data";
    }

    @PostMapping("/currency")
    public String saveCurrency(@ModelAttribute Currency currency, Model model) {
        currency.setDateTime(LocalDateTime.now());
        currency.setType(FinancialDataType.CURRENCY);

        currencyService.saveCurrency(currency);

        model.addAttribute("currency", currency);
        model.addAttribute("showCurrency", true);

        return "data_added";
    }

    @GetMapping("/update-currency/{id}")
    public String updateCurrency(@PathVariable(name = "id") Long id, Model model) {
        Currency currency;
        try {
            currency = currencyService.getCurrencyById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("currency", currency);
        model.addAttribute("id", id);
        model.addAttribute("country", Countries.values());
        model.addAttribute("currencyNames", CurrencyNames.values());
        model.addAttribute("showCurrency", true);
        model.addAttribute("updateCurrency", true);
        return "add_data";
    }

    @PutMapping("/currency/{id}")
    public String updateCurrency(@PathVariable(name = "id") Long id, @ModelAttribute Currency currency, Model model) {
        currency.setDateTime(LocalDateTime.now());
        currency.setType(FinancialDataType.CURRENCY);

        try {
            currencyService.updateCurrencyById(id, currency);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("currency", currency);
        model.addAttribute("showCurrency", true);
        model.addAttribute("updatedCurrency", true);

        return "data_added";
    }

    @DeleteMapping("/currency/{id}")
    public String deleteCurrencyById(@PathVariable(name = "id") Long id, Model model) {
        try {
            currencyService.deleteCurrencyById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        return getAllFinancialData(model);

    }
// ========================== Stock ================================

    @GetMapping("/stocks")
    public String getAllStocks(Model model) {
        List<Stock> stockList = stockService.getAllStocks();

        model.addAttribute("stockList", stockList);
        model.addAttribute("showStock", true);

        return "index";
    }


    @GetMapping("/stocks/{id}")
    public Stock getStockById(@PathVariable(name = "id") Long id) {
        return null;
    }


    @GetMapping("/stocks/{dateTime}")
    public List<Stock> getAllStocksByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @GetMapping("/add-stock")
    public String saveStock(Model model) {
        model.addAttribute("stock", new Stock());
        model.addAttribute("stockTypes", StockNames.values());
        model.addAttribute("showStock", true);
        model.addAttribute("addStock", true);
        return "add_data";
    }

    @PostMapping("/stocks")
    public String saveStock(@ModelAttribute Stock stock, Model model) {
        stock.setDateTime(LocalDateTime.now());
        stock.setType(FinancialDataType.STOCK);

        stockService.saveStock(stock);

        model.addAttribute("stock", stock);
        model.addAttribute("showStock", true);

        return "data_added";
    }

    @GetMapping("/update-stock/{id}")
    public String updateStock(@PathVariable(name = "id") Long id, Model model) {
        Stock stock;
        try {
            stock = stockService.getStockById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }
        model.addAttribute("stock", stock);
        model.addAttribute("id", id);
        model.addAttribute("stockTypes", StockNames.values());
        model.addAttribute("showStock", true);
        model.addAttribute("updateStock", true);
        return "add_data";
    }

    @PutMapping("/stocks/{id}")
    public String updateStock(@PathVariable(name = "id") Long id, @ModelAttribute Stock stock, Model model) {
        stock.setDateTime(LocalDateTime.now());
        stock.setType(FinancialDataType.STOCK);

        try {
            stockService.updateStockById(id, stock);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        model.addAttribute("stock", stock);
        model.addAttribute("showStock", true);
        model.addAttribute("updatedStock", true);

        return "data_added";
    }

    @DeleteMapping("/stocks/{id}")
    public String deleteStockById(@PathVariable(name = "id") Long id, Model model) {
        try {
            stockService.deleteStockById(id);
        } catch (InvalidFinancialDataIdException e) {
            throw new RuntimeException(e);
        }

        return getAllFinancialData(model);

    }
}
