package com.pulsohaptico.bridge.builder.measurement.strategy;

import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;

public interface PressureStrategy {
    void setPressure(DeviceMeasurement deviceMeasurement);
}
