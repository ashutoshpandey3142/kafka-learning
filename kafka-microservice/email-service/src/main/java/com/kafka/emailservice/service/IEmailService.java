package com.kafka.emailservice.service;

import com.kafka.basedomains.event.*;
public interface IEmailService {
    void processOrderNotification(OrderEvent orderEvent);
    void processPaymentNotification(PaymentEvent paymentEvent);
    void processShipmentNotification(ShipmentEvent shipmentEvent);
    void processGeneralNotification(NotificationEvent notificationEvent);
    void processInventoryUpdate(InventoryEvent inventoryEvent);
}