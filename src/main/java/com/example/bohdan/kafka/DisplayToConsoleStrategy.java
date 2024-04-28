package com.example.bohdan.kafka;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DisplayToConsoleStrategy implements DisplayStrategy {
    @Override
    public void displayData(List<String> data) throws InterruptedException {
        for(String message: data){
            System.out.println(message);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
