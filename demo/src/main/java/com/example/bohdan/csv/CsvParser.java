package com.example.bohdan.csv;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class CsvParser {
    public static Map<List<String>, List<List<String>>> parseCsv(String fileName){
        final Map<List<String>, List<List<String>>> parsedCsv = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            List<String> currentTable = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if(line.equals(CsvHeader.stockCsvHeader) ||
                   line.equals(CsvHeader.currencyCsvHeader) ||
                   line.equals(CsvHeader.cryptocurrencyCsvHeader)){
                    currentTable = Arrays.asList(line.split(","));
                    parsedCsv.put(currentTable, new ArrayList<>());
                } else {
                    parsedCsv.get(currentTable).add(Arrays.asList(line.split(",")));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return parsedCsv;
    }
}
