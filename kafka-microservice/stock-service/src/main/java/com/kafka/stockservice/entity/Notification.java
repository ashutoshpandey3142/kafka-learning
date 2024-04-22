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
@Table
@Entity
public class Notification {
    @Id
    private String notificationId;
    @Column
    private String orderId;
    @Column
    private String message;
    @Column
    private String recipient;
}