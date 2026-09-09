package com.pulsohaptico.bridge.model.measurement;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class DeviceMeasurement {
    private OffsetDateTime offsetDateTime;
    private double pulse;
    public DeviceMeasurement() {
        this.offsetDateTime = OffsetDateTime.now();
    }
}
