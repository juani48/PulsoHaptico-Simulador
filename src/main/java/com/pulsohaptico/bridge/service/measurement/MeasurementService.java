package com.pulsohaptico.bridge.service.measurement;

import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;
import com.pulsohaptico.bridge.model.measurement.MeasurementType;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {
    private DeviceMeasurement deviceMeasurement;
    private MeasurementType scenarioType = MeasurementType.REGULATED;
    private MeasurementBuilder scenarioBuilder;

    public MeasurementService(MeasurementBuilder scenarioBuilder) {
        this.scenarioBuilder = scenarioBuilder;
        setScenario(MeasurementType.REGULATED);
    }

    public void setScenario(MeasurementType scenarioType) {
        deviceMeasurement = scenarioBuilder.build(scenarioType);
        this.scenarioType = scenarioType;
    }

    public DeviceMeasurement getDeviceMeasurement() { return this.deviceMeasurement; }
    public MeasurementType getScenarioType() { return this.scenarioType; }

}
