package com.kafka.stockservice.repository;

import com.kafka.stockservice.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, String> {
    // Add custom methods if needed
}