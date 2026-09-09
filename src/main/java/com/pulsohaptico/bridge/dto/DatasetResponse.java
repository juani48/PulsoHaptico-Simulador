package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.dataset.Dataset;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class DatasetResponse {
    @JsonProperty("on_event") private boolean onEvent;
    @JsonProperty("state") private Double state;
    @JsonProperty("last_sensing") private OffsetDateTime lastSensing;

    public DatasetResponse(Dataset dataset){
        this.onEvent = dataset.isOnEvent();
        this.state = dataset.getState();
        this.lastSensing = dataset.getLastSensing();
    }
}
