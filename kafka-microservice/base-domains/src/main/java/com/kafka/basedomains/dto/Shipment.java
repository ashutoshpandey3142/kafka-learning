package com.kafka.basedomains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    private String shipmentId;
    private String orderId;
    private String destination;
    private String shipmentStatus;
}