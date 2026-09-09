package com.pulsohaptico.bridge.decorator.measurement;

import com.pulsohaptico.bridge.decorator.structure.BaseDecorator;
import com.pulsohaptico.bridge.decorator.structure.Component;
import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;


public class LowPressureDecorator extends BaseDecorator<DeviceMeasurement> {
    public LowPressureDecorator(Component<DeviceMeasurement> component) {
        super(component);
    }

    @Override
    public DeviceMeasurement getData() {
        DeviceMeasurement scenario = super.getData();
        scenario.setPulse(75.0);
        return scenario;
    }
}
