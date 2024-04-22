package com.kafka.basedomains.event;

import com.kafka.basedomains.dto.Notification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationEvent {
    private String message;
    private String status;
    private Notification notification;
}