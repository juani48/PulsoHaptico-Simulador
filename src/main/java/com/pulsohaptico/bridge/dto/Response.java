package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("measurement") private MeasurementResponse measurementResponse;
    @JsonProperty("dataset") private DatasetResponse datasetResponse;

    public Response(MeasurementResponse measurementResponse, DatasetResponse datasetResponse) {
        this.measurementResponse = measurementResponse;
        this.datasetResponse = datasetResponse;
    }
}