package com.example.bohdan.services;

import com.example.bohdan.entities.Stock;
import com.example.bohdan.exceptions.UnexistingSendMessageDestinationException;
import com.example.bohdan.kafka.DisplayStrategy;
import com.example.bohdan.kafka.DisplayToConsoleStrategy;
import com.example.bohdan.kafka.DisplayToKafkaStrategy;
import com.example.bohdan.kafka.KafkaSender;
import com.example.bohdan.repositories.StockRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class KafkaService {
    private final StockRepository stockRepository;
    private final KafkaSender kafkaSender;

    @Value("${my_custom_send_messages_destination}")
    private String sendMessagesDestination;

    private DisplayStrategy displayStrategy;

    @Autowired
    public KafkaService(KafkaSender kafkaSender, StockRepository stockRepository) throws UnexistingSendMessageDestinationException {
        this.stockRepository = stockRepository;
        this.kafkaSender = kafkaSender;
    }

    private String validateMessageDestination() throws UnexistingSendMessageDestinationException {
        if(Objects.equals(sendMessagesDestination, "kafka")){
            return "kafka";
        } else if (Objects.equals(sendMessagesDestination, "terminal")){
            return "terminal";
        } else if (Objects.equals(sendMessagesDestination, null)){
            throw new UnexistingSendMessageDestinationException(
                    "Variable 'my_custom_send_messages_destination' is not defined in application.properties"
            );
        }
        throw new UnexistingSendMessageDestinationException(
                "Variable 'my_custom_send_messages_destination' in application.properties has invalid value"
        );
    }

    public void writeMessages() throws UnexistingSendMessageDestinationException, InterruptedException {
        List<String> stockJsons = getAllStocksAsListOfJsons();

        if(Objects.equals(validateMessageDestination(), "kafka")){
            setDisplayStrategy(new DisplayToKafkaStrategy(kafkaSender));
        } else {
            setDisplayStrategy(new DisplayToConsoleStrategy());
        }

        displayStrategy.displayData(stockJsons);
    }

    private List<String> getAllStocksAsListOfJsons(){
        List<Stock> stocks = stockRepository.findAll();
        List<String> stockJsons = new ArrayList<>();
        for(Stock stock: stocks){
            stockJsons.add(
              stock.toJson()
            );
        }
        return stockJsons;
    }
}
