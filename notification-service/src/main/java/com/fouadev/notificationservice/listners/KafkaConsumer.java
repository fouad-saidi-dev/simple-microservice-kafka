package com.fouadev.notificationservice.listners;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/*
 Created by : Fouad SAIDI on 09/03/2025
 @author : Fouad SAIDI
 @date : 09/03/2025
 @project : microservices-kafka
*/
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void listen(com.fouadev.orderservice.event.Order message) {
        System.out.println("Received message: " + message);
        System.out.println("Order ID: " + message.getOrderId());
    }
}