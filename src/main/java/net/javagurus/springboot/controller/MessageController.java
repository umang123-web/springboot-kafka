package net.javagurus.springboot.controller;

import net.javagurus.springboot.kafka.KafkaProducers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

   private KafkaProducers kafkaProducer;

    @Autowired
    public MessageController(KafkaProducers kafkaProducer) {

       this.kafkaProducer = kafkaProducer;

    }
    //http:localhost:8080/api/v1/kafka/publish?message=helloworld
    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message")  String message){

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic");
    }
}
