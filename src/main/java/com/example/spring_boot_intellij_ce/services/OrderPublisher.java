package com.example.spring_boot_intellij_ce.services;

import com.example.spring_boot_intellij_ce.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderPublisher {

    @Autowired
    private MqttPahoMessageHandler mqttHandler;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void publishOrder(Order order) {
        try {
            String topic = "/dmn/orders";
            String payload = objectMapper.writeValueAsString(order);
            Message<String> message = MessageBuilder.withPayload(payload)
                    .setHeader(MqttHeaders.TOPIC, topic)
                    .build();
            mqttHandler.handleMessage(message);
            System.out.println("Order published to MQTT topic: " + topic);
        } catch (Exception e) {
            System.err.println("Error publishing order to MQTT: " + e.getMessage());
        }
    }
}