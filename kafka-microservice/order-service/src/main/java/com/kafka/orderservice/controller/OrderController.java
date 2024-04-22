package com.kafka.orderservice.controller;

import com.kafka.basedomains.dto.*;
import com.kafka.basedomains.event.*;
import com.kafka.orderservice.service.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    public String placeOrder(@RequestBody Order order) {
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("Order status is in pending state");
        orderEvent.setOrder(order);
        orderService.sendOrderEvent(orderEvent);
        return "Order placed successfully";
    }

    @PostMapping("/payment")
    public String processPayment(@RequestBody Payment payment) {
        // Additional logic to process payment
        PaymentEvent paymentEvent = new PaymentEvent();
        paymentEvent.setStatus("PROCESSING");
        paymentEvent.setMessage("Payment processing is in progress");
        paymentEvent.setPayment(payment);
        orderService.sendPaymentEvent(paymentEvent);
        return "Payment processed successfully";
    }

    @PostMapping("/shipment")
    public String shipOrder(@RequestBody Shipment shipment) {
        ShipmentEvent shipmentEvent = new ShipmentEvent();
        shipmentEvent.setStatus("SHIPPING");
        shipmentEvent.setMessage("Order shipment is in progress");
        shipmentEvent.setShipment(shipment);
        orderService.sendShipmentEvent(shipmentEvent);
        return "Order shipment initiated successfully";
    }

    @PostMapping("/notifications")
    public String notification(@RequestBody Notification notification) {
        NotificationEvent notificationEvent = new NotificationEvent();
        notificationEvent.setStatus("SHIPPING");
        notificationEvent.setMessage("Order shipment is in progress");
        notificationEvent.setNotification(notification);
        orderService.sendNotificationEvent(notificationEvent);
        return "Notification sent successfully for order ID: " + notification.getOrderId();
    }

    @PostMapping("/inventory")
    public String inventory(@RequestBody Inventory inventory) {
        InventoryEvent inventoryEvent = new InventoryEvent();
        inventoryEvent.setStatus("SHIPPING");
        inventoryEvent.setMessage("Order shipment is in progress");
        inventoryEvent.setInventory(inventory);
        orderService.sendInventoryEvent(inventoryEvent);
        return "Inventory updated successfully for order ID: " + inventory.getInventoryId();
    }

}
