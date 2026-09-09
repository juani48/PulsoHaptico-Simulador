package com.pulsohaptico.bridge.builder.measurement.strategy;

import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;

public class LowPressureStrategy implements PressureStrategy {
    @Override
    public void setPressure(DeviceMeasurement deviceMeasurement) {
        deviceMeasurement.setPulse(75.0);
    }
}
