package com.example.spring_boot_intellij_ce.services;

import com.example.spring_boot_intellij_ce.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class OrderSubscriber {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private OrderService orderService;

    @ServiceActivator(inputChannel = "mqttInputChannel")
    public void handleMessage(Message<?> message) {
        try {
            Order order = objectMapper.readValue((String) message.getPayload(), Order.class);
            System.out.println("Received order from MQTT: " + order.getOrderId());
            orderService.saveOrder(order);
        } catch (Exception e) {
            System.err.println("Error processing MQTT message: " + e.getMessage());
        }
    }
}