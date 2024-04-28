package com.example.bohdan.kafka;

import java.util.List;

public interface DisplayStrategy {
    void displayData(List<String> data) throws InterruptedException;
}
