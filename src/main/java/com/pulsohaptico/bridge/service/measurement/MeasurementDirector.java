package com.pulsohaptico.bridge.service.measurement;

import com.pulsohaptico.bridge.builder.measurement.MeassurementBuilderHP;
import com.pulsohaptico.bridge.builder.measurement.MeassurementBuilderLP;
import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;
import com.pulsohaptico.bridge.model.measurement.MeasurementType;
import org.springframework.stereotype.Service;

@Service
public class MeasurementDirector {
    public DeviceMeasurement build(MeasurementType scenarioType) {
        switch (scenarioType) {
            case DEREGULATED -> {
                return new MeassurementBuilderHP().build();
            }
            case REGULATED -> {
                return new MeassurementBuilderLP().build();
            }
            default -> throw new IllegalArgumentException("Unknown scenario type: " + scenarioType);
        }
    }
}
