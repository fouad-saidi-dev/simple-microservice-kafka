package com.fouadev.orderservice.event;

import lombok.*;

import java.io.Serializable;

/*
 Created by : Fouad SAIDI on 09/03/2025
 @author : Fouad SAIDI
 @date : 09/03/2025
 @project : microservices-kafka
*/
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private String orderId;
    private String productName;
    private int quantity;
}