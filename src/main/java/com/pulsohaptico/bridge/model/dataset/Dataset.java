package com.pulsohaptico.bridge.model.dataset;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Dataset {
    private OffsetDateTime startEvent;
    private OffsetDateTime endEvent;
    private Double state;
    private OffsetDateTime lastSensing;

    public boolean isOnEvent() {
        if (startEvent == null || endEvent == null) {
            return false;
        }

        OffsetDateTime now = OffsetDateTime.now();
        return !now.isBefore(startEvent) && !now.isAfter(endEvent);
    }
}
