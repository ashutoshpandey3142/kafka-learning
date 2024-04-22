package com.kafka.stockservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Inventory {
    @Id
    private String inventoryId;
    @Column
    private String productId;
    @Column
    private int quantity;
    @Column
    private String status;
}