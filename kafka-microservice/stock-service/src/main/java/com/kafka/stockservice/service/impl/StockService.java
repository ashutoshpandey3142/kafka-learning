package com.kafka.stockservice.service.impl;

import com.kafka.basedomains.event.*;
import com.kafka.stockservice.entity.*;
import com.kafka.stockservice.repository.*;
import com.kafka.stockservice.service.IStockService;
import com.kafka.stockservice.utils.KafkaTopics;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class StockService implements IStockService {

    private static final Logger LOG = LoggerFactory.getLogger(StockService.class);

    private final IOrderRepository orderRepository;
    private final PaymentRepository paymentRepository;
    private final ShipmentRepository shipmentRepository;
    private final NotificationRepository notificationRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public StockService(IOrderRepository orderRepository, PaymentRepository paymentRepository, ShipmentRepository shipmentRepository, NotificationRepository notificationRepository, InventoryRepository inventoryRepository) {
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
        this.shipmentRepository = shipmentRepository;
        this.notificationRepository = notificationRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @KafkaListener(
            topics = KafkaTopics.ORDER_TOPIC,
            groupId = "order1"
    )
    public void consumeOrderEvent(OrderEvent orderEvent) {
        LOG.info("Order event received in stock service => " + orderEvent.toString());
        try {
            Order order = new Order();
            order.setId(orderEvent.getOrder().getOrderId());
            order.setName(orderEvent.getOrder().getName());
            order.setPrice(orderEvent.getOrder().getPrice());
            order.setQuantity(orderEvent.getOrder().getQuantity());
            orderRepository.save(order);

        }catch (Exception e) {
            LOG.error("Error processing order event: {}", e.getMessage());
        }
    }

    @KafkaListener(
            topics = KafkaTopics.PAYMENT_TOPIC,
            groupId = "payment1"
    )
    public void consumePaymentEvent(PaymentEvent paymentEvent) {
        LOG.info("Payment event received in stock service => " + paymentEvent.toString());
        try {
            Payment payment = new Payment();
            payment.setPaymentId(paymentEvent.getPayment().getPaymentId());
            payment.setAmount(paymentEvent.getPayment().getAmount());
            payment.setPaymentStatus(paymentEvent.getPayment().getPaymentStatus());
            payment.setOrderId(paymentEvent.getPayment().getOrderId());
            paymentRepository.save(payment);

        }catch (Exception e) {
            LOG.error("Error processing payment event: {}", e.getMessage());
        }
    }

    @KafkaListener(
            topics = KafkaTopics.SHIPMENT_TOPIC,
            groupId = "shipment1"
    )
    public void consumeShipmentEvent(ShipmentEvent shipmentEvent) {
        LOG.info("Shipment event received in stock service => " + shipmentEvent.toString());
        try {
            Shipment shipment = new Shipment();
            shipment.setShipmentId(shipmentEvent.getShipment().getShipmentId());
            shipment.setShipmentStatus(shipmentEvent.getShipment().getShipmentStatus());
            shipment.setDestination(shipmentEvent.getShipment().getDestination());
            shipment.setOrderId(shipmentEvent.getShipment().getOrderId());
            shipmentRepository.save(shipment);

        }catch (Exception e) {
            LOG.error("Error processing shipment event: {}", e.getMessage());
        }
    }

    @KafkaListener(
            topics = KafkaTopics.NOTIFICATION_TOPIC,
            groupId = "notification1"
    )
    public void consumeNotificationEvent(NotificationEvent notificationEvent) {
        LOG.info("Notification event received in stock service => " + notificationEvent.toString());
        try {
            Notification notification = new Notification();
            notification.setNotificationId(notificationEvent.getNotification().getNotificationId());
            notification.setRecipient(notificationEvent.getNotification().getRecipient());
            notification.setMessage(notificationEvent.getMessage());
            notification.setOrderId(notificationEvent.getNotification().getOrderId());
            notificationRepository.save(notification);

        }catch (Exception e) {
            LOG.error("Error processing notification event: {}", e.getMessage());
        }
    }

    @KafkaListener(
            topics = KafkaTopics.INVENTORY_TOPIC,
            groupId = "inventory1"
    )
    public void consumeInventoryEvent(InventoryEvent inventoryEvent) {
        LOG.info("Inventory event received in stock service => " + inventoryEvent.toString());

        try {
            Inventory inventory = new Inventory();
            inventory.setInventoryId(inventoryEvent.getInventory().getInventoryId());
            inventory.setQuantity(inventoryEvent.getInventory().getQuantity());
            inventory.setStatus(inventoryEvent.getStatus());
            inventory.setProductId(inventoryEvent.getInventory().getProductId());
            inventoryRepository.save(inventory);

        }catch (Exception e) {
            LOG.error("Error processing inventory event: {}", e.getMessage());
        }
    }
}
