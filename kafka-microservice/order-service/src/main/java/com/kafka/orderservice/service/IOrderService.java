package com.kafka.orderservice.service;

import com.kafka.basedomains.event.*;

public interface IOrderService {

    void sendOrderEvent(OrderEvent event);

    void sendPaymentEvent(PaymentEvent event);

    void sendShipmentEvent(ShipmentEvent event);

    void sendNotificationEvent(NotificationEvent event);

    void sendInventoryEvent(InventoryEvent event);
}
