package com.fouadev.orderservice.services;

import com.fouadev.orderservice.event.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/*
 Created by : Fouad SAIDI on 09/03/2025
 @author : Fouad SAIDI
 @date : 09/03/2025
 @project : microservices-kafka
*/
@Service
public class KafkaProducer {

    private KafkaTemplate<String, Order> kafkaTemplate;
    @Autowired
    public KafkaProducer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String topic,Order message) {
        kafkaTemplate.send(topic, message);
    }

}