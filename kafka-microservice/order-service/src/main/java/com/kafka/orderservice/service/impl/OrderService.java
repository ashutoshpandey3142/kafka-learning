package com.kafka.orderservice.service.impl;

import com.kafka.basedomains.event.*;
import com.kafka.orderservice.service.IOrderService;
import com.kafka.orderservice.utils.KafkaTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);


    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public OrderService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrderEvent(OrderEvent event) {
        sendMessage(event, KafkaTopics.ORDER_TOPIC);
    }

    @Override
    public void sendPaymentEvent(PaymentEvent event) {
        sendMessage(event, KafkaTopics.PAYMENT_TOPIC);
    }

    @Override
    public void sendShipmentEvent(ShipmentEvent event) {
        sendMessage(event, KafkaTopics.SHIPMENT_TOPIC);
    }

    @Override
    public void sendNotificationEvent(NotificationEvent event) {
        sendMessage(event, KafkaTopics.NOTIFICATION_TOPIC);
    }

    @Override
    public void sendInventoryEvent(InventoryEvent event) {
        sendMessage(event, KafkaTopics.INVENTORY_TOPIC);
    }

    private <T> void sendMessage(T event, String topicName) {
        try {
            Message<T> message = MessageBuilder
                    .withPayload(event)
                    .setHeader(KafkaHeaders.TOPIC, topicName)
                    .build();
            kafkaTemplate.send(message);
            LOGGER.info("Message sent successfully to topic: {}", topicName);
        } catch (Exception e) {
            LOGGER.error("Error sending message to topic: {}", topicName, e);
        }
    }
}
