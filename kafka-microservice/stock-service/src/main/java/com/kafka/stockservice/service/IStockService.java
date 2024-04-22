package com.kafka.stockservice.service;

import com.kafka.basedomains.event.*;

public interface IStockService {
    void consumeOrderEvent(OrderEvent orderEvent);
    void consumePaymentEvent(PaymentEvent paymentEvent);
    void consumeShipmentEvent(ShipmentEvent shipmentEvent);
    void consumeNotificationEvent(NotificationEvent notificationEvent);
    void consumeInventoryEvent(InventoryEvent inventoryEvent);
}
