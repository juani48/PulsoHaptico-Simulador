package com.pulsohaptico.bridge.service.measurement;

import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;
import com.pulsohaptico.bridge.model.measurement.MeasurementType;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {
    private DeviceMeasurement deviceMeasurement;
    private MeasurementType scenarioType = MeasurementType.REGULATED;
    private MeasurementDirector measurementDirector;

    public MeasurementService(MeasurementDirector measurementDirector) {
        this.measurementDirector = measurementDirector;
        setScenario(MeasurementType.REGULATED);
    }

    public void setScenario(MeasurementType scenarioType) {
        deviceMeasurement = measurementDirector.build(scenarioType);
        this.scenarioType = scenarioType;
    }

    public DeviceMeasurement getDeviceMeasurement() { return this.deviceMeasurement; }
    public MeasurementType getScenarioType() { return this.scenarioType; }

}
