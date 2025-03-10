package com.fouadev.orderservice.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fouadev.orderservice.event.Order;
import com.fouadev.orderservice.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 Created by : Fouad SAIDI on 09/03/2025
 @author : Fouad SAIDI
 @date : 09/03/2025
 @project : microservices-kafka
*/
@RestController
@RequestMapping("/orders")
public class OrderRestController {


    private KafkaProducer kafkaProducer;

    public OrderRestController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/send")
    public String placeOrder(@RequestBody Order order) {
        System.out.println("sending order : " + order.toString());

        kafkaProducer.send("order-topic", order);

        return "Order placed successfully";
    }
}