package com.pulsohaptico.bridge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pulsohaptico.bridge.model.Scenario;
import lombok.Data;

@Data
public class ScenarioResponse {
    private Long id;
    private String description;
    @JsonProperty("pulse")
    private double pulse;
    @JsonProperty("state")
    private double state;

    private ProfileResponse profile;

    public ScenarioResponse(Scenario scenario, double pulse, double state) {
        this.id = scenario.getId();
        this.description = scenario.getDescription();
        this.profile = new ProfileResponse(scenario.getProfile());
        this.pulse = pulse;
        this.state = state;
    }
}
