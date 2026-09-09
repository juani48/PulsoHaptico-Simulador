package com.pulsohaptico.bridge.builder.measurement;

import com.pulsohaptico.bridge.builder.measurement.strategy.PressureStrategy;
import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;

public abstract class AbstractMeasurementBuilder {
    protected PressureStrategy pressureStrategy;
    protected AbstractMeasurementBuilder(PressureStrategy pressureStrategy) {
        this.pressureStrategy = pressureStrategy;
    }
    public DeviceMeasurement build() {
        DeviceMeasurement deviceMeasurement = new DeviceMeasurement();
        setPressure(deviceMeasurement);
        return deviceMeasurement;
    }
    private void setPressure(DeviceMeasurement deviceMeasurement) {
        this.pressureStrategy.setPressure(deviceMeasurement);
    }
}
