package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.measurement.DeviceMeasurement;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class MeasurementResponse {
    @JsonProperty("offset_date_time") private OffsetDateTime offsetDateTime;
    @JsonProperty("pulse") private double pulse;
    public MeasurementResponse(DeviceMeasurement scenario) {
        this.offsetDateTime = scenario.getOffsetDateTime();
        this.pulse = scenario.getPulse();
    }
}
