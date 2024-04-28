package com.example.bohdan.controllers;

import com.example.bohdan.exceptions.UnexistingSendMessageDestinationException;
import com.example.bohdan.kafka.KafkaSender;
import com.example.bohdan.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/kafka")
public class KafkaController {
    private final KafkaService kafkaService;

    @Autowired
    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping(value = "/send-messages")
    public String sendMessages() {
        try {
            kafkaService.writeMessages();
        } catch (UnexistingSendMessageDestinationException | InterruptedException e) {
            return e.getMessage();
        }

        return "Message was written successfully";
    }

//    @GetMapping(value = "/send")
//    public String producer(@RequestParam("message") String message) {
//        kafkaSender.send(message);
//
//        return "Message sent to the Kafka Topic 'my_topic' Successfully";
//    }

}
