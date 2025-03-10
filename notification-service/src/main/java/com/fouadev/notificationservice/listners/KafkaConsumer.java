package com.fouadev.notificationservice.listners;


import com.fouadev.orderservice.event.Order;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/*
 Created by : Fouad SAIDI on 09/03/2025
 @author : Fouad SAIDI
 @date : 09/03/2025
 @project : microservices-kafka
*/
@Service
public class KafkaConsumer {

//    @KafkaListener(topics = "order-topic", groupId = "notification-group")
//    public void listen(com.fouadev.orderservice.event.Order message) {
//        System.out.println("Received message: " + message);
//        System.out.println("Order ID: " + message.getOrderId());
//    }

    @KafkaListener(topics = "order-topic", groupId = "notification-group",containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String,Order> record, Acknowledgment acknowledgment) {
        try {
            // Process the message
            Order order = record.value();
            System.out.println("Consumed order: " + order);

            // After successful processing, commit the offset manually
            acknowledgment.acknowledge();  // This commits the offset of the current message

        } catch (Exception e) {
            // Handle any exceptions (e.g., retry logic or DLQ)
            System.err.println("Error consuming message: " + e.getMessage());
        }
    }
}