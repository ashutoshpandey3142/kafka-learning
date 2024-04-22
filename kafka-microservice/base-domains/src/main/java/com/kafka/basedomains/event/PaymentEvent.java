package com.kafka.basedomains.event;

import com.kafka.basedomains.dto.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentEvent {
    private String message;
    private String status;
    private Payment payment;
}

