package com.pulsohaptico.bridge.builder.measurement;

import com.pulsohaptico.bridge.builder.measurement.strategy.HighPressureStrategy;

public class MeassurementBuilderHP extends AbstractMeasurementBuilder {
    public MeassurementBuilderHP() {
        super(new HighPressureStrategy());
    }
}
