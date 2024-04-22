package com.kafka.basedomains.event;

import com.kafka.basedomains.dto.Shipment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShipmentEvent {
    private String message;
    private String status;
    private Shipment shipment;
}
