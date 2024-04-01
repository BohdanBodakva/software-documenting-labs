package com.example.bohdan.services;

import java.util.List;
import java.util.Map;

public interface CsvService {
    void writeCsvData(Map<List<String>, List<List<String>>> parsedCsv);
}
