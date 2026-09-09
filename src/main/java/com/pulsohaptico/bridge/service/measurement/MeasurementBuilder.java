package com.pulsohaptico.bridge.service.measurement;

import com.pulsohaptico.bridge.decorator.measurement.HighPressureDecorator;
import com.pulsohaptico.bridge.decorator.measurement.LowPressureDecorator;
import com.pulsohaptico.bridge.decorator.structure.MeasurementComponent;
import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;
import com.pulsohaptico.bridge.model.measurement.MeasurementType;
import org.springframework.stereotype.Service;

@Service
public class MeasurementBuilder {
    public DeviceMeasurement build(MeasurementType scenarioType) {
        return switch (scenarioType) {
            case DEREGULATED ->
                new HighPressureDecorator(new MeasurementComponent()).getData();
            case REGULATED ->
                   new LowPressureDecorator(new MeasurementComponent()).getData();
            default -> throw new IllegalArgumentException("Unknown scenario type: " + scenarioType);
        };
    }
}
