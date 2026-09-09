package com.pulsohaptico.bridge.decorator.structure;

import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;

public class MeasurementComponent implements Component<DeviceMeasurement> {
    @Override
    public DeviceMeasurement getData() {
        return new DeviceMeasurement();
    }
}
