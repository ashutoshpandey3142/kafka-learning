package com.kafka.stockservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Shipment {
    @Id
    private String shipmentId;
    private String orderId;
    private String destination;
    private String shipmentStatus;
}