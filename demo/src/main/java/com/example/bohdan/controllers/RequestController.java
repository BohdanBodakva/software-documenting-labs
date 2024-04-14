package com.example.bohdan.controllers;

import com.example.bohdan.controllers.interfaces.CryptocurrencyController;
import com.example.bohdan.controllers.interfaces.CurrencyController;
import com.example.bohdan.controllers.interfaces.StockController;
import com.example.bohdan.csv.CsvParser;
import com.example.bohdan.entities.Cryptocurrency;
import com.example.bohdan.entities.Currency;
import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.InvalidFinancialDataIdException;
import com.example.bohdan.services.CryptocurrencyService;
import com.example.bohdan.services.CsvService;
import com.example.bohdan.services.CurrencyService;
import com.example.bohdan.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@CrossOrigin
@Controller
//@RequestMapping("/api")
public class RequestController implements CurrencyController,
                                          StockController,
                                          CryptocurrencyController {
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
        return "Data was successfully written to DB";
    }
// ========================== Cryptocurrency ================================
    @Override
//    @GetMapping("/cryptocurrency")
    public String getAllCryptocurrency(Model model) {
        List<Cryptocurrency> cryptocurrencyList = cryptocurrencyService.getAllCryptocurrency();
        ModelAndView mav = new ModelAndView();
        mav.addObject("cryptocurrencyList", "aaa");
        return "index";
    }

    @Override
    @GetMapping("/cryptocurrency/{id}")
    public String getCryptocurrencyById(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @GetMapping("/cryptocurrency/{dateTime}")
    public String getAllCryptocurrencyByDateTime(@PathVariable(name = "dateTime") String dateTime) {
        return null;
    }

    @Override
    public String saveCryptocurrency(Cryptocurrency cryptocurrency) {
        return null;
    }

    @Override
    public String updateCryptocurrencyById(Long id, Cryptocurrency cryptocurrency) throws InvalidFinancialDataIdException {
        return null;
    }

    @Override
    public String deleteCryptocurrencyById(Long id) throws InvalidFinancialDataIdException {
        return null;
    }
// ========================== Currency ================================
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
    public Currency saveCurrency(Currency currency) {
        return null;
    }

    @Override
    public Currency updateCurrencyById(Long id, Currency currency) throws InvalidFinancialDataIdException {
        return null;
    }

    @Override
    public void deleteCurrencyById(Long id) throws InvalidFinancialDataIdException {

    }
// ========================== Stock ================================
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

    @Override
    public Stock saveStock(Stock stock) {
        return null;
    }

    @Override
    public Stock updateStockById(Long id, Stock stock) throws InvalidFinancialDataIdException {
        return null;
    }

    @Override
    public void deleteStockById(Long id) throws InvalidFinancialDataIdException {

    }
}
