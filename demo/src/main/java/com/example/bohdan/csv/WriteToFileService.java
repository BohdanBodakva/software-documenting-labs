package com.example.bohdan.csv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class WriteToFileService {

    public static void main(String[] args){
        resetCsvFile("result.csv");
        generateRandomStocksWriteToCsvFile(350, "result.csv");
        generateRandomCurrenciesWriteToCsvFile(350, "result.csv");
        generateRandomCryptocurrenciesWriteToCsvFile(350, "result.csv");

        System.out.println(CsvParser.parseCsv("result.csv"));
    }

    public static void resetCsvFile(String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.write("");
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void generateRandomStocksWriteToCsvFile(int numberOfStocks, String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(CsvHeader.stockCsvHeader);
            writer.newLine();
            for(int i = 0; i < numberOfStocks; i++){
                writer.write(new CsvGenerator().getRandomStock().toCsv());
                writer.newLine();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void generateRandomCurrenciesWriteToCsvFile(int numberOfCurrencies, String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(CsvHeader.currencyCsvHeader);
            writer.newLine();
            for(int i = 0; i < numberOfCurrencies; i++){
                writer.write(new CsvGenerator().getRandomCurrency().toCsv());
                writer.newLine();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void generateRandomCryptocurrenciesWriteToCsvFile(int numberOfCryptocurrencies, String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))){
            writer.write(CsvHeader.cryptocurrencyCsvHeader);
            writer.newLine();
            for(int i = 0; i < numberOfCryptocurrencies; i++){
                writer.write(new CsvGenerator().getRandomCryptocurrency().toCsv());
                writer.newLine();
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
