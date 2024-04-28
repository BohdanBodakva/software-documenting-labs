package com.example.bohdan.kafka;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DisplayToKafkaStrategy implements DisplayStrategy {
    private final KafkaSender kafkaSender;

    public DisplayToKafkaStrategy(KafkaSender kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @Override
    public void displayData(List<String> data) throws InterruptedException {
        for(String message: data){
            kafkaSender.send(message);
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
