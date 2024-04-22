package com.kafka.basedomains.event;

import com.kafka.basedomains.dto.Inventory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InventoryEvent {
    private String message;
    private String status;
    private Inventory inventory;
}