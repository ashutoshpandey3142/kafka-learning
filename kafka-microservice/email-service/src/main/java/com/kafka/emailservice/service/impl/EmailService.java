package com.kafka.emailservice.service.impl;

import com.kafka.basedomains.event.*;
import com.kafka.emailservice.service.IEmailService;
import com.kafka.emailservice.utils.KafkaTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService {

    private static final Logger LOG = LoggerFactory.getLogger(EmailService.class);

    @KafkaListener(
            topics = KafkaTopics.ORDER_TOPIC,
            groupId = "order"
    )
    public void processOrderNotification(OrderEvent orderEvent) {
        LOG.info("Received order event: {}", orderEvent.toString());
    }

    @KafkaListener(
            topics = KafkaTopics.PAYMENT_TOPIC,
            groupId = "payment"
    )
    public void processPaymentNotification(PaymentEvent paymentEvent) {
        LOG.info("Received payment event: {}", paymentEvent.toString());
    }

    @KafkaListener(
            topics = KafkaTopics.SHIPMENT_TOPIC,
            groupId = "shipment"
    )
    public void processShipmentNotification(ShipmentEvent shipmentEvent) {
        LOG.info("Received shipment event: {}", shipmentEvent.toString());
    }

    @KafkaListener(
            topics = KafkaTopics.NOTIFICATION_TOPIC,
            groupId = "notification"
    )
    public void processGeneralNotification(NotificationEvent notificationEvent) {
        LOG.info("Received general notification event: {}", notificationEvent.toString());
    }

    @KafkaListener(
            topics = KafkaTopics.INVENTORY_TOPIC,
            groupId = "inventory"
    )
    public void processInventoryUpdate(InventoryEvent inventoryEvent) {
        LOG.info("Received inventory update event: {}", inventoryEvent.toString());
    }
}
