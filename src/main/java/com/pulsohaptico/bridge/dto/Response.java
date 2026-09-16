package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Response {
    @JsonProperty("scenario") private ScenarioResponse scenarioResponse;

    public Response(ScenarioResponse scenarioResponse) {
        this.scenarioResponse = scenarioResponse;
    }
}