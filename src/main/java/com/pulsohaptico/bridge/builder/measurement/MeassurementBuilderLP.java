package com.pulsohaptico.bridge.builder.measurement;

import com.pulsohaptico.bridge.builder.measurement.strategy.LowPressureStrategy;

public class MeassurementBuilderLP extends AbstractMeasurementBuilder {
    public MeassurementBuilderLP() {
        super(new LowPressureStrategy());
    }
}
